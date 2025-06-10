package casestudy.view;

import casestudy.controller.TrainerController;
import casestudy.model.Trainer;
import java.util.List;
import java.util.Scanner;

public class TrainerView {
    private final Scanner scanner = new Scanner(System.in);
    private final TrainerController trainerController = new TrainerController();
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
        List<Trainer> trainers = trainerController.getAllTrainers();
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
        if (id.trim().isEmpty()) {
            System.out.println("ID không được để trống");
            return;
        }

        System.out.print("Tên: ");
        String name = scanner.nextLine();
        if (name.trim().isEmpty()) {
            System.out.println("Tên không được để trống");
            return;
        }

        System.out.print("Tuổi: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Tuổi phải là số");
            return;
        }

        System.out.print("Giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.print("Chuyên môn: ");
        String specialty = scanner.nextLine();
        System.out.print("Kinh nghiệm (năm): ");
        int experience;
        try {
            experience = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Kinh nghiệm phải là số");
            return;
        }

        Trainer trainer = new Trainer(id, name, specialty, phone, age, gender, experience);
        boolean result = trainerController.addTrainer(trainer);
        if (result) {
            System.out.println("Đã thêm huấn luyện viên thành công");
        } else {
            System.out.println("Thêm huấn luyện viên thất bại");
        }
    }

    private void updateTrainer() {
        System.out.print("Nhập ID huấn luyện viên cần sửa: ");
        String id = scanner.nextLine();
        Trainer trainer = trainerController.findTrainerById(id);
        if (trainer == null) {
            System.out.println("Không tìm thấy huấn luyện viên");
            return;
        }

        System.out.print("Tên mới: ");
        trainer.setName(scanner.nextLine());
        System.out.print("Số điện thoại mới: ");
        trainer.setPhone(scanner.nextLine());
        System.out.print("Giới tính mới: ");
        trainer.setGender(scanner.nextLine());

        System.out.print("Tuổi mới: ");
        try {
            trainer.setAge(Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("Tuổi phải là số.");
            return;
        }

        System.out.print("Chuyên môn mới: ");
        trainer.setSpecialty(scanner.nextLine());

        System.out.print("Kinh nghiệm mới (năm): ");
        try {
            trainer.setExperience(Integer.parseInt(scanner.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("Kinh nghiệm phải là số.");
            return;
        }

        boolean result = trainerController.updateTrainer(id, trainer);
        if (result) {
            System.out.println("Đã cập nhật huấn luyện viên thành công.");
        } else {
            System.out.println("Cập nhật thất bại.");
        }
    }
    private void deleteTrainer() {
        System.out.print("Nhập ID huấn luyện viên cần xóa: ");
        String id = scanner.nextLine();
        Trainer trainer = trainerController.findTrainerById(id);
        if (trainer == null) {
            System.out.println("Không tìm thấy huấn luyện viên.");
            return;
        }

        System.out.print("Bạn có chắc muốn xóa huấn luyện viên này? (y/n): ");
        String confirm = scanner.nextLine().trim().toLowerCase();
        if (confirm.equals("y")) {
            boolean result = trainerController.deleteTrainer(id);
            if (result) {
                System.out.println("Xóa thành công.");
            } else {
                System.out.println("Xóa thất bại.");
            }
        } else {
            System.out.println("Đã hủy xóa.");
        }
    }
}
