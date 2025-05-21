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
            System.out.println("Quản Lí Trái Cây");
            System.out.println("1. Hiển thị danh sách trái cây");
            System.out.println("2. Thêm trái cây");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    List<Fruit> fruitList = fruitService.getAll();
                    FruitView.display(fruitList);
                    break;
                case 2:
                    Fruit fruit = FruitView.addFruit();
                    fruitService.add(fruit);
                    System.out.println("Them thanh cong");
                    break;
                case 0:
                    System.out.println("Đã thoát");
            }
        }while (choice!=0);
    }
}
