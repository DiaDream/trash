/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */


package com.xyb.trash.pojo.mp.message;

/**
 * 链接形式的请求消息
 */
public class RequestLinkMessage extends RequestMessage
{
    /**
     * 
     */
    private static final long serialVersionUID = 8417369401581780519L;



    /**
     * 消息标题
     */
    private String Title;
    /**
     * 消息描述
     */
    private String Description;
    /**
     * 消息链接
     */
    private String Url;
    
    /**
     *  取得消息标题
     * @return the title
     */
    public String getTitle ()
    {
        return Title;
    }
    /**
     * 设置消息标题
     * @param title the title to set.
     */
    public void setTitle (String title)
    {
        Title = title;
    }
    /**
     *  取得消息描述
     * @return the description
     */
    public String getDescription ()
    {
        return Description;
    }
    /**
     * 设置消息描述
     * @param description the description to set.
     */
    public void setDescription (String description)
    {
        Description = description;
    }
    /**
     *  取得消息链接
     * @return the url
     */
    public String getUrl ()
    {
        return Url;
    }
    /**
     * 设置消息链接
     * @param url the url to set.
     */
    public void setUrl (String url)
    {
        Url = url;
    }
    /* (non-Javadoc)
    
     * @see java.lang.Object#toString()
    
     */
    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("LinkMessage [Title=");
        builder.append (Title);
        builder.append (", Description=");
        builder.append (Description);
        builder.append (", Url=");
        builder.append (Url);
        builder.append (", super.toString()=");
        builder.append (super.toString ());
        builder.append ("]");
        return builder.toString ();
    }
}
