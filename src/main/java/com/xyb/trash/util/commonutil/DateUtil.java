/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */

package com.xyb.trash.util.commonutil;

import com.xyb.trash.constants.DateConstant;
import com.xyb.trash.constants.RegexConst;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 操作日期的工具类
 */
public abstract class DateUtil extends DateUtils
{
    /**
     * 日志工具类
     */
    private static LogUtil log = new LogUtil (LoggerFactory.getLogger (DateUtil.class.getName ()));
    
    private static String[] parsePatterns =
    {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss",
     "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy.MM.dd",
     * "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
     */
    public static Date parseDate (Object str)
    {
        if (str == null)
        {
            return null;
        }
        try
        {
            return parseDate (str.toString (), parsePatterns);
        }
        catch (ParseException e)
        {
            log.errorLog ("parseDate (Object str)", e);
            return null;
        }
    }

    /**
     * 毫秒转换为时间（天,时:分:秒.毫秒）
     * 
     * @param timeMillis
     * @return
     */
    public static String formatDateTime (long timeMillis)
    {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = timeMillis / (60 * 60 * 1000) - day * 24;
        long min = (timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60;
        long s = timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60;
        long sss = timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000;
        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    /**
     * 把毫秒形式表示的时间按给定格式转换为字符串
     * 
     * @param timeLong 毫秒时间
     * @param format 转换格式，如果传null或空字符串，则按yyyy-MM-dd HH:mm:ss转换
     * @return
     * 
     */
    public static String formatDateToStringFromLong (long timeLong, String format)
    {
        Calendar calendar = Calendar.getInstance ();
        calendar.setTimeInMillis (timeLong);
        SimpleDateFormat dateFormat = new SimpleDateFormat ();
        if (null == format || "".equals (format.trim ()))
        {
            dateFormat.applyPattern (DateConstant.FULL_TIME_FORMAT_JAVA);
        }
        else
        {
            dateFormat.applyPattern (format);
        }
        return dateFormat.format (calendar.getTime ());
    }

    /**
     * 对日期字符串补零 使之成为yyyy-MM-dd hh:mm:ss这种格式
     * 
     * @param timeStr
     * @return
     * 
     */
    public static String fillZeroForDate (String timeStr)
    {
        if (null != timeStr)
        {
            StringBuilder newTimeStr = new StringBuilder ();
            try
            {
                if (!timeStr.matches (RegexConst.matchesFullDateTime))
                {
                    String[] fullTimeArray = timeStr.split (" ");
                    String[] dateArray = fullTimeArray[0].split ("-");// 拆分完的日期数组
                    String[] timeArray = fullTimeArray[1].split (":");// 拆分完的时间数组
                    newTimeStr.append (dateArray[0]);// 年
                    newTimeStr.append ('-');
                    newTimeStr.append (dateArray[1].length () == 1 ? "0" + dateArray[1] : dateArray[1]);// 月
                    newTimeStr.append ('-');
                    newTimeStr.append (dateArray[2].length () == 1 ? "0" + dateArray[2] : dateArray[2]);// 日
                    newTimeStr.append (' ');
                    newTimeStr.append (timeArray[0].length () == 1 ? "0" + timeArray[0] : timeArray[0]);// 时
                    newTimeStr.append (':');
                    newTimeStr.append (timeArray[1].length () == 1 ? "0" + timeArray[1] : timeArray[1]);// 分
                    newTimeStr.append (':');
                    newTimeStr.append (timeArray[2].length () == 1 ? "0" + timeArray[2] : timeArray[2]);// 秒
                    return newTimeStr.toString ();
                }
                return timeStr;
            }
            catch (Exception e)
            {
                log.errorLog ("fillZeroForDate (String timeStr)", e);
                return "";
            }
        }
        return "";
    }

    /**
     * 取得一天中的小时数
     * 
     * @param date
     * @return
     */
    public static int getHourFromDate (Date date)
    {
        if (null != date)
        {
            Calendar calendar = Calendar.getInstance ();
            calendar.setTime (date);
            return calendar.get (Calendar.HOUR_OF_DAY);
        }
        return -1;
    }

    /**
     * 返回日期中的时间字符串，如：9:30、19:20这种形式的字符串
     * 
     * @param date
     * @return
     */
    public static String getTimeStr (Date date)
    {
        return String.format ("%tH:%tM", date, date);
    }

    /**
     * 返回日期中的时间字符串，如：9:30、19:20这种形式的字符串
     * 
     * @param date
     * @return
     */
    public static String getMonthAndDayStr (Date date)
    {
        return formatDateToString (date, DateConstant.MONTH_DAY_FORMAT_JAVA_CH);
    }

    /**
     * 计算两个日期之间相差的天数
     * 
     * @param startDate 开始时间 yyyy-MM-dd
     * @param endDate 结束时间 yyyy-MM-dd
     * @return 相差天数
     */
    public static int daysOfTwo (Date startDate, Date endDate)
    {
        try
        {
            return (int) ((endDate.getTime () - startDate.getTime ()) / DateConstant.MILLI_SECOND_OF_DAY);
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    /**
     * 计算两个日期之间相差的天数
     * 
     * @param startDate 开始时间 yyyy-MM-dd
     * @param endDate 结束时间 yyyy-MM-dd
     * @return 相差天数
     */
    public static int daysOfTwo (String startDate, String endDate)
    {
        if (null != startDate && null != endDate && startDate.matches (RegexConst.matchesFullData)
            && endDate.matches (RegexConst.matchesFullData))
        {
            return daysOfTwo (formatStringToDate (startDate, DateConstant.DAY_TIME_FORMAT_JAVA),
                              formatStringToDate (endDate, DateConstant.DAY_TIME_FORMAT_JAVA));
        }
        return 0;
    }

    /**
     * 计算两个日期之间相差的天数(2012.1.8 18:00-2012.1.9 12:00这种情况会认为相差0天)
     * 
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @return 相差天数
     */
    public static int getIntervalDays (Date startDate, Date endDate)
    {
        if (null == startDate || null == endDate)
        {
            return -1;
        }
        long intervalMilli = endDate.getTime () - startDate.getTime ();
        return (int) (intervalMilli / (24 * 60 * 60 * 1000));
    }

    /**
     * 按照格式格式化日期
     * 
     * @param date 要格式化的日期
     * @param format 转换格式，如果传null或空字符串，则按yyyy-MM-dd HH:mm:ss转换
     * @return
     * 
     */
    public static Date formatDateToDate (Date date, String format)
    {
        try
        {
            if (null != date)
            {
                Date returnDate;
                String dateStr = "";
                SimpleDateFormat dateFormat = new SimpleDateFormat ();
                if (null == format || "".equals (format.trim ()))
                {
                    dateFormat.applyPattern (DateConstant.FULL_TIME_FORMAT_JAVA);
                    dateStr = dateFormat.format (date);
                    returnDate = dateFormat.parse (dateStr);
                }
                else
                {
                    dateFormat.applyPattern (format);
                    dateStr = dateFormat.format (date);
                    returnDate = dateFormat.parse (dateStr);
                }
                return returnDate;
            }
        }
        catch (ParseException e)
        {
            log.errorLog ("formatDateToDate (Date date, String format)", e);
        }
        return date;
    }

    /**
     * 转换日期为字符串形式
     * 
     * @param date Date 要转换的日起对象
     * @param format String 转换格式，如果传null或空字符串，则按yyyy-MM-dd HH:mm:ss转换
     * @return 转换结果
     */
    public static String formatDateToString (Date date, String format)
    {
        String dateStr = "";
        try
        {
            if (null != date)
            {
                SimpleDateFormat dateFormat = new SimpleDateFormat ();
                if (null == format || "".equals (format.trim ()))
                {
                    dateFormat.applyPattern (DateConstant.FULL_TIME_FORMAT_JAVA);
                    dateStr = dateFormat.format (date);
                }
                else
                {
                    dateFormat.applyPattern (format);
                    dateStr = dateFormat.format (date);
                }
            }
        }
        catch (Exception e)
        {
            log.errorLog ("formatDateToString (Date date, String format)", e);
        }
        return dateStr;
    }

    /**
     * 对日期字符串进行再次格式化，返回再次格式化后的字符串
     * 
     * @param dateStr 日期字符串
     * @param format 该日期字符串原本的格式，如果传null或空字符串，则按yyyy-MM-dd HH:mm:ss转换
     * @param targetStringFormat 该日期字符串要被转换成的日期字符串格式，如果传null或空字符串，则按yyyy-MM-dd
     *            HH:mm:ss转换
     * @return
     * 
     */
    public static String formatDateStringToString (String dateStr, String format, String targetStringFormat)
    {
        Date formatedDate = formatStringToDate (dateStr, format);
        return formatDateToString (formatedDate, targetStringFormat);
    }

    /**
     * 取得指定日期是中文的星期几
     * 
     * @param date
     * @return
     */
    public static String getChineseDayOfWeek (Date date)
    {
        Calendar calendar = Calendar.getInstance ();
        calendar.setTime (date);
        if (Calendar.SUNDAY == calendar.get (Calendar.DAY_OF_WEEK))
        {
            return "星期日";
        }
        else if (Calendar.MONDAY == calendar.get (Calendar.DAY_OF_WEEK))
        {
            return "星期一";
        }
        else if (Calendar.TUESDAY == calendar.get (Calendar.DAY_OF_WEEK))
        {
            return "星期二";
        }
        else if (Calendar.WEDNESDAY == calendar.get (Calendar.DAY_OF_WEEK))
        {
            return "星期三";
        }
        else if (Calendar.THURSDAY == calendar.get (Calendar.DAY_OF_WEEK))
        {
            return "星期四";
        }
        else if (Calendar.FRIDAY == calendar.get (Calendar.DAY_OF_WEEK))
        {
            return "星期五";
        }
        else if (Calendar.SATURDAY == calendar.get (Calendar.DAY_OF_WEEK))
        {
            return "星期六";
        }
        return "";
    }

    /**
     * 取得指定日期是中文的周几
     * 
     * @param date
     * @return
     */
    public static String getChineseDayOfWeekend (Date date)
    {
        Calendar calendar = Calendar.getInstance ();
        calendar.setTime (date);
        if (Calendar.SUNDAY == calendar.get (Calendar.DAY_OF_WEEK))
        {
            return "周日";
        }
        else if (Calendar.MONDAY == calendar.get (Calendar.DAY_OF_WEEK))
        {
            return "周一";
        }
        else if (Calendar.TUESDAY == calendar.get (Calendar.DAY_OF_WEEK))
        {
            return "周二";
        }
        else if (Calendar.WEDNESDAY == calendar.get (Calendar.DAY_OF_WEEK))
        {
            return "周三";
        }
        else if (Calendar.THURSDAY == calendar.get (Calendar.DAY_OF_WEEK))
        {
            return "周四";
        }
        else if (Calendar.FRIDAY == calendar.get (Calendar.DAY_OF_WEEK))
        {
            return "周五";
        }
        else if (Calendar.SATURDAY == calendar.get (Calendar.DAY_OF_WEEK))
        {
            return "周六";
        }
        return "";
    }

    /**
     * 取得当前日期七天后的日期字符串
     * 
     * @param currentDate 当前日期
     * @param dataformat 日期字符串格式
     * @return
     */
    public static String getNextSevenDaysDateStr (Date currentDate, String dataformat)
    {
        Calendar calendar = Calendar.getInstance ();
        calendar.setTime (currentDate);
        calendar.add (Calendar.DATE, 7);
        Date newDate = calendar.getTime ();
        return formatDateToString (newDate, dataformat);
    }

    /**
     * 取得当前日期第二天字符串
     * 
     * @param currentDate
     * @param dataformat
     * @return
     * 
     */
    public static String getNextDayDateStr (Date currentDate, String dataformat)
    {
        Calendar calendar = Calendar.getInstance ();
        calendar.setTime (currentDate);
        calendar.add (Calendar.DATE, 1);
        Date newDate = calendar.getTime ();
        return formatDateToString (newDate, dataformat);
    }

    /**
     * 取得当前日期第二天的日期对象
     * 
     * @param currentDate
     * @param dataformat
     * @return
     * 
     */
    public static Date getNextDayDate (Date currentDate, String dataformat)
    {
        Calendar calendar = Calendar.getInstance ();
        calendar.setTime (currentDate);
        calendar.add (Calendar.DATE, 1);
        Date newDate = calendar.getTime ();
        return newDate;
    }

    /**
     * 取得当前日期第二天的日期字符串
     * 
     * @param currentDate
     * @param dataformat
     * @return
     * 
     */
    public static String getNextDayStr (Date currentDate, String dataformat)
    {
        Calendar calendar = Calendar.getInstance ();
        calendar.setTime (currentDate);
        calendar.add (Calendar.DATE, 1);
        Date newDate = calendar.getTime ();
        return formatDateToString (newDate, dataformat);
    }

    /**
     * 取得当前日期一天前的日期字符串
     * 
     * @param currentDate 当前日期
     * @param dataformat 日期字符串格式
     * @return
     */
    public static String getPreviousOneDayDateStr (Date currentDate, String dataformat)
    {
        Calendar calendar = Calendar.getInstance ();
        calendar.setTime (currentDate);
        calendar.add (Calendar.DATE, -1);
        Date newDate = calendar.getTime ();
        return formatDateToString (newDate, dataformat);
    }

    /**
     * 取得当前日期一天前的日期
     * 
     * @param currentDate 当前日期
     * @return
     */
    public static Date getPreviousOneDayDate (Date currentDate)
    {
        Calendar calendar = Calendar.getInstance ();
        calendar.setTime (currentDate);
        calendar.add (Calendar.DATE, -1);
        Date newDate = calendar.getTime ();
        return newDate;
    }

    /**
     * 取得当前日期七天前的日期字符串
     * 
     * @param currentDate 当前日期
     * @param dataformat 日期字符串格式
     * @return
     */
    public static String getPreviousSevenDaysDateStr (Date currentDate, String dataformat)
    {
        Calendar calendar = Calendar.getInstance ();
        calendar.setTime (currentDate);
        calendar.add (Calendar.DATE, -7);
        Date newDate = calendar.getTime ();
        return formatDateToString (newDate, dataformat);
    }

    /**
     * 取得当前日期30天前的日期字符串
     * 
     * @param currentDate 当前日期
     * @param dataformat 日期字符串格式
     * @return
     */
    public static String getPreviousOneMonthDateStr (Date currentDate, String dataformat)
    {
        Calendar calendar = Calendar.getInstance ();
        calendar.setTime (currentDate);
        calendar.add (Calendar.DATE, -30);
        Date newDate = calendar.getTime ();
        return formatDateToString (newDate, dataformat);
    }

    /**
     * 取得当前日期365天前的日期字符串
     * 
     * @param currentDate 当前日期
     * @param dataformat 日期字符串格式
     * @return
     */
    public static String getPreviousOneYearDateStr (Date currentDate, String dataformat)
    {
        Calendar calendar = Calendar.getInstance ();
        calendar.setTime (currentDate);
        calendar.add (Calendar.DATE, -365);
        Date newDate = calendar.getTime ();
        return formatDateToString (newDate, dataformat);
    }

    /**
     * 取得long型对应的小时数
     * 
     * @param hoursLong
     * @return
     */
    public static long getHoursFromLong (long hoursLong)
    {
        return ((hoursLong / 1000) / 60) / 60;
    }

    /**
     * 字符串转日期对象 如果dateStr为空或转换失败则返回null，如果format为空或null则按yyyy-MM-dd HH:mm:ss格式转换
     * 
     * @param dateStr
     * @param format
     * @return
     */
    public static Date formatStringToDate (String dateStr, String format)
    {
        if (dateStr == null || dateStr.trim ().equals (""))
        {
            return null;
        }

        if (null == format || "".equals (format.trim ()))
        {
            format = DateConstant.FULL_TIME_FORMAT_JAVA;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat (format);

        try
        {
            return dateFormat.parse (dateStr);
        }
        catch (ParseException e)
        {
            log.errorLog ("formatStringToDate (String dateStr, String format)", e);
            return null;
        }
    }

    /**
     * 获取七天内的日期
     * 
     * @return
     */
    public static List <Map <String, String>> getSevenDays ()
    {
        List <Map <String, String>> dateList = new ArrayList <> ();
        Map <String, String> dateMap = null;
        Date date = new Date ();
        for (int i = 0; i < 7; i++)
        {
            dateMap = new HashMap <> ();
            date = getNextDayDate (date, null);
            dateMap.put ("day", formatDateToString (date, DateConstant.DAY_TIME_FORMAT_JAVA));
            dateList.add (dateMap);
        }
        return dateList;
    }

    /**
     * 获取七天内的日期及周期名称
     * 
     * @return
     */
    public static List <Map <String, String>> getSevenDayAndWeek ()
    {
        List <Map <String, String>> dateList = new ArrayList <> ();
        Map <String, String> dateMap = null;
        Date date = new Date ();
        for (int i = 0; i < 7; i++)
        {
            dateMap = new HashMap <> ();
            date = getNextDayDate (date, null);
            dateMap.put ("day", getMonthAndDayStr (date));
            if (i == 0)
            {
                dateMap.put ("week", "明天");
            }
            else
            {
                dateMap.put ("week", getChineseDayOfWeek (date));
            }
            dateList.add (dateMap);
        }
        return dateList;
    }

    /**
     * 获取七天内的日期及周天名称
     * 
     * @return
     */
    public static List <Map <String, String>> getSevenDayAndWeekend ()
    {
        List <Map <String, String>> dateList = new ArrayList <> ();
        Map <String, String> dateMap = null;
        Date currentDate = null;
        currentDate = new Date ();
        for (int i = 0; i < 7; i++)
        {
            dateMap = new HashMap <> ();
            Date date = getNextDayDate (currentDate, null);
            dateMap.put ("day", getMonthAndDayStr (date));
            if (i == 0)
            {
                dateMap.put ("week", "明天");
            }
            else
            {
                dateMap.put ("week", getChineseDayOfWeekend (date));
            }
            dateList.add (dateMap);
            currentDate = date;
        }
        return dateList;
    }

    /**
     * 根据传入的日期格式化pattern将传入的日期格式化成字符串。
     * 
     * @param date 要格式化的日期对象
     * @param pattern 日期格式化pattern
     * @return 格式化后的日期字符串
     */
    public static String format (final Date date, final String pattern)
    {
        DateFormat df = new SimpleDateFormat (pattern);
        return df.format (date);
    }

    /**
     * 将传入的日期按照默认形式转换成字符串（yyyy-MM-dd）
     * 
     * @param date 要格式化的日期对象
     * @return 格式化后的日期字符串
     */
    public static String format (final Date date)
    {
        return format (date, DateConstant.DAY_TIME_FORMAT_JAVA);
    }

    /**
     * 根据传入的日期格式化patter将传入的字符串转换成日期对象
     * 
     * @param dateStr 要转换的字符串
     * @param pattern 日期格式化pattern
     * @return 转换后的日期对象
     * @throws ParseException 如果传入的字符串格式不合法
     */
    public static Date parse (final String dateStr, final String pattern) throws ParseException
    {
        DateFormat df = new SimpleDateFormat (pattern);
        return df.parse (dateStr);
    }

    /**
     * 将传入的字符串按照默认格式转换为日期对象（yyyy-MM-dd）
     * 
     * @param dateStr 要转换的字符串
     * @return 转换后的日期对象
     * @throws ParseException 如果传入的字符串格式不符合默认格式（如果传入的字符串格式不合法）
     */
    public static Date parse (final String dateStr) throws ParseException
    {
        // modify by liaoxl 支持两种格式的时间yyyy-MM-dd和yyyy-MM-dd HH:mm:ss
        if (dateStr.length () == DateConstant.DAY_TIME_FORMAT_JAVA.length ())
        {
            return parse (dateStr, DateConstant.DAY_TIME_FORMAT_JAVA);
        }
        else if (dateStr.length () == DateConstant.FULL_TIME_FORMAT_JAVA.length ())
        {
            return parse (dateStr, DateConstant.FULL_TIME_FORMAT_JAVA);
        }
        else
        {
            return parse (dateStr, DateConstant.DAY_TIME_FORMAT_JAVA);
        }
    }

    /**
     * 获取本周的第一天
     * 
     * @return
     */
    public static Date getFirstDayOfThisWeek ()
    {
        Calendar cal = Calendar.getInstance ();
        cal.set (cal.get (Calendar.YEAR), cal.get (Calendar.MONDAY), cal.get (Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set (Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return cal.getTime ();
    }

    /**
     * 获取本周最后一天
     * 
     * @return
     */
    public static Date getLastDayOfThisWeek ()
    {
        Calendar cal = Calendar.getInstance ();
        cal.setTime (getFirstDayOfThisWeek ());
        cal.add (Calendar.DAY_OF_WEEK, 6);
        return cal.getTime ();
    }

    /**
     * 获取本月的第一天
     * 
     * @return
     */
    public static Date getFirstDayOfThisMonth ()
    {
        Calendar cal = Calendar.getInstance ();
        cal.set (cal.get (Calendar.YEAR), cal.get (Calendar.MONDAY), cal.get (Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set (Calendar.DAY_OF_MONTH, cal.getActualMinimum (Calendar.DAY_OF_MONTH));
        return cal.getTime ();
    }

    /**
     * 获取本月的最后一天
     * 
     * @return
     */
    public static Date getLastDayOfThisMonth ()
    {
        Calendar cal = Calendar.getInstance ();
        cal.set (cal.get (Calendar.YEAR), cal.get (Calendar.MONDAY), cal.get (Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set (Calendar.DAY_OF_MONTH, cal.getActualMaximum (Calendar.DAY_OF_MONTH) - 1);
        cal.set (Calendar.HOUR_OF_DAY, 23);
        return cal.getTime ();
    }
}
