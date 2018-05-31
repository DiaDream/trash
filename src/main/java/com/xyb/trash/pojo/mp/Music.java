/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 
 * $Id$
 * 
 * 版权所有 ( c ) 2014 湖南凯歌医疗信息技术有限公司.
 *
 */

package com.xyb.trash.pojo.mp;

import java.io.Serializable;

/**
 * 音乐类
 */
public class Music implements Serializable
{

    /**
     * 音乐名称
     */
    private String Title;
    
    /**
     * 音乐描述
     */
    private String Description;
    
    /**
     * 音乐链接
     */
    private String MusicUrl;
    
    /**
     * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
     */
    private String HQMusicUrl;

    /**
     * 缩略图的媒体id，通过上传图片多媒体文件，得到的id
     */
    private String ThumbMediaId;
    
    /**
     *  取得音乐名称
     * @return the title
     */
    public String getTitle ()
    {
        return Title;
    }

    /**
     * 设置音乐名称
     * @param title the title to set.
     */
    public void setTitle (String title)
    {
        Title = title;
    }

    /**
     *  取得音乐描述
     * @return the description
     */
    public String getDescription ()
    {
        return Description;
    }

    /**
     * 设置音乐描述
     * @param description the description to set.
     */
    public void setDescription (String description)
    {
        Description = description;
    }

    /**
     *  取得音乐链接
     * @return the musicUrl
     */
    public String getMusicUrl ()
    {
        return MusicUrl;
    }

    /**
     * 设置音乐链接
     * @param musicUrl the musicUrl to set.
     */
    public void setMusicUrl (String musicUrl)
    {
        MusicUrl = musicUrl;
    }

    /**
     *  取得高质量音乐链接，WIFI环境优先使用该链接播放音乐
     * @return the hQMusicUrl
     */
    public String getHQMusicUrl ()
    {
        return HQMusicUrl;
    }

    /**
     * 设置高质量音乐链接，WIFI环境优先使用该链接播放音乐
     * @param hQMusicUrl the hQMusicUrl to set.
     */
    public void setHQMusicUrl (String hQMusicUrl)
    {
        HQMusicUrl = hQMusicUrl;
    }
    
    /**
     *  取得缩略图的媒体id，通过上传图片多媒体文件，得到的id
     * @return the thumbMediaId
     */
    public String getThumbMediaId ()
    {
        return ThumbMediaId;
    }

    /**
     * 设置缩略图的媒体id，通过上传图片多媒体文件，得到的id
     * @param thumbMediaId the thumbMediaId to set.
     */
    public void setThumbMediaId (String thumbMediaId)
    {
        ThumbMediaId = thumbMediaId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("Music [Title=");
        builder.append (Title);
        builder.append (", Description=");
        builder.append (Description);
        builder.append (", MusicUrl=");
        builder.append (MusicUrl);
        builder.append (", HQMusicUrl=");
        builder.append (HQMusicUrl);
        builder.append (", ThumbMediaId=");
        builder.append (ThumbMediaId);
        builder.append ("]");
        return builder.toString ();
    }
}
