import product.*;
import product.type.ProductBottle;
import product.type.ProductKilo;
import product.type.ProductPiece;

import java.util.List;

public class Shop implements IPrintAllProduct, IPrintProductsWithSameNameOrMarker/*, ICreateProduct*/ {
    private final List<Product> products;

    public Shop(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void printProductsWithSameNameOrMarker(String name, boolean isMaker) {
        List<Product> sameProductName = products.stream()
                .filter(product -> (isMaker) ?
                        product.getMaker().toLowerCase().contains(name) :
                        product.getName().toLowerCase().contains(name))
                .toList();
        sameProductName.forEach(System.out::println);
    }

    public void printAllProducts() {
        products.forEach(System.out::println);
    }

  /*  public void addNewProduct(int unitNumber, String name, int count, Double price, String maker) {
        Product newProduct = createProduct(unitNumber, name, count, price, maker);
        if (newProduct != null) {
            products.add(newProduct);
        }
    }*/
/*
    public Product createProduct(int unitNumber, String name, int count, Double price, String maker) {
        Product newProduct = null;
        switch (unitNumber) {
            case 0:
                newProduct = new ProductPiece(name, count, price, maker);
                break;
            case 1:
                newProduct = new ProductKilo(name, count, price, maker);
                break;
            case 2:
                newProduct = new ProductBottle(name, count, price, maker);
                break;
        }
        return newProduct;
    }*/
}
