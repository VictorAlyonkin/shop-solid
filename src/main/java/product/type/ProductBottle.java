package product.type;

import product.Product;
import product.Unit;

public class ProductBottle extends Product {
    private String alcohol;
    public ProductBottle(String name, int count, double price, String maker, String alcohol) {
        super(name, Unit.BOTTLE, count, price, maker);
        this.alcohol = alcohol;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(String alcohol) {
        alcohol = alcohol;
    }

    @Override
    public String toString() {

        return super.toString() + String.format("%15s", alcohol);
    }
}
