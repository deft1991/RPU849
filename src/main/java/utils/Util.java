package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static Date parseStringToDateByFormat(String date, String format) throws ParseException {
        if (!date.equals("null") && format!=null) {
                DateFormat df = new SimpleDateFormat(format);
                return df.parse(date);
        } else return null;
    }

    public static String parseDateToStringByFormat(Date date, String format) throws ParseException {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.format(date);
        } else return null;
    }
}
