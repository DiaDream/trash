
/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.util.commonutil;

import org.apache.commons.io.IOUtils;


import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * http请求工具类
 */
public abstract class HttpClientUtil
{

    /**
     * 日志工具类
     */
    private static final LogUtil log = new LogUtil (LoggerFactory.getLogger (HttpClientUtil.class.getName ()));
    private static PoolingHttpClientConnectionManager connMgr;
    private static RequestConfig requestConfig;
    /**
     * 超时时间15秒
     */
    private static final int MAX_TIMEOUT = 15000;

    static
    {
        // 设置连接池
        connMgr = new PoolingHttpClientConnectionManager ();
        // 设置连接池大小
        connMgr.setMaxTotal (100);
        connMgr.setDefaultMaxPerRoute (connMgr.getMaxTotal ());

        RequestConfig.Builder configBuilder = RequestConfig.custom ();
        // 设置连接超时
        configBuilder.setConnectTimeout (MAX_TIMEOUT);
        // 设置读取超时
        configBuilder.setSocketTimeout (MAX_TIMEOUT);
        // 设置从连接池获取连接实例的超时
        configBuilder.setConnectionRequestTimeout (MAX_TIMEOUT);
        // 在提交请求之前 测试连接是否可用
        connMgr.setValidateAfterInactivity (30);
        requestConfig = configBuilder.build ();
    }

    /**
     * 发送 GET 请求（HTTP），不带输入数据
     * 
     * @param url
     * @return
     */
    public static String doGet (String url) throws RuntimeException
    {
        return doGet (url, new HashMap <> ());
    }

    /**
     * 发送 GET 请求（HTTP），K-V形式
     * 
     * @param url
     * @param params
     * @return
     */
    public static String doGet (String url, Map <String, String> params) throws RuntimeException
    {
        String apiUrl = url;
        if (null != params && !params.isEmpty ())
        {            
            StringBuffer param = new StringBuffer ();
            int i = 0;
            Set <Entry <String, String>> keyValuePairs = params.entrySet ();
            for (Entry <String, String> keyValue : keyValuePairs)
            {
                if (i == 0)
                {
                    param.append ("?");
                }
                else
                {
                    param.append ("&");
                }
                param.append (keyValue.getKey ()).append ("=").append (keyValue.getValue ());
                i++;
            }
            apiUrl = apiUrl + param;
        }
        String result = null;
        CloseableHttpClient httpClient = HttpClients.custom ().setDefaultRequestConfig (requestConfig).build ();
        try
        {
            HttpGet getMethod = new HttpGet (apiUrl);
            HttpResponse response = httpClient.execute (getMethod);
            int statusCode = response.getStatusLine ().getStatusCode ();
            if (statusCode != HttpStatus.SC_OK)
            {
                throw new RuntimeException ("发送http get请求失败，请求地址：" + url + "\n请求状态码：" + statusCode);
            }
            HttpEntity entity = response.getEntity ();
            if (entity != null)
            {
                InputStream instream = entity.getContent ();
                result = IOUtils.toString (instream, Consts.UTF_8.name ());
            }
        }
        catch (IOException e)
        {
            log.errorLog ("doGet (String url, Map <String, String> params) error: " + e.getMessage (), e);
            throw new RuntimeException (e);
        }
        return result;
    }

    /**
     * 发送 GET 请求（HTTP），不带输入数据
     * 
     * @param url
     * @return
     */
    public static String doGetSSL (String url) throws RuntimeException
    {
        return doGetSSL (url, new HashMap <> ());
    }

