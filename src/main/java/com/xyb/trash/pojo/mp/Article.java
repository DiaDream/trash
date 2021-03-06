/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */



package com.xyb.trash.pojo.mp;

import java.io.Serializable;

/**
 * 图文对象
 */
public class Article implements Serializable
{

    /**
     * 图文消息名称
     */
    private String Title;
    
    /**
     * 图文消息描述
     */
    private String Description;

    /**
     * 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80，限制图片链接的域名需要与开发者填写的基本资料中的Url一致
     */
    private String PicUrl;
    
    /**
     * 点击图文消息跳转链接
     */
    private String Url;

    /**
     *  取得图文消息名称
     * @return the title
     */
    public String getTitle ()
    {
        return Title;
    }

    /**
     * 设置图文消息名称
     * @param title the title to set.
     */
    public void setTitle (String title)
    {
        Title = title;
    }

    /**
     *  取得图文消息描述
     * @return the description
     */
    public String getDescription ()
    {
        return Description;
    }

    /**
     * 设置图文消息描述
     * @param description the description to set.
     */
    public void setDescription (String description)
    {
        Description = description;
    }

    /**
     *  取得图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80，限制图片链接的域名需要与开发者填写的基本资料中的Url一致
     * @return the picUrl
     */
    public String getPicUrl ()
    {
        return PicUrl;
    }

    /**
     * 设置图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80，限制图片链接的域名需要与开发者填写的基本资料中的Url一致
     * @param picUrl the picUrl to set.
     */
    public void setPicUrl (String picUrl)
    {
        PicUrl = picUrl;
    }

    /**
     *  取得点击图文消息跳转链接
     * @return the url
     */
    public String getUrl ()
    {
        return Url;
    }

    /**
     * 设置点击图文消息跳转链接
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
        builder.append ("Article [Title=");
        builder.append (Title);
        builder.append (", Description=");
        builder.append (Description);
        builder.append (", PicUrl=");
        builder.append (PicUrl);
        builder.append (", Url=");
        builder.append (Url);
        builder.append ("]");
        return builder.toString ();
    }
}
