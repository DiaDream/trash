/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.controller.mp;

import com.xyb.trash.constants.CommonConst;
import com.xyb.trash.controller.BaseController;
import com.xyb.trash.pojo.mp.OAuthAccessToken;
import com.xyb.trash.service.mp.MessageProcessService;
import com.xyb.trash.service.systemconfig.SystemConfigService;
import com.xyb.trash.util.commonutil.LogUtil;
import com.xyb.trash.util.commonutil.SignUtil;
import com.xyb.trash.util.commonutil.WxCommonUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



/**
 * 微信公众号核心消息服务Controller
 * 
 * @author chenqiang
 * @version 2017-02-22
 */
@Controller
@RequestMapping (value = "${server.rootpath}")
public class MpCoreController extends BaseController
{
    /**
     * 日志工具类
     */
    private static final LogUtil log = new LogUtil (LoggerFactory.getLogger (MpCoreController.class.getName ()));
    @Autowired
    private MessageProcessService messageProcessService;
    @Autowired
    private SystemConfigService systemConfigService;
    /**
     * 微信公众号服务器get和post请求转发处理器
     * 
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     */
    @RequestMapping (value = "mpMsgDispatch")
    public void mpMsgDispatcher (HttpServletRequest request, HttpServletResponse response)
    {
        PrintWriter out = null;
        if ("get".equalsIgnoreCase (request.getMethod ()))// 微信服务器发过来的验证服务是否配置正确的通知
        {
            try
            {
                // 微信加密签名
                String signature = request.getParameter ("signature");
                // 时间戳
                String timestamp = request.getParameter ("timestamp");
                // 随机数
                String nonce = request.getParameter ("nonce");
                // 随机字符串
                String echostr = request.getParameter ("echostr");

                out = response.getWriter ();
                // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
                if (SignUtil.checkSignature (systemConfigService.findMpToken (), signature, timestamp, nonce))
                {
                    out.print (echostr);
                }
            }
            catch (IOException e)
            {
                log.errorLog ("mpMsgDispatcher () error.", e);
            }
            finally
            {
                if (null != out)
                {
                    out.flush ();
                    out.close ();
                }
            }
        }
        else
        // 微信服务器发过来的消息通知
        {
            try
            {
                response.setCharacterEncoding (CommonConst.ENCODE_UTF8);
                String responseMessage = messageProcessService.requestProccess (request);
                // 响应消息
                if (null != responseMessage && !"".equals (responseMessage))
                {
                    out = response.getWriter ();
                    out.print (responseMessage);
                }
            }
            catch (IOException e)
            {
                log.errorLog ("mpMsgDispatcher () error.", e);
            }
            finally
            {
                if (null != out)
                {
                    out.flush ();
                    out.close ();
                }
            }
        }

    }

    /**
     * 微信公众号通过微信oauth认证过来的请求的转发处理器
     * 
     * @param request HttpServletRequest
     * @return
     */
    @RequestMapping (value = "mpOauthReqProcess")
    public String mpOauthRequestProcess (HttpServletRequest request)
    {
        String requestMenuCode = request.getParameter ("menuCode");// 获取到用户openId后要跳转到的请求地址
        String code = request.getParameter ("code");// 用户同意授权以后微信发过来的一个编码
        if (null == code || code.trim ().length () == 0)// 没有拿到编码，说明用户拒绝了授权
        {
            return wxServiceErrorPage;
        }
        else
        {
            OAuthAccessToken oauthToken = null;
            String wxOpenId = getWxOpenId (request);
            if (wxOpenId == null)
            {
                // 拿到了编码
                oauthToken = WxCommonUtil.getOAuthAccessToken (systemConfigService.findMpAppId (), systemConfigService.findMpAppSecret (), code);
                if (null == oauthToken)// 说明微信发过来的第一次请求就没拿到用户openid
                {
                    return wxServiceErrorPage;
                }
                else
                {
                    setWxOpenId (request, oauthToken.getOpenId ());
                    wxOpenId = oauthToken.getOpenId ();
                }
            }
            String remoteAddr = request.getRemoteAddr ();
            request.setAttribute ("remoteAddr", remoteAddr);// 客户端ip地址
            // 注入服务器域名到session
            request.getSession ().setAttribute ("serviceDomain", super.serviceDomain);
            if ("toIndex".equals (requestMenuCode))
            {
                

            }
            else if ("counselorBind".equals (requestMenuCode))
            {
                // 跳转到咨询师绑定
                return "forward:/counselor/bindCounselor";
            }
            else if ("otherBind".equals (requestMenuCode))
            {
                // 跳转到其它用户绑定
                return "forward:/other/bindOtherUser";
            }
            else if ("leaderBind".equals (requestMenuCode))
            {
                // 跳转到领导绑定
                return "forward:/leader/bindLeaderUser";
            }
        }
        return wxServiceErrorPage;
    }
}
