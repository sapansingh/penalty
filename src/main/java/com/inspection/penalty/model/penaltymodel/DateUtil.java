package com.inspection.penalty.model.penaltymodel;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day); // Month is 0-based in Calendar
        return calendar.getTime();
    }
}