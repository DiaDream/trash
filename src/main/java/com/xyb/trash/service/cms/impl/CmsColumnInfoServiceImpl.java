
/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.service.cms.impl;

import com.xyb.trash.dao.cms.CmsColumnInfoMapper;
import com.xyb.trash.pojo.cms.CmsColumnInfo;
import com.xyb.trash.service.cms.CmsColumnInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *新闻栏目服务类
 */
@Service
public class CmsColumnInfoServiceImpl implements CmsColumnInfoService
{
	/**
	 * 公司版权信息.
	 */
	public static final String copyright = "版权所有 2018, 凯歌健康";

	/**
	 * 提交路径.
	 */
	public static final String SCC_BRANCH = "$URL$";

	/**
	 * 提交日期.
	 */
	public static final String SCC_LAST_MODIFICATION_DATE = "$Date$";

	/**
	 * 最终修改人员.
	 */
	public static final String SCC_LAST_MODIFIER_NAME = "$Author$";

	/**
	 * 最终版本号.
	 */
	public static final String SCC_REVISION = "$Revision$";
	@Autowired
	private CmsColumnInfoMapper columnInfoMapper;
	@Override
	public List<CmsColumnInfo> getAllColumnList() {
		// TODO Auto-generated method stub
		return columnInfoMapper.getAllColumnList();
	}
	@Override
	public CmsColumnInfo getColumnById(long columnId) {
		return columnInfoMapper.selectByPrimaryKey(columnId);
	}
	@Override
	public List<CmsColumnInfo> getColumnListByCondition(Map<String, Object> buildParam) {
		// TODO Auto-generated method stub
		return columnInfoMapper.getColumnListByCondition(buildParam);
	}
	@Override
	public int addColumn(CmsColumnInfo nbc) {
		// TODO Auto-generated method stub
		return columnInfoMapper.insert(nbc);
	}
	@Override
	public int updateColumn(CmsColumnInfo nbc) {
		// TODO Auto-generated method stub
		return columnInfoMapper.updateByPrimaryKeySelective(nbc);
	}
}
