/**   
 * 功能描述：日期时间格式化工具类
 * @Package: com.aliyun.gts.macao.travel.util 
 * @author: 裴书贤 
 * @date: 2019-11-25
 */


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**   
* @ClassName: DateUtil.java
* @Description: 日期时间格式化工具类
*
* @author: 裴书贤
* @date: 2019-11-25
*
*/

public class DateUtil {
    //日期格式常量
    //------DATE------
    /** @Fields DATE_FORMAT_YYYY : 日期格式，年份，例如：2019 */
    public static final String DATE_FORMAT_YYYY = "yyyy";
    /** @Fields DATE_FORMAT_YYYYMM : 日期格式，年月，例如：201911 */
    public static final String DATE_FORMAT_YYYYMM = "yyyyMM";
    /** @Fields DATE_FORMAT_YYYY_MM : 日期格式，年月，用横杠分割，例如：2019-11 */
    public static final String DATE_FORMAT_YYYY_MM = "yyyy-MM";
    /** @Fields DATE_FORMAT_YYMMDD : 日期格式，年月日，例如：191125 */
    public static final String DATE_FORMAT_YYMMDD = "yyMMdd";
    /** @Fields DATE_FORMAT_YYYYMMDD : 日期格式，年月日，例如：20191125 */
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    /** @Fields DATE_FORMAT_YY_MM_DD : 日期格式，年月日，用横杠分开，例如：19-11-25 */
    public static final String DATE_FORMAT_YY_MM_DD = "yy-MM-dd";
    /** @Fields DATE_FORMAT_YYYY_MM_DD : 日期格式，年月日，用横杠分开，例如：2019-11-25 */
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    /** @Fields DATE_FORMAT_POINTYYYYMMDD : 日期格式，年月日，例如：2019.11.25 */
    public static final String DATE_FORMAT_POINTYYYYMMDD = "yyyy.MM.dd";
    
    //------DATE_TIME------
    /** @Fields DATE_TIME_FORMAT_YYYYMMDDHHmm : 日期格式，年月日时分，例如：201911251500 */
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMM = "yyyyMMddHHmm";
    /** @Fields DATE_TIME_FORMAT_YYYYMMDDHHMISS : 日期格式，年月日时分秒，例如：20191125150500 */
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISS = "yyyyMMddHHmmss";
    /** @Fields DATE_TIME_FORMAT_YYYYMMDDHHMISSSSS : 日期格式，年月日时分秒毫秒，例如：20191125150530123 */
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISSSSS = "yyyyMMddHHmmssSSS";
    /** @Fields DATE_TIME_FORMAT_YYYYMMDD_HH_MI : 日期格式，年月日时分，例如：20191125 15:00 */
    public static final String DATE_TIME_FORMAT_YYYYMMDD_HH_MI = "yyyyMMdd HH:mm";
    /** @Fields DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI : 日期格式，年月日时分，例如：2019-11-25 15:00 */
    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI = "yyyy-MM-dd HH:mm";
    /** @Fields DATE_TIME_FORMAT_MM_DD_HH_MI : 日期格式，月日时分，例如：11-25 15:10 */
    public static final String DATE_TIME_FORMAT_MM_DD_HH_MI = "MM-dd HH:mm";
    /**
     * @Fields DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS :
     * 日期格式，年月日时分秒，年月日用横杠分开，时分秒用冒号分开
     * 例如：2019-11-25 15:05:00
     */
    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd HH:mm:ss";
    /** @Fields DATE_TIME_FORMAT_CHINA : 日期格式，年月日，例如：2019年11月25日 */
    public static final String DATE_TIME_FORMAT_CHINA = "yyyy年MM月dd日";
    
    //------TIME------
    /** @Fields TIME_FORMAT_HHMISS : 日期格式，时分秒，例如：152030 */
    public static final String TIME_FORMAT_HHMISS = "HHmmss";
    /** @Fields TIME_FORMAT_HHMI : 日期格式，时分，例如：1520 */
    public static final String TIME_FORMAT_HHMI = "HHmm";
    /** @Fields TIME_FORMAT_HH_MI_SS : 日期格式，时分秒，例如：15:20:30 */
    public static final String TIME_FORMAT_HH_MI_SS = "HH:mm:ss";
    /** @Fields TIME_FORMAT_HH_MI : 日期格式，时分，例如：15:20 */
    public static final String TIME_FORMAT_HH_MI = "HH:mm";
    
