
/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.enumeration;


public enum SystemConfigType
{
 /**
  * 公众号appId
  */
 MP_APP_ID ("公众号appId", "MP_APP_ID"),
 /**
  * 公众号appSecret
  */
 MP_APP_SECRET ("公众号appSecret", "MP_APP_SECRET"),
 /**
  * 公众号token
  */
 MP_TOKEN ("公众号token", "MP_TOKEN");

    private String name;
    private String value;

    private SystemConfigType (String name, String value)
    {
        this.name = name;
        this.value = value;
    }
    /**
     * 取得枚举类型的值
     * @return
     */
    public String getValue ()
    {
        return this.value;
    }
    /**
     * 取得枚举类型的名称
     * @return
     */
    public String getName ()
    {
        return this.name;
    }
    /**
     * 根据枚举类型的值取得枚举类型
     * @param typeValue
     * @return
     */
    public static SystemConfigType findByValue (String typeValue)
    {
        for (SystemConfigType systemConfigType : values ())
        {
            if (systemConfigType.getValue ().equals (typeValue))
            {
                return systemConfigType;
            }
        }
        return null;
    }
    /**
     * 根据枚举类型的值取得枚举类型的名称
     * @param typeValue
     * @return
     */
    public static String getNameByValue (String typeValue)
    {
        for (SystemConfigType systemConfigType : values ())
        {
            if (systemConfigType.getValue ().equals (typeValue))
            {
                return systemConfigType.getName ();
            }
        }
        return null;
    }
}
