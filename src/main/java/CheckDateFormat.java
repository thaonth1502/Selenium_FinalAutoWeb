import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CheckDateFormat {
    final static String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static boolean isDateValid(String date)
    {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }


    public static boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }

    public static boolean validateDateFormat(String dateToValdate) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        //To make strict date format validation
        formatter.setLenient(false);
        Date parsedDate = null;
        boolean valid = true;
        try {
            parsedDate = formatter.parse(dateToValdate);
          //  System.out.println(formatter.format(parsedDate));
        } catch (ParseException e) {
           valid = false;
        }

        if(parsedDate == null){
            valid = false;
        }else {
            valid = true;
        }
        return valid;
    }

    public static void main(String[] args) {

        System.out.println(validateDateFormat( "18/07/2024"));
    }
}
