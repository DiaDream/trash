
/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.service.mp.impl;

import com.xyb.trash.enumeration.CoordinateType;
import com.xyb.trash.enumeration.mp.EventType;
import com.xyb.trash.enumeration.mp.RequestMessageType;
import com.xyb.trash.enumeration.mp.ResponseMessageType;
import com.xyb.trash.pojo.baidumap.BaiduLocation;
import com.xyb.trash.pojo.mp.AccessToken;
import com.xyb.trash.pojo.mp.CustomerServiceMessage;
import com.xyb.trash.pojo.mp.Text;
import com.xyb.trash.pojo.mp.message.ResponseTextMessage;
import com.xyb.trash.service.mp.MessageProcessService;
import com.xyb.trash.service.systemconfig.SystemConfigService;
import com.xyb.trash.util.commonutil.BaiduMapUtil;
import com.xyb.trash.util.commonutil.HttpClientUtil;
import com.xyb.trash.util.commonutil.MessageUtil;
import com.xyb.trash.util.commonutil.WxCommonUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 微信消息处理服务接口实现类
 * 
 * @author chenqiang
 * @since 2018-02-20
 */
@Service
public class MessageProcessServiceImpl implements MessageProcessService
{

    @Autowired
    private SystemConfigService m_systemConfigService;
    
    @Override
    public String requestProccess (HttpServletRequest request)
    {
        String responseMessage = null;
        try
        {
            String respContent = "";

            Map <String, String> requestMap = MessageUtil.parseXml (request);

            String fromUserName = requestMap.get ("FromUserName");

            String toUserName = requestMap.get ("ToUserName");

            String msgType = requestMap.get ("MsgType");

            ResponseTextMessage textMessage = new ResponseTextMessage ();
            textMessage.setToUserName (fromUserName);
            textMessage.setFromUserName (toUserName);
            textMessage.setCreateTime (new Date ().getTime ());
            textMessage.setMsgType (ResponseMessageType.TEXT.getValue ());
            textMessage.setFuncFlag (0);
            // 文本消息
            if (msgType.equals (RequestMessageType.TEXT.getValue ()))
            {
                respContent = "您发送的是文本消息！";
            }
            // 图片消息
            else if (msgType.equals (RequestMessageType.IMAGE.getValue ()))
            {
                respContent = "您发送的是图片消息！";
            }
            // 地理位置消息
            else if (msgType.equals (RequestMessageType.LOCATION.getValue ()))
            {
                // 地理位置信息
                String locationInfo = requestMap.get ("Label");
                respContent = "您发送的是地理位置消息！您所在的位置是：" + locationInfo;
            }
            // 链接消息
            else if (msgType.equals (RequestMessageType.LINK.getValue ()))
            {
                respContent = "您发送的是链接消息！";
            }
            // 音频消息
            else if (msgType.equals (RequestMessageType.VOICE.getValue ()))
            {

            }
            // 事件推送
            else if (msgType.equals (RequestMessageType.EVENT.getValue ()))
            {
                // 事件类型
                String eventType = requestMap.get ("Event");
                // 订阅
                if (eventType.equals (EventType.SUBSCRIBE.getValue ()))
                {
                    String aa = "<xml><ToUserName><![CDATA[" + fromUserName + "]]></ToUserName><FromUserName><![CDATA["
                                + toUserName
                                + "]]></FromUserName><CreateTime>12345678</CreateTime><MsgType><![CDATA[news]]></MsgType><ArticleCount>2</ArticleCount><Articles><item><Title><![CDATA[title1]]></Title> <Description><![CDATA[description1]]></Description><PicUrl><![CDATA[picurl]]></PicUrl><Url><![CDATA[http://www.baidu.com]]></Url></item><item><Title><![CDATA[title]]></Title><Description><![CDATA[description]]></Description><PicUrl><![CDATA[picurl]]></PicUrl><Url><![CDATA[url]]></Url></item></Articles></xml>";
                    // respContent = "谢谢您的关注！";
                    return "谢谢您的关注！";
                }
                // 取消订阅
                else if (eventType.equals (EventType.UNSUBSCRIBE.getValue ()))
                {
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                }
                // 用户进入会话上报地理位置事件
                else if (eventType.equals (EventType.LOCATION.getValue ()))
                {
                    // TODO 获取到的地理位置
                    String latitude = requestMap.get ("Latitude");// 纬度
                    String longitude = requestMap.get ("Longitude");// 经度
                    BaiduLocation locationInfo = BaiduMapUtil.findLocationInfo (latitude, longitude,
                                                                                CoordinateType.WGS84.getValue ());
                    return "";
                }
            }
            responseMessage = MessageUtil.textMessageToXml (textMessage);
        }
        catch (Exception e)
        {
            e.printStackTrace ();
        }
        return responseMessage;
    }

    /**
     * 微信发送客服消息
     * @param targetAccount 消息接收方账号（在微信中这里填接收方的openId）
     * @param msgContent 消息内容
     * @return
     */
    @Override
    public String sendTextMessage (String targetAccount, String msgContent)
    {
        String result = "0";
        try
        {
            AccessToken accessToken = WxCommonUtil.getAccessToken (m_systemConfigService.findMpAppId (),
                                                                   m_systemConfigService.findMpAppSecret ());

            CustomerServiceMessage msg = new CustomerServiceMessage ();
            msg.setTouser (targetAccount);
            msg.setMsgtype ("text");
            Text text = new Text ();
            text.setContent (msgContent);
            msg.setText (text);
            String msgJsonStr = JSONObject.fromObject (msg).toString ();
            String sendUrl = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN".replace ("ACCESS_TOKEN",
                                                                                                                        accessToken.getToken ());
            JSONObject jsonObject = JSONObject.fromObject (HttpClientUtil.doPostString (sendUrl, msgJsonStr));
            if (null != jsonObject)
            {
                if (0 != jsonObject.optInt ("errcode"))
                {
                    result = "微信文本消息发送失败，失败原因：" + jsonObject.getString ("errmsg");
                    throw new RuntimeException (result);
                }
            }
        }
        catch (RuntimeException e)
        {
            throw e;
        }
        return result;
    }
}
