package ss10.view;

import ss10.utils.Regex;
import ss10.model.Fruit;
import ss10.service.IFruitService;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FruitView {
    private static final Scanner scanner = new Scanner(System.in);
    public static void displayByKey(Set<String> keys, IFruitService service) {
        for (String key : keys) {
            Fruit fruit = service.getByCode(key);
            System.out.println("Mã: " + key + " - " + fruit);
        }
    }
    public static void displayByEntries(Set<Map.Entry<String, Fruit>> entries) {
        for (Map.Entry<String, Fruit> entry : entries) {
            System.out.println("Mã: " + entry.getKey() + " - " + entry.getValue());
        }
    }
    public static String inputCode() {
        System.out.print("Nhập mã trái cây: ");
        return scanner.nextLine();
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
            if (!Regex.isNotAfterToday(productionDate)) {
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
            if (Regex.isValidOrigin(origin)) {
                break;
            }
            System.out.println("Xuất xứ không hợp lệ");
        }
        while (true) {
            try {
                System.out.print("Giá: ");
                price = Double.parseDouble(scanner.nextLine());
                if (price > 0 && price <= 100000000) {
                    break;
                }
                System.out.println("Giá phải > 0 và nhỏ hơn 100 triệu");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        }
        return new Fruit(name, type, productionDate, expirationDate, origin, price);
    }
    public static String inputCodeToUpdate() {
        System.out.print("Nhập mã trái cây cần sửa: ");
        return scanner.nextLine();
    }
    public static Fruit updateFruit(Fruit oldFruit) {
        System.out.println("Thông tin hiện tại: " + oldFruit);
        return addFruit();
    }
    public static String deleteFruit() {
        System.out.print("Nhập mã trái cây cần xóa: ");
        return scanner.nextLine();
    }
}