package casestudy.view;

import casestudy.model.Member;
import casestudy.model.Trainer;
import casestudy.service.IMemberService;
import casestudy.service.ITrainerService;
import casestudy.service.MemberService;
import casestudy.service.TrainerService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MemberView {
    private final Scanner scanner = new Scanner(System.in);
    private final IMemberService memberService = new MemberService();
    private final ITrainerService trainerService = new TrainerService();

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
        List<Member> members = memberService.findAll();
        if (members.isEmpty()) {
            System.out.println("Không có hội viên nào");
        } else {
            for (Member member : members) {
                System.out.println(member);
            }
        }
    }
    private void addMember(){
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Tên: ");
        String name = scanner.nextLine();
        System.out.print("Ngày sinh: ");
        LocalDate dob = LocalDate.parse(scanner.nextLine());
        System.out.print("Giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.print("Gói tập: ");
        String type = scanner.nextLine();
        System.out.print("Ngày bắt đầu: ");
        LocalDate start = LocalDate.parse(scanner.nextLine());
        Member member = new Member(id, name, dob, gender, phone, type, start, null);
        memberService.add(member);
        System.out.println("Đã thêm hội viên");
    }
    private void updateMember() {
        System.out.print("Nhập ID hội viên cần sửa: ");
        String id = scanner.nextLine();
        Member member = memberService.findById(id);
        if (member == null) {
            System.out.println("Không tìm thấy hội viên");
            return;
        }
        System.out.print("Tên mới: ");
        String name = scanner.nextLine();
        member.setName(name);
        System.out.print("Số điện thoại mới: ");
        String phone = scanner.nextLine();
        member.setPhone(phone);
        System.out.print("Giới tính mới: ");
        member.setGender(scanner.nextLine());
        System.out.print("Ngày sinh mới: ");
        member.setDateOfBirth(LocalDate.parse(scanner.nextLine()));
        System.out.print("Loại gói tập mới: ");
        member.setMembershipType(scanner.nextLine());
        System.out.print("Ngày bắt đầu mới: ");
        member.setStartDate(LocalDate.parse(scanner.nextLine()));
        memberService.update(id, member);
        System.out.println("Đã cập nhật lại thông tin hội viên");
    }
    private void deleteMember() {
        System.out.print("Nhập ID thành viên cần xóa: ");
        String id = scanner.nextLine();

        Member member = memberService.findById(id);
        if (member == null) {
            System.out.println("Không tìm thấy thành viên với ID: " + id);
            return;
        }
        System.out.print("Bạn có chắc muốn xóa thành viên này? (y/n): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("y")) {
            boolean result = memberService.delete(id);
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
        List<Member> members = memberService.findAll();
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
        Member member = memberService.findById(memberId);
        if (member == null) {
            System.out.println("Không tìm thấy hội viên");
            return;
        }
        List<Trainer> trainers = trainerService.findAll();
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
        Trainer trainer = trainerService.findById(trainerId);
        if (trainer == null) {
            System.out.println("Không tìm thấy huấn luyện viên");
            return;
        }
        member.setTrainerId(trainerId);
        memberService.update(memberId, member);
        System.out.println("Đã gán HLV " + trainer.getName() + " cho hội viên " + member.getName());
    }
    public void searchMemberById() {
        System.out.print("Nhập ID hội viên cần tìm: ");
        String id = scanner.nextLine();
        Member member = memberService.findById(id);
        if (member == null) {
            System.out.println("Không tìm thấy hội viên có ID: " + id);
        } else {
            System.out.println("Thông tin hội viên:");
            System.out.println(member);
        }
    }
}
