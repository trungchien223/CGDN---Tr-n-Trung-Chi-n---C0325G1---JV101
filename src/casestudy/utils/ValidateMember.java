package casestudy.utils;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class ValidateMember {
    private static final Pattern ID_PATTERN = Pattern.compile("^MB\\d{3}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^(\\+\\d{2}-)?(0\\d{9})$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-ZÀ-Ỹ][a-zà-ỹ]*(\\s[A-ZÀ-Ỹ][a-zà-ỹ]*)*$");
    private static final Pattern GENDER_PATTERN = Pattern.compile("^(Nam|Nữ)$");
    private static final Pattern MEMBERSHIP_TYPE_PATTERN = Pattern.compile("^(Normal|Plus|Pro|Promax)$");

    public static boolean isValidId(String id) {
        return ID_PATTERN.matcher(id).matches();
    }

    public static boolean isValidPhone(String phone) {
        return PHONE_PATTERN.matcher(phone).matches();
    }

    public static boolean isValidName(String name) {
        return NAME_PATTERN.matcher(name).matches();
    }

    public static boolean isValidDateOfBirth(LocalDate dob) {
        if (dob == null) {
            return false;
        }
        LocalDate today = LocalDate.now();
        return !dob.isAfter(today);
    }

    public static boolean isValidGender(String gender) {
        return GENDER_PATTERN.matcher(gender).matches();
    }

    public static boolean isValidMembershipType(String type) {
        return MEMBERSHIP_TYPE_PATTERN.matcher(type).matches();
    }

    public static boolean isValidStartDate(LocalDate date) {
        return date != null && !date.isAfter(LocalDate.now());
    }
}
