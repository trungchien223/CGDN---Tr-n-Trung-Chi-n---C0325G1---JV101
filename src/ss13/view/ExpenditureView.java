package ss13.view;

import ss13.model.Expenditure;
import ss13.utils.ValidateExpenditure;

import java.util.List;
import java.util.Scanner;

public class ExpenditureView {
    private final static Scanner scanner = new Scanner(System.in);
    public static void display(List<Expenditure> list) {
        System.out.println(" DANH SÁCH CHI TIÊU ");
        for (Expenditure e : list) {
            System.out.println(e);
        }
    }
    public static Expenditure addExpenditure() {
        String id;
        do {
            System.out.print("Nhập mã chi tiêu (CT-xxxx): ");
            id = scanner.nextLine();
            if (!ValidateExpenditure.isValidateId(id)) {
                System.out.println("Sai định dạng, Mã phải theo định dạng CT-xxxx.");
            }
        } while (!ValidateExpenditure.isValidateId(id));

        String name;
        do {
            System.out.print("Nhập tên chi tiêu: ");
            name = scanner.nextLine();
            if (!ValidateExpenditure.isValidateName(name)) {
                System.out.println("Tên chỉ được chứa chữ cái và khoảng trắng");
            }
        } while (!ValidateExpenditure.isValidateName(name));

        String date;
        do {
            System.out.print("Nhập ngày chi (dd/MM/yyyy): ");
            date = scanner.nextLine();
            if (!ValidateExpenditure.isValidateDate(date)) {
                System.out.println("Sai định dạng");
            }
        } while (!ValidateExpenditure.isValidateDate(date));

        double amount = 0;
        while (true) {
            try {
                System.out.print("Nhập số tiền chi: ");
                amount = Double.parseDouble(scanner.nextLine());
                if (!ValidateExpenditure.isValidateAmount(amount)) {
                    System.out.println("Số tiền phải lớn hơn 0 và nhỏ hơn 100 trịu");
                }else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        }

        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();

        return new Expenditure(id, name, date, amount, description);
    }

    public static String deleteExpenditure() {
        System.out.print("Nhập mã chi tiêu cần xóa: ");
        return scanner.nextLine();
    }

    public static Expenditure updateExpenditure() {
        System.out.print("Nhập mã chi tiêu cần sửa: ");
        String id = scanner.nextLine();
        System.out.println("Nhập thông tin mới cho mã chi tiêu: " + id);

        String name;
        do {
            System.out.print("Tên chi tiêu mới: ");
            name = scanner.nextLine();
            if (!ValidateExpenditure.isValidateName(name)) {
                System.out.println("Tên chỉ được chứa chữ cái và khoảng trắng");
            }
        } while (!ValidateExpenditure.isValidateName(name));

        String date;
        do {
            System.out.print("Ngày chi mới (dd/MM/yyyy): ");
            date = scanner.nextLine();
            if (!ValidateExpenditure.isValidateDate(date)) {
                System.out.println("Sai định dạng");
            }
        } while (!ValidateExpenditure.isValidateDate(date));

        double amount = 0;
        while (true) {
            try {
                System.out.print("Số tiền chi mới: ");
                amount = Double.parseDouble(scanner.nextLine());
                if (!ValidateExpenditure.isValidateAmount(amount)) {
                    System.out.println("Số tiền phải lớn hơn 0 và nhỏ hơn 100 trịu");
                } else{
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        }

        System.out.print("Mô tả mới: ");
        String description = scanner.nextLine();

        return new Expenditure(id, name, date, amount, description);
    }

    public static String searchExpenditureById() {
        System.out.print("Nhập mã chi tiêu cần tìm: ");
        return scanner.nextLine();
    }

    public static String searchExpenditureByName() {
        System.out.print("Nhập tên cần tìm: ");
        return scanner.nextLine();
    }

    public static void displayListSort(List<Expenditure> expenditures) {
        if (expenditures.isEmpty()) {
            System.out.println("Danh sách trống");
        } else {
            for (Expenditure expenditure : expenditures) {
                System.out.println(expenditure);
            }
        }
    }
}
