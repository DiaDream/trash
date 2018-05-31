/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */


package com.xyb.trash.pojo.mp;

import java.io.Serializable;

/**
 * 微信图片对象
 */
public class Image implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -9079093636270859938L;


    
    /**
     * 通过上传多媒体文件，得到的id
     */
    private String MediaId;

    /**
     *  取得通过上传多媒体文件，得到的id
     * @return the mediaId
     */
    public String getMediaId ()
    {
        return MediaId;
    }

    /**
     * 设置通过上传多媒体文件，得到的id
     * @param mediaId the mediaId to set.
     */
    public void setMediaId (String mediaId)
    {
        MediaId = mediaId;
    }

    /* (non-Javadoc)
    
     * @see java.lang.Object#toString()
    
     */
    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("Image [MediaId=");
        builder.append (MediaId);
        builder.append (", super.toString()=");
        builder.append (super.toString ());
        builder.append ("]");
        return builder.toString ();
    }
    
    
}
