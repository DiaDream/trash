
/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.service.cms;

import com.xyb.trash.pojo.cms.CmsColumnInfo;

import java.util.List;
import java.util.Map;


/**
 *新闻栏目服务类接口
 */

public interface CmsColumnInfoService {


	/**
	 * @return
	 */
	List<CmsColumnInfo> getAllColumnList();

	/**
	 * @return
	 */
	CmsColumnInfo getColumnById(long id);

	/**
	 * @param buildParam
	 * @return
	 */
	List<CmsColumnInfo> getColumnListByCondition(Map<String, Object> buildParam);

	/**
	 * @param nbc
	 * @return
	 */
	int addColumn(CmsColumnInfo nbc);

	/**
	 * @param nbc
	 * @return
	 */
	int updateColumn(CmsColumnInfo nbc);

}
