package kosa.mission04;

import java.util.ArrayList;
import java.util.List;

public class SubCategory {
    private String name;
    private List<Product> products;

    public SubCategory() {}
    public SubCategory(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void printAll() {
        for (Product product : products) {
            product.printProduct();
        }
    }
}