    /**   
    * @Function: getYear
    * @Description: 获取某日期的年份 
    *
    * @param: date
    * @return： Integer
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static Integer getYear(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        return cal.get(Calendar.YEAR);  
    }    
      
    /**   
    * @Function: getMonth
    * @Description: 获取某日期的月份 
    *
    * @param: date
    * @return：Integer
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static Integer getMonth(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        return cal.get(Calendar.MONTH) + 1;  
    }  
      
    /**   
    * @Function: getDay
    * @Description: 获取某日期的日数 
    *
    * @param: date
    * @return： Integer
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static Integer getDay(Date date){  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        int day=cal.get(Calendar.DATE);
        return day;  
    }
    
    /**   
    * @Function: getWeekDay
    * @Description: 获取某日期属于周几
    *
    * @param: Date
    * @return： Integer
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-12-02
    */
    public static Integer getWeekDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int weekday = c.get(Calendar.DAY_OF_WEEK);
        return weekday;
    }
    /**   
    * @Function: getMinute
    * @Description: 获取某日期的分钟数
    *
    * @param: Date
    * @return：Integer
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-12-02
    */
    public static Integer getMinute(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int minute = c.get(Calendar.MINUTE);
        return minute;
    }
    /**   
    * @Function: getHours
    * @Description: 获取某一时间的小时数
    *
    * @param: date
    * @return： Integer
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static Integer getHours(Date date){  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        int day=cal.get(Calendar.HOUR_OF_DAY);
        return day;  
    }
    
    /**   
    * @Function: parseTimestampToStr
    * @Description: 格式化Timestamp时间 
    *
    * @param： timestamp Timestamp类型时间 
    * @param： timeFromat
    * @return： 格式化后的字符串 
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static String parseTimestampToStr(Timestamp timestamp,String timeFromat){  
        SimpleDateFormat df = new SimpleDateFormat(timeFromat);  
        return df.format(timestamp);  
    }  
    
    /**   
    * @Function: parseDateToStr
    * @Description: 格式化Date时间 
    *
    * @param： time Date类型时间 
    * @param： timeFromat String类型格式 
    * @return： String
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static String parseDateToStr(Date time, String timeFromat){  
        DateFormat dateFormat=new SimpleDateFormat(timeFromat);  
        return dateFormat.format(time);  
    }  
    
    /**   
    * @Function: parseDateToStr
    * @Description: 格式化Date时间 
    *
    * @param： time Date类型时间 
    * @param： timeFromat String类型格式 
    * @param： defaultValue 异常时返回的默认值 (如果为null，则默认值为当前时间Date)
    * @return： String
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static String parseDateToStr(Date time, String timeFromat, final Date defaultValue){  
        try{  
            DateFormat dateFormat=new SimpleDateFormat(timeFromat);  
            return dateFormat.format(time);  
        }catch (Exception e){  
            if(defaultValue!=null) {
                return parseDateToStr(defaultValue, timeFromat);
            } else {
                return parseDateToStr(new Date(), timeFromat);
            }
        }  
    }  
    
    /**   
    * @Function: parseDateToStr
    * @Description: 格式化Date时间 
    *
    * @param: time Date类型时间 
    * @param: timeFromat String类型格式 
    * @param: defaultValue 异常时返回的默认值 String类型 
    * @return：String
    * @throws： 格式化后的字符串 
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static String parseDateToStr(Date time, String timeFromat, final String defaultValue){  
        try{  
            DateFormat dateFormat=new SimpleDateFormat(timeFromat);  
            return dateFormat.format(time);  
        }catch (Exception e){  
            return defaultValue;  
        }  
    }  
    
    /**   
    * @Function: parseStrToDate
    * @Description: 格式化String时间 
    *
    * @param: time String类型时间 
    * @param: timeFromat String类型格式 
    * @return： Date
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static Date parseStrToDate(String time, String timeFromat) {  
        if (time == null || "".equals(time)) {
            return null;  
        }  
        
        Date date=null;  
        try{  
            DateFormat dateFormat=new SimpleDateFormat(timeFromat);  
            date=dateFormat.parse(time);  
        }catch(Exception e){  
            e.printStackTrace();
        }  
        return date;  
    }  
    
    /**   
    * @Function: parseStrToDate
    * @Description: 格式化String时间 
    *
    * @param: strTime String类型时间 
    * @param: timeFromat String类型格式 
    * @param: defaultValue 异常时返回的默认值 
    * @return： Date
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static Date parseStrToDate(String strTime, String timeFromat,  
        Date defaultValue) {  
        try {  
            DateFormat dateFormat = new SimpleDateFormat(timeFromat);  
            return dateFormat.parse(strTime);  
        } catch (Exception e) {  
            return defaultValue;  
        }  
    }  
    
    /**   
    * @Function: getDayListOfDate
    * @Description: 解析两个日期段之间的所有日期 
    *
    * @param: beginDateStr 开始日期  ，至少精确到yyyy-MM-dd
    *  @param: endDateStr 结束日期  ，至少精确到yyyy-MM-dd
    * @return： List<String>
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static List<String> getDayListOfDate(String beginDateStr, String endDateStr) {    
        // 指定要解析的时间格式    
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");    
        
        // 定义一些变量    
        Date beginDate = null;    
        Date endDate = null;    
        
        Calendar beginGc = null;
        Calendar endGc = null;
        List<String> list = new ArrayList<String>();    
        
        try {    
            // 将字符串parse成日期    
            beginDate = f.parse(beginDateStr);    
            endDate = f.parse(endDateStr);    
            
            // 设置日历    
            beginGc = Calendar.getInstance();
            beginGc.setTime(beginDate);
            
            endGc = Calendar.getInstance();
            endGc.setTime(endDate);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");    
            
            // 直到两个时间相同    
            while (beginGc.getTime().compareTo(endGc.getTime()) <= 0) {
                
                list.add(sdf.format(beginGc.getTime()));
                // 以日为单位，增加时间    
                beginGc.add(Calendar.DAY_OF_MONTH, 1);
            }    
            return list;    
        } catch (Exception e) {    
            e.printStackTrace();    
            return null;    
        }    
    }    
    
    /**   
    * @Function: getWeekthOfYear
    * @Description: 获取当前日期是一年中第几周  
    *
    * @param: date
    * @return： Integer
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static Integer getWeekthOfYear(Date date) {    
        Calendar c = new GregorianCalendar();    
        c.setFirstDayOfWeek(Calendar.MONDAY);    
        c.setMinimalDaysInFirstWeek(7);    
        c.setTime(date);    
        
        return c.get(Calendar.WEEK_OF_YEAR);    
    }   
    
    /**   
    * @Function: getWeekCountOfYear
    * @Description: 获取某一年的总周数
    *
    * @param: year
    * @return： Integer
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static Integer getWeekCountOfYear(int year){    
        Calendar c = new GregorianCalendar();    
        c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);    
        int count = getWeekthOfYear(c.getTime());    
        return count;    
    }    
    
    /**   
    * @Function: getFirstDayOfMonth
    * @Description: 获取某年某月的第一天  
    *
    * @param: year 目标年份 
    * @param: month 目标月份 
    * @return： 【特别 注意】：返回时间到这一天的00:00:00:000
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static Date getFirstDayOfMonth(int year,int month){    
        month = month-1;    
        Calendar   c   =   Calendar.getInstance();       
        c.set(Calendar.YEAR, year);    
        c.set(Calendar.MONTH, month);    
        
        int day = c.getActualMinimum(Calendar.DAY_OF_MONTH);    
        
        c.set(Calendar.DAY_OF_MONTH, day);  
        c.set(Calendar.HOUR_OF_DAY, 0);  
        c.set(Calendar.MINUTE, 0);  
        c.set(Calendar.SECOND, 0);  
        c.set(Calendar.MILLISECOND, 0);  
        return c.getTime();  
    }    
    
    /**   
    * @Function: getLastDayOfMonth
    * @Description: 获取某年某月的最后一天  
    *
    * @param: year 目标年份
    * @param: month 目标月份 
    * @return：【特别 注意】：返回时间到这一天的23:59:59:999
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static Date getLastDayOfMonth(int year,int month){    
        month = month-1;    
        Calendar   c   =   Calendar.getInstance();       
        c.set(Calendar.YEAR, year);    
        c.set(Calendar.MONTH, month);    
        int day = c.getActualMaximum(Calendar.DAY_OF_MONTH);    
        c.set(Calendar.DAY_OF_MONTH, day);  
        c.set(Calendar.HOUR_OF_DAY, 23);  
        c.set(Calendar.MINUTE, 59);  
        c.set(Calendar.SECOND, 59);  
        c.set(Calendar.MILLISECOND, 999);  
        return c.getTime();    
    }    
    
    /**   
    * @Function: getDayWeekOfDate1
    * @Description: 获取某个日期为星期几
    *
    * @param: date
    * @return： String "星期*"
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static String getDayWeekOfDate1(Date date) {    
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;  
        if (w < 0) {
            w = 0;
        }
        
        return weekDays[w];  
    }    
    
    /**   
    * @Function: getDayWeekOfDate2
    * @Description: 获得指定日期的星期几数 
    *
    * @param: date
    * @return：Integer
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static Integer getDayWeekOfDate2(Date date){    
        Calendar aCalendar = Calendar.getInstance();    
        aCalendar.setTime(date);       
        int weekDay = aCalendar.get(Calendar.DAY_OF_WEEK);       
        return weekDay;  
    }  
    
    /**   
    * @Function: formatHhMmSsOfDate
    * @Description: 将指定日期的时分秒格式为零 
    *
    * @param: date
    * @return： Date
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static Date formatHhMmSsOfDate(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);  
        cal.set(Calendar.HOUR_OF_DAY, 0);  
        cal.set(Calendar.MINUTE, 0);  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0);  
        return cal.getTime();  
    }  
    
    /**   
    * @Function: addDate
    * @Description: 获得指定时间加减参数后的日期(不计算则输入0)
    *
    * @param: date 指定日期 
    * @param: year 年数，可正可负 
    * @param: month 月数，可正可负 
    * @param: day 天数，可正可负 
    * @param: hour 小时数，可正可负 
    * @param: minute 分钟数，可正可负 
    * @param: second 秒数，可正可负 
    * @param: millisecond 毫秒数，可正可负 
    * @return： 计算后的日期 
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static Date addDate(Date date,int year,int month,int day,int hour,int minute,int second,int millisecond){  
        Calendar c = Calendar.getInstance();  
        c.setTime(date);  
        c.add(Calendar.YEAR, year);
        c.add(Calendar.MONTH, month);
        c.add(Calendar.DATE, day);
        c.add(Calendar.HOUR,hour);
        c.add(Calendar.MINUTE, minute);
        c.add(Calendar.SECOND, second);
        c.add(Calendar.MILLISECOND, millisecond);
        
        return c.getTime();  
    }  
    
    /**   
    * @Function: getDistanceTimestamp
    * @Description: 获得两个日期的时间戳之差 
    *
    * @param: startDate 
    * @param: endDate
    * @return： 返回结果描述
    * @throws： 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static Long getDistanceTimestamp(Date startDate,Date endDate){  
        long daysBetween=(endDate.getTime()-startDate.getTime()+1000000)/(3600*24*1000);  
        return daysBetween;  
    }  
    
    /**   
    * @Function: compareIsSameMonth
    * @Description: 判断二个时间是否为同年同月 
    *
    * @param: date1
    * @param: date2
    * @return: 返回结果描述
    * @throws: 异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static Boolean compareIsSameMonth(Date date1,Date date2){  
        boolean flag = false;  
        int year1  = getYear(date1);  
        int year2 = getYear(date2);  
        if(year1 == year2){  
            int month1 = getMonth(date1);  
            int month2 = getMonth(date2);  
            if(month1 == month2) {
                flag = true;
            }
        }  
        return flag;  
    }  
    
    /**   
     * @Function: getDistanceTime
     * @Description: 两个时间相差距离多少天\多少小时\多少分\多少秒
     *
     * @param: date1 时间参数 1
     * @param: date2 时间参数 2
     * @return： 返回值为long[] :{天, 时, 分, 秒}
     * @throws：异常描述
     *
     * @author: 裴书贤
     * @date: 2019-11-25
     */
    public static long[] getDistanceTime(Date date1, Date date2) {   
        long day = 0;   
        long hour = 0;   
        long min = 0;   
        long sec = 0;   
        try {   
            
            long time1 = date1.getTime();   
            long time2 = date2.getTime();   
            long diff ;   
            if(time1<time2) {   
                diff = time2 - time1;   
            } else {   
                diff = time1 - time2;   
            }   
            day = diff / (24 * 60 * 60 * 1000);   
            hour = (diff / (60 * 60 * 1000) - day * 24);   
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);   
            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);   
        } catch (Exception e) {   
            e.printStackTrace();   
        }  
        long[] times = {day, hour, min, sec};   
        return times;   
    }   
    
    /**   
    * @Function: getDistanceTime
    * @Description: 两个时间相差距离多少天\多少小时\多少分\多少秒
    *
    * @param: str1 时间参数 1
    * @param: str2 时间参数 2
    * @return： 返回值为long[] :{天, 时, 分, 秒}
    * @throws：异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static long[] getDistanceTime(String str1, String str2) {   
        DateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);   
        Date one;   
        Date two;   
        long day = 0;   
        long hour = 0;   
        long min = 0;   
        long sec = 0;   
        try {   
            one = df.parse(str1);   
            two = df.parse(str2);   
            long time1 = one.getTime();   
            long time2 = two.getTime();   
            long diff ;   
            if(time1<time2) {   
                diff = time2 - time1;   
            } else {   
                diff = time1 - time2;   
            }   
            day = diff / (24 * 60 * 60 * 1000);   
            hour = (diff / (60 * 60 * 1000) - day * 24);   
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);   
            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);   
        } catch (ParseException e) {   
            e.printStackTrace();   
        }   
        long[] times = {day, hour, min, sec};   
        return times;   
    }   
    
    /**   
     * @Function: getDistanceDays
     * @Description: 两个时间之间相差距离多少天
     *
     * @param: date1 时间参数 1
     * @param: date2 时间参数 2
     * @return：相差天数
     * @throws：异常描述
     *
     * @author: 裴书贤
     * @date: 2019-11-25
     */
     public static Long getDistanceDays(Date date1, Date date2) {   
         long days=0;
         long time1 = date1.getTime();
         long time2 = date2.getTime();
         long diff ;
         if(time1<time2) {
             diff = time2 - time1;
         } else {   
             diff = time1 - time2;
         }   
         days = diff / (1000 * 60 * 60 * 24);
         return days;   
     }
    
    /**   
    * @Function: getDistanceDays
    * @Description: 两个时间之间相差距离多少天
    *
    * @param: str1 时间参数 1
    * @param: str2 时间参数 2
    * @return：相差天数
    * @throws：异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static Long getDistanceDays(String str1, String str2) {   
        DateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);   
        Date one;   
        Date two;   
        long days=0;   
        try {   
            one = df.parse(str1);   
            two = df.parse(str2);   
            long time1 = one.getTime();   
            long time2 = two.getTime();   
            long diff ;   
            if(time1<time2) {   
                diff = time2 - time1;   
            } else {   
                diff = time1 - time2;   
            }   
            days = diff / (1000 * 60 * 60 * 24);   
        } catch (ParseException e) {   
            e.printStackTrace();   
        }   
        return days;   
    }
    
    /**   
    * @Function: getDayBeginTime
    * @Description: 获取指定时间的那天 00:00:00.000 的时间 
    *
    * @param: date
    * @return：Date
    * @throws：异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static Date getDayBeginTime(final Date date) {  
        Calendar c = Calendar.getInstance();  
        c.setTime(date);  
        c.set(Calendar.HOUR_OF_DAY, 0);  
        c.set(Calendar.MINUTE, 0);  
        c.set(Calendar.SECOND, 0);  
        c.set(Calendar.MILLISECOND, 0);  
        return c.getTime();  
    }  
    
    /**   
    * @Function: getDayEndTime
    * @Description: 获取指定时间的那天 23:59:59.999 的时间
    *
    * @param: date
    * @return：Date
    * @throws：异常描述
    *
    * @author: 裴书贤
    * @date: 2019-11-25
    */
    public static Date getDayEndTime(final Date date) {  
        Calendar c = Calendar.getInstance();  
        c.setTime(date);  
        c.set(Calendar.HOUR_OF_DAY, 23);  
        c.set(Calendar.MINUTE, 59);  
        c.set(Calendar.SECOND, 59);  
        c.set(Calendar.MILLISECOND, 999);  
        return c.getTime();  
    }

    /**
     * @Title: getNowDealTime
     * @Description: 获取当前时间String格式, 用于更新时间
     * @return: java.lang.String
     * @Author: hao.yiming
     * @Date: 2019-11-29 11:28
     * @version: v1.0
     */
    public static String getNowDealTime() {
        return parseDateToStr(new Date(), DATE_TIME_FORMAT_YYYYMMDDHHMISS);
    }

    public static void main(String [] args){
/*        int[] arr = {2,1,3,4};
        int[] arrSort = arr.clone();
        Arrays.sort(arrSort);
        arrSort.
        if(Arrays.equals(arr,)){
            System.out.println("相同");
        }else{
            System.out.println("no相同");
        }
        System.out.println(arr.toString());
        System.out.println(arrSort.toString());*/

        String skuId = "0";
        Long aLong = Long.valueOf(skuId);
        System.out.println(aLong);
    }


}
