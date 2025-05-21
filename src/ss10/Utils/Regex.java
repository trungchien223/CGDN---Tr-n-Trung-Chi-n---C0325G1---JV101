package ss10.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class Regex {
    private static final String ORIGIN_REGEX = "^([A-Z][a-z]+)(\\s[A-Z][a-z]+)+$";
    private static final String DATE_REGEX = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
    private static final String NAME_TYPE_REGEX = "^[a-zA-Z\\s]+$";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static boolean isValidOrigin(String origin) {
        return Pattern.matches(ORIGIN_REGEX, origin);
    }
    public static boolean isValidDate(String dateStr) {
        return Pattern.matches(DATE_REGEX, dateStr);
    }
    public static boolean isValidNameOrType(String input) {
        return Pattern.matches(NAME_TYPE_REGEX, input);
    }
    public static boolean expirationAfterProduction(String productionDateStr, String expirationDateStr) {
        try {
            LocalDate productionDate = LocalDate.parse(productionDateStr, DATE_FORMATTER);
            LocalDate expirationDate = LocalDate.parse(expirationDateStr, DATE_FORMATTER);
            return expirationDate.isAfter(productionDate);
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    public static boolean isProductionDateValid(String productionDateStr) {
        try {
            LocalDate productionDate = LocalDate.parse(productionDateStr, DATE_FORMATTER);
            return !productionDate.isAfter(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
