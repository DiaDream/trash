
/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.pojo.mp.message;

import java.io.Serializable;

/**
 * 模板消息段落对象（每个段落都可以设置独立的字体颜色）
 * @author chenqiang
 */
public class TemplateMessagePara implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -2365375167866958465L;


    /**
     * 段落内容
     */
    private String m_value;
    /**
     * 字体颜色
     */
    private String m_color;
    
    /**
     * 默认构造函数
     */
    public TemplateMessagePara ()
    {
        super ();
    }
    
    /**
     * 
     * @param value 段落内容
     * @param color 字体颜色
     *
     */
    public TemplateMessagePara (String value, String color)
    {
        super ();
        m_value = value;
        m_color = color;
    }
    /**
     *  取得段落内容
     * @return the value
     */
    public String getValue ()
    {
        return m_value;
    }
    /**
     * 设置段落内容
     * @param value the value to set.
     */
    public void setValue (String value)
    {
        m_value = value;
    }
    /**
     *  取得字体颜色
     * @return the color
     */
    public String getColor ()
    {
        return m_color;
    }
    /**
     * 设置字体颜色
     * @param color the color to set.
     */
    public void setColor (String color)
    {
        m_color = color;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("TemplateMessagePara [");
        if (m_value != null)
        {
            builder.append ("value=");
            builder.append (m_value);
            builder.append (", ");
        }
        if (m_color != null)
        {
            builder.append ("color=");
            builder.append (m_color);
        }
        builder.append ("]");
        return builder.toString ();
    }
    
    
}
