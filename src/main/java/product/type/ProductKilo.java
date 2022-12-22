package product.type;

import product.Product;
import product.Unit;

public class ProductKilo extends Product {
    public ProductKilo(String name, int count, double price, String maker) {
        super(name, Unit.KILO, count, price, maker);
    }
}