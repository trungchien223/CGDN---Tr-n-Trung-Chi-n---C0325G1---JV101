package ss13.view;

import ss13.model.Expenditure;
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
    public static Expenditure addExpenditure(){
        System.out.print("Nhập mã chi tiêu: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên chi tiêu: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày chi: ");
        String date = scanner.nextLine();
        System.out.print("Nhập số tiền chi: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();
        return new Expenditure(id,name,date,amount,description);
    }
    public static String deleteExpenditure(){
        System.out.print("Nhap ma chi tieu can xoa: ");
        return scanner.nextLine();
    }
    public static Expenditure updateExpemditure(){
        System.out.print("Nhập mã chi tiêu cần sửa: ");
        String id = scanner.nextLine();
        System.out.println("Nhập thông tin mới cho mã chi tiêu: " + id);
        System.out.print("Tên chi tiêu mới: ");
        String name = scanner.nextLine();
        System.out.print("Ngày chi mới: ");
        String date = scanner.nextLine();
        System.out.print("Số tiền chi mới: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Mô tả mới: ");
        String description = scanner.nextLine();
        return new Expenditure(id,name,date,amount,description);
    }
    public static String searchExpenditureById(){
        System.out.print("Nhập mã chi tiêu cần tìm: ");
        return scanner.nextLine();
    }
    public static String searchExpemditureByName(){
        System.out.print("Nhập tên cần tìm: ");
        return scanner.nextLine();
    }
}
