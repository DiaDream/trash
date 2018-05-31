/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.constants;

public interface DateConstant
{
    /**
     * 精确到年月的简单时间格式: yyyyMM
     */
    String YEAR_MONTH_SIMPLE_FORMAT = "yyyyMM";
    /**
     * 精确到年月的时间格式: yyyy-MM
     */
    String YEAR_MONTH_FORMAT = "yyyy-MM";
    /**
     * 精确到年月的中文时间格式: yyyy-MM
     */
    String YEAR_MONTH_FORMAT_CH = "yyyy年MM月";
    /**
     * 精确到秒的时间格式(Oracle): yyyy-MM-dd hh24:mi:ss
     */
    String FULL_TIME_FORMAT_ORACLE = "yyyy-MM-dd hh24:mi:ss";
    /**
     * 精确到秒的时间格式(java): yyyy-MM-dd HH:mm:ss
     */
    String FULL_TIME_FORMAT_JAVA = "yyyy-MM-dd HH:mm:ss";
    /**
     * 时分秒模式：HH:mm:ss
     */
    String HOUR_MINUTE_SECOND_PATTERN = "HH:mm:ss";

    /**
     * 精确到秒的时间格式,12小时为一轮: yyyy-MM-dd kk:mm:ss
     */
    String FULL_TIME_KK_FORMAT_JAVA = "yyyy-MM-dd kk:mm:ss";

    /**
     * 精确到日期的时间格式(java): yyyy-MM-dd
     */
    String DAY_TIME_FORMAT_JAVA = "yyyy-MM-dd";
    /**
     * 身份证上生日时间格式: yyyyMMdd
     */
    String BRITHDAY_TIME_FORMAT = "yyyyMMdd";
    /**
     * 精确到日期的中文时间格式(java): yyyy年MM月dd日
     */
    String DAY_TIME_FORMAT_JAVA_CH = "yyyy年MM月dd日";
    /**
     * 精确到日期的中文时间格式(java): MM月/dd日
     */
    String MONTH_DAY_FORMAT_JAVA_CH = "MM/dd";
    /**
     * 一天的毫秒数：86400000
     */
    long MILLI_SECOND_OF_DAY = 86400000L;
    /**
     * 一小时的毫秒数
     */
    long MILLI_SECOND_OF_HOUR = 3600000L;
    /**
     * 一分钟的毫秒数
     */
    long MILLI_SECOND_OF_MINUTE = 60000L;
}
