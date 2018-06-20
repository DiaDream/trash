
/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.controller.oa.admin;

import com.xyb.trash.constants.CommonConst;
import com.xyb.trash.controller.BaseController;
import com.xyb.trash.util.commonutil.LogUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


/**
 * 首页controller
 */
@RequestMapping (value = "${server.rootpath}/admin")
@Controller
public class LoginController extends BaseController
{
    
    /**
     * 日志工具类
     */
    private static final LogUtil log = new LogUtil(LoggerFactory.getLogger (LoginController.class.getName ()));
    
    @Value("${site.name}")
    protected String siteName;
    /**
     * 跳转到登录界面
     * @param request
     * @return
     */
    @RequestMapping (value = "toLogin")
    public String toLogin (HttpServletRequest request)
    {
        System.out.println(siteName);
        request.getSession ().setAttribute ("siteName", siteName);
        return "/login";
    }
    
    /**
     * 跳转到登录界面
     * @param request
     * @return
     */
    @RequestMapping (value = "login")
    public String login (HttpServletRequest request, String userName, String password)
    {
        log.infoLog ("============" + userName);
        log.infoLog ("============" + password);
        return "redirect:/admin/index";
    }
    /**
     * 跳转到index界面
     * @param request
     * @return
     */
    @RequestMapping (value = "index")
    public String toIndex (HttpServletRequest request)
    {
        return "/admin/index";
    }
    /**
     * 跳转到dashboard界面
     * @param request
     * @return
     */
    @RequestMapping (value = "toDashboard")
    public String toDashboard (HttpServletRequest request)
    {
        return "/admin/dashboard";
    }
    
    /**
     * 跳转到个人中心界面
     * @param request
     * @return
     */
    @RequestMapping (value = "toProfile")
    public String toProfile (HttpServletRequest request, HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin","*");
        return "/admin/profile";
    }
    /**
     * 跳转到首页
     * @param request
     * @return
     * @throws UnsupportedEncodingException 
     */
    @RequestMapping (value = "smallApp")
    public void smallApp (HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
    {
        PrintWriter out = null;
        String responseMessage = "111";
        String nickName = request.getParameter ("nickName");
        System.out.println ("========================" + URLDecoder.decode (nickName, "UTF-8"));
        try
        {
            // 响应消息
            if (null != responseMessage && !"".equals (responseMessage))
            {
                response.setCharacterEncoding (CommonConst.ENCODE_UTF8);
                out = response.getWriter ();
                out.print (responseMessage);
            }
        }
        catch (IOException e)
        {
            log.errorLog ("smallApp () error.", e);
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
