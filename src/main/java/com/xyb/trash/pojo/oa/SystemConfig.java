
/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.pojo.oa;


import com.xyb.trash.pojo.BasePojo;

public class SystemConfig extends BasePojo
{
    /**
     * 
     */
    private static final long serialVersionUID = -2052801367212143216L;
    /**
     * 配置项的key
     */
    private String configKey;
    /**
     * 配置项的值
     */
    private String configValue;
    /**
     * 配置项描述
     */
    private String configDesc;
    
    /**
     * 取得配置项的key
     * @return the configKey
     */
    public String getConfigKey ()
    {
        return configKey;
    }
    /**
     * 设置配置项的key
     * @param configKey the configKey to set.
     */
    public void setConfigKey (String configKey)
    {
        this.configKey = configKey;
    }
    /**
     * 取得配置项的值
     * @return the configValue
     */
    public String getConfigValue ()
    {
        return configValue;
    }
    /**
     * 设置配置项的值
     * @param configValue the configValue to set.
     */
    public void setConfigValue (String configValue)
    {
        this.configValue = configValue;
    }
    /**
     * 取得配置项描述
     * @return the configDesc
     */
    public String getConfigDesc ()
    {
        return configDesc;
    }
    /**
     * 设置配置项描述
     * @param configDesc the configDesc to set.
     */
    public void setConfigDesc (String configDesc)
    {
        this.configDesc = configDesc;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("SystemConfig [");
        if (configKey != null)
        {
            builder.append ("configKey=");
            builder.append (configKey);
            builder.append (", ");
        }
        if (configValue != null)
        {
            builder.append ("configValue=");
            builder.append (configValue);
            builder.append (", ");
        }
        if (configDesc != null)
        {
            builder.append ("configDesc=");
            builder.append (configDesc);
        }
        builder.append ("]");
        return builder.toString ();
    }
}