    /**
     * 发送 GET 请求（HTTP），K-V形式
     * 
     * @param url
     * @param params
     * @return
     */
    public static String doGetSSL (String url, Map <String, String> params) throws RuntimeException
    {
        String apiUrl = url;
        if (null != params && !params.isEmpty ())
        {            
            StringBuffer param = new StringBuffer ();
            int i = 0;
            Set <Entry <String, String>> keyValuePairs = params.entrySet ();
            for (Entry <String, String> keyValue : keyValuePairs)
            {
                if (i == 0)
                {
                    param.append ("?");
                }
                else
                {
                    param.append ("&");
                }
                param.append (keyValue.getKey ()).append ("=").append (keyValue.getValue ());
                i++;
            }
            apiUrl = apiUrl + param;
        }
        String result = null;
        CloseableHttpClient httpClient = HttpClients.custom ().setSSLSocketFactory (createSSLConnSocketFactory ())
                                                    .setConnectionManager (connMgr)
                                                    .setDefaultRequestConfig (requestConfig).build ();
        try
        {
            HttpGet getMethod = new HttpGet (apiUrl);
            HttpResponse response = httpClient.execute (getMethod);
            int statusCode = response.getStatusLine ().getStatusCode ();
            if (statusCode == 200)
            {
                HttpEntity entity = response.getEntity ();
                if (entity != null)
                {
                    InputStream instream = entity.getContent ();
                    result = IOUtils.toString (instream, Consts.UTF_8.name ());
                }
            }
            else
            {
                throw new RuntimeException ("发送http get请求失败，请求地址：" + url + "\n请求状态码：" + statusCode);
            }
        }
        catch (IOException e)
        {
            log.errorLog ("doGetSSL (String url, Map <String, Object> params) error: " + e.getMessage (), e);
            throw new RuntimeException (e);
        }
        return result;
    }

    /**
     * 发送 POST 请求（HTTP），不带输入数据
     * 
     * @param requestUrl
     * @return
     */
    public static String doPost (String requestUrl) throws RuntimeException
    {
        return doPost (requestUrl, new HashMap <> (), true);
    }

    /**
     * 发送 POST 请求（HTTP），K-V形式
     * 
     * @param requestUrl 请求地址
     * @param params 参数map
     * @param needEncoding 是否需要对参数编码
     * @return
     */
    public static String doPost (String requestUrl, Map <String, String> params,
                                 boolean needEncoding) throws RuntimeException
    {
        CloseableHttpClient httpClient = HttpClients.createDefault ();
        String httpStr = null;
        HttpPost httpPost = new HttpPost (requestUrl);
        CloseableHttpResponse response = null;

        try
        {
            httpPost.setConfig (requestConfig);
            List <NameValuePair> pairList = new ArrayList <> (params.size ());
            for (Entry <String, String> entry : params.entrySet ())
            {
                NameValuePair pair = new BasicNameValuePair (entry.getKey (), entry.getValue ());
                pairList.add (pair);
            }
            if (needEncoding)
            {
                httpPost.setEntity (new UrlEncodedFormEntity (pairList, Consts.UTF_8));
            }
            else
            {
                EntityBuilder entityBuilder = EntityBuilder.create ();
                entityBuilder.setParameters (pairList);
                httpPost.setEntity (entityBuilder.build ());
            }
            response = httpClient.execute (httpPost);
            int statusCode = response.getStatusLine ().getStatusCode ();
            if (statusCode != HttpStatus.SC_OK)
            {
                throw new RuntimeException ("发送https post请求失败，请求地址：" + requestUrl + "\n请求状态码：" + statusCode);
            }
            HttpEntity entity = response.getEntity ();
            httpStr = EntityUtils.toString (entity, Consts.UTF_8);
        }
        catch (IOException e)
        {
            log.errorLog ("doPost (String requestUrl, Map <String, String> params, boolean needEncoding)"
                          + e.getMessage (), e);
        }
        finally
        {
            if (response != null)
            {
                try
                {
                    EntityUtils.consume (response.getEntity ());
                }
                catch (IOException e)
                {
                    throw new RuntimeException (e);
                }
            }
        }
        return httpStr;
    }

    /**
     * 发送 POST 请求（HTTP），字符串形式
     * 
     * @param requestUrl
     * @param param 要post过去的字符串
     * @return
     */
    public static String doPostString (String requestUrl, String param) throws RuntimeException
    {
        CloseableHttpClient httpClient = HttpClients.createDefault ();
        String httpStr = null;
        HttpPost httpPost = new HttpPost (requestUrl);
        CloseableHttpResponse response = null;

        try
        {
            httpPost.setConfig (requestConfig);
            StringEntity stringEntity = new StringEntity (param, Consts.UTF_8);// 解决中文乱码问题
            httpPost.setEntity (stringEntity);
            response = httpClient.execute (httpPost);
            int statusCode = response.getStatusLine ().getStatusCode ();
            if (statusCode != HttpStatus.SC_OK)
            {
                throw new RuntimeException ("发送https psot请求失败，请求地址：" + requestUrl + "\n请求状态码：" + statusCode);
            }
            HttpEntity entity = response.getEntity ();
            httpStr = EntityUtils.toString (entity, Consts.UTF_8);
        }
        catch (IOException e)
        {
            log.errorLog ("doPostString (String requestUrl, String param)" + e.getMessage (), e);
            throw new RuntimeException (e);
        }
        finally
        {
            if (response != null)
            {
                try
                {
                    EntityUtils.consume (response.getEntity ());
                }
                catch (IOException e)
                {
                    throw new RuntimeException (e);
                }
            }
        }
        return httpStr;
    }

