package com.example.eatyet.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class DateUtils {
    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);
    private DateUtils() {
    }

    public static final Long ONE_DAY = 86400000L;
    public static final Long LESS_ONE_DAY = 86399999L;
    public static final Long OLD_DAY = 946659600000L;

    public static String getCurrentDateTime(){
        return  new SimpleDateFormat("ddMMyyyyHHmmss").format(Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh")).getTime());
    }

    public static Integer getDay(Long time){
        Date date=new Date(time);
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static String toString(Long time, String pattern){
        if(time != null){
            Date date=new Date(time);
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
            cal.setTime(date);
            String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
            if (cal.get(Calendar.DAY_OF_MONTH)  < 10 ) {
                day = 0 + day;
            }
            pattern = pattern.replace("dd",day);
            String month = Integer.toString(cal.get(Calendar.MONTH) +1);
            if (cal.get(Calendar.MONTH) +1 < 10 ) {
                month = 0 + month;
            }
            pattern = pattern.replace("MM",month);
            if(pattern.contains("yyyy")){
                pattern = pattern.replace("yyyy",Integer.toString(cal.get(Calendar.YEAR)));
            } else if(pattern.contains("yy")){
                String year = Integer.toString(cal.get(Calendar.YEAR));
                year = year.substring(year.length() - 2);
                pattern = pattern.replace("yy",year);
            }

            pattern = pattern.replace("HH",Integer.toString(cal.get(Calendar.HOUR_OF_DAY)));
            pattern = pattern.replace("mm",Integer.toString(cal.get(Calendar.MINUTE)));
            pattern = pattern.replace("ss",Integer.toString(cal.get(Calendar.SECOND)));
            return pattern;
        }
        return null;
    }

    public static  String toString(Long time){
        if(time !=null){
            Date d = new Date(time);
            DateFormat f = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            f.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
            return f.format(d);
        }
        return null;
    }

    public static  String toString(Object time){
        if(time !=null){
            try {
                String stringToConvert = String.valueOf(time);
                Long convertedLong = Long.parseLong(stringToConvert);
                Date d = new Date(convertedLong);
                DateFormat f = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                f.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
                return f.format(d);
            } catch (Exception e){
                return null;
            }
        }
        return null;
    }

    public static Long toString(String dateTime,String pattern, int addition){
        SimpleDateFormat f = new SimpleDateFormat(pattern);
        f.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        Long time = null;
        try {
            Date d = f.parse(dateTime);
            f.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
            if(addition !=0){
                d = addDays(d, 1);
            }
            time = d.getTime();
        } catch (ParseException e) {
           return  null;
        }
        return time;
    }

    public static Long getCurrentDate(){
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime();
    }

    public static Long getDateByTime(Long time){
        Date date = new Date(time);
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime();
    }

    public static Integer getMonth(Long time){
        Date date = new Date(time);
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        cal.setTime(date);
        return cal.get(Calendar.MONTH) +1;
    }

    public static Integer getYear(Long time){
        Date date = new Date(time);
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    public static String getCurrentDateString(){
        Long today = getCurrentDate();
        return toString(today,"yyyy-MM-dd");
    }

    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    public static Long addMonth(Long time, int month) {
        Date date = new Date(time);
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        return cal.getTime().getTime();
    }

    public static Long nextMonth(Long time, int month) {
        Date date = new Date(time);
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        Long newTime = cal.getTime().getTime();
        Long firstDayOfMonth = getFirstDayOfMonth(newTime);
        return firstDayOfMonth;
    }

    public static Long nextYear(Long time, int year) {
        Date date = new Date(time);
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        cal.setTime(date);
        cal.add(Calendar.YEAR, year);
        Long newTime = cal.getTime().getTime();
        Long firstDayOfYear = getFirstDayOfYear(newTime);
        return firstDayOfYear;
    }

    public static Long getFirstDayOfYear(Integer year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime().getTime();
    }

    public static Long getLastDayOfYear(Integer year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, 11); // 11 = december
        cal.set(Calendar.DAY_OF_MONTH, 31); // new years eve
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime().getTime();
    }

    public static Integer getWeekOfYear(Long time){
        Date date = new Date(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        return weekOfYear;
    }

    public static Long getTimestamp(String date){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate = dateFormat.parse(date);
            Timestamp timestamp = new Timestamp(parsedDate.getTime());
            return timestamp.getTime();
        } catch(Exception e) { //this generic but you can control another types of exception
            // look the origin of excption
            return null;
        }
    }

    public static Long getLastDayOfMonth(Long time) {
        try {
            Date date = new Date(time);
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
            calendar.setTime(date);
            String month = Integer.toString(calendar.get(Calendar.MONTH) +1);
            String year =  Integer.toString(calendar.get(Calendar.YEAR));
            return getLastDayOfMonth(year,month);
        } catch (Exception e){
            return null;
        }

    }

    public static Long getLastDayOfMonth(String year,String month) {
        try {
            String date = year+"-"+month+"-01";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
            cal.setTime(dateFormat.parse(date));
            int res = cal.getActualMaximum(Calendar.DATE);
            String value = year +"-"+month+"-"+res;
            return getTimestamp(value);
        } catch (Exception e){
            return null;
        }

    }

    public static Long getFirstDayOfMonth(String year,String month) {
        try {
            String date = year+"-"+month+"-01";
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
            cal.setTime(dateFormat.parse(date));
            int res = cal.getActualMinimum(Calendar.DATE);
            String value = year +"-"+month+"-"+res;
            return getTimestamp(value);
        } catch (Exception e){
            return null;
        }

    }

    public static Long getFirstDayOfMonth(Long time){
        Date date = new Date(time);
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        return c.getTimeInMillis();
    }

    public static Long getLastDayOfLastMonth(Long time){
        Date date = new Date(time);
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 0);
        return c.getTimeInMillis();
    }

    public static Long getFirstDayOfWeek(Long time){
        Date date = new Date(time);
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        return cal.getTimeInMillis() + ONE_DAY;
    }

    public static Long getFirstDayOfYear(Long time){
        Date date = new Date(time);
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        cal.setTime(date);
        cal.set(Calendar.MONTH,0);
        cal.set(Calendar.DAY_OF_MONTH,1);
        cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);
        return cal.getTimeInMillis();
    }

    public static Integer getNumberDayOfMonth(Long time){
        Date date = new Date(time);
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        c.setTime(date);
        int month = c.get(Calendar.MONTH) +1;
        int year  = c.get(Calendar.YEAR);
        YearMonth yearMonthObject = YearMonth.of(year, month);
        return yearMonthObject.lengthOfMonth();
    }

    public static Long setHourAndMinute(Long time, Integer hour, Integer minute){
        Date date = new Date(time);
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        c.setTime(date);
        c.set(Calendar.HOUR,hour);
        c.set(Calendar.MINUTE,minute);
        return c.getTimeInMillis();
    }

    public static TimeRange getTimeRange(Date time, Integer range){
        TimeRange timeRange = new TimeRange();
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        cal.setTime(time);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Integer minute = cal.get(Calendar.MINUTE);
        Integer rate = minute/range;
        Integer startMinute = rate*range;
        Integer endMinute = startMinute + range;

        cal.set(Calendar.MINUTE, startMinute);
        timeRange.setStart(cal.getTimeInMillis());
        cal.set(Calendar.MINUTE, endMinute);
        timeRange.setEnd(cal.getTimeInMillis());
        return timeRange;
    }

    public static String convertDateTime(Long time, String pattern){
        if(time != null){
            Date date=new Date(time);
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
            cal.setTime(date);
            String day = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
            if (cal.get(Calendar.DAY_OF_MONTH)  < 10 ) {
                day = 0 + day;
            }
            pattern = pattern.replace("dd",day);
            String month = Integer.toString(cal.get(Calendar.MONTH) +1);
            if (cal.get(Calendar.MONTH) +1 < 10 ) {
                month = 0 + month;
            }
            pattern = pattern.replace("MM",month);
            if(pattern.contains("yyyy")){
                pattern = pattern.replace("yyyy",Integer.toString(cal.get(Calendar.YEAR)));
            } else if(pattern.contains("yy")){
                String year = Integer.toString(cal.get(Calendar.YEAR));
                year = year.substring(year.length() - 2);
                pattern = pattern.replace("yy",year);
            }

            pattern = pattern.replace("HH",Integer.toString(cal.get(Calendar.HOUR_OF_DAY)));
            pattern = pattern.replace("mm",Integer.toString(cal.get(Calendar.MINUTE)));
            pattern = pattern.replace("ss",Integer.toString(cal.get(Calendar.SECOND)));
            return pattern;
        }
        return null;
    }

    public static Long getDayOfLastYear(Long time){
        Date date = new Date(time);
        Integer lastYear = DateUtils.getYear(time) - 1;
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        c.set(Calendar.YEAR, lastYear);
        c.set(Calendar.MONTH, date.getMonth());
        c.set(Calendar.DAY_OF_MONTH, date.getDate());
        return c.getTimeInMillis();
    }

    public static Long getDayOfLastMonth(Long time){
        Date date = new Date(time);
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        return c.getTimeInMillis();
    }

    public static Long getFirstDayOfQuarter(Long time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);

        int quarter = (calendar.get(Calendar.MONTH) / 3) + 1;
        // Lấy ngày đầu tiên của quý
        calendar.set(Calendar.MONTH, (quarter - 1) * 3);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTimeInMillis();
    }

    public static Long getLastDayOfQuarter(Long time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        int quarter = (calendar.get(Calendar.MONTH) / 3) + 1;
        // Lấy ngày cuối cùng của quý
        calendar.set(Calendar.MONTH, quarter * 3);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTimeInMillis();
    }
}
