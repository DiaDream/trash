/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */



package com.xyb.trash.pojo.mp.message;

import java.io.Serializable;

/**
 * 模板消息详情
 */
public class TemplateMessageDetail implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 7461929572758051670L;


    
    /**
     * 消息第一句话
     */
    private TemplateMessagePara m_first;
    /**
     * 第一个段落
     */
    private TemplateMessagePara m_keyword1;
    /**
     * 第二个段落
     */
    private TemplateMessagePara m_keyword2;
    /**
     * 第三个段落
     */
    private TemplateMessagePara m_keyword3;
    /**
     * 第四个段落
     */
    private TemplateMessagePara m_keyword4;
    /**
     * 第五个段落
     */
    private TemplateMessagePara m_keyword5;
    /**
     * 消息最后一句话
     */
    private TemplateMessagePara m_remark;
    
    /**
     *  取得消息第一句话
     * @return the first
     */
    public TemplateMessagePara getFirst ()
    {
        return m_first;
    }
    
    /**
     * 设置消息第一句话
     * @param first the first to set.
     */
    public void setFirst (TemplateMessagePara first)
    {
        m_first = first;
    }
    
    /**
     *  取得第一个段落
     * @return the keyword1
     */
    public TemplateMessagePara getKeyword1 ()
    {
        return m_keyword1;
    }
    
    /**
     * 设置第一个段落
     * @param keyword1 the keyword1 to set.
     */
    public void setKeyword1 (TemplateMessagePara keyword1)
    {
        m_keyword1 = keyword1;
    }
    
    /**
     *  取得第二个段落
     * @return the keyword2
     */
    public TemplateMessagePara getKeyword2 ()
    {
        return m_keyword2;
    }
    
    /**
     * 设置第二个段落
     * @param keyword2 the keyword2 to set.
     */
    public void setKeyword2 (TemplateMessagePara keyword2)
    {
        m_keyword2 = keyword2;
    }
    
    /**
     *  取得第三个段落
     * @return the keyword3
     */
    public TemplateMessagePara getKeyword3 ()
    {
        return m_keyword3;
    }
    
    /**
     * 设置第三个段落
     * @param keyword3 the keyword3 to set.
     */
    public void setKeyword3 (TemplateMessagePara keyword3)
    {
        m_keyword3 = keyword3;
    }
    
    /**
     *  取得第四个段落
     * @return the keyword4
     */
    public TemplateMessagePara getKeyword4 ()
    {
        return m_keyword4;
    }
    
    /**
     * 设置第四个段落
     * @param keyword4 the keyword4 to set.
     */
    public void setKeyword4 (TemplateMessagePara keyword4)
    {
        m_keyword4 = keyword4;
    }
    
    /**
     *  取得第五个段落
     * @return the keyword5
     */
    public TemplateMessagePara getKeyword5 ()
    {
        return m_keyword5;
    }
    
    /**
     * 设置第五个段落
     * @param keyword5 the keyword5 to set.
     */
    public void setKeyword5 (TemplateMessagePara keyword5)
    {
        m_keyword5 = keyword5;
    }
    
    /**
     *  取得消息最后一句话
     * @return the remark
     */
    public TemplateMessagePara getRemark ()
    {
        return m_remark;
    }
    
    /**
     * 设置消息最后一句话
     * @param remark the remark to set.
     */
    public void setRemark (TemplateMessagePara remark)
    {
        m_remark = remark;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("TemplateMessageDetail [");
        if (m_first != null)
        {
            builder.append ("first=");
            builder.append (m_first);
            builder.append (", ");
        }
        if (m_keyword1 != null)
        {
            builder.append ("keyword1=");
            builder.append (m_keyword1);
            builder.append (", ");
        }
        if (m_keyword2 != null)
        {
            builder.append ("keyword2=");
            builder.append (m_keyword2);
            builder.append (", ");
        }
        if (m_keyword3 != null)
        {
            builder.append ("keyword3=");
            builder.append (m_keyword3);
            builder.append (", ");
        }
        if (m_keyword4 != null)
        {
            builder.append ("keyword4=");
            builder.append (m_keyword4);
            builder.append (", ");
        }
        if (m_keyword5 != null)
        {
            builder.append ("keyword5=");
            builder.append (m_keyword5);
            builder.append (", ");
        }
        if (m_remark != null)
        {
            builder.append ("remark=");
            builder.append (m_remark);
        }
        builder.append ("]");
        return builder.toString ();
    }
}
