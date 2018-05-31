/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */


package com.xyb.trash.pojo.mp.message;

import java.io.Serializable;

/**
 * 微信响应消息父类(服务号发送消息给订阅者)
 */
public class ResponseMessage implements Serializable
{
    /**
     * 
     * 
     * 
     */
    private static final long serialVersionUID = 480588454469672080L;


    /**
     * 接收者（开发者）微信号
     */
    private String ToUserName;
    /**
     * 发送方帐号（一个OpenID）
     */
    private String FromUserName;
    /**
     * 消息创建时间 （long型）
     */
    private long CreateTime;
    /**
     * 消息类型（text/music/news/image）
     */
    private String MsgType;
    /**
     * 位0x0001被标志时，星标刚收到的消息
     */
    private int FuncFlag;
    
    /**
     * 取得接收者（开发者）微信号
     * @return
     */
    public String getToUserName ()
    {
        return ToUserName;
    }
    
    /**
     * 设置接收者（开发者）微信号
     * @param toUserName
     */
    public void setToUserName (String toUserName)
    {
        ToUserName = toUserName;
    }
    
    /**
     * 取得发送方帐号（一个OpenID）
     * @return
     */
    public String getFromUserName ()
    {
        return FromUserName;
    }
    
    /**
     * 设置发送方帐号（一个OpenID）
     * @param fromUserName
     */
    public void setFromUserName (String fromUserName)
    {
        FromUserName = fromUserName;
    }
    
    /**
     * 取得消息创建时间
     * @return
     */
    public long getCreateTime ()
    {
        return CreateTime;
    }
    
    /**
     * 设置消息创建时间
     * @param createTime
     */
    public void setCreateTime (long createTime)
    {
        CreateTime = createTime;
    }
    
    /**
     * 取得消息类型
     * @return
     */
    public String getMsgType ()
    {
        return MsgType;
    }
    
    /**
     * 设置消息类型
     * @param msgType
     */
    public void setMsgType (String msgType)
    {
        MsgType = msgType;
    }
    
    /**
     * 取得消息id
     * @return
     */
    public int getFuncFlag ()
    {
        return FuncFlag;
    }
    
    /**
     * 设置消息id
     * @param funcFlag
     */
    public void setFuncFlag (int funcFlag)
    {
        FuncFlag = funcFlag;
    }

    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("Message [ToUserName=");
        builder.append (ToUserName);
        builder.append (", FromUserName=");
        builder.append (FromUserName);
        builder.append (", CreateTime=");
        builder.append (CreateTime);
        builder.append (", MsgType=");
        builder.append (MsgType);
        builder.append (", FuncFlag=");
        builder.append (FuncFlag);
        builder.append ("]");
        return builder.toString ();
    }
}
