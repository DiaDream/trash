/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */


package com.xyb.trash.service.mp;

import javax.servlet.http.HttpServletRequest;


/**
 * 微信消息处理接口
 */
public interface MessageProcessService
{
    /**
     * 公司版权信息.
     */
    public static final String COPYRIGHT = "版权所有 2018, icarehx.com";

    /**
     * 处理平台（比如微信）发过来的请求
     * 
     * @param request
     * @return
     *
     */
    String requestProccess(HttpServletRequest request);

    /**
     * 主动推送文本消息给指定的用户
     * 
     * @param targetAccount 消息接收方账号（在微信中这里填接收方的openId）
     * @param msgContent 消息内容
     * @return
     * @throws
     *
     */
    String sendTextMessage(String targetAccount, String msgContent);
}
