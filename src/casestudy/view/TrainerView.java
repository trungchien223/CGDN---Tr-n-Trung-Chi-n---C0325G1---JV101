package casestudy.view;

import casestudy.model.Trainer;
import casestudy.service.ITrainerService;
import casestudy.service.TrainerService;

import java.util.List;
import java.util.Scanner;

public class TrainerView {
    private final Scanner scanner = new Scanner(System.in);
    private final ITrainerService trainerService = new TrainerService();
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
                    displayAllTrainers();
                    break;
                case 2:
                    addTrainer();
                    break;
                case 3:
                    updateTrainer();
                    break;
                case 4:
                    deleteTrainer();
                    break;
                case 0:
                    break;
            }
        }while (choice!=0);
    }
    private void displayAllTrainers() {
        List<Trainer> trainers = trainerService.findAll();
        if (trainers.isEmpty()) {
            System.out.println("Không có huấn luyện viên nào");
        } else {
            for (Trainer trainer : trainers) {
                System.out.println(trainer);
            }
        }
    }
    private void addTrainer() {
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Tên: ");
        String name = scanner.nextLine();
        System.out.print("Chuyên môn: ");
        String specialty = scanner.nextLine();
        System.out.print("Số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.print("Tuổi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Số năm kinh nghiệm: ");
        int exp = Integer.parseInt(scanner.nextLine());

        Trainer trainer = new Trainer(id, name, specialty, phone, age, gender, exp);
        trainerService.add(trainer);
        System.out.println("Đã thêm HLV");
    }
    private void updateTrainer() {
        System.out.print("Nhập ID HLV cần sửa: ");
        String id = scanner.nextLine();
        Trainer trainer = trainerService.findById(id);
        if (trainer == null) {
            System.out.println("Không tìm thấy HLV");
            return;
        }
        System.out.print("Tên mới: ");
        String name = scanner.nextLine();
        trainer.setName(name);
        System.out.print("Số điện thoại mới: ");
        String phone = scanner.nextLine();
        trainer.setPhone(phone);
        trainerService.update(id, trainer);
        System.out.println("Đã cập nhật HLV");
    }
    private void deleteTrainer() {
        System.out.print("Nhập ID HLV cần xóa: ");
        String id = scanner.nextLine();
        boolean removed = trainerService.delete(id);
        if (removed) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Không tìm thấy HLV");
        }
    }
}
