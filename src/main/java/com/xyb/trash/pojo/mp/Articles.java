/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */



package com.xyb.trash.pojo.mp;

import java.util.List;

/**
 * 多个文章对象
 */
public class Articles
{

    /**
     * 多条图文消息信息，默认第一个item为大图
     */
    private List <Article> item;
    /**
     *  取得多条图文消息信息，默认第一个item为大图
     * @return the item
     */
    public List <Article> getItem ()
    {
        return item;
    }
    /**
     * 设置多条图文消息信息，默认第一个item为大图
     * @param item the item to set.
     */
    public void setItem (List <Article> item)
    {
        this.item = item;
    }
    /* (non-Javadoc)
    
     * @see java.lang.Object#toString()
    
     */
    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("Articles [item=");
        builder.append (item);
        builder.append ("]");
        return builder.toString ();
    }
}
