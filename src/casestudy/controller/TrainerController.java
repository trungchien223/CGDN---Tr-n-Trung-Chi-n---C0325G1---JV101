package casestudy.controller;

import java.util.Scanner;

public class TrainerController {
    private static final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        int choice;
        do {
            System.out.println(" QUẢN LÝ HUẤN LUYỆN VIÊN ");
            System.out.println("1. Hiển thị danh sách HLV");
            System.out.println("2. Thêm HLV");
            System.out.println("3. Sửa thông tin HLV");
            System.out.println("4. Xóa HLV");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    break;
            }
        }while (choice!=0);
    }
}
