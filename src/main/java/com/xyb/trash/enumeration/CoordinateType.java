/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.enumeration;

/**
 * 地图坐标类型
 */
public enum CoordinateType
{
    /**
     * GPS经纬度: wgs84ll
     */
    WGS84 ("GPS经纬度", "wgs84ll"),
    /**
     * 百度经纬度：bd09ll
     */
    BD09ll ("百度经纬度", "bd09ll"),
    /**
     * 百度米制坐标：bd09mc
     */
    BD09mc ("国测局经纬度", "bd09mc"),
    /**
     * 国测局经纬度：gcj02ll
     */
    gcj02ll ("国测局经纬度", "gcj02ll");

    private CoordinateType (String name, String value)
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
    public static CoordinateType findByValue (String typeValue)
    {
        for (CoordinateType coordinateType : values ())
        {
            if (coordinateType.getValue ().equals (typeValue))
            {
                return coordinateType;
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
        for (CoordinateType coordinateType : values ())
        {
            if (coordinateType.getValue ().equals (typeValue))
            {
                return coordinateType.getName ();
            }
        }
        return null;
    }
}
