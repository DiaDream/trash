/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */


package com.xyb.trash.constants;

/**
 * 微信通用常量

 */
public interface WxCommonConst
{
    /**
     * 微信统一支付接口地址
     */
    String wx_pay_unifiedorder_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    /**
     * 获取access_token的接口地址（GET）
     * 限200（次/天），使用时请用你的appid替换该字符串中的APPID，你的secret替换该字符串中的APPSECRET
     */
    String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    /**
     * 获取OAuth认证时的access_token的接口地址，使用时请用你的appid替换该字符串中的APPID，
     * 你的secret替换该字符串中的APPSECRET
     */
    String oauth_access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=APPSECRET&code=CODE&grant_type=authorization_code";

    /**
     * 菜单创建（POST） (限100次/天），使用时请用你取得的ACCESS_TOKEN替换该字符串中的ACCESS_TOKEN
     */
    String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    /**
     * 微信客服消息发送地址，使用时请用你取得的ACCESS_TOKEN替换该字符串中的ACCESS_TOKEN
     */
    String customer_msg_url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";
    /**
     * 微信模板消息发送地址，使用时请用你取得的ACCESS_TOKEN替换该字符串中的ACCESS_TOKEN
     */
    String wx_template_msg_url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
    /**
     * 微信简单oauth认证的url，该认证只能取得用户的openid，并且不需要用户手动授权
     * 使用时请用你的appid替换该字符串中的APPID，通过oauth认证后要重定向到的url替换该字符串中的REDIRECT_URL
     */
    String simple_oauth_url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URL&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
    /**
     * 
     * 微信发货通知url
     */
    String wx_deliver_notify_url = "https://api.weixin.qq.com/pay/delivernotify";

    /**
     * 微信订单查询地址
     */
    String wx_order_query_url = "https://api.weixin.qq.com/pay/orderquery";
    /**
     * 获取用户基本信息（包括unionid）
     */
    String get_baseInfo_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    /**
     * 微信支付退款请求地址
     */
    String wx_pay_refund_url = "https://api.mch.weixin.qq.com/secapi/pay/refund";

    /**
     * 获取ticket请求地址
     */
    String wx_get_jsapi_ticket_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
    /**
     * 为用户打标签请求地址
     */
    String wx_batch_tagging_url = "https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=ACCESS_TOKEN";
    /**
     * 获取用户标签请求地址
     */
    String wx_get_tagging_url = "https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=ACCESS_TOKEN";
    
    /**
     * 转换微信支付长地址为短地址
     */
    String getShortUrl = "https://api.mch.weixin.qq.com/tools/shorturl";
    
    /**
     * 取得多媒体文件的url
     */
    String getMediaUrl = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
    /**
     * 公司版权信息.
     */
    public static final String copyright = "版权所有 2014, 湖南凯歌医疗信息技术有限公司";

    /**
     * 提交路径.
     */
    public static final String SCC_BRANCH = "$URL: https://svn/svn/SourceCode/Mobile/codes/trunk/%E6%8E%8C%E4%B8%8A%E5%8C%BB%E9%99%A2/NkWxService/src/main/java/com/icarefx/wx/constant/WxCommonConst.java $";

    /**
     * 提交日期.
     */
    public static final String SCC_LAST_MODIFICATION_DATE = "$Date: 2014-09-01 15:24:29 +0800 (周一, 2014-09-01) $";

    /**
     * 最终修改人员.
     */
    public static final String SCC_LAST_MODIFIER_NAME = "$Author: chenqiang $";

    /**
     * 最终版本号.
     */
    public static final String SCC_REVISION = "$Revision$";

}
