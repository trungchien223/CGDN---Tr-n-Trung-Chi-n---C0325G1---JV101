package ss8;

public class CleanCode {
    public int tinhTongDiem(int toan,int ly,int hoa){
        return toan + ly + hoa;
    }

    private void employeeDetails(Employee employee) {
        System.out.println(employee);
    }

    public boolean isLeapYear(int year) {
        // Năm nhuận là năm chia hết cho 4 và không chia hết cho 100, hoặc chia hết cho 400
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public int getDayOfMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return -1;
        }
    }
}
