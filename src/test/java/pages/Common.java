package pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {
    public static String URL = "https://sma.tec.sh/admin/login";
    public static String LOGIN_MESSAGE_SUCCESS = "You are successfully logged in.";
    public static String SALE_MESSAGE_SUCCESS = "Sale successfully added";
    public static String PURCH_MESSAGE_SUCCESS = "Purchase successfully added";
    public static String USERNAME = "admin@tecdiary.com";
    public static String PASSWORD = "12345678";
    public static String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static boolean validateDateFormat(String dateToValdate) {

        SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
        //To make strict date format validation
        formatter.setLenient(false);
        Date parsedDate = null;
        boolean valid = true;
        try {
            parsedDate = formatter.parse(dateToValdate);
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
}
