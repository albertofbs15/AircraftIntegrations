package util;

import javax.xml.datatype.XMLGregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
}
