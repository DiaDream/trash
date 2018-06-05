/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.dao.cms;


import com.xyb.trash.annotation.OaDao;
import com.xyb.trash.pojo.cms.CmsMenu;
@OaDao
public interface CmsMenuMapper {
    int deleteByPrimaryKey(Long resourceId);

    int insert(CmsMenu record);

    int insertSelective(CmsMenu record);

    CmsMenu selectByPrimaryKey(Long resourceId);

    int updateByPrimaryKeySelective(CmsMenu record);

    int updateByPrimaryKey(CmsMenu record);
}