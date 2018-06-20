
/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.service.cms;

import com.xyb.trash.pojo.cms.CmsNews;

import java.util.List;
import java.util.Map;

/**
 *通知新闻服务类接口
 */

public interface CmsNewsService
{


	/**
	 * @param nbNoticeArticle
	 * @return
	 */
	int addNews(CmsNews nbNoticeArticle);

	/**
	 * @param nbNoticeArticle
	 * @return
	 */
	int updateNews(CmsNews nbNoticeArticle);

	/**
	 * @param buildParam
	 * @param offset
	 * @param limit
	 * @return 根据条件获得所有新闻数据
	 */
	List<CmsNews> getNewsList(Map<String, Object> buildParam, int offset, int limit);

	/**
	 * @param buildParam
	 * @return 获得总条数
	 */
	int countNews(Map<String, Object> buildParam);

	/**
	 * @param aid
	 * @return
	 */
	CmsNews getNewsById(long aid);

}
