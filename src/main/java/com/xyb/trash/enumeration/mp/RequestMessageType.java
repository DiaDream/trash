/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.enumeration.mp;

/**
 * 请求消息枚举类型
 */
public enum RequestMessageType
{
    /**
     * 请求消息类型: 文本 text
     */
    TEXT ("文本", "text"), 
    /**
     * 请求消息类型: 图片 image
     */
    IMAGE ("图片", "image"), 
    /**
     * 请求消息类型: 链接 link
     */
    LINK ("链接", "link"), 
    /**
     * 请求消息类型: 地理位置 location
     */
    LOCATION ("地理位置", "location"), 
    /**
     * 请求消息类型: 音频 voice
     */
    VOICE ("音频", "voice"), 
    /**
     * 请求消息类型: 事件 event
     */
    EVENT ("事件", "event");

    private RequestMessageType (String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    private String name;
    private String value;

    public String getValue ()
    {
        return value;
    }

    public String getName ()
    {
        return name;
    }

    /**
     * 根据枚举值取得枚举对象
     * 
     * @param typeValue
     * @return
     *
     */
    public static RequestMessageType findByValue (String typeValue)
    {
        for (RequestMessageType requestMessageType : values ())
        {
            if (requestMessageType.getValue ().equals (typeValue))
            {
                return requestMessageType;
            }
        }
        return null;
    }

    /**
     * 根据枚举值取得枚举名称
     * 
     * @param typeValue
     * @return
     *
     */
    public static String getNameByValue (String typeValue)
    {
        for (RequestMessageType requestMessageType : values ())
        {
            if (requestMessageType.getValue ().equals (typeValue))
            {
                return requestMessageType.getName ();
            }
        }
        return null;
    }
}
