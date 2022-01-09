package Validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static final String ID_REGEX = "^[0-9]+$";
    public static final String NAME_REGEX = "^[\\s.\\D]+$";
    public static final String AGE_REGEX = "^[0-9]+$";
    public static final String PHONE_REGEX = "^[0]+[0-9]{9,}$";
    public static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public static boolean validateId(String regex) {
        Pattern pattern = Pattern.compile(ID_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateName(String regex) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateAge(String regex) {
        Pattern pattern = Pattern.compile(AGE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validatePhone(String regex) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateEmail(String regex) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
