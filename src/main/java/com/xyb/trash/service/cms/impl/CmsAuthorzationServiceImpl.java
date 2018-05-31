/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.service.cms.impl;

import com.xyb.trash.dao.cms.CmsMenuMapper;
import com.xyb.trash.dao.cms.CmsRoleMapper;
import com.xyb.trash.dao.cms.CmsRoleMenuMapper;
import com.xyb.trash.dao.cms.CmsUserMapper;
import com.xyb.trash.pojo.cms.CmsMenu;
import com.xyb.trash.pojo.cms.CmsRole;
import com.xyb.trash.pojo.cms.CmsRoleMenu;
import com.xyb.trash.service.cms.CmsAuthorizationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by BBZZ on 2017/11/28.
 */
@Service("authorizationService")
public class CmsAuthorzationServiceImpl implements CmsAuthorizationService {
    //进入模板页面
    @Resource
    private CmsUserMapper cmsUserMapper;
    @Resource
    private CmsMenuMapper cmsMenuMapper;


    @Resource
    private CmsRoleMapper cmsRoleMapper;
    @Resource
    private CmsRoleMenuMapper cmsRoleMenuMapper;
    public List<CmsMenu> getResouceListByRoleId(Map params) {
        List<CmsMenu> resouceListByRoleId = cmsUserMapper.getResouceListByRoleId(params);
        return resouceListByRoleId;
    }

    public List<CmsMenu> selectAllMenu() {
        List<CmsMenu> CmsMenus = cmsUserMapper.selectAllMenu();
        return CmsMenus;
    }

    public int addResource(CmsMenu CmsMenu) {
        return cmsMenuMapper.insert(CmsMenu);
    }

    public int updateResource(CmsMenu CmsMenu) {
        return cmsMenuMapper.updateByPrimaryKeySelective(CmsMenu);
    }

    public int deleteResource(long resourceId) {
        return cmsMenuMapper.deleteByPrimaryKey(resourceId);
    }

    public List<CmsRole> getAllRole() {
        return cmsRoleMapper.getAllRole();
    }

    public int addRole(CmsRole role) {
        return cmsRoleMapper.insert(role);
    }

    public int updateRole(CmsRole role) {
        return cmsRoleMapper.updateByPrimaryKeySelective(role);
    }

    public int deleteRole(long roleId) {
        return cmsRoleMapper.deleteByPrimaryKey(roleId);
    }

    public List<CmsMenu> getCurrentAuthorization(long roleId) {

        //构造查询参数
        Map selectParams = new HashMap();
        selectParams.put ("roleId",  roleId);
        //获得正常能使用的资源0，正常，1禁用，2删除
        selectParams.put ("resourceStatu", 0);
        List<CmsMenu> resouceListByRoleId = cmsUserMapper.getResouceListByRoleId(selectParams);
        //得到所有菜单
        List<CmsMenu> allrole =cmsUserMapper.selectAllMenu();

        List<CmsMenu> hasmenu = new ArrayList<CmsMenu>();
        //遍历所有菜单
        for (CmsMenu all_menu:allrole) {
            //遍历当前角色拥有的权限
            CmsMenu temp=null;
            for (CmsMenu role_menu:resouceListByRoleId
                    ) {
                //如果角色id相等，说明他已经拥有该权限id被选中
                if(all_menu.getResourceId()==role_menu.getResourceId()){
                    temp = all_menu;
                    temp.setIscheck(1);
                    break;
                }
            }
            //如果不相等代表为空设置为0
            if (temp==null){
                temp= all_menu;
                temp.setIscheck(0);
            }
            hasmenu.add(temp);

        }
        return  hasmenu;
    }

    public int addMenuInRole(Long roleId, long[] longRoleIds) {
        int deleteFlag = cmsRoleMenuMapper.delResourceByRoleId(roleId);

        for (int i=0;i<longRoleIds.length;i++){
            CmsRoleMenu CmsRoleMenu=new CmsRoleMenu();
            CmsRoleMenu.setRoleId(roleId);
            CmsRoleMenu.setResourceId(longRoleIds[i]);
            deleteFlag = cmsRoleMenuMapper.insert(CmsRoleMenu);
        }
        return deleteFlag;
    }

}
