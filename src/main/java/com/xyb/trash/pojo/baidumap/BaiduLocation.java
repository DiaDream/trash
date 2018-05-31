/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */


package com.xyb.trash.pojo.baidumap;

import java.io.Serializable;

/**
 * 百度地理位置对象
 */
public class BaiduLocation implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 5977823634530219886L;


    /**
     * 纬度
     */
    private String latitude;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 详细地址描述
     */
    private String formattedAddress;
    /**
     * 周围商圈
     */
    private String business;
    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 区
     */
    private String district;
    /**
     * 街道
     */
    private String street;
    /**
     * 街道门牌号
     */
    private String streetNumber;
    
    /**
     * 城市代码
     */
    private String cityCode;
    /**
     * 兴趣点类型
     */
    private String poiType;
    /**
     * 取得纬度
     * 
     * @return the latitude
     */
    public String getLatitude ()
    {
        return latitude;
    }

    /**
     * 设置纬度
     * 
     * @param latitude the latitude to set.
     */
    public void setLatitude (String latitude)
    {
        this.latitude = latitude;
    }

    /**
     * 取得经度
     * 
     * @return the longitude
     */
    public String getLongitude ()
    {
        return longitude;
    }

    /**
     * 设置经度
     * 
     * @param longitude the longitude to set.
     */
    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }

    /**
     * 取得详细地址描述
     * 
     * @return the formattedAddress
     */
    public String getFormattedAddress ()
    {
        return formattedAddress;
    }

    /**
     * 设置详细地址描述
     * 
     * @param formattedAddress the formattedAddress to set.
     */
    public void setFormattedAddress (String formattedAddress)
    {
        this.formattedAddress = formattedAddress;
    }

    /**
     * 取得周围商圈
     * 
     * @return the business
     */
    public String getBusiness ()
    {
        return business;
    }

    /**
     * 设置周围商圈
     * 
     * @param business the business to set.
     */
    public void setBusiness (String business)
    {
        this.business = business;
    }

    /**
     * 取得省份
     * 
     * @return the province
     */
    public String getProvince ()
    {
        return province;
    }

    /**
     * 设置省份
     * 
     * @param province the province to set.
     */
    public void setProvince (String province)
    {
        this.province = province;
    }

    /**
     * 取得城市
     * 
     * @return the city
     */
    public String getCity ()
    {
        return city;
    }

    /**
     * 设置城市
     * 
     * @param city the city to set.
     */
    public void setCity (String city)
    {
        this.city = city;
    }

    /**
     * 取得区
     * 
     * @return the district
     */
    public String getDistrict ()
    {
        return district;
    }

    /**
     * 设置区
     * 
     * @param district the district to set.
     */
    public void setDistrict (String district)
    {
        this.district = district;
    }

    /**
     * 取得街道
     * 
     * @return the street
     */
    public String getStreet ()
    {
        return street;
    }

    /**
     * 设置街道
     * 
     * @param street the street to set.
     */
    public void setStreet (String street)
    {
        this.street = street;
    }
    
    /**
     *  取得街道门牌号
     * @return the streetNumber
     */
    public String getStreetNumber ()
    {
        return streetNumber;
    }

    /**
     * 设置街道门牌号
     * @param streetNumber the streetNumber to set.
     */
    public void setStreetNumber (String streetNumber)
    {
        this.streetNumber = streetNumber;
    }

    /**
     * 取得城市代码
     * 
     * @return the cityCode
     */
    public String getCityCode ()
    {
        return cityCode;
    }

    /**
     * 设置城市代码
     * 
     * @param cityCode the cityCode to set.
     */
    public void setCityCode (String cityCode)
    {
        this.cityCode = cityCode;
    }
    
    
    
    /**
     * 取得兴趣点类型
     * @return the poiType
     */
    public String getPoiType ()
    {
        return poiType;
    }

    /**
     * 设置兴趣点类型
     * @param poiType the poiType to set.
     */
    public void setPoiType (String poiType)
    {
        this.poiType = poiType;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString ()
    {
        StringBuilder builder = new StringBuilder ();
        builder.append ("BaiduLocation [latitude=");
        builder.append (latitude);
        builder.append (", longitude=");
        builder.append (longitude);
        builder.append (", poiType=");
        builder.append (poiType);
        builder.append (", formattedAddress=");
        builder.append (formattedAddress);
        builder.append (", business=");
        builder.append (business);
        builder.append (", province=");
        builder.append (province);
        builder.append (", city=");
        builder.append (city);
        builder.append (", district=");
        builder.append (district);
        builder.append (", street=");
        builder.append (street);
        builder.append (", streetNumber=");
        builder.append (streetNumber);
        builder.append (", cityCode=");
        builder.append (cityCode);
        builder.append ("]");
        return builder.toString ();
    }
}
