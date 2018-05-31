/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */


package com.xyb.trash.pojo.mp.message;

/**
 * 文本形式的响应消息
 */
public class ResponseTextMessage extends ResponseMessage
{
    /**
     * 
     * 
     * 
     */
    private static final long serialVersionUID = 2416627748512461175L;


    
    /**
     * 消息内容
     */
    private String Content;

    /**
     * 取得消息内容
     * @return
     */
    public String getContent ()
    {
        return Content;
    }

    /**
     * 设置消息内容
     * @param content
     */
    public void setContent (String content)
    {
        Content = content;
    }

    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("TextMessage [Content=");
        builder.append (Content);
        builder.append (", super.toString()=");
        builder.append (super.toString ());
        builder.append ("]");
        return builder.toString ();
    } 
    
}
