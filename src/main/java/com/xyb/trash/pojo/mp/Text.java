/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */


package com.xyb.trash.pojo.mp;

import java.io.Serializable;

/**
 * text对象
 */
public class Text implements Serializable
{
    /**
     * 
     * 
     * 
     */
    private static final long serialVersionUID = -5805908592022118510L;


    /**
     * 内容
     */
    private String m_content;
    
    /**
     * 取得内容
     * @return
     *
     */
    public String getContent ()
    {
        return m_content;
    }
    
    /**
     * 设置内容
     * @param content
     *
     */
    public void setContent (String content)
    {
        m_content = content;
    }

    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("Text [content=");
        builder.append (m_content);
        builder.append ("]");
        return builder.toString ();
    }
}
