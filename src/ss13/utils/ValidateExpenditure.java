package ss13.utils;

import java.util.Scanner;

public class ValidateExpenditure {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ID_REGEX = "^CT-\\d{4}$";
    private static final String NAME_REGEX = "^[a-zA-Z\\s]+$";
    private static final String DATE_REGEX = "^\\d{2}/\\d{2}/\\d{4}$";
    private static final String DESCRIPTION_REGEX = "^.{1,100}$";
}
