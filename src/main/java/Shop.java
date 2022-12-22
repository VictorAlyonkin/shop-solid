import product.IPrintAllProduct;
import product.IPrintProductsWithSameNameOrMarker;
import product.Product;

import java.util.List;

public class Shop implements IPrintAllProduct, IPrintProductsWithSameNameOrMarker {
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
}
