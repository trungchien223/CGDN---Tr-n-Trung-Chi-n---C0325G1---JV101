package ss10.controller;

import ss10.model.Fruit;
import ss10.service.FruitService;
import ss10.service.IFruitService;
import ss10.view.FruitView;

import java.util.List;
import java.util.Scanner;

public class FruitController {
    private static final IFruitService fruitService = new FruitService();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println(" Quản Lý Trái Cây ");
            System.out.println("1. Hiển thị (theo keySet)");
            System.out.println("2. Hiển thị (theo entrySet)");
            System.out.println("3. Thêm");
            System.out.println("4. Xóa");
            System.out.println("5. Sửa");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    FruitView.displayByKey(fruitService.getAllKeys(), fruitService);
                    break;
                case 2:
                    FruitView.displayByEntries(fruitService.getAllEntries());
                    break;
                case 3:
                    String addCode = FruitView.inputCode();
                    Fruit fruit = FruitView.addFruit();
                    fruitService.add(addCode, fruit);
                    System.out.println("Thêm thành công.");
                    break;
                case 4:
                    String removeCode = FruitView.deleteFruit();
                    fruitService.containsCode(removeCode);
                    fruitService.remove(removeCode);
                    System.out.println("Xóa thành công.");
                    break;
                case 5:
                    String updateCode = FruitView.inputCodeToUpdate();
                    fruitService.containsCode(updateCode);
                    Fruit oldFruit = fruitService.getByCode(updateCode);
                    Fruit newFruit = FruitView.updateFruit(oldFruit);
                    fruitService.update(updateCode, newFruit);
                    System.out.println("Cập nhật thành công.");
                    break;
                case 0:
                    System.out.println("Đã thoát");
            }
        }while (choice!=0);
    }
}
