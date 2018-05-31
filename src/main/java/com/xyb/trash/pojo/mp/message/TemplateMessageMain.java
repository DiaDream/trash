/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */



package com.xyb.trash.pojo.mp.message;

import java.io.Serializable;

/**
 * 微信模板消息主对象
 * @author chenqiang
 */
public class TemplateMessageMain implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -6723595113909661010L;

    /**
     * 要发送给的用户的微信唯一标识符
     */
    private String m_touser;
    /**
     * 模板id
     */
    private String m_template_id;
    /**
     * 用户点击消息以后要跳转的地址，如果为空则在ios中点击后跳入空白页，在android中无法点击该消息
     */
    private String m_url;
    /**
     * 消息头部颜色（#FF0000格式）
     */
    private String m_topcolor;
    /**
     * 模板消息内容
     */
    private TemplateMessageDetail m_data;
    
    /**
     *  取得要发送给的用户的微信唯一标识符
     * @return the touser
     */
    public String getTouser ()
    {
        return m_touser;
    }
    
    /**
     * 设置要发送给的用户的微信唯一标识符
     * @param touser the touser to set.
     */
    public void setTouser (String touser)
    {
        m_touser = touser;
    }
    
    /**
     *  取得模板id
     * @return the template_id
     */
    public String getTemplate_id ()
    {
        return m_template_id;
    }
    
    /**
     * 设置模板id
     * @param template_id the template_id to set.
     */
    public void setTemplate_id (String template_id)
    {
        m_template_id = template_id;
    }
    
    /**
     *  取得用户点击消息以后要跳转的地址，如果为空则在ios中点击后跳入空白页，在android中无法点击该消息
     * @return the url
     */
    public String getUrl ()
    {
        return m_url;
    }
    
    /**
     * 设置用户点击消息以后要跳转的地址，如果为空则在ios中点击后跳入空白页，在android中无法点击该消息
     * @param url the url to set.
     */
    public void setUrl (String url)
    {
        m_url = url;
    }
    
    /**
     *  取得消息头部颜色（#FF0000格式）
     * @return the topcolor
     */
    public String getTopcolor ()
    {
        return m_topcolor;
    }
    
    /**
     * 设置消息头部颜色（#FF0000格式）
     * @param topcolor the topcolor to set.
     */
    public void setTopcolor (String topcolor)
    {
        m_topcolor = topcolor;
    }

    /**
     *  取得模板消息内容
     * @return the data
     */
    public TemplateMessageDetail getData ()
    {
        return m_data;
    }

    /**
     * 设置模板消息内容
     * @param data the data to set.
     */
    public void setData (TemplateMessageDetail data)
    {
        m_data = data;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("TemplateMessage [");
        if (m_touser != null)
        {
            builder.append ("touser=");
            builder.append (m_touser);
            builder.append (", ");
        }
        if (m_template_id != null)
        {
            builder.append ("template_id=");
            builder.append (m_template_id);
            builder.append (", ");
        }
        if (m_url != null)
        {
            builder.append ("url=");
            builder.append (m_url);
            builder.append (", ");
        }
        if (m_topcolor != null)
        {
            builder.append ("topcolor=");
            builder.append (m_topcolor);
            builder.append (", ");
        }
        if (m_data != null)
        {
            builder.append ("data=");
            builder.append (m_data);
            builder.append (", ");
        }
        builder.append ("]");
        return builder.toString ();
    }
}
