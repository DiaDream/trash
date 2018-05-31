/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.pojo.mp;

import java.io.Serializable;

/**
 * 客服消息
 */
public class CustomerServiceMessage implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 5614156304571975756L;


    /**
     * 接收人的微信OpenId
     */
    private String m_touser;
    /**
     * 消息类型
     */
    private String m_msgtype;
    /**
     * 消息正文
     */
    private Text m_text;

    /**
     * 取得接收人的微信OpenId
     * 
     * @return the touser
     */
    public String getTouser ()
    {
        return m_touser;
    }

    /**
     * 设置接收人的微信OpenId
     * 
     * @param touser the touser to set.
     */
    public void setTouser (String touser)
    {
        m_touser = touser;
    }

    /**
     * 取得消息类型
     * 
     * @return the msgtype
     */
    public String getMsgtype ()
    {
        return m_msgtype;
    }

    /**
     * 设置消息类型
     * 
     * @param msgtype the msgtype to set.
     */
    public void setMsgtype (String msgtype)
    {
        m_msgtype = msgtype;
    }

    /**
     * 取得消息正文
     * 
     * @return the text
     */
    public Text getText ()
    {
        return m_text;
    }

    /**
     * 设置消息正文
     * 
     * @param text the text to set.
     */
    public void setText (Text text)
    {
        m_text = text;
    }

    /* (non-Javadoc)
    
     * @see java.lang.Object#toString()
    
     */
    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("CustomerServiceMessage [touser=");
        builder.append (m_touser);
        builder.append (", msgtype=");
        builder.append (m_msgtype);
        builder.append (", text=");
        builder.append (m_text);
        builder.append ("]");
        return builder.toString ();
    }

    
}
