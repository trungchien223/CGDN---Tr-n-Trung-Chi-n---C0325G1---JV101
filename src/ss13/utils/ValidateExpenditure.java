package ss13.utils;


public class ValidateExpenditure {
    private static final String ID_REGEX = "^CT-\\d{4}$";
    private static final String NAME_REGEX = "^[a-zA-Z\\s]+$";
    private static final String DATE_REGEX = "^\\d{2}/\\d{2}/\\d{4}$";
    public static boolean isValidateId(String id){
        return id != null && id.matches(ID_REGEX);
    }
    public static boolean isValidateName(String name){
        return name != null && name.matches(NAME_REGEX);
    }
    public static boolean isValidateDate(String date){
        return date != null && date.matches(DATE_REGEX);
    }
    public static boolean isValidateAmount(double amount){
        return amount > 0 && amount < 100000000;
    }
}
