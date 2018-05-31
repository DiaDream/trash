/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.util.commonutil;

import com.xyb.trash.pojo.baidumap.BaiduLocation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 百度地图工具类
 * 
 * @author chenqiang
 * @since 2017-11-15
 */
public abstract class BaiduMapUtil
{


    public static final String baiduMapKey = "44b970efc5ae5a7ee73cebf7872ea44a";

    public static final String baiduMapLocationApiUrl = "http://api.map.baidu.com/geocoder/v2/?location=latitude,longitude&pois=1&radius=1000&coordtype=coordinateType&output=json&latest_admin=1&ak=44b970efc5ae5a7ee73cebf7872ea44a";

    public static final String hospitalQueryApiUrl = "http://api.map.baidu.com/place/v2/search?&query=%E5%8C%BB%E9%99%A2&location=28.217567,112.887245&radius=3000&page_size=20&page_num=0&output=json&ak=44b970efc5ae5a7ee73cebf7872ea44a";

    public static final String hosUrl = "http://api.map.baidu.com/geocoder?address=hospitalName&output=json&key=44b970efc5ae5a7ee73cebf7872ea44a&city=长沙";

    /**
     * 根据坐标和坐标类型返回反向解析到的地理信息
     * 
     * @param latitude 纬度
     * @param longitude 经度
     * @param coordinateType 坐标类型
     * @return
     */
    public static BaiduLocation findLocationInfo (String latitude, String longitude,
                                                  String coordinateType)
    {
        List <BaiduLocation> locationInfos = findLocationInfos (latitude, longitude, coordinateType);
        if (null != locationInfos && locationInfos.size () > 0)
        {
            return locationInfos.get (0);
        }
        return null;
    }

    /**
     * 根据坐标和坐标类型返回反向解析到的地理信息List
     * 
     * @param latitude 纬度
     * @param longitude 经度
     * @param coordinateType 坐标类型
     * @return
     */
    public static List <BaiduLocation> findLocationInfos (String latitude, String longitude,
                                                          String coordinateType)
    {
        String urlStr = baiduMapLocationApiUrl.replace ("latitude", latitude).replace ("longitude", longitude)
                                              .replace ("coordinateType", coordinateType);
        String requestResult = HttpClientUtil.doGet (urlStr);
        if (null != requestResult)
        {
            JSONObject jsonObject = JSONObject.fromObject (requestResult);
            String locationRequestResult = jsonObject.getString ("status");
            if ("0".equals (locationRequestResult))
            {
                JSONObject resultJson = jsonObject.getJSONObject ("result");
                JSONObject locationJson = resultJson.optJSONObject ("location");
                if (null != locationJson)
                {

                    String business = resultJson.optString ("business");
                    List <BaiduLocation> locations = new ArrayList <> ();
                    JSONObject addressComponentJson = resultJson.optJSONObject ("addressComponent");
                    JSONArray pois = resultJson.optJSONArray ("pois");
                    if (null != pois && pois.size () > 0)
                    {
                        @SuppressWarnings ("unchecked")
                        Iterator <JSONObject> poiIterator = pois.iterator ();
                        while (poiIterator.hasNext ())
                        {
                            JSONObject poiObj = poiIterator.next ();
                            BaiduLocation baiduLocation = new BaiduLocation ();
                            baiduLocation.setBusiness (business);
                            baiduLocation.setLatitude (latitude);
                            baiduLocation.setLongitude (longitude);
                            String poiType = poiObj.optString ("poiType");
                            if (null != poiType && poiType.length () > 0)
                            {
                                baiduLocation.setPoiType (poiType);
                            }
                            String formattedAddress = resultJson.optString ("formatted_address");
                            if (null != addressComponentJson)
                            {
                                String province = addressComponentJson.optString ("province");
                                String city = addressComponentJson.optString ("city");
                                String district = addressComponentJson.optString ("district");
                                String street = addressComponentJson.optString ("street");
                                String streetNumber = addressComponentJson.optString ("street_number");
                                String cityCode = addressComponentJson.optString ("adcode");
                                baiduLocation.setCity (city);
                                baiduLocation.setCityCode (cityCode);
                                baiduLocation.setDistrict (district);
                                baiduLocation.setProvince (province);
                                baiduLocation.setStreet (street);
                                baiduLocation.setStreetNumber (streetNumber);
                                baiduLocation.setFormattedAddress (formattedAddress);
                            }
                            String poiName = poiObj.optString ("name");
                            if (null != poiName && poiName.length () > 0)
                            {
                                formattedAddress = formattedAddress + poiName;
                            }
                            baiduLocation.setFormattedAddress (formattedAddress);
                            locations.add (baiduLocation);
                        }
                    }
                    else
                    {
                        BaiduLocation baiduLocation = new BaiduLocation ();
                        baiduLocation.setBusiness (business);
                        baiduLocation.setLatitude (latitude);
                        baiduLocation.setLongitude (longitude);
                        if (null != addressComponentJson)
                        {
                            String province = addressComponentJson.optString ("province");
                            String city = addressComponentJson.optString ("city");
                            String district = addressComponentJson.optString ("district");
                            String street = addressComponentJson.optString ("street");
                            String streetNumber = addressComponentJson.optString ("street_number");
                            String cityCode = addressComponentJson.optString ("adcode");
                            baiduLocation.setCity (city);
                            baiduLocation.setCityCode (cityCode);
                            baiduLocation.setDistrict (district);
                            baiduLocation.setProvince (province);
                            baiduLocation.setStreet (street);
                            baiduLocation.setStreetNumber (streetNumber);
                        }
                        String formattedAddress = resultJson.optString ("formatted_address");
                        baiduLocation.setFormattedAddress (formattedAddress);
                        locations.add (baiduLocation);
                    }
                    return locations;
                }
            }
        }
        return null;
    }
}
