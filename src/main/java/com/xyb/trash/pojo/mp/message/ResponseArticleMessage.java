/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */


package com.xyb.trash.pojo.mp.message;

import com.xyb.trash.pojo.mp.Articles;

/**
 * 图文形式的响应消息
 */
public class ResponseArticleMessage extends ResponseMessage
{
    /**
     * 
     */
    private static final long serialVersionUID = -7967601009739483108L;


    /**
     * 图文消息个数，限制为10条以内
     */
    private int ArticleCount;
    
    /**
     * 多条图文消息信息，默认第一个item为大图
     */
    private Articles Articles;

    /**
     *  取得图文消息个数，限制为10条以内
     * @return the articleCount
     */
    public int getArticleCount ()
    {
        return ArticleCount;
    }

    /**
     * 设置图文消息个数，限制为10条以内
     * @param articleCount the articleCount to set.
     */
    public void setArticleCount (int articleCount)
    {
        ArticleCount = articleCount;
    }

    /**
     *  取得多条图文消息信息，默认第一个item为大图
     * @return the articles
     */
    public Articles getArticles ()
    {
        return Articles;
    }

    /**
     * 设置多条图文消息信息，默认第一个item为大图
     * @param articles the articles to set.
     */
    public void setArticles (Articles articles)
    {
        Articles = articles;
    }

    /* (non-Javadoc)
    
     * @see java.lang.Object#toString()
    
     */
    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("ResponseArticleMessage [ArticleCount=");
        builder.append (ArticleCount);
        builder.append (", Articles=");
        builder.append (Articles);
        builder.append (", super.toString()=");
        builder.append (super.toString ());
        builder.append ("]");
        return builder.toString ();
    }

}
