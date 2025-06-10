package casestudy.view;

import casestudy.controller.MemberController;
import casestudy.model.Member;
import casestudy.model.Trainer;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class MemberView {
    private final Scanner scanner = new Scanner(System.in);
    private final MemberController memberController = new MemberController();

    public void showMenu() {
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
            switch (choice) {
                case 1:
                    displayAllMembers();
                    break;
                case 2:
                    addMember();
                    break;
                case 3:
                    updateMember();
                    break;
                case 4:
                    deleteMember();
                    break;
                case 0:
                    break;
            }
        } while (choice != 0);
    }

    private void displayAllMembers() {
        List<Member> members = memberController.getAllMembers();
        if (members.isEmpty()) {
            System.out.println("Không có hội viên nào");
        } else {
            for (Member member : members) {
                System.out.println(member);
            }
        }
    }

    private void addMember() {
        try {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Tên: ");
            String name = scanner.nextLine();

            System.out.print("Ngày sinh (yyyy-MM-dd): ");
            LocalDate dob = LocalDate.parse(scanner.nextLine());

            System.out.print("Giới tính: ");
            String gender = scanner.nextLine();

            System.out.print("Số điện thoại: ");
            String phone = scanner.nextLine();

            System.out.print("Gói tập: ");
            String type = scanner.nextLine();

            System.out.print("Ngày bắt đầu (yyyy-MM-dd): ");
            LocalDate start = LocalDate.parse(scanner.nextLine());

            Member member = new Member(id, name, dob, gender, phone, type, start, null);
            boolean result = memberController.addMember(member);
            if (result) {
                System.out.println("Đã thêm hội viên thành công");
            } else {
                System.out.println("Thêm hội viên thất bại");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Sai định dạng. Vui lòng nhập theo yyyy-MM-dd.");
        } catch (Exception e) {
            System.out.println("Lỗi" + e.getMessage());
        }
    }


    private void updateMember() {
        System.out.print("Nhập ID hội viên cần sửa: ");
        String id = scanner.nextLine();
        Member member = memberController.findMemberById(id);
        if (member == null) {
            System.out.println("Không tìm thấy hội viên");
            return;
        }
        try {
            System.out.print("Tên mới: ");
            member.setName(scanner.nextLine());

            System.out.print("Số điện thoại mới: ");
            member.setPhone(scanner.nextLine());

            System.out.print("Giới tính mới: ");
            member.setGender(scanner.nextLine());

            System.out.print("Ngày sinh mới (yyyy-MM-dd): ");
            member.setDateOfBirth(LocalDate.parse(scanner.nextLine()));

            System.out.print("Loại gói tập mới: ");
            member.setMembershipType(scanner.nextLine());

            System.out.print("Ngày bắt đầu mới (yyyy-MM-dd): ");
            member.setStartDate(LocalDate.parse(scanner.nextLine()));

            boolean result = memberController.updateMember(id, member);
            if (result) {
                System.out.println("Đã cập nhật hội viên thành công");
            } else {
                System.out.println("Cập nhật thất bại");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Sai định dạng. Vui lòng nhập theo yyyy-MM-dd.");
        } catch (Exception e) {
            System.out.println("Lỗi " + e.getMessage());
        }
    }

    private void deleteMember() {
        System.out.print("Nhập ID thành viên cần xóa: ");
        String id = scanner.nextLine();

        Member member = memberController.findMemberById(id);
        if (member == null) {
            System.out.println("Không tìm thấy thành viên với ID: " + id);
            return;
        }
        System.out.print("Bạn có chắc muốn xóa thành viên này? (y/n): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("y")) {
            boolean result = memberController.deleteMember(id);
            if (result) {
                System.out.println("Xóa thành công");
            } else {
                System.out.println("Xóa thất bại");
            }
        } else {
            System.out.println("Đã hủy xóa");
        }
    }

    public void assignTrainer() {
        List<Member> members = memberController.getAllMembers();
        if (members.isEmpty()) {
            System.out.println("Không có hội viên nào");
            return;
        }
        System.out.println("DANH SÁCH HỘI VIÊN:");
        for (Member m : members) {
            System.out.println("ID: " + m.getId() + " | Tên: " + m.getName());
        }

        System.out.print("Nhập ID hội viên cần gán: ");
        String memberId = scanner.nextLine();
        Member member = memberController.findMemberById(memberId);
        if (member == null) {
            System.out.println("Không tìm thấy hội viên");
            return;
        }

        List<Trainer> trainers = memberController.getAllTrainers();
        if (trainers.isEmpty()) {
            System.out.println("Không có huấn luyện viên nào");
            return;
        }
        System.out.println("DANH SÁCH HUẤN LUYỆN VIÊN:");
        for (Trainer t : trainers) {
            System.out.println("ID: " + t.getId() + " | Tên: " + t.getName());
        }
        System.out.print("Nhập ID huấn luyện viên: ");
        String trainerId = scanner.nextLine();
        Trainer trainer = null;
        for (Trainer t : memberController.getAllTrainers()) {
            if (t.getId().equals(trainerId)) {
                trainer = t;
                break;
            }
        }

        if (trainer == null) {
            System.out.println("Không tìm thấy huấn luyện viên");
            return;
        }
        member.setTrainerId(trainerId);
        memberController.assignTrainerToMember(memberId, trainerId);
        System.out.println("Đã gán HLV " + trainer.getName() + " cho hội viên " + member.getName());

    }
    public void searchMemberById() {
        System.out.print("Nhập ID hội viên cần tìm: ");
        String id = scanner.nextLine();
        Member member = memberController.findMemberById(id);
        if (member == null) {
            System.out.println("Không tìm thấy hội viên có ID: " + id);
        } else {
            System.out.println("Thông tin hội viên:");
            System.out.println(member);
        }
    }
}
