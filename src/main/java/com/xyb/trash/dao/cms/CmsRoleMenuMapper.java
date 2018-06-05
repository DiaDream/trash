/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.dao.cms;


import com.xyb.trash.annotation.OaDao;
import com.xyb.trash.pojo.cms.CmsRoleMenu;
@OaDao
public interface CmsRoleMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CmsRoleMenu record);

    int insertSelective(CmsRoleMenu record);

    CmsRoleMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CmsRoleMenu record);

    int updateByPrimaryKey(CmsRoleMenu record);

    int delResourceByRoleId(long roleId);
}