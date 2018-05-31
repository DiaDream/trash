/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */



package com.xyb.trash.pojo.mp.message;

/**
 * 地理位置形式的请求消息
 */
public class RequestLocationMessage extends RequestMessage
{
    /**
     * 
     */
    private static final long serialVersionUID = -8232404138507120626L;


    /**
     * 地理位置纬度
     */
    private String Location_X;

    /**
     * 地理位置经度
     */
    private String Location_Y;

    /**
     * 地图缩放大小
     */
    private String Scale;

    /**
     * 地理位置信息
     */
    private String Label;

    /**
     *  取得地理位置纬度
     * @return the location_X
     */
    public String getLocation_X ()
    {
        return Location_X;
    }

    /**
     * 设置地理位置纬度
     * @param location_X the location_X to set.
     */
    public void setLocation_X (String location_X)
    {
        Location_X = location_X;
    }

    /**
     *  取得地理位置经度
     * @return the location_Y
     */
    public String getLocation_Y ()
    {
        return Location_Y;
    }

    /**
     * 设置地理位置经度
     * @param location_Y the location_Y to set.
     */
    public void setLocation_Y (String location_Y)
    {
        Location_Y = location_Y;
    }

    /**
     *  取得地图缩放大小
     * @return the scale
     */
    public String getScale ()
    {
        return Scale;
    }

    /**
     * 设置地图缩放大小
     * @param scale the scale to set.
     */
    public void setScale (String scale)
    {
        Scale = scale;
    }

    /**
     *  取得地理位置信息
     * @return the label
     */
    public String getLabel ()
    {
        return Label;
    }

    /**
     * 设置地理位置信息
     * @param label the label to set.
     */
    public void setLabel (String label)
    {
        Label = label;
    }

    /* (non-Javadoc)
    
     * @see java.lang.Object#toString()
    
     */
    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("LocationMessage [Location_X=");
        builder.append (Location_X);
        builder.append (", Location_Y=");
        builder.append (Location_Y);
        builder.append (", Scale=");
        builder.append (Scale);
        builder.append (", Label=");
        builder.append (Label);
        builder.append (", super.toString()=");
        builder.append (super.toString ());
        builder.append ("]");
        return builder.toString ();
    }
}
