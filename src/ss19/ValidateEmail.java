package ss19;

import java.util.Scanner;

public class ValidateEmail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email ;
        String regex = "^\\w{6,32}@[a-z]{2,12}\\.[a-z]{2,12}$";
        while (true){
            System.out.print("Nhap email: ");
            email = scanner.nextLine();
            if (email.matches(regex)){
                System.out.println("ok");
                break;
            }else {
                System.out.println(email + "sai dinh dang");
            }
        }
    }
}
