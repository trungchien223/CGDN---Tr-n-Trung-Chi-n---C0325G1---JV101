package ss10.view;

import ss10.model.Fruit;

import java.util.List;
import java.util.Scanner;

public class FruitView {
    private static Scanner scanner = new Scanner(System.in);

    public static void display(List<Fruit> fruits) {
        System.out.println(" Danh sách trái cây ");
        for (Fruit fruit : fruits) {
            System.out.println(fruit);
        }
    }
    public static Fruit addFruit() {
        System.out.print("Tên trái cây: ");
        String name = scanner.nextLine();
        System.out.print("Loại trái cây: ");
        String type = scanner.nextLine();
        System.out.print("Ngày sản xuất: ");
        int productionDate = Integer.parseInt(scanner.nextLine());
        System.out.print("Hạn sử dụng: ");
        int expirationDate = Integer.parseInt(scanner.nextLine());
        System.out.print("Xuất xứ: ");
        String origin = scanner.nextLine();
        System.out.print("Giá: ");
        double price = Double.parseDouble(scanner.nextLine());
        return new Fruit(name, type, productionDate, expirationDate, origin, price);
    }
}
