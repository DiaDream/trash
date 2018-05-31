/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */


package com.xyb.trash.pojo.mp.message;

import com.xyb.trash.pojo.mp.Image;
/**
 * 图片形式的响应消息
 */
public class ResponseImageMessage extends ResponseMessage
{
    /**
     * 
     * 
     * 
     */
    private static final long serialVersionUID = 3342005637073176131L;

    /**
     * 图片对象
     */
    private Image Image;
    
    /**
     *  取得图片对象
     * @return the image
     */
    public Image getImage ()
    {
        return Image;
    }
    /**
     * 设置图片对象
     * @param image the image to set.
     */
    public void setImage (Image image)
    {
        Image = image;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("ResponseImageMessage [Image=");
        builder.append (Image);
        builder.append (", super.toString()=");
        builder.append (super.toString ());
        builder.append ("]");
        return builder.toString ();
    }
}
