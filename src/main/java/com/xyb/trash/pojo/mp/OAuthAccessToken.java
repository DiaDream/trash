/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 
 * $Id$
 * 
 * 版权所有 ( c ) 2014 湖南凯歌医疗信息技术有限公司.
 *
 */

package com.xyb.trash.pojo.mp;

import java.io.Serializable;

/**
 * 微信OAuth认证的AccessToken对象
 */
public class OAuthAccessToken implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = -5465603959320913834L;


    /**
     * 网页授权接口调用凭证, 此access_token与基础支持的access_token不同
     */
    private String accessToken;
    /**
     * access_token接口调用凭证超时时间，单位（秒）
     */
    private String expiresIn;
    /**
     * 用户刷新access_token
     */
    private String refreshToken;
    /**
     * 用户唯一标识
     */
    private String openId;
    /**
     * 用户授权作用域
     */
    private String scope;
    /**
     * 用户对应的微信开放平台唯一标识（是同一服务商多个公众号下跨公众号服务时识别用户得唯一标识）
     */
    private String unionId;

    /**
     * 取得网页授权接口调用凭证, 此access_token与基础支持的access_token不同
     * 
     * @return the accessToken
     */
    public String getAccessToken ()
    {
        return accessToken;
    }

    /**
     * 设置网页授权接口调用凭证, 此access_token与基础支持的access_token不同
     * 
     * @param accessToken the accessToken to set.
     */
    public void setAccessToken (String accessToken)
    {
        this.accessToken = accessToken;
    }

    /**
     * 取得access_token接口调用凭证超时时间，单位（秒）
     * 
     * @return the expiresIn
     */
    public String getExpiresIn ()
    {
        return expiresIn;
    }

    /**
     * 设置access_token接口调用凭证超时时间，单位（秒）
     * 
     * @param expiresIn the expiresIn to set.
     */
    public void setExpiresIn (String expiresIn)
    {
        this.expiresIn = expiresIn;
    }

    /**
     * 取得用户刷新access_token
     * 
     * @return the refreshToken
     */
    public String getRefreshToken ()
    {
        return refreshToken;
    }

    /**
     * 设置用户刷新access_token
     * 
     * @param refreshToken the refreshToken to set.
     */
    public void setRefreshToken (String refreshToken)
    {
        this.refreshToken = refreshToken;
    }

    /**
     * 取得用户唯一标识
     * 
     * @return the openId
     */
    public String getOpenId ()
    {
        return openId;
    }

    /**
     * 设置用户唯一标识
     * 
     * @param openId the openId to set.
     */
    public void setOpenId (String openId)
    {
        this.openId = openId;
    }

    /**
     * 取得用户授权作用域
     * 
     * @return the scope
     */
    public String getScope ()
    {
        return scope;
    }

    /**
     * 设置用户授权作用域
     * 
     * @param scope the scope to set.
     */
    public void setScope (String scope)
    {
        this.scope = scope;
    }

    /**
     * 取得用户对应的微信开放平台唯一标识（是同一服务商多个公众号下跨公众号服务时识别用户得唯一标识）
     * 
     * @return the unionId
     */
    public String getUnionId ()
    {
        return unionId;
    }

    /**
     * 设置用户对应的微信开放平台唯一标识（是同一服务商多个公众号下跨公众号服务时识别用户得唯一标识）
     * 
     * @param unionId the unionId to set.
     */
    public void setUnionId (String unionId)
    {
        this.unionId = unionId;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("OAuthAccessToken [accessToken=");
        builder.append (accessToken);
        builder.append (", expiresIn=");
        builder.append (expiresIn);
        builder.append (", refreshToken=");
        builder.append (refreshToken);
        builder.append (", openId=");
        builder.append (openId);
        builder.append (", scope=");
        builder.append (scope);
        builder.append (", unionId=");
        builder.append (unionId);
        builder.append ("]");
        return builder.toString ();
    }
}
