/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.dao.cms;

import com.xyb.trash.pojo.cms.CmsRole;

import java.util.List;

public interface CmsRoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(CmsRole record);

    int insertSelective(CmsRole record);

    CmsRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(CmsRole record);

    int updateByPrimaryKey(CmsRole record);

    List<CmsRole> getAllRole();
}