package casestudy.view;

import casestudy.controller.MemberController;
import casestudy.model.Member;
import casestudy.model.Trainer;
import casestudy.utils.ValidateMember;

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
        String id, name, gender, phone, type;
        LocalDate dob, start;
        while (true) {
            System.out.print("ID (MBxxx): ");
            id = scanner.nextLine();
            if (ValidateMember.isValidId(id))
                break;
            System.out.println("ID không hợp lệ. Phải theo định dạng MBxxx.");
        }

        while (true) {
            System.out.print("Tên: ");
            name = scanner.nextLine();
            if (ValidateMember.isValidName(name))
                break;
            System.out.println("Tên không hợp lệ. Viết hoa chữ cái đầu và không chứa số.");
        }
        while (true) {
            try {
                System.out.print("Ngày sinh (yyyy-MM-dd): ");
                dob = LocalDate.parse(scanner.nextLine());
                if (ValidateMember.isValidDateOfBirth(dob)) break;
                System.out.println("Ngày sinh không hợp lệ. Phải từ 18 tuổi trở lên.");
            } catch (DateTimeParseException e) {
                System.out.println("Sai định dạng ngày. Vui lòng nhập theo yyyy-MM-dd.");
            }
        }


        while (true) {
            System.out.print("Giới tính (Nam/Nữ): ");
            gender = scanner.nextLine();
            if (ValidateMember.isValidGender(gender)) break;
            System.out.println("Giới tính không hợp lệ. Nhập 'Nam' hoặc 'Nữ'.");
        }

        while (true) {
            System.out.print("Số điện thoại (vd:+84-0xxxxxxxxx): ");
            phone = scanner.nextLine();
            if (ValidateMember.isValidPhone(phone)) break;
            System.out.println("Số điện thoại không hợp lệ.");
        }


        while (true) {
            System.out.print("Gói tập (Normal/Plus/Pro/Promax): ");
            type = scanner.nextLine();
            if (ValidateMember.isValidMembershipType(type)) break;
            System.out.println("Gói tập không hợp lệ.");
        }

        while (true) {
            try {
                System.out.print("Ngày bắt đầu (yyyy-MM-dd): ");
                start = LocalDate.parse(scanner.nextLine());
                if (ValidateMember.isValidStartDate(start)) break;
                System.out.println("Ngày bắt đầu không hợp lệ. Không được trong quá khứ.");
            } catch (DateTimeParseException e) {
                System.out.println("Sai định dạng ngày. Vui lòng nhập theo yyyy-MM-dd.");
            }
        }

        Member member = new Member(id, name, dob, gender, phone, type, start, null);
        boolean result = memberController.addMember(member);
        System.out.println(result ? " Đã thêm hội viên thành công." : "Thêm hội viên thất bại.");
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
            System.out.println("Tên hiện tại: " + member.getName());
            System.out.print("Tên mới (Enter để giữ nguyên): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                if (ValidateMember.isValidName(name)) {
                    member.setName(name);
                } else {
                    System.out.println("Tên không hợp lệ");
                    return;
                }
            }

            System.out.println("Số điện thoại hiện tại: " + member.getPhone());
            System.out.print("SĐT mới (Enter để giữ nguyên): ");
            String phone = scanner.nextLine();
            if (!phone.isEmpty()) {
                if (ValidateMember.isValidPhone(phone)) {
                    member.setPhone(phone);
                } else {
                    System.out.println("SĐT không hợp lệ");
                    return;
                }
            }

            System.out.println("Giới tính hiện tại: " + member.getGender());
            System.out.print("Giới tính mới (Nam/Nữ, Enter để giữ nguyên): ");
            String gender = scanner.nextLine();
            if (!gender.isEmpty()) {
                if (ValidateMember.isValidGender(gender)) {
                    member.setGender(gender);
                } else {
                    System.out.println("Giới tính không hợp lệ");
                    return;
                }
            }

            System.out.println("Ngày sinh hiện tại: " + member.getDateOfBirth());
            System.out.print("Ngày sinh mới (yyyy-MM-dd, Enter để giữ nguyên): ");
            String dobInput = scanner.nextLine();
            if (!dobInput.isEmpty()) {
                LocalDate dob = LocalDate.parse(dobInput);
                if (ValidateMember.isValidDateOfBirth(dob)) {
                    member.setDateOfBirth(dob);
                } else {
                    System.out.println("Ngày sinh không hợp lệ");
                    return;
                }
            }

            System.out.println("Loại gói tập hiện tại: " + member.getMembershipType());
            System.out.print("Loại gói tập mới (Normal/Plus/Pro/Promax, Enter để giữ nguyên): ");
            String type = scanner.nextLine();
            if (!type.isEmpty()) {
                if (ValidateMember.isValidMembershipType(type)) {
                    member.setMembershipType(type);
                } else {
                    System.out.println("Loại gói tập không hợp lệ");
                    return;
                }
            }

            System.out.println("Ngày bắt đầu hiện tại: " + member.getStartDate());
            System.out.print("Ngày bắt đầu mới (yyyy-MM-dd, Enter để giữ nguyên): ");
            String startInput = scanner.nextLine();
            if (!startInput.isEmpty()) {
                LocalDate start = LocalDate.parse(startInput);
                if (ValidateMember.isValidStartDate(start)) {
                    member.setStartDate(start);
                } else {
                    System.out.println("Ngày bắt đầu không hợp lệ");
                    return;
                }
            }

            boolean result = memberController.updateMember(id, member);
            if (result) {
                System.out.println("Đã cập nhật hội viên thành công");
            } else {
                System.out.println("Cập nhật thất bại");
            }

        } catch (DateTimeParseException e) {
            System.out.println("Sai định dạng ngày. Vui lòng nhập đúng yyyy-MM-dd.");
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
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
            System.out.println("Không có hội viên nào.");
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
            System.out.println("Không tìm thấy hội viên.");
            return;
        }

        if (member.getTrainerId() != null && !member.getTrainerId().isEmpty()) {
            Trainer currentTrainer = memberController.findTrainerById(member.getTrainerId());
            if (currentTrainer != null) {
                System.out.println("Hội viên đã được gán cho HLV: " + currentTrainer.getName());
            } else {
                System.out.println("Hội viên đã được gán cho HLV có ID: " + member.getTrainerId());
            }
            System.out.print("Bạn có muốn đổi HLV không? (y/n): ");
            String confirm = scanner.nextLine().trim().toLowerCase();
            if (!confirm.equals("y")) {
                System.out.println("Không thay đổi HLV.");
                return;
            }
        }

        List<Trainer> trainers = memberController.getAllTrainers();
        if (trainers.isEmpty()) {
            System.out.println("Không có huấn luyện viên nào.");
            return;
        }

        System.out.println("DANH SÁCH HUẤN LUYỆN VIÊN:");
        for (Trainer t : trainers) {
            System.out.println("ID: " + t.getId() + " | Tên: " + t.getName());
        }

        Trainer trainer = null;
        while (trainer == null) {
            System.out.print("Nhập ID huấn luyện viên: ");
            String trainerId = scanner.nextLine();
            trainer = memberController.findTrainerById(trainerId);
            if (trainer == null) {
                System.out.println("Không tìm thấy huấn luyện viên. Vui lòng nhập lại.");
            } else {
                member.setTrainerId(trainer.getId());
                memberController.assignTrainerToMember(member.getId(), trainer.getId());
                System.out.println("Đã gán HLV " + trainer.getName() + " cho hội viên " + member.getName());
            }
        }
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
