package com.llj.demo.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by liulj on 2017/5/26.
 */
public class Testllj {

    public static void main(String[] args) {
//        Calendar birthday = Calendar.getInstance();
//        birthday.set(Calendar.MONTH,2);
//        birthday.set(Calendar.DAY_OF_MONTH,31);
//        birthday.set(Calendar.HOUR_OF_DAY,0);
//        birthday.set(Calendar.MINUTE,0);
//        birthday.set(Calendar.SECOND,0);
//        birthday.set(Calendar.MILLISECOND,0);
//        SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        for (int i = 0; i < 10; i++) {
//            String a=simple.format(birthday.getTimeInMillis());
//            birthday.add(Calendar.MONTH,+1);
//           String b =a+"   "+simple.format(birthday.getTimeInMillis()-1);
//            System.out.println(b);
//        }
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
//
//        Calendar max = Calendar.getInstance();
//        max.set(Calendar.YEAR, 2016);
//        max.set(Calendar.MONTH, 4);
//        max.set(Calendar.DAY_OF_MONTH, 10);
//        max.set(Calendar.HOUR_OF_DAY, 22);
//        max.set(Calendar.MINUTE, 22);
//        max.set(Calendar.SECOND, 2);
//        max.set(Calendar.MILLISECOND, 200);
//
//        System.out.println(simpleDateFormat.format(max.getTimeInMillis()));
//
//        Calendar birthday = Calendar.getInstance();
//        birthday.set(Calendar.YEAR, 2015);
//        birthday.set(Calendar.MONTH, 7);
//        birthday.set(Calendar.DAY_OF_MONTH, 20);
//        birthday.set(Calendar.HOUR_OF_DAY, 20);
//        birthday.set(Calendar.MINUTE, 20);
//        birthday.set(Calendar.SECOND, 20);
//        birthday.set(Calendar.MILLISECOND, 400);
//
//        System.out.println(simpleDateFormat.format(birthday.getTimeInMillis()));
//
//        SimpleCalendar simple = getDiffData(max, birthday);
//        System.out.println(simple.toString());

        System.out.println(decimalFormat(1, 000.10));
    }

    public static String decimalFormat(int formatType, double data) {
        String pattern;
        switch (formatType) {
            case 0:
                pattern = "#.##";
                break;
            case 1:
                pattern = "00.00";
                break;
            case 2:
                pattern = "#.#";
                break;
            case 3:
                pattern = "0.0";
                break;
            case 4:
                pattern = "0.##";
                break;
            default:
                pattern = "0.0";
                break;
        }
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        return decimalFormat.format(data);
    }
    public static class SimpleCalendar {
        public long millis;
        public int year = -1;
        public int month = -1;
        public int day = -1;
        public int hour = -1;
        public int minute = -1;
        public int second = -1;
        public int millSecond = -1;

        public SimpleCalendar() {
        }

        public SimpleCalendar(long millis, int year, int month, int day) {
            this.millis = millis;
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public SimpleCalendar(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public String toString() {
            return "year:" + year + "   month:" + month + "   day:" + day + "   hour:" + hour + "   minute:" + minute + "   second:" + second + "   millSecond:" + millSecond;
        }
    }

    public static SimpleCalendar getDiffData(Calendar big, Calendar small) {
        if (big == null || small == null) {
            return null;
        }
        SimpleCalendar simpleCalendar = new SimpleCalendar();
        Calendar trueBig;
        Calendar trueSmall;
        if (big.getTimeInMillis() > small.getTimeInMillis()) {
            trueBig = big;
            trueSmall = small;
        } else {
            trueBig = small;
            trueSmall = big;
        }

        int bigYear = trueBig.get(Calendar.YEAR);
        int bigMonth = trueBig.get(Calendar.MONTH);
        int bigDay = trueBig.get(Calendar.DAY_OF_MONTH);
        int bigHour = trueBig.get(Calendar.HOUR_OF_DAY);
        int bigMinute = trueBig.get(Calendar.MINUTE);
        int bigSecond = trueBig.get(Calendar.SECOND);
        int bigMill = trueBig.get(Calendar.MILLISECOND);

        int smallYear = trueSmall.get(Calendar.YEAR);
        int smallMonth = trueSmall.get(Calendar.MONTH);
        int smallDay = trueSmall.get(Calendar.DAY_OF_MONTH);
        int smallHour = trueSmall.get(Calendar.HOUR_OF_DAY);
        int smallMinute = trueSmall.get(Calendar.MINUTE);
        int smallSecond = trueSmall.get(Calendar.SECOND);
        int smallMill = trueSmall.get(Calendar.MILLISECOND);


        int diffMill;
        if (bigMill > smallMill) {
            diffMill = bigMill - smallMill;
        } else {
            if (bigSecond < 1) {
                if (bigMinute < 1) {
                    if (bigHour < 1) {
                        bigDay = bigDay - 1;
                        bigHour = bigHour + 24 - 1;
                    } else {
                        bigHour = bigHour - 1;
                    }
                    bigMinute = bigMinute + 60 - 1;
                } else {
                    bigMinute = bigMinute - 1;
                }
                bigSecond = bigSecond + 60 - 1;
            } else {
                bigSecond = bigSecond - 1;
            }

            diffMill = bigMill + 1000 - smallMill;
        }
        simpleCalendar.millSecond = diffMill;
        //
        int diffSecond;
        if (bigSecond > smallSecond) {
            diffSecond = bigSecond - smallSecond;
        } else {
            if (bigMinute < 1) {
                if (bigHour < 1) {
                    bigDay = bigDay - 1;
                    bigHour = bigHour + 24 - 1;
                } else {
                    bigHour = bigHour - 1;
                }
                bigMinute = bigMinute + 60 - 1;
            } else {
                bigMinute = bigMinute - 1;
            }
            diffSecond = bigSecond + 60 - smallSecond;
        }
        simpleCalendar.second = diffSecond;
        //
        int diffMinute;
        if (bigMinute > smallMinute) {
            diffMinute = bigMinute - smallMinute;
        } else {
            if (bigHour < 1) {
                bigDay = bigDay - 1;
                bigHour = bigHour + 24 - 1;
            } else {
                bigHour = bigHour - 1;
            }
            diffMinute = bigMinute + 60 - smallMinute;
        }
        simpleCalendar.minute = diffMinute;
        //
        int diffHour;
        if (bigHour > smallHour) {
            diffHour = bigHour - smallHour;
        } else {
            bigDay = bigDay - 1;
            diffHour = bigHour + 24 - smallHour;
        }
        simpleCalendar.hour = diffHour;


        int diffYear;
        if (bigMonth > smallMonth) {
            diffYear = bigYear - smallYear;
        } else {
            diffYear = bigYear - smallYear - 1;
        }
        simpleCalendar.year = diffYear;

        //月
        int diffMonth;
        if (bigMonth > smallMonth) {
            diffMonth = bigYear * 12 + bigMonth - (smallYear * 12 + smallMonth);
        } else {
            diffMonth = bigYear * 12 + bigMonth - (smallYear * 12 + smallMonth) - 1;
        }
        simpleCalendar.month = diffMonth;

        trueSmall.add(Calendar.MONTH, diffMonth);


        //天
        int diffDay;
        if (bigDay > smallDay) {
            diffDay = bigDay - smallDay;
        } else {
            int day = trueSmall.getActualMaximum(Calendar.DATE);
            diffDay = day + bigDay - smallDay;
        }
        simpleCalendar.day = diffDay;

        return simpleCalendar;
    }
}
