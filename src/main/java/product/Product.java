package product;

public class Product {
    private String name;
    private Unit unit;
    private int count;
    private double price;
    private String maker;

    public Product(String name, Unit unit, int count, double price, String maker) {
        this.name = name;
        this.unit = unit;
        this.count = count;
        this.price = price;
        this.maker = maker;
    }

    public String getName() {
        return name;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setCount(int count) {
        this.count -= count;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public String getMaker() {
        return maker;
    }

    @Override
    public String toString() {
        return String.format("%-25s%-6s%6d%12.2f%20s", name, unit, count, price, maker);
    }
}