package casestudy.view;

import casestudy.model.Member;
import casestudy.service.IMemberService;
import casestudy.service.MemberService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MemberView {
    private final Scanner scanner = new Scanner(System.in);
    private final IMemberService memberService = new MemberService();

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
        memberService.update(id, member);
        System.out.println("Đã cập nhật thông tin");
    }
    private void deleteMember() {
        System.out.print("Nhập ID hội viên cần xóa: ");
        String id = scanner.nextLine();
        boolean removed = memberService.delete(id);
        if (removed) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Không tìm thấy học viên");
        }
    }
}
