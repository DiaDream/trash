/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.enumeration.mp;

/**
 * 事件类型
 */
public enum EventType
{
    /**
     * 事件类型: 订阅 subscribe
     */
    SUBSCRIBE ("订阅", "subscribe"),
    /**
     * 事件类型: 取消订阅 unsubscribe
     */
    UNSUBSCRIBE ("取消订阅", "unsubscribe"),
    /**
     * 事件类型: 自定义菜单点击事件 CLICK
     */
    CLICK ("自定义菜单点击事件", "CLICK"),
    /**
     * 事件类型: 上报地理位置 LOCATION
     */
    LOCATION ("上报地理位置", "LOCATION"),
    /**
     * 事件类型: 进入会话 ENTER
     */
    ENTER ("进入会话", "ENTER");

    private EventType (String name, String value)
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
    public static EventType findByValue (String typeValue)
    {
        for (EventType eventType : values ())
        {
            if (eventType.getValue ().equals (typeValue))
            {
                return eventType;
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
        for (EventType eventType : values ())
        {
            if (eventType.getValue ().equals (typeValue))
            {
                return eventType.getName ();
            }
        }
        return null;
    }
}
