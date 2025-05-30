package ss13.utils;

import ss13.model.Expenditure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
//    public static void writeFile(String path, List<String> lines, boolean append) {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, append))) {
//            for (String line : lines) {
//                writer.write(line);
//                writer.newLine();
//            }
//        } catch (IOException e) {
//            System.out.println("Lỗi ghi file: " + e.getMessage());
//        }
//    }
//
//    public static List<String> readFile(String path) {
//        List<String> lines = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                lines.add(line);
//            }
//        } catch (IOException e) {
//            System.out.println("Lỗi đọc file: " + e.getMessage());
//        }
//        return lines;
//    }

    public static void writeFileToBinary(String filePath, List<Expenditure> expenses) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(expenses);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file nhị phân: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Expenditure> readFileToBinary(String filePath) {
        List<Expenditure> expenses = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists() || file.length() == 0) {
            return expenses;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            expenses = (List<Expenditure>) ois.readObject();
        } catch (IOException e) {
            System.out.println("Lỗi đọc file nhị phân: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Lỗi không tìm thấy class: " + e.getMessage());
        }

        return expenses;
    }
}
