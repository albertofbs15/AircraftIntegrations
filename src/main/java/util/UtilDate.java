package util;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by AHernandezS on 13/09/2017.
 */
public class UtilDate {

    public static String XMLGregorianCalendarToStringFormat(XMLGregorianCalendar xmlGregorianCalendar, String format) {
        Calendar calendar = xmlGregorianCalendar.toGregorianCalendar();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        formatter.setTimeZone(calendar.getTimeZone());
        return formatter.format(calendar.getTime());
    }

    public static String getNow(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static void main (String... args) {
        System.out.println(getNow( "yyyy-MM-dd'T'HH:mm:ss"));
    }
}
