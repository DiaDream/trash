/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 *
 *
 */

package com.xyb.trash.constants;

/**
 * 正则表达式常量
 */
public interface RegexConst
{
    /**
     * 匹配精确到月份的完整日期格式
     * 如：2014-02
     */
    String matchesFullDateMonth = "[0-9]{4}[-]{1}[0-9]{2}";
    /**
     * 匹配日期格式
     * 如：2014-2-2或2014-02-02之类
     */
    String matchesDate = "[0-9]{4}[-]{1}[0-9]{1,2}[-]{1}[0-9]{1,2}";
    /**
     * 匹配时间段
     * 如：2014-02-12 17:20:00-17:30:00或2014-02-10 8:00-8:30这类格式
     */
    String matchesTimeSlot = "[0-9]{4}[-]{1}[0-9]{1,2}[-]{1}[0-9]{1,2}[ ]{1}[0-9]{1,2}[:]{1}[0-9]{1,2}[:]{1}[0-9]{1,2}[-]{1}[0-9]{1,2}[:]{1}[0-9]{1,2}[:]{1}[0-9]{1,2}";
    /**
     * 匹配时间格式
     * 如：2014-02-12 17:20:00或2014-02-12 7:20:1
     */
    String matchesDateTime = "[0-9]{4}[-]{1}[0-9]{1,2}[-]{1}[0-9]{1,2}[ ]{1}[0-9]{1,2}[:]{1}[0-9]{1,2}[:]{1}[0-9]{1,2}";
    /**
     * 匹配完整的时间格式
     * 只有满足yyyy-MM-dd hh:mm:ss的才通过
     */
    String matchesFullDateTime = "[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}[ ]{1}[0-9]{2}[:]{1}[0-9]{2}[:]{1}[0-9]{2}";
    /**
     * 匹配8:7:06或:88:77:66或8:88:8等格式
     */
    String matchesTime = "[0-9]{1,2}[:][0-9]{1,2}[:][0-9]{1,2}";
    /**
     * 匹配yyyy-MM-dd格式
     */
    String matchesFullData = "[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}";
    /**
     * 匹配纯数字（不包含带小数点的）
     */
    String matchesNumber = "[0-9]+";
    /**
     * 匹配手机号
     */
    String matchesMobilePhone = "[1]{1}[0-9]{10}";
    /**
     * 公司版权信息.
     */
    String copyright = "版权所有 2014, 湖南凯歌医疗信息技术有限公司";

    /**
     * 提交路径.
     */
    String SCC_BRANCH = "$URL: https://svn/svn/SourceCode/Mobile/codes/trunk/%E6%8E%8C%E4%B8%8A%E5%8C%BB%E9%99%A2/NkWxService/src/main/java/com/icarefx/wx/hospital/constants/RegexConst.java $";

    /**
     * 提交日期.
     */
    String SCC_LAST_MODIFICATION_DATE = "$Date: 2014-10-28 15:06:19 +0800 (周二, 2014-10-28) $";

    /**
     * 最终修改人员.
     */
    String SCC_LAST_MODIFIER_NAME = "$Author: lijuan $";

    /**
     * 最终版本号.
     */
    String SCC_REVISION = "$Revision$";

}
