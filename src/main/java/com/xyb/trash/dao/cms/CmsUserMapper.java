/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.dao.cms;


import com.xyb.trash.pojo.cms.CmsMenu;
import com.xyb.trash.pojo.cms.CmsUser;

import java.util.List;
import java.util.Map;

public interface CmsUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(CmsUser record);

    int insertSelective(CmsUser record);

    CmsUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(CmsUser record);

    int updateByPrimaryKey(CmsUser record);

    List<CmsMenu> getResouceListByRoleId(Map params);

    List<CmsMenu> selectAllMenu();
}