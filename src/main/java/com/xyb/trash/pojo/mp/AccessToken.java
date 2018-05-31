/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.pojo.mp;

import java.util.Date;

public class AccessToken
{


    /**
     * 
     * @param args
     * 
     */
    public static void main (String[] args)
    {
        // TODO Auto-generated method stub

    }

    /**
     * 获取到的凭证
     */
    private String token;
    /**
     * 凭证有效时间，单位：秒 
     */
    private int expiresIn;
    /**
     * 令牌创建时间
     */
    private Date createTime;
    /**
     * 获取凭证
     * @return
     */
    public String getToken ()
    {
        return token;
    }
    
    /**
     * 设置凭证
     * @param token
     */
    public void setToken (String token)
    {
        this.token = token;
    }
    /**
     * 取得凭证有效时间，单位：秒
     * @return
     */
    public int getExpiresIn ()
    {
        return expiresIn;
    }
    
    /**
     * 设置凭证有效时间，单位：秒
     * @param expiresIn
     */
    public void setExpiresIn (int expiresIn)
    {
        this.expiresIn = expiresIn;
    }

    /**
     * 取得令牌创建时间
     * @return the createTime
     */
    public Date getCreateTime ()
    {
        return createTime;
    }

    /**
     * 设置令牌创建时间
     * @param createTime the createTime to set.
     */
    public void setCreateTime (Date createTime)
    {
        this.createTime = createTime;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("AccessToken [token=");
        builder.append (token);
        builder.append (", expiresIn=");
        builder.append (expiresIn);
        builder.append (", createTime=");
        builder.append (createTime);
        builder.append ("]");
        return builder.toString ();
    }

    
}
