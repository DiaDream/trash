/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.controller.cms.cmsadmin;

/**
 * Created by xieyunbo on 2018/5/31.
 */

import com.xyb.trash.util.commonutil.LogUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 首页controller
 */
@RequestMapping(value = "${server.rootpath}/cmsadmin")
@Controller
public class CmsLoginController {
    /**
     * 日志工具类
     */
    private static final LogUtil log = new LogUtil(LoggerFactory.getLogger (CmsLoginController.class.getName()));

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
        return "/cms/admin/index";
    }
    /**
     * 跳转到dashboard界面
     * @param request
     * @return
     */
    @RequestMapping (value = "toDashboard")
    public String toDashboard (HttpServletRequest request)
    {
        return "/cms/admin/dashboard";
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
        return "/cms/admin/profile";
    }

}
