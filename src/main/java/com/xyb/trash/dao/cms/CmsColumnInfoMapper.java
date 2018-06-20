/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.dao.cms;

import com.xyb.trash.annotation.OaDao;
import com.xyb.trash.pojo.cms.CmsColumnInfo;

import java.util.List;
import java.util.Map;

/**
 * 新闻栏目表
 */
@OaDao
public interface CmsColumnInfoMapper {
    int deleteByPrimaryKey(Long columnId);

    int insert(CmsColumnInfo record);

    int insertSelective(CmsColumnInfo record);

    CmsColumnInfo selectByPrimaryKey(Long columnId);

    int updateByPrimaryKeySelective(CmsColumnInfo record);

    int updateByPrimaryKey(CmsColumnInfo record);

	/**
	 * @return
	 */
    List<CmsColumnInfo> getAllColumnList();

	/**
	 * @param buildParam
	 * @return
	 */
	List<CmsColumnInfo> getColumnListByCondition(Map<String, Object> buildParam);
}