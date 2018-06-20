/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.dao.cms;

import com.xyb.trash.annotation.OaDao;
import com.xyb.trash.pojo.cms.CmsNews;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * 新闻通知表
 */
@OaDao
public interface CmsNewsMapper {
    int deleteByPrimaryKey(Long articleId);

    int insert(CmsNews record);

    int insertSelective(CmsNews record);

    CmsNews selectByPrimaryKey(Long articleId);

    int updateByPrimaryKeySelective(CmsNews record);

    int updateByPrimaryKeyWithBLOBs(CmsNews record);

    int updateByPrimaryKey(CmsNews record);

	/**
	 * @param buildParam
	 * @param rowBounds
	 * @return
	 */
	List<CmsNews> getNewsList(Map<String, Object> buildParam, RowBounds rowBounds);

	/**
	 * @param buildParam
	 * @return
	 */
	int countNews(Map<String, Object> buildParam);
}