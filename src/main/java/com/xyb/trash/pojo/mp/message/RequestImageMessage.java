/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */



package com.xyb.trash.pojo.mp.message;

/**
 * 图片形式的请求消息
 */
public class RequestImageMessage extends RequestMessage
{
    /**
     * 
     */
    private static final long serialVersionUID = 7139198529272211162L;


    /**
     * 图片链接
     */
    private String PicUrl;
    
    /**
     *  取得图片链接
     * @return the picUrl
     */
    public String getPicUrl ()
    {
        return PicUrl;
    }
    /**
     * 设置图片链接
     * @param picUrl the picUrl to set.
     */
    public void setPicUrl (String picUrl)
    {
        PicUrl = picUrl;
    }
    /* (non-Javadoc)
    
     * @see java.lang.Object#toString()
    
     */
    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("ImageMessage [PicUrl=");
        builder.append (PicUrl);
        builder.append (", super.toString()=");
        builder.append (super.toString ());
        builder.append ("]");
        return builder.toString ();
    }
}
