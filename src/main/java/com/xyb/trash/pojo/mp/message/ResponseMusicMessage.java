/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */



package com.xyb.trash.pojo.mp.message;

import com.xyb.trash.pojo.mp.Music;

/**
 * 音乐形式的响应消息
 */
public class ResponseMusicMessage extends ResponseMessage
{
    /**
     * 
     */
    private static final long serialVersionUID = 5752193424999031685L;


    
    /**
     * 音乐
     */
    private Music Music;

    /**
     *  取得音乐对象
     * @return the music
     */
    public Music getMusic ()
    {
        return Music;
    }

    /**
     * 设置音乐对象
     * @param music the music to set.
     */
    public void setMusic (Music music)
    {
        Music = music;
    }

    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("ResponseMusicMessage [Music=");
        builder.append (Music);
        builder.append (", super.toString()=");
        builder.append (super.toString ());
        builder.append ("]");
        return builder.toString ();
    }  
}
