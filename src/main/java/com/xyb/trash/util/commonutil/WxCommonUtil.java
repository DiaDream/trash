/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.util.commonutil;

import com.xyb.trash.constants.WxCommonConst;
import com.xyb.trash.pojo.mp.AccessToken;
import com.xyb.trash.pojo.mp.BatchTag;
import com.xyb.trash.pojo.mp.OAuthAccessToken;
import net.sf.json.JSONObject;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.security.MessageDigest;
import java.util.*;
import java.util.Map.Entry;

public abstract class WxCommonUtil
{

    /**
     * 日志工具类
     */
    private static final LogUtil log = new LogUtil (LoggerFactory.getLogger (WxCommonUtil.class.getName ()));
    /**
     * 微信token
     */
    private static AccessToken accessToken = null;

    /**
     * 公众号用于调用微信JS接口的临时票据
     */
    private static AccessToken jsapiTicket = null;

    /**
     * 取得请求xml
     * 
     * @param requestMap
     * @return
     *
     */
    public static String getRequestXml (Map <String, String> requestMap)
    {
        StringBuffer sb = new StringBuffer ();
        sb.append ("<xml>");
        Set <Entry <String, String>> entrySet = requestMap.entrySet ();
        Iterator <Entry <String, String>> it = entrySet.iterator ();
        while (it.hasNext ())
        {
            Entry <String, String> entry = it.next ();
            String key = entry.getKey ();
            String value = entry.getValue ();
            if (null != value && !"".equals (value) && !"appkey".equals (key))
            {

                sb.append ("<" + key + ">" + value + "</" + key + ">\n");
            }
        }
        sb.append ("</xml>");
        return sb.toString ();
    }

