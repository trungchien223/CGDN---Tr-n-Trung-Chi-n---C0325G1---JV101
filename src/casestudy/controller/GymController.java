package casestudy.controller;

import casestudy.view.MemberView;
import casestudy.view.TrainerView;

import java.util.Scanner;

public class GymController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MemberView memberView = new MemberView();
    private static final TrainerView trainerView = new TrainerView();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("  QUẢN LÝ PHÒNG GYM  ");
            System.out.println("1. Quản lý hội viên");
            System.out.println("2. Quản lý huấn luyện viên");
            System.out.println("3. Gán huấn luyện viên cho hội viên");
            System.out.println("4. Tìm hội viên");
            System.out.println("5. Danh sách hội viên sắp hết hạn");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    memberView.showMenu();
                    break;
                case 2:
                    trainerView.showMenu();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("Đã thoát");
            }
        }while (choice!=0);
    }
}
