package ss13.model;

import java.io.Serializable;

public class Expenditure implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String date;
    private double expenditureAmount;
    private String description;

    public Expenditure() {
    }

    public Expenditure(String id, String name, String date, double expenditureAmount, String description) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.expenditureAmount = expenditureAmount;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getExpenditureAmount() {
        return expenditureAmount;
    }

    public void setExpenditureAmount(double expenditureAmount) {
        this.expenditureAmount = expenditureAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String toCSV() {
        return id + "," + name + "," + date + "," + expenditureAmount + "," + description;
    }

    @Override
    public String toString() {
        return "Chi tiêu:" +
                " | Mã: '" + id + '\'' +
                " | Tên: '" + name + '\'' +
                " | Ngày chi: " + date +
                " | Số tiền chi: " + expenditureAmount +
                " | Mô tả: '" + description + '\'';
    }
}
