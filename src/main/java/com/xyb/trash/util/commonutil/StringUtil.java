/*
 * 版权所有 2018 ，xieyunbo.com
 */

/*
 * 版权所有 2018 ，xieyunbo.com
 */


package com.xyb.trash.util.commonutil;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import java.math.RoundingMode;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DecimalFormat;

public abstract class StringUtil extends StringUtils
{

    /**
     * 日志工具类
     */
    private static final LogUtil log = new LogUtil (LoggerFactory.getLogger (StringUtil.class.getName ()));

    /**
     * 校验字符串是否为空（null、长度为0、只有空格都返回true） 可传无限个字符串进来，只要有一个为空就返回true，全部不为空才为false
     * 
     * @param strings 任意数量的字符串
     * @return
     * 
     */
    public static boolean isStringsEmpty (String... strings)
    {
        for (String str : strings)
        {
            if (isEmpty (str))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 校验字符串是否不为空（null、长度为0、只有空格都返回false） 可传无限个字符串进来，只要有一个为空就返回false，全部不为空才为true
     * 
     * @param strings 任意数量的字符串
     * @return
     * 
     */
    public static boolean isStringsNotEmpty (String... strings)
    {
        for (String str : strings)
        {
            if (isEmpty (str))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * 给传进来的字符串补指定位数的零，如传入1，补零长度为4则返回0001
     * 
     * @param sourceStr
     * @param length
     * @return
     */
    public static String fillZero (String sourceStr, int length)
    {
        String filledString = sourceStr;
        if (null != filledString && length > 0)
        {
            if (filledString.length () >= length)
            {
                return filledString;
            }
            int missedLength = length - filledString.length ();
            for (int i = 0; i < missedLength; i++)
            {
                filledString = "0" + filledString;
            }
            return filledString;
        }
        return filledString;
    }

    /**
     * 四舍五入到百分位
     * 
     * @param number 要四舍五入的数字
     * @return
     */
    public static String roundPercentile (double number)
    {
        DecimalFormat decimalFormat = new DecimalFormat ("#0.00");
        decimalFormat.setRoundingMode (RoundingMode.HALF_UP);
        return decimalFormat.format (number);
    }

    /**
     * double转换为int字符串
     * 
     * @param number
     * @return
     */
    public static String doubleToIntStr (double number)
    {
        DecimalFormat decimalFormat = new DecimalFormat ("#");
        return decimalFormat.format (number);
    }

    /**
     * 检查对象是否为数字型字符串,包含负数开头的。
     */
    public static boolean isNumeric (Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        char[] chars = obj.toString ().toCharArray ();
        int length = chars.length;
        if (length < 1)
            return false;

        int i = 0;
        if (length > 1 && chars[0] == '-')
            i = 1;

        for (; i < length; i++)
        {
            if (!Character.isDigit (chars[i]))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * string转换int
     * 
     * @param str
     * @return
     */
    public static int string2int (String str)
    {
        if (isNumeric (str))
        {
            return Integer.parseInt (str);
        }
        return 0;
    }

    /**
     * string转换double
     * 
     * @param str
     * @return
     */
    public static double string2double (String str)
    {
        if (isNumber (str))
        {
            return Double.parseDouble (str);
        }
        return 0.0;
    }

    public static boolean isNumber (String str)
    {
        if (str == null)
        {
            return false;
        }
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches (reg);
    }

    /**
     * 取得六位随机数
     * 
     * @return
     */
    public static String getSixRandomCode ()
    {
        try
        {
            SecureRandom random = SecureRandom.getInstance ("SHA1PRNG");

            String ssource = "0123456789";
            char[] src = ssource.toCharArray ();

            char[] buf = new char[6];
            int rnd;
            for (int i = 0; i < 6; i++)
            {
                rnd = Math.abs (random.nextInt ()) % src.length;

                buf[i] = src[rnd];
            }
            return new String (buf);
        }
        catch (NoSuchAlgorithmException e)
        {
            log.errorLog ("getSixRandomCode () error.", e);
        }
        return null;
    }
}
