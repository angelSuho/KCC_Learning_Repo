package kosa.mission04.category;

import kosa.mission04.Product;

import java.util.ArrayList;
import java.util.List;

public class SubCategory extends Category {
    private List<Product> products;

    public SubCategory() {}
    public SubCategory(String name) {
        super(name);
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void printAll() {
        for (Product product : products) {
            product.printProduct();
        }
    }
}
