/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.pojo.mp;

import java.io.Serializable;

/**
 * 个性化菜单匹配规则
 */

public class MatchRule implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1594769705011682114L;


    /**
     * 用户标签的id，可通过用户标签管理接口获取
     */
    private String tag_id;
    /**
     * 性别：男（1）女（2），不填则不做匹配
     */
    private String sex;
    /**
     * 国家信息，是用户在微信中设置的地区，具体请参考地区信息表
     */
    private String country;
    /**
     * 省份信息，是用户在微信中设置的地区，具体请参考地区信息表
     */
    private String province;
    /**
     * 城市信息，是用户在微信中设置的地区，具体请参考地区信息表
     */
    private String city;
    /**
     * 客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配
     */
    private String client_platform_type;
    /**
     * 语言信息，是用户在微信中设置的语言，具体请参考语言表：1、简体中文 "zh_CN" 2、繁体中文TW "zh_TW" 3、繁体中文HK
     * "zh_HK" 4、英文 "en" 5、印尼 "id" 6、马来 "ms" 7、西班牙 "es" 8、韩国 "ko" 9、意大利 "it"
     * 10、日本 "ja" 11、波兰 "pl" 12、葡萄牙 "pt" 13、俄国 "ru" 14、泰文 "th" 15、越南 "vi"
     * 16、阿拉伯语 "ar" 17、北印度 "hi" 18、希伯来 "he" 19、土耳其 "tr" 20、德语 "de" 21、法语 "fr"
     */
    private String language;

    /**
     * 取得用户标签的id，可通过用户标签管理接口获取
     * 
     * @return the tag_id
     */
    public String getTag_id ()
    {
        return tag_id;
    }

    /**
     * 设置用户标签的id，可通过用户标签管理接口获取
     * 
     * @param tag_id the tag_id to set.
     */
    public void setTag_id (String tag_id)
    {
        this.tag_id = tag_id;
    }

    /**
     * 取得性别：男（1）女（2），不填则不做匹配
     * 
     * @return the sex
     */
    public String getSex ()
    {
        return sex;
    }

    /**
     * 设置性别：男（1）女（2），不填则不做匹配
     * 
     * @param sex the sex to set.
     */
    public void setSex (String sex)
    {
        this.sex = sex;
    }

    /**
     * 取得国家信息，是用户在微信中设置的地区，具体请参考地区信息表
     * 
     * @return the country
     */
    public String getCountry ()
    {
        return country;
    }

    /**
     * 设置国家信息，是用户在微信中设置的地区，具体请参考地区信息表
     * 
     * @param country the country to set.
     */
    public void setCountry (String country)
    {
        this.country = country;
    }

    /**
     * 取得省份信息，是用户在微信中设置的地区，具体请参考地区信息表
     * 
     * @return the province
     */
    public String getProvince ()
    {
        return province;
    }

    /**
     * 设置省份信息，是用户在微信中设置的地区，具体请参考地区信息表
     * 
     * @param province the province to set.
     */
    public void setProvince (String province)
    {
        this.province = province;
    }

    /**
     * 取得城市信息，是用户在微信中设置的地区，具体请参考地区信息表
     * 
     * @return the city
     */
    public String getCity ()
    {
        return city;
    }

    /**
     * 设置城市信息，是用户在微信中设置的地区，具体请参考地区信息表
     * 
     * @param city the city to set.
     */
    public void setCity (String city)
    {
        this.city = city;
    }

    /**
     * 取得客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配
     * 
     * @return the client_platform_type
     */
    public String getClient_platform_type ()
    {
        return client_platform_type;
    }

    /**
     * 设置客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配
     * 
     * @param client_platform_type the client_platform_type to set.
     */
    public void setClient_platform_type (String client_platform_type)
    {
        this.client_platform_type = client_platform_type;
    }

    /**
     * 取得语言信息，是用户在微信中设置的语言，具体请参考语言表：1、简体中文 "zh_CN" 2、繁体中文TW "zh_TW" 3、繁体中文HK
     * "zh_HK" 4、英文 "en" 5、印尼 "id" 6、马来 "ms" 7、西班牙 "es" 8、韩国 "ko" 9、意大利 "it"
     * 10、日本 "ja" 11、波兰 "pl" 12、葡萄牙 "pt" 13、俄国 "ru" 14、泰文 "th" 15、越南 "vi"
     * 16、阿拉伯语 "ar" 17、北印度 "hi" 18、希伯来 "he" 19、土耳其 "tr" 20、德语 "de" 21、法语 "fr"
     * 
     * @return the language
     */
    public String getLanguage ()
    {
        return language;
    }

    /**
     * 设置语言信息，是用户在微信中设置的语言，具体请参考语言表：1、简体中文 "zh_CN" 2、繁体中文TW "zh_TW" 3、繁体中文HK
     * "zh_HK" 4、英文 "en" 5、印尼 "id" 6、马来 "ms" 7、西班牙 "es" 8、韩国 "ko" 9、意大利 "it"
     * 10、日本 "ja" 11、波兰 "pl" 12、葡萄牙 "pt" 13、俄国 "ru" 14、泰文 "th" 15、越南 "vi"
     * 16、阿拉伯语 "ar" 17、北印度 "hi" 18、希伯来 "he" 19、土耳其 "tr" 20、德语 "de" 21、法语 "fr"
     * 
     * @param language the language to set.
     */
    public void setLanguage (String language)
    {
        this.language = language;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("MatchRule [tag_id=");
        builder.append (tag_id);
        builder.append (", sex=");
        builder.append (sex);
        builder.append (", country=");
        builder.append (country);
        builder.append (", province=");
        builder.append (province);
        builder.append (", city=");
        builder.append (city);
        builder.append (", client_platform_type=");
        builder.append (client_platform_type);
        builder.append (", language=");
        builder.append (language);
        builder.append ("]");
        return builder.toString ();
    }
}
