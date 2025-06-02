package ss13.controller;
import ss13.model.Expenditure;
import ss13.service.ExpenditureService;
import ss13.service.IExpenditureService;
import ss13.view.ExpenditureView;

import java.util.List;
import java.util.Scanner;

public class ExpenditureController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IExpenditureService<Expenditure> expenditureService = new ExpenditureService();
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println(" Quản lý công việc ");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm");
            System.out.println("3. Xóa");
            System.out.println("4. Sửa");
            System.out.println("5. Tìm kiếm theo mã chi tiêu");
            System.out.println("6. Tìm kiếm gần đúng theo tên chi tiêu");
            System.out.println("7. Sắp xếp theo tên tăng dần");
            System.out.println("8. Sắp xếp theo số tiền chi giảm dần, nếu số tiền chi giống nhau thì sắp xếp theo tên tăng dần");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    ExpenditureView.display(expenditureService.getAll());
                    break;
                case 2:
                    Expenditure expenditure = ExpenditureView.addExpenditure();
                    boolean add = expenditureService.add(expenditure);
                    if (add){
                        System.out.println("Thêm thành công");
                    }else {
                        System.out.println("Thêm thất bại");
                    }
                    break;
                case 3:
                    String id = ExpenditureView.deleteExpenditure();
                    boolean delete = expenditureService.delete(id);
                    if (delete){
                        System.out.println("Xóa thành công");
                    }else {
                        System.out.println("Xóa thất bại");
                    }
                    break;
                case 4:
                    String updateId;
                    Expenditure existingExpenditure;
                    do {
                        updateId = ExpenditureView.getExpenditureIdForUpdate();
                        existingExpenditure = expenditureService.findById(updateId);

                        if (existingExpenditure == null) {
                            System.out.println("Không tìm thấy mã chi tiêu: " + updateId);
                        }
                    } while (existingExpenditure == null);

                    Expenditure updatedExpenditure = ExpenditureView.updateExpenditure(updateId);

                    boolean update = expenditureService.update(updateId, updatedExpenditure);
                    if (update) {
                        System.out.println("Sửa thành công");
                    }
                    break;
                case 5:
                    String searchById = ExpenditureView.searchExpenditureById();
                    Expenditure found = expenditureService.findById(searchById);
                    if (found != null) {
                        System.out.println("Đây là mã chi tiêu cần tìm");
                        System.out.println(found);
                    } else {
                        System.out.println("Không tìm thấy mã chi tiêu");
                    }
                    break;
                case 6:
                    String keyword = ExpenditureView.searchExpenditureByName();
                    List<Expenditure> result = expenditureService.searchByName(keyword);
                    if (!result.isEmpty()) {
                        System.out.println("Đã tìm thấy các tên chi tiêu gần đúng:");
                        for (Expenditure expenditure2 : result) {
                            System.out.println(expenditure2);
                        }
                    } else {
                        System.out.println("Không tìm thấy tên chi tiêu phù hợp");
                    }
                    break;
                case 7:
                    List<Expenditure> sortList = expenditureService.sortByName();
                    System.out.println("Danh sách đã sắp xếp theo tên tăng dần");
                    ExpenditureView.displayListSort(sortList);
                    break;
                case 8:
                    List<Expenditure> sortList1 = expenditureService.sortByAmount();
                    System.out.println("Danh sách đã sắp xếp");
                    ExpenditureView.displayListSort(sortList1);
                    break;
                case 0:
                    System.out.println("Đã thoát");
            }
        }while (choice!=0);
    }
}
