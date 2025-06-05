package casestudy.view;

import java.util.Scanner;

public class MemberView {
    private final Scanner scanner = new Scanner(System.in);
    public void showMenu(){
        int choice;
        do {
            System.out.println(" QUẢN LÝ HỘI VIÊN ");
            System.out.println("1. Hiển thị danh sách hội viên");
            System.out.println("2. Thêm hội viên");
            System.out.println("3. Sửa thông tin hội viên");
            System.out.println("4. Xóa hội viên");
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
