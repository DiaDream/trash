/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.enumeration.mp;

/**
 * 响应消息枚举类型
 */
public enum ResponseMessageType
{
    /**
     * 响应消息类型: 文本 text
     */
    TEXT ("文本", "text"), 
    /**
     * 响应消息类型: 音乐 music
     */
    MUSIC ("音乐", "music"), 
    /**
     * 响应消息类型: 图文 news
     */
    ARTICLE ("图文", "news"), 
    /**
     * 响应消息类型: 图片 image
     */
    IMAGE ("图片", "image"),
    /**
     * 响应消息类型: 转发给多客服系统 transfer_customer_service
     */
    CUSTOMER_MSG ("转发给多客服系统", "transfer_customer_service");

    private ResponseMessageType (String name, String value)
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
    public static ResponseMessageType findByValue (String typeValue)
    {
        for (ResponseMessageType responseMessageType : values ())
        {
            if (responseMessageType.getValue ().equals (typeValue))
            {
                return responseMessageType;
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
        for (ResponseMessageType responseMessageType : values ())
        {
            if (responseMessageType.getValue ().equals (typeValue))
            {
                return responseMessageType.getName ();
            }
        }
        return null;
    }
}
