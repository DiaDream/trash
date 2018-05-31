/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.util.commonutil;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.druid.util.StringUtils;

/**
 * 自定义数据源（增加了对加密后的配置文件中的数据库用户名密码解密的功能）
 * Created by xieyunbo on 2018/5/3.
 */
public class EncryptDataSource  extends DruidDataSource
{
    private final static Log LOG = LogFactory.getLog (EncryptDataSource.class);

    @Override
    public void setUsername(String username) {
        if (inited)
        {
            throw new UnsupportedOperationException ();
        }
        if (null != username)
        {
            this.username = Cryptos.aesDecrypt (username);
        }
    }

    @Override
    public void setPassword(String password) {
        if (null == password)
        {
            return;
        }
        if (StringUtils.equals (this.password, Cryptos.aesDecrypt (password)))
        {
            return;
        }

        if (inited)
        {
            LOG.info ("password changed");
        }
        this.password = Cryptos.aesDecrypt (password);
    }
}
