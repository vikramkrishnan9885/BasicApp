package datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
    public static void main(String[] args) {
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String string1 = "2001-07-04T12:08:56.235-0700";
        try {
            Date result1 = df1.parse(string1);
            System.out.println(result1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        String string2 = "2001-07-04T12:08:56.235-07:00";
        try {
            Date result2 = df2.parse(string2);
            System.out.println(result2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        java.util.Date date = Date.from( Instant.parse( "2014-12-12T10:39:40Z" ));
        System.out.println(date);

        OffsetDateTime odt = OffsetDateTime.parse( "2010-01-01T12:00:00+01:00" );
        Instant instant = odt.toInstant();  // Instant is always in UTC.
        java.util.Date date2 = java.util.Date.from( instant );
        System.out.println(date2);

        SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        Date today = Calendar.getInstance().getTime();
        String test = timestampFormat.format(today);
        System.out.println(test);

        long now = System.currentTimeMillis();
        String test2 = timestampFormat.format(now);
        System.out.println(test2);
    }
}
