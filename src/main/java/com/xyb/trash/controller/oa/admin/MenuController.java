
/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.controller.oa.admin;


import com.xyb.trash.controller.BaseController;
import com.xyb.trash.util.commonutil.LogUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


/**
 * 首页controller
 */
@RequestMapping (value = "${server.rootpath}/admin")
@Controller
public class MenuController extends BaseController
{



    /**
     * 日志工具类
     */
    private static final LogUtil log = new LogUtil (LoggerFactory.getLogger (MenuController.class.getName ()));
    
    @Value("${site.name}")
    protected String siteName;
    /**
     * 取得顶部菜单
     * @param request
     * @return
     */
    @RequestMapping (value = "getTopMenu")
    public String getTopMenu (HttpServletRequest request)
    {
        return "/admin/topMenu";
    }
    
    /**
     * 取得左侧菜单
     * @param request
     * @return
     */
    @RequestMapping (value = "getLeftMenu")
    public String getLeftMenu (HttpServletRequest request, String userName, String password)
    {
        return "/admin/leftMenu";
    }
    
    /**
     * 取得左侧菜单
     * @param request
     * @return
     */
    @RequestMapping (value = "toTest")
    public String toTest (HttpServletRequest request, String userName, String password)
    {
        return "/admin/test";
    }
}
