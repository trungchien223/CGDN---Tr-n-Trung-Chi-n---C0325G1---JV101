package casestudy.utils;

import java.util.regex.Pattern;

public class ValidateTrainer {
    private static final Pattern ID_PATTERN = Pattern.compile("^TR\\d{3}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^(\\+\\d{2}-)?(0\\d{9})$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-ZÀ-Ỹ][a-zà-ỹ]*(\\s[A-ZÀ-Ỹ][a-zà-ỹ]*)*$");
    private static final Pattern GENDER_PATTERN = Pattern.compile("^(Nam|Nữ)$");
    private static final Pattern SPECIALTY_PATTERN = Pattern.compile("^[A-Za-zÀ-ỹ\\s]{2,50}$");

    public static boolean isValidId(String id) {
        return ID_PATTERN.matcher(id).matches();
    }

    public static boolean isValidPhone(String phone) {
        return PHONE_PATTERN.matcher(phone).matches();
    }

    public static boolean isValidName(String name) {
        return NAME_PATTERN.matcher(name).matches();
    }

    public static boolean isValidGender(String gender) {
        return GENDER_PATTERN.matcher(gender).matches();
    }

    public static boolean isValidSpecialty(String specialty) {
        return SPECIALTY_PATTERN.matcher(specialty).matches();
    }
}
