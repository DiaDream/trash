
/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.service.cms.impl;

import com.xyb.trash.dao.cms.CmsNewsMapper;
import com.xyb.trash.pojo.cms.CmsNews;
import com.xyb.trash.service.cms.CmsNewsService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *通知新闻服务类
 */
@Service
public class CmsNewsServiceImpl implements CmsNewsService
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
	private CmsNewsMapper nbNoticeArticleMapper;
	
	@Override
	public int addNews(CmsNews nbNoticeArticle) {
		// TODO Auto-generated method stub
		return nbNoticeArticleMapper.insert(nbNoticeArticle);
	}

	@Override
	public int updateNews(CmsNews nbNoticeArticle) {
		// TODO Auto-generated method stub
		return nbNoticeArticleMapper.updateByPrimaryKeySelective(nbNoticeArticle);
	}

	@Override
	public List<CmsNews> getNewsList(Map<String, Object> buildParam, int offset, int limit) {
		// TODO Auto-generated method stub
		return nbNoticeArticleMapper.getNewsList (buildParam, new RowBounds (offset, limit));
	}

	@Override
	public int countNews(Map<String, Object> buildParam) {
		// TODO Auto-generated method stub
		return nbNoticeArticleMapper.countNews(buildParam);
	}

	@Override
	public CmsNews getNewsById(long aid) {
		// TODO Auto-generated method stub
		return nbNoticeArticleMapper.selectByPrimaryKey(aid);
	}
}
