package hu.elte.cinema.util;


import hu.elte.cinema.model.Occupied;
import org.apache.commons.lang3.time.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static DateFormat df = new SimpleDateFormat("mm/dd/yyyy HH:mm");

    public static String getString(Date date) {
        try {
            String temp =  df.format(date);
            if(date.getHours() > 12) {
                temp += " AM";
            } else {
                temp += " PM";
            }
            return temp;
        } catch (Exception ex) {
            return df.format(Calendar.getInstance().getTime());
        }
    }
    public static Date getDate(String date) {
        try {
            return DateUtils.parseDate(date, "yyyy-MM-dd HH:mm");
        } catch (Exception ex) {
            return Calendar.getInstance().getTime();
        }
    }
    public static boolean isBetween(Date date, Occupied occupied) {
        return date.after(occupied.getFrom()) && date.before(occupied.getTo());
    }
}
