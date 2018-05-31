
/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.dao.oa;

import com.xyb.trash.annotation.OaDao;
import com.xyb.trash.pojo.oa.SystemConfig;

import java.util.List;



@OaDao
public interface SystemConfigMapper
{

    /**
     * 取得所有的系统配置项
     * @return
     */
    List<SystemConfig> findAllSystemConfigs();
    /**
     * 根据系统配置项key取得系统配置项
     * @param configKey
     * @return
     */
    SystemConfig findSystemConfigByKey(String configKey);
}
