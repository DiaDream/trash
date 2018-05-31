
/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.service.systemconfig;


import com.xyb.trash.pojo.oa.SystemConfig;

public interface SystemConfigService
{

    /**
     * 根据配置项的key取得配置项
     * @param configKey
     * @return
     */
    SystemConfig findSystemConfigByKey(String configKey);
    /**
     * 根据配置项的key取得配置项的值
     * @param configKey
     * @return
     */
    String findSystemConfigValueByKey(String configKey);
    /**
     * 取得公众号的appId
     * @return
     */
    String findMpAppId();
    /**
     * 取得公众号的appSecret
     * @return
     */
    String findMpAppSecret();
    /**
     * 取得公众号的token
     * @return
     */
    String findMpToken();
}
