package ss10.view;

import ss10.Utils.Regex;
import ss10.model.Fruit;
import java.util.List;
import java.util.Scanner;

public class FruitView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void display(List<Fruit> fruits) {
        System.out.println(" Danh sách trái cây ");
        for (Fruit fruit : fruits) {
            System.out.println(fruit);
        }
    }
    public static Fruit addFruit() {
        String origin, name, type;
        double price;
        String expirationDate;
        String productionDate;

        while (true) {
            System.out.print("Tên trái cây: ");
            name = scanner.nextLine();
            if (Regex.isValidNameOrType(name)) {
                break;
            }
            System.out.println("Ten khong hop le");
        }

        while (true) {
            System.out.print("Loại trái cây: ");
            type = scanner.nextLine();
            if (Regex.isValidNameOrType(type)) {
                break;
            }
            System.out.println("Loại trái cây không hợp lệ");
        }

        while (true) {
            System.out.print("Ngày sản xuất (dd/MM/yyyy): ");
            productionDate = scanner.nextLine();
            if (!Regex.isValidDate(productionDate)) {
                System.out.println("Định dạng không hợp lệ. Phải là dd/MM/yyyy");
                continue;
            }
            if (!Regex.isProductionDateValid(productionDate)) {
                System.out.println("Ngày sản xuất không được lớn hơn ngày hôm nay");
                continue;
            }
            System.out.print("Hạn sử dụng (dd/MM/yyyy): ");
            expirationDate = scanner.nextLine();
            if (!Regex.isValidDate(expirationDate)) {
                System.out.println("Định dạng không hợp lệ. Phải là dd/MM/yyyy");
                continue;
            }
            if (!Regex.expirationAfterProduction(productionDate, expirationDate)) {
                System.out.println("Hạn sử dụng phải sau ngày sản xuất");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("Xuất xứ: ");
            origin = scanner.nextLine();
            if (Regex.isValidOrigin(origin))
                break;
            System.out.println("Xuất xứ không hợp lệ");
        }
        while (true) {
            try {
                System.out.print("Giá: ");
                price = Double.parseDouble(scanner.nextLine());
                if (price > 0)
                    break;
                System.out.println("Giá phải > 0");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        }
        return new Fruit(name, type, productionDate, expirationDate, origin, price);
    }
}