    /**
     * 获取access_token
     * 
     * @param appid 凭证
     * @param appsecret 密钥
     * @return
     */
    public static AccessToken getAccessToken (String appid, String appsecret)
    {
        String requestUrl = WxCommonConst.access_token_url.replace ("APPID", appid).replace ("APPSECRET", appsecret);
        try
        {
            if (null == accessToken)
            {
                Date now = new Date ();
                JSONObject jsonObject = JSONObject.fromObject (HttpClientUtil.doGetSSL (requestUrl));
                // 如果请求成功
                if (null != jsonObject)
                {
                    if (jsonObject.optInt ("errcode") != 0)
                    {
                        accessToken = null;
                        // 获取token失败
                        System.out.println ("获取token失败 errcode:{" + jsonObject.optInt ("errcode") + "}, errmsg:{"
                                            + jsonObject.optString ("errmsg") + '}');
                    }
                    else
                    {
                        accessToken = new AccessToken ();
                        accessToken.setToken (jsonObject.optString ("access_token"));
                        accessToken.setExpiresIn (jsonObject.optInt ("expires_in"));
                        accessToken.setCreateTime (now);
                    }
                }
            }
            else
            {
                // 判断令牌有没有过期，没过期就直接返回，否则重新获取令牌
                int validSeconds = accessToken.getExpiresIn ();// 令牌有效期
                validSeconds = validSeconds - 120;
                if (validSeconds > 240)
                {
                    validSeconds = 240;
                } // 把令牌有效期缩短两分钟，防止腾讯服务器与我们服务器之间出现时间差导致令牌失效时间计算错误
                Date now = new Date ();
                if ((now.getTime () / 1000 - accessToken.getCreateTime ().getTime () / 1000) >= validSeconds)
                {
                    JSONObject jsonObject = JSONObject.fromObject (HttpClientUtil.doGetSSL (requestUrl));
                    if (null != jsonObject)
                    {
                        if (jsonObject.optInt ("errcode") != 0)
                        {
                            accessToken = null;
                            // 获取token失败
                            System.out.println ("获取token失败 errcode:{" + jsonObject.optInt ("errcode") + "}, errmsg:{"
                                                + jsonObject.optString ("errmsg") + '}');
                        }
                        else
                        {
                            accessToken = new AccessToken ();
                            accessToken.setToken (jsonObject.optString ("access_token"));
                            accessToken.setExpiresIn (jsonObject.optInt ("expires_in"));
                            accessToken.setCreateTime (now);
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            log.errorLog ("getAccessToken () error: " + e.getMessage (), e);
            throw e;
        }
        return accessToken;
    }

    /**
     * 获取unionId
     * 
     * @param appid
     * @param appsecret
     * @param openId
     * @return
     */
    public static String getUnionId (String appid, String appsecret, String openId)
    {
        String requestUrl = WxCommonConst.get_baseInfo_url.replace ("ACCESS_TOKEN",
                                                                    getAccessToken (appid, appsecret).getToken ())
                                                          .replace ("OPENID", openId);
        JSONObject jsonObject = JSONObject.fromObject (HttpClientUtil.doGetSSL (requestUrl));
        // 如果请求成功
        if (null != jsonObject)
        {
            if (jsonObject.containsKey ("errcode") && jsonObject.containsKey ("errmsg"))
            {
                throw new RuntimeException ("获取unionid失败 errcode:{" + jsonObject.optString ("errcode") + "}, errmsg:{"
                                            + jsonObject.optString ("errmsg") + '}');
            }
            return jsonObject.optString ("unionid");
        }
        return null;
    }

    /**
     * 取得用户基本信息
     * 
     * @param appid
     * @param appsecret
     * @param openId
     * @return
     */
    public static Map <String, String> getUserBaseInfo (String appid, String appsecret,
                                                        String openId)
    {
        String requestUrl = WxCommonConst.get_baseInfo_url.replace ("ACCESS_TOKEN",
                                                                    getAccessToken (appid, appsecret).getToken ())
                                                          .replace ("OPENID", openId);
        JSONObject jsonObject = JSONObject.fromObject (HttpClientUtil.doGetSSL (requestUrl));
        if (null != jsonObject)
        {
            if (jsonObject.containsKey ("errcode") && jsonObject.containsKey ("errmsg"))
            {
                throw new RuntimeException ("获取用户基本信息失败 errcode:{" + jsonObject.getString ("errcode") + "}, errmsg:{"
                                            + jsonObject.getString ("errmsg") + '}');
            }
            Map <String, String> baseInfo = new HashMap <String, String> ();
            baseInfo.put ("openid", openId);
            baseInfo.put ("nickname", jsonObject.optString ("nickname"));
            baseInfo.put ("sex", jsonObject.optString ("sex"));
            baseInfo.put ("city", jsonObject.optString ("city"));
            baseInfo.put ("country", jsonObject.optString ("country"));
            baseInfo.put ("province", jsonObject.optString ("province"));
            baseInfo.put ("language", jsonObject.optString ("language"));
            baseInfo.put ("headimgurl", jsonObject.optString ("headimgurl"));
            baseInfo.put ("unionid", jsonObject.optString ("unionid"));
            baseInfo.put ("remark", jsonObject.optString ("remark"));
            baseInfo.put ("groupid", jsonObject.optString ("groupid"));
            baseInfo.put ("tagid_list", jsonObject.optString ("tagid_list"));
            return baseInfo;
        }
        return null;
    }

    /**
     * 取得微信OAuth认证通过后的访问令牌对象
     * 
     * @param appid
     * @param appsecret
     * @param code
     * @return
     *
     */
    public static OAuthAccessToken getOAuthAccessToken (String appid, String appsecret, String code)
    {
        OAuthAccessToken oAuthAccessToken = null;
        String requestUrl = WxCommonConst.oauth_access_token_url.replace ("APPID", appid)
                                                                .replace ("APPSECRET", appsecret)
                                                                .replace ("CODE", code);
        try
        {
            JSONObject jsonObject = JSONObject.fromObject (HttpClientUtil.doGetSSL (requestUrl));
            // 如果请求成功
            if (null != jsonObject)
            {
                if (jsonObject.containsKey ("errcode"))
                {                    
                    throw new RuntimeException ("获取oAuthAccessToken失败: \nerrcode:" + jsonObject.optString ("errcode") + "\nerrmsg：" + jsonObject.optString ("errmsg"));
                }
                oAuthAccessToken = new OAuthAccessToken ();
                oAuthAccessToken.setAccessToken (jsonObject.optString ("access_token"));
                oAuthAccessToken.setExpiresIn (jsonObject.optString ("expires_in"));
                oAuthAccessToken.setOpenId (jsonObject.optString ("openid"));
                oAuthAccessToken.setRefreshToken (jsonObject.optString ("refresh_token"));
                oAuthAccessToken.setScope (jsonObject.optString ("scope"));
                // String unionid = getUnionId (appid, appsecret,
                // jsonObject.getString ("openid"));
                // oAuthAccessToken.setUnionId (unionid);
                // oAuthAccessToken = new OAuthAccessToken ();
                // oAuthAccessToken.setAccessToken ("access_token");
                // oAuthAccessToken.setExpiresIn ("expires_in");
                // oAuthAccessToken.setOpenId ("olOWct1sG_-D1QHv0XzCjjYQgKtE");
                // oAuthAccessToken.setRefreshToken ("refresh_token");
                // oAuthAccessToken.setScope ("scope");
            }
        }
        catch (Exception e)
        {
            oAuthAccessToken = null;
            // 获取token失败
            log.errorLog ("getOAuthAccessToken () error: " + e.getMessage (), e);
        }
        return oAuthAccessToken;
    }

    /**
     * 取得企业号用于调用微信JS接口的临时票据
     * 
     * @return
     *
     */
    public static String getJsApiTicket (String appid, String appsecret)
    {
        JSONObject jsonObject = null;
        try
        {
            if (null == jsapiTicket)
            {
                String requestUrl = WxCommonConst.wx_get_jsapi_ticket_url.replace ("ACCESS_TOKEN",
                                                                                   getAccessToken (appid,
                                                                                                   appsecret).getToken ());
                Date now = new Date ();
                jsonObject = JSONObject.fromObject (HttpClientUtil.doGetSSL (requestUrl));
                if (null != jsonObject && "0".equals (jsonObject.optString ("errcode")))
                {
                    jsapiTicket = new AccessToken ();
                    jsapiTicket.setToken (jsonObject.optString ("ticket"));
                    jsapiTicket.setExpiresIn (jsonObject.optInt ("expires_in"));
                    jsapiTicket.setCreateTime (now);
                }
            }
            else
            {
                // 判断令牌有没有过期，没过期就直接返回，否则重新获取令牌
                int validSeconds = jsapiTicket.getExpiresIn ();// 令牌有效期
                validSeconds = validSeconds - 120;// 把令牌有效期缩短两分钟，防止腾讯服务器与我们服务器之间出现时间差导致令牌失效时间计算错误
                if (validSeconds > 240)
                {
                    validSeconds = 240;
                }
                Date now = new Date ();
                if ((now.getTime () / 1000 - accessToken.getCreateTime ().getTime () / 1000) >= validSeconds)
                {
                    String requestUrl = WxCommonConst.wx_get_jsapi_ticket_url.replace ("ACCESS_TOKEN",
                                                                                       getAccessToken (appid,
                                                                                                       appsecret).getToken ());
                    Date newDate = new Date ();
                    jsonObject = JSONObject.fromObject (HttpClientUtil.doGetSSL (requestUrl));
                    if (null != jsonObject && "0".equals (jsonObject.optString ("errcode")))
                    {
                        jsapiTicket = new AccessToken ();
                        jsapiTicket.setToken (jsonObject.optString ("ticket"));
                        jsapiTicket.setExpiresIn (jsonObject.optInt ("expires_in"));
                        jsapiTicket.setCreateTime (newDate);
                    }
                }
            }
            return jsapiTicket.getToken ();
        }
        catch (Exception e)
        {
            jsapiTicket = null;
            log.errorLog ("getJsApiTicket () error: " + e.getMessage (), e);
        }
        return null;
    }

    /**
     * 给用户添加标签
     * 
     * @param tag 标签实例
     * @return 0表示成功，其他值表示失败
     */
    public static int batchTagging (String appid, String appsecret, List <String> openid_list,
                                    String tagid)
    {
        int result = 0;
        // 拼装添加标签的url
        String url = WxCommonConst.wx_batch_tagging_url.replace ("ACCESS_TOKEN",
                                                                 getAccessToken (appid, appsecret).getToken ());
        BatchTag tag = new BatchTag ();
        tag.setOpenid_list (openid_list);
        tag.setTagid (Integer.parseInt (tagid));
        // 将Tag对象转换成json字符串
        String jsonTag = JSONObject.fromObject (tag).toString ();
        // 调用接口添加标签
        JSONObject jsonObject = JSONObject.fromObject (HttpClientUtil.doPostString (url, jsonTag));
        if (null != jsonObject)
        {
            if (0 != jsonObject.getInt ("errcode"))
            {
                result = jsonObject.getInt ("errcode");
                System.out.println ("添加用户标签失败 errcode:{" + jsonObject.getInt ("errcode") + "}, errmsg:{"
                                    + jsonObject.getString ("errmsg") + '}');
            }
        }
        return result;
    }

    public static String getJsApiSign (String unsignedString)
    {
        try
        {
            MessageDigest crypt = MessageDigest.getInstance ("SHA-1");
            crypt.reset ();
            crypt.update (unsignedString.getBytes ("UTF-8"));
            unsignedString = byteToHex (crypt.digest ());
            return unsignedString;
        }
        catch (Exception e)
        {
            log.errorLog ("getJsApiSign () error: " + e.getMessage (), e);
            return null;
        }
    }

    /**
     * 把字节转换为十六进制
     * 
     * @param hash
     * @return
     *
     */
    private static String byteToHex (final byte[] hash)
    {
        Formatter formatter = new Formatter ();
        for (byte b : hash)
        {
            formatter.format ("%02x", b);
        }
        String result = formatter.toString ();
        formatter.close ();
        return result;
    }

    /**
     * 从微信服务器下载图片
     * 
     * @param appId
     * @param secret
     * @param mediaId
     */
    public static void downloadImg (String appId, String secret, String mediaId,
                                    String filePath)
    {
        String requestUrl = WxCommonConst.getMediaUrl.replace ("ACCESS_TOKEN",
                                                               getAccessToken (appId, secret).getToken ())
                                                     .replace ("MEDIA_ID", mediaId);
        try
        {
            HttpClient httpclient = new HttpClient ();
            HttpMethod method = new GetMethod (requestUrl);
            httpclient.executeMethod (method);
            Header head = method.getResponseHeader ("Content-Type");
            if (head != null)
            {
                if (head.getValue ().contains ("image/jpeg"))// 正确读取到了信息
                {
                    BufferedInputStream bis = new BufferedInputStream (method.getResponseBodyAsStream ());
                    File imgFile = new File (filePath);
                    imgFile.getParentFile ().mkdirs ();
                    FileOutputStream fos = new FileOutputStream (new File (filePath));
                    byte[] buf = new byte[8096];
                    int size = 0;
                    while ((size = bis.read (buf)) != -1)
                    {
                        fos.write (buf, 0, size);
                    }
                    fos.close ();
                    bis.close ();
                    method.releaseConnection ();
                }
                else if (head.getValue ().contains ("application/json"))// 微信服务器返回了json数据，说明很有可能accessToken过期了，马上刷新它
                {
                    // 刷新token
                    // refreshAccessToken (appId, secret);
                    // 重新获取token
                    requestUrl = WxCommonConst.getMediaUrl.replace ("ACCESS_TOKEN",
                                                                    getAccessToken (appId, secret).getToken ())
                                                          .replace ("MEDIA_ID", mediaId);
                    HttpMethod newmethod = new GetMethod (requestUrl);
                    httpclient.executeMethod (newmethod);
                    BufferedInputStream bis = new BufferedInputStream (newmethod.getResponseBodyAsStream ());
                    FileOutputStream fos = new FileOutputStream (new File (filePath));
                    byte[] buf = new byte[8096];
                    int size = 0;
                    while ((size = bis.read (buf)) != -1)
                    {
                        fos.write (buf, 0, size);
                    }
                    fos.close ();
                    bis.close ();
                    newmethod.releaseConnection ();
                }
                else
                {
                    // 将返回的输入流转换成字符串
                    InputStream inputStream = method.getResponseBodyAsStream ();
                    InputStreamReader inputStreamReader = new InputStreamReader (inputStream, "utf-8");
                    BufferedReader bufferedReader = new BufferedReader (inputStreamReader);
                    StringBuffer buffer = new StringBuffer ();
                    String str = null;
                    while ((str = bufferedReader.readLine ()) != null)
                    {
                        buffer.append (str);
                    }
                    bufferedReader.close ();
                    inputStreamReader.close ();
                    // 释放资源
                    inputStream.close ();
                    inputStream = null;
                    method.releaseConnection ();
                    throw new RuntimeException (buffer.toString ());
                }
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException (e.getMessage ());
        }
    }
}