    /**
     * 发送 POST 请求（HTTP），JSON形式
     * 
     * @param requestUrl
     * @param json json对象
     * @return
     */
    public static String doPostJson (String requestUrl, Object json) throws RuntimeException
    {
        CloseableHttpClient httpClient = HttpClients.createDefault ();
        String httpStr = null;
        HttpPost httpPost = new HttpPost (requestUrl);
        CloseableHttpResponse response = null;

        try
        {
            httpPost.setConfig (requestConfig);
            StringEntity stringEntity = new StringEntity (json.toString (), Consts.UTF_8);// 解决中文乱码问题
            stringEntity.setContentType ("application/json");
            httpPost.setEntity (stringEntity);
            response = httpClient.execute (httpPost);
            int statusCode = response.getStatusLine ().getStatusCode ();
            if (statusCode != HttpStatus.SC_OK)
            {
                throw new RuntimeException ("发送https psot请求失败，请求地址：" + requestUrl + "\n请求状态码：" + statusCode);
            }
            HttpEntity entity = response.getEntity ();
            httpStr = EntityUtils.toString (entity, Consts.UTF_8);
        }
        catch (IOException e)
        {
            throw new RuntimeException (e);
        }
        finally
        {
            if (response != null)
            {
                try
                {
                    EntityUtils.consume (response.getEntity ());
                }
                catch (IOException e)
                {
                    throw new RuntimeException (e);
                }
            }
        }
        return httpStr;
    }

    /**
     * 发送 POST 请求（HTTPS），不带输入数据
     * 
     * @param requestUrl
     * @return
     */
    public static String doPostSSL (String requestUrl) throws RuntimeException
    {
        return doPostSSL (requestUrl, new HashMap <> ());
    }

    /**
     * 发送 SSL POST 请求（HTTPS），K-V形式
     * 
     * @param apiUrl API接口URL
     * @param params 参数map
     * @return
     */
    public static String doPostSSL (String requestUrl, Map <String, Object> params) throws RuntimeException
    {
        CloseableHttpClient httpClient = HttpClients.custom ().setSSLSocketFactory (createSSLConnSocketFactory ())
                                                    .setConnectionManager (connMgr)
                                                    .setDefaultRequestConfig (requestConfig).build ();
        HttpPost httpPost = new HttpPost (requestUrl);
        CloseableHttpResponse response = null;
        String httpStr = null;

        try
        {
            httpPost.setConfig (requestConfig);
            List <NameValuePair> pairList = new ArrayList <> (params.size ());
            for (Entry <String, Object> entry : params.entrySet ())
            {
                NameValuePair pair = new BasicNameValuePair (entry.getKey (), entry.getValue ().toString ());
                pairList.add (pair);
            }
            httpPost.setEntity (new UrlEncodedFormEntity (pairList, Consts.UTF_8));
            response = httpClient.execute (httpPost);
            int statusCode = response.getStatusLine ().getStatusCode ();
            if (statusCode != HttpStatus.SC_OK)
            {
                throw new RuntimeException ("发送https post请求失败，请求地址：" + requestUrl + "\n请求状态码：" + statusCode);
            }
            HttpEntity entity = response.getEntity ();
            if (entity == null)
            {
                return null;
            }
            httpStr = EntityUtils.toString (entity, Consts.UTF_8);
        }
        catch (Exception e)
        {
            throw new RuntimeException (e);
        }
        finally
        {
            if (response != null)
            {
                try
                {
                    EntityUtils.consume (response.getEntity ());
                }
                catch (IOException e)
                {
                    throw new RuntimeException (e);
                }
            }
        }
        return httpStr;
    }

