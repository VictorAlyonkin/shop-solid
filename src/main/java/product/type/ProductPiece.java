package product.type;

import product.Product;
import product.Unit;

public class ProductPiece extends Product {
    public ProductPiece(String name, int count, double price, String maker) {
        super(name, Unit.PIECE, count, price, maker);
    }
}