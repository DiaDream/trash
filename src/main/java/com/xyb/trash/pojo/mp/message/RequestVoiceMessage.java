/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */


package com.xyb.trash.pojo.mp.message;

/**
 * 语音形式的请求消息
 */
public class RequestVoiceMessage extends RequestMessage
{
    /**
     * 
     */
    private static final long serialVersionUID = 8039787900700139455L;



    /**
     * 媒体ID
     */
    private String MediaId;

    /**
     * 语音格式
     */
    private String Format;

    /**
     *  取得媒体ID
     * @return the mediaId
     */
    public String getMediaId ()
    {
        return MediaId;
    }

    /**
     * 设置媒体ID
     * @param mediaId the mediaId to set.
     */
    public void setMediaId (String mediaId)
    {
        MediaId = mediaId;
    }

    /**
     *  取得语音格式
     * @return the format
     */
    public String getFormat ()
    {
        return Format;
    }

    /**
     * 设置语音格式
     * @param format the format to set.
     */
    public void setFormat (String format)
    {
        Format = format;
    }

    /* (non-Javadoc)
    
     * @see java.lang.Object#toString()
    
     */
    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("VoiceMessage [MediaId=");
        builder.append (MediaId);
        builder.append (", Format=");
        builder.append (Format);
        builder.append (", super.toString()=");
        builder.append (super.toString ());
        builder.append ("]");
        return builder.toString ();
    }
}
