package casestudy.view;

import casestudy.controller.TrainerController;
import casestudy.model.Trainer;
import casestudy.utils.ValidateTrainer;

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
        System.out.print("ID (định dạng TRxxx): ");
        String id = scanner.nextLine();
        if (!ValidateTrainer.isValidId(id)) {
            System.out.println("ID không hợp lệ (ví dụ: TR001).");
            return;
        }

        if (trainerController.findTrainerById(id) != null) {
            System.out.println("ID đã tồn tại.");
            return;
        }

        System.out.print("Tên: ");
        String name = scanner.nextLine();
        if (!ValidateTrainer.isValidName(name)) {
            System.out.println("Tên không hợp lệ. Mỗi từ phải viết hoa chữ cái đầu.");
            return;
        }

        System.out.print("Tuổi: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());
            if (age < 18 || age > 80) {
                System.out.println("Tuổi phải từ 18 đến 80.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Tuổi phải là số.");
            return;
        }

        System.out.print("Giới tính (Nam/Nữ): ");
        String gender = scanner.nextLine();
        if (!ValidateTrainer.isValidGender(gender)) {
            System.out.println("Giới tính không hợp lệ.");
            return;
        }

        System.out.print("Số điện thoại (+84-0xxxxxxxxx): ");
        String phone = scanner.nextLine();
        if (!ValidateTrainer.isValidPhone(phone)) {
            System.out.println("Số điện thoại không hợp lệ.");
            return;
        }

        System.out.print("Chuyên môn: ");
        String specialty = scanner.nextLine();
        if (!ValidateTrainer.isValidSpecialty(specialty)) {
            System.out.println("Chuyên môn không hợp lệ (chỉ chứa chữ cái, khoảng trắng và từ 2 đến 50 ký tự).");
            return;
        }

        System.out.print("Kinh nghiệm (năm): ");
        int experience;
        try {
            experience = Integer.parseInt(scanner.nextLine());
            if (experience < 0 || experience > 60) {
                System.out.println("Kinh nghiệm phải từ 0 đến 60 năm.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Kinh nghiệm phải là số.");
            return;
        }

        Trainer trainer = new Trainer(id, name, specialty, phone, age, gender, experience);
        boolean result = trainerController.addTrainer(trainer);
        if (result) {
            System.out.println("Đã thêm huấn luyện viên thành công.");
        } else {
            System.out.println("Thêm huấn luyện viên thất bại.");
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

        try {
            System.out.println("Tên hiện tại: " + trainer.getName());
            System.out.print("Tên mới (Enter để giữ nguyên): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                if (ValidateTrainer.isValidName(name)) {
                    trainer.setName(name);
                } else {
                    System.out.println("Tên không hợp lệ.");
                    return;
                }
            }

            System.out.println("Số điện thoại hiện tại: " + trainer.getPhone());
            System.out.print("Số điện thoại mới (Enter để giữ nguyên): ");
            String phone = scanner.nextLine();
            if (!phone.isEmpty()) {
                if (ValidateTrainer.isValidPhone(phone)) {
                    trainer.setPhone(phone);
                } else {
                    System.out.println("Số điện thoại không hợp lệ.");
                    return;
                }
            }

            System.out.println("Giới tính hiện tại: " + trainer.getGender());
            System.out.print("Giới tính mới (Nam/Nữ, Enter để giữ nguyên): ");
            String gender = scanner.nextLine();
            if (!gender.isEmpty()) {
                if (ValidateTrainer.isValidGender(gender)) {
                    trainer.setGender(gender);
                } else {
                    System.out.println("Giới tính không hợp lệ.");
                    return;
                }
            }

            System.out.println("Tuổi hiện tại: " + trainer.getAge());
            System.out.print("Tuổi mới (Enter để giữ nguyên): ");
            String ageInput = scanner.nextLine();
            if (!ageInput.isEmpty()) {
                try {
                    int age = Integer.parseInt(ageInput);
                    if (age >= 18 && age <= 60) {
                        trainer.setAge(age);
                    } else {
                        System.out.println("Tuổi không hợp lệ (18-100).");
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Tuổi phải là số.");
                    return;
                }
            }

            System.out.println("Chuyên môn hiện tại: " + trainer.getSpecialty());
            System.out.print("Chuyên môn mới (Enter để giữ nguyên): ");
            String specialty = scanner.nextLine();
            if (!specialty.isEmpty()) {
                if (ValidateTrainer.isValidSpecialty(specialty)) {
                    trainer.setSpecialty(specialty);
                } else {
                    System.out.println("Chuyên môn không hợp lệ.");
                    return;
                }
            }

            System.out.println("Kinh nghiệm hiện tại: " + trainer.getExperience() + " năm");
            System.out.print("Kinh nghiệm mới (năm, Enter để giữ nguyên): ");
            String expInput = scanner.nextLine();
            if (!expInput.isEmpty()) {
                try {
                    int exp = Integer.parseInt(expInput);
                    if (exp >= 0 && exp <= 80) {
                        trainer.setExperience(exp);
                    } else {
                        System.out.println("Kinh nghiệm không hợp lệ (0-80).");
                        return;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Kinh nghiệm phải là số.");
                    return;
                }
            }

            boolean result = trainerController.updateTrainer(id, trainer);
            if (result) {
                System.out.println("Đã cập nhật huấn luyện viên thành công.");
            } else {
                System.out.println("Cập nhật thất bại.");
            }

        } catch (Exception e) {
            System.out.println("Lỗi" + e.getMessage());
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
