/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.service.cms;


import com.xyb.trash.pojo.cms.CmsMenu;
import com.xyb.trash.pojo.cms.CmsRole;

import java.util.List;
import java.util.Map;

/**
 * Created by BBZZ on 2017/11/28.
 */
public interface CmsAuthorizationService {
    /**
     *
     * @param params 查询参数列表 一般包括角色id和是否禁用的状态
     * @return 当前角色能使用的菜单集合
     */
    List<CmsMenu> getResouceListByRoleId(Map params);
    /**
     * 查询所有菜单
     * @return
     */
    List<CmsMenu> selectAllMenu();

    /**
     * 添加菜单
     * @param CmsMenu
     * @return
     */
    int addResource(CmsMenu CmsMenu);

    /**
     * 更新菜单
     * @param CmsMenu
     * @return
     */
    int updateResource(CmsMenu CmsMenu);

    /**
     * 删除菜单（软删除）
     * @param resourceId
     * @return
     */
    int deleteResource(long resourceId);

    /**
     * 查询所有角色
     * @return
     */
    List<CmsRole>  getAllRole();

    /**
     * 添加角色
     * @param role
     * @return
     */
    int addRole(CmsRole role);

    /**
     * 更新角色
     * @param role
     * @return
     */
    int updateRole(CmsRole role);

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    int deleteRole(long roleId);

    List<CmsMenu> getCurrentAuthorization(long roleId);

    int addMenuInRole(Long roleId, long[] longRoleIds);

}