    /**
     * 发送 SSL POST 请求（HTTPS），JSON形式
     * 
     * @param apiUrl API接口URL
     * @param json JSON对象
     * @return
     */
    public static String doPostSSL (String apiUrl, String param)
    {
        CloseableHttpClient httpClient = HttpClients.custom ().setSSLSocketFactory (createSSLConnSocketFactory ())
                                                    .setConnectionManager (connMgr)
                                                    .setDefaultRequestConfig (requestConfig).build ();
        HttpPost httpPost = new HttpPost (apiUrl);
        CloseableHttpResponse response = null;
        String httpStr = null;

        try
        {
            httpPost.setConfig (requestConfig);
            StringEntity stringEntity = new StringEntity (param, Consts.UTF_8);// 解决中文乱码问题
            stringEntity.setContentType ("application/json");
            httpPost.setEntity (stringEntity);
            response = httpClient.execute (httpPost);
            int statusCode = response.getStatusLine ().getStatusCode ();
            if (statusCode != HttpStatus.SC_OK)
            {
                return null;
            }
            HttpEntity entity = response.getEntity ();
            if (entity == null)
            {
                return null;
            }
            httpStr = EntityUtils.toString (entity, Consts.UTF_8);
        }
        catch (Exception e)
        {
            log.errorLog ("doPostSSL (String apiUrl, String param)" + e.getMessage (), e);
        }
        finally
        {
            if (response != null)
            {
                try
                {
                    EntityUtils.consume (response.getEntity ());
                }
                catch (IOException e)
                {
                    e.printStackTrace ();
                }
            }
        }
        return httpStr;
    }

    /**
     * 发送 SSL POST 请求（HTTPS），String形式
     * 
     * @param apiUrl API接口URL
     * @param json JSON对象
     * @return
     */
    public static String doPostSSL (String apiUrl, Object json)
    {
        CloseableHttpClient httpClient = HttpClients.custom ().setSSLSocketFactory (createSSLConnSocketFactory ())
                                                    .setConnectionManager (connMgr)
                                                    .setDefaultRequestConfig (requestConfig).build ();
        HttpPost httpPost = new HttpPost (apiUrl);
        CloseableHttpResponse response = null;
        String httpStr = null;

        try
        {
            httpPost.setConfig (requestConfig);
            StringEntity stringEntity = new StringEntity (json.toString (), Consts.UTF_8);// 解决中文乱码问题
            stringEntity.setContentType ("application/json");
            httpPost.setEntity (stringEntity);
            response = httpClient.execute (httpPost);
            int statusCode = response.getStatusLine ().getStatusCode ();
            if (statusCode != HttpStatus.SC_OK)
            {
                return null;
            }
            HttpEntity entity = response.getEntity ();
            if (entity == null)
            {
                return null;
            }
            httpStr = EntityUtils.toString (entity, Consts.UTF_8);
        }
        catch (Exception e)
        {
            log.errorLog ("doPostSSL (String apiUrl, Object json)" + e.getMessage (), e);
        }
        finally
        {
            if (response != null)
            {
                try
                {
                    EntityUtils.consume (response.getEntity ());
                }
                catch (IOException e)
                {
                    e.printStackTrace ();
                }
            }
        }
        return httpStr;
    }

    /**
     * 创建SSL安全连接
     * 
     * @return
     */
    private static SSLConnectionSocketFactory createSSLConnSocketFactory ()
    {
        SSLConnectionSocketFactory sslsf = null;
        try
        {
            SSLContext sslContext = new SSLContextBuilder ().loadTrustMaterial (null, new TrustStrategy ()
            {

                public boolean isTrusted (X509Certificate[] chain, String authType) throws CertificateException
                {
                    return true;
                }
            }).build ();
            sslsf = new SSLConnectionSocketFactory (sslContext, new HostnameVerifier ()
            {

                @Override
                public boolean verify (String arg0, SSLSession arg1)
                {
                    return true;
                }
            });
        }
        catch (GeneralSecurityException e)
        {
            log.errorLog ("createSSLConnSocketFactory ()" + e.getMessage (), e);
        }
        return sslsf;
    }
}
