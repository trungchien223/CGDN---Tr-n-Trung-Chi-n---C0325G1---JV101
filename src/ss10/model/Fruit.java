package ss10.model;


public class Fruit {
    private String fruitName;
    private String fruitType;
    private String productionDate;
    private String expirationDate;
    private String origin;
    private double price;

    public Fruit() {
    }

    public Fruit(String fruitName, String fruitType, String productionDate, String expirationDate, String origin, double price) {
        this.fruitName = fruitName;
        this.fruitType = fruitType;
        this.productionDate = productionDate;
        this.expirationDate = expirationDate;
        this.origin = origin;
        this.price = price;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tên: " + fruitName +
                ", Loại: " + fruitType +
                ", NSX: " + productionDate +
                ", HSD: " + expirationDate +
                ", Xuất xứ: " + origin +
                ", Giá: " + price;
    }
}
