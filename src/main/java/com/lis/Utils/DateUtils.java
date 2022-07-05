package com.lis.Utils;import io.swagger.models.auth.In;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: yc
 * @des: 时间工具类
 * @date: 2021/7/5 14:28
 */
public class DateUtils {

    //年月日格式
    private static final String Y_M_D = "yyyy-MM-dd";

    //年月日 时分秒格式
    private static final String Y_M_D_H_M_S = "yyyy-MM-dd HH:mm:ss";

    /**
     * @author: yc
     * @des: 获取当前 年月日 时间字符串
     * @date: 2021/7/5 14:29
     */
    public static String getCurrentYMDStr(){
        SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D);
        String dateStr = sdf.format(new Date());
        return dateStr;
    }

    /**
     * @author: yc
     * @des: 获取当前 年月日-时分秒 时间字符串
     * @date: 2021/7/5 14:34
     */
    public static String getCurrentYMDHMSStr(){
        SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D_H_M_S);
        String dateStr = sdf.format(new Date());
        return dateStr;
    }

    /**
     * @author: yc
     * @des: 获取当前 年月日 date对象
     * @date: 2021/7/5 14:38
     */
    public static Date getCurrentYMDDate(){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D);
            return sdf.parse(getCurrentYMDStr());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author: yc
     * @des: 获取当前 年月日-时分秒 date对象
     * @date: 2021/7/5 14:41
     */
    public static Date getCurrentYMDHMSDate(){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D_H_M_S);
            return sdf.parse(getCurrentYMDHMSStr());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author: yc
     * @des: 根据某一时间字符串获取 年月日 date对象
     * @date: 2021/7/5 14:45
     */
    public static Date getCurrentYMDDate(String ymdTime){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D);
            return sdf.parse(ymdTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author: yc
     * @des: 根据某一时间获取 年月日-时分秒 date对象
     * @date: 2021/7/5 14:46
     */
    public static Date getCurrentYMDHMSDate(String ymdHmsTime){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D_H_M_S);
            return sdf.parse(ymdHmsTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @author: yc
     * @des: 将date对象转换为 年月日字符串
     * @date: 2021/7/5 15:36
     */
    public static String date2ymdStr(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D);
        return null == date ? "" : sdf.format(date);
    }

    /**
     * @author: yc
     * @des: 将date对象转换为 年月日-时分秒 字符串
     * @date: 2021/7/5 15:37
     */
    public static String date2ymdHmsStr(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D_H_M_S);
        return null == date ? "" : sdf.format(date);
    }

    /**
     * @author: yc
     * @des: 将某一 年月日字符串时间 转换为 年月日时分秒字符串
     * @date: 2021/7/5 15:54
     */
    public static String ymdStr2ymdHmsStr(String ymdTime){
        SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D_H_M_S);
        return null == ymdTime ? "" : sdf.format(getCurrentYMDDate(ymdTime));
    }

    /**
     * @author: yc
     * @des: 将某一 年月日时分秒字符串 转换为 年月日字符串时间
     * @date: 2021/7/5 15:58
     */
    public static String ymdHmsStr2ymdStr(String ymdHmsTime){
        SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D);
        return null == ymdHmsTime ? "" : sdf.format(getCurrentYMDHMSDate(ymdHmsTime));
    }
    /**
     * @author: yc
     * @des: 时间移动 根据某一 年月日时间字符串(time) 及 移动天数(moveDays) 得到移动后的 年月日时间字符串
     * moveNum > 0 -> 向后移 反之 -> 向前移
     * moveType = "移动维度" ->
     * Calendar.SECOND = "秒"
     * Calendar.MINUTE = "分"
     * Calendar.HOUR_OF_DAY = "时"
     * Calendar.DATE = "日"
     * Calendar.WEEK_OF_MONTH = "周"
     * Calendar.MONTH = "月"
     * Calendar.YEAR = "年"
     * @date: 2021/7/5 14:48
     */
    public static String getMoveYMDStrByTime(Integer moveNum,Integer moveType,String ymdTime){
        SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D);
        Date date = null;
        try {
            date = sdf.parse(ymdTime);
            Calendar calendar  =   Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(moveNum, moveType);
            date=calendar.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf.format(date);
    }

    /**
     * @author: yc
     * @des: 时间移动 根据某一 年月日-时分秒时间字符串(time) 及 移动天数(moveDays) 得到移动后的 年月日-时分秒时间字符串
     * moveNum > 0 -> 向后移 反之 -> 向前移
     * moveType = "移动维度" ->
     * Calendar.SECOND = "秒"
     * Calendar.MINUTE = "分"
     * Calendar.HOUR_OF_DAY = "时"
     * Calendar.DATE = "日"
     * Calendar.WEEK_OF_MONTH = "周"
     * Calendar.MONTH = "月"
     * Calendar.YEAR = "年"
     * @date: 2021/7/5 14:48
     */
    public static String getMoveYMDHMSStrByTime(Integer moveNum,Integer moveType,String ymdHmsTime){
        SimpleDateFormat sdf = new SimpleDateFormat(Y_M_D_H_M_S);
        Date date = null;
        try {
            date = sdf.parse(ymdHmsTime);
            Calendar calendar  =   Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(moveType, moveNum);
            date=calendar.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf.format(date);
    }

    /**
     * @author: yc
     * @des: 获取最近24小时List
     * @date: 2021/7/5 15:39
     */
    public static List<String> getLocal24Hour(){
        int mod = 24;
        String time = null;
        List<String> local24HourList = new ArrayList<>();
        String currentHour = getCurrentYMDHMSStr().substring(11,13);
        for(int i = 1; i <= mod; i++){
            time = String.valueOf((Integer.parseInt(currentHour) + i) % mod);
            String hourTime = Integer.parseInt(time) < 10 ? "0" + time +":00" : time +":00";
            String realDate = ymdHmsStr2ymdStr(getMoveYMDHMSStrByTime(i - mod,Calendar.HOUR_OF_DAY,getCurrentYMDHMSStr())) + " " +hourTime + ":00";
            local24HourList.add(realDate +"_"+ hourTime);
        }
        return local24HourList;
    }

    /**
     * @author: yc
     * @des: 获取两个 年月日字符串时间 之间的 list 年月日事件对象
     * @date: 2021/7/5 16:01
     */
    public static List<String> getYMDListBetweenStartEndTime(String startTime,String endTime){
        List<String> ymdList = new ArrayList<>();
        try {
            String currentTime = "";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar st = Calendar.getInstance();
            Calendar ed = Calendar.getInstance();
            st.setTime(sdf.parse(startTime));
            ed.setTime(sdf.parse(endTime));
            //按照天维度来拉取数据
            for (st.setTime(sdf.parse(startTime)); !st.after(ed); st.add(Calendar.DAY_OF_YEAR, 1)) {
                currentTime = sdf.format(st.getTime());
                ymdList.add(currentTime);
                System.out.println(currentTime);
            }
            return ymdList;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     */
    /**
     * @author: yc
     * @des: 获取最近12个月
     * @date: 2021/7/5 16:03
     */
    public static List<String> getLast12Months(){
        List<String> last12MonthList = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1);
        cal.set(Calendar.DATE,1);
        for(int i = 0; i < 12; i++){
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1);
            last12MonthList.add(cal.get(Calendar.YEAR)+ "-" + (cal.get(Calendar.MONTH)+1 < 10 ? "0" + (cal.get(Calendar.MONTH)+1): String.valueOf(cal.get(Calendar.MONTH)+1)));
        }
        return last12MonthList;
    }
    /**
     * @author: yc
     * @des: 转换unix时间格式
     * @date: 2021/7/28 16:49
     */
    public static String getTimestampDate(String timestamp) {
        String str;
        SimpleDateFormat unix_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        str = unix_time.format(new Date(Long.valueOf(timestamp + "000")));
        return str;
    }

    /**
     * @author: yc
     * @des: 判断一个时间 是否在一个时间区间内
     * @date: 2021/8/23 9:24
     */
    public static boolean isBetween(Date current, Date startTime, Date endTime) {
        if (current.getTime() == startTime.getTime()
                || current.getTime() == endTime.getTime()) {
            return true;
        }
        Calendar date = Calendar.getInstance();
        date.setTime(current);
        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @author: yc
     * @des: 判断 年月日 日期 在哪个季度
     * @date: 2021/7/9 11:16
     */
    public static Integer getQuarterByYMD(String ymdTime){
        Integer currentMonth = Integer.parseInt(ymdTime.substring(5,7));
        if(currentMonth >= 1 && currentMonth <= 3){
            return 1;
        }else if(currentMonth >= 4 && currentMonth <= 6){
            return 2;
        }else if(currentMonth >= 7 && currentMonth <= 9){
            return 3;
        }else{
            return 4;
        }
    }

}
