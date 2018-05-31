
/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.service.systemconfig.impl;

import com.xyb.trash.dao.oa.SystemConfigMapper;
import com.xyb.trash.enumeration.SystemConfigType;
import com.xyb.trash.pojo.oa.SystemConfig;
import com.xyb.trash.service.systemconfig.SystemConfigService;
import com.xyb.trash.util.commonutil.Cryptos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DefaultSystemConfigServiceImpl implements SystemConfigService
{


    private static Map <String, SystemConfig> systemConfigsMap = new HashMap <> ();
    @Autowired
    private SystemConfigMapper m_systemConfigMapper;

    /**
     * 初始化系统配置项缓存
     */
    @PostConstruct
    public void initSystemConfig ()
    {
        List <SystemConfig> configs = m_systemConfigMapper.findAllSystemConfigs ();
        if (configs != null && !configs.isEmpty ())
        {
            for (SystemConfig config : configs)
            {
                systemConfigsMap.put (config.getConfigKey (), config);
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.foxkissme.service.SystemConfigService#findSystemConfigByKey(java.lang
     * .String)
     */
    @Override
    public SystemConfig findSystemConfigByKey (String configKey)
    {
        if (systemConfigsMap.containsKey (configKey))
        {
            return systemConfigsMap.get (configKey);
        }
        SystemConfig config = m_systemConfigMapper.findSystemConfigByKey (configKey);
        if (config != null)
        {
            systemConfigsMap.put (configKey, config);
            return config;
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.foxkissme.service.SystemConfigService#findSystemConfigValueByKey(java
     * .lang.String)
     */
    @Override
    public String findSystemConfigValueByKey (String configKey)
    {
        if (systemConfigsMap.containsKey (configKey))
        {
            return systemConfigsMap.get (configKey).getConfigValue ();
        }
        SystemConfig config = this.m_systemConfigMapper.findSystemConfigByKey (configKey);
        if (config != null)
        {
            systemConfigsMap.put (configKey, config);
            return config.getConfigValue ();
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.foxkissme.service.SystemConfigService#findMpAppId()
     */
    @Override
    public String findMpAppId ()
    {
        if (systemConfigsMap.containsKey (SystemConfigType.MP_APP_ID.getValue ()))
        {
            return Cryptos.aesDecrypt (systemConfigsMap.get (SystemConfigType.MP_APP_ID.getValue ()).getConfigValue ());
        }
        SystemConfig config = this.m_systemConfigMapper.findSystemConfigByKey (SystemConfigType.MP_APP_ID.getValue ());
        if (config != null)
        {
            systemConfigsMap.put (SystemConfigType.MP_APP_ID.getValue (), config);
            return Cryptos.aesDecrypt (config.getConfigValue ());
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.foxkissme.service.SystemConfigService#findMpAppSecret()
     */
    @Override
    public String findMpAppSecret ()
    {
        if (systemConfigsMap.containsKey (SystemConfigType.MP_APP_SECRET.getValue ()))
        {
            return Cryptos.aesDecrypt (systemConfigsMap.get (SystemConfigType.MP_APP_SECRET.getValue ()).getConfigValue ());
        }
        SystemConfig config = this.m_systemConfigMapper.findSystemConfigByKey (SystemConfigType.MP_APP_SECRET.getValue ());
        if (config != null)
        {
            systemConfigsMap.put (SystemConfigType.MP_APP_SECRET.getValue (), config);
            return Cryptos.aesDecrypt (config.getConfigValue ());
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.foxkissme.service.SystemConfigService#findMpToken()
     */
    @Override
    public String findMpToken ()
    {
        if (systemConfigsMap.containsKey (SystemConfigType.MP_TOKEN.getValue ()))
        {
            return Cryptos.aesDecrypt (systemConfigsMap.get (SystemConfigType.MP_TOKEN.getValue ()).getConfigValue ());
        }
        SystemConfig config = this.m_systemConfigMapper.findSystemConfigByKey (SystemConfigType.MP_TOKEN.getValue ());
        if (config != null)
        {
            systemConfigsMap.put (SystemConfigType.MP_TOKEN.getValue (), config);
            return Cryptos.aesDecrypt (config.getConfigValue ());
        }
        return null;
    }
}
