package kosa.mission04;

import kosa.mission04.category.SubCategory;

import java.util.HashMap;
import java.util.Map;

public class Product {
    private String name;
    private long price;
    private String description;
    private SubCategory subCategory;
    Map<String, Long> sizeQuantities;

    public Product() {}
    public Product(String name, long price, String description, SubCategory subCategory) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.subCategory = subCategory;
        this.sizeQuantities = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public long getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    public SubCategory getSubCategory() {
        return this.subCategory;
    }

    public Map<String, Long> getSizeQuantities() {
        return sizeQuantities;
    }

    public void addSizeQuantity(String size, int quantity) {
        sizeQuantities.put(size, sizeQuantities.getOrDefault(size, 0L) + quantity);
    }

    public void printProduct() {
        printProductExceptSizeQuantity();
        sizeQuantities.entrySet().stream()
        		.forEach(e -> System.out.println("사이즈: " + e.getKey() + ", 수량: " + e.getValue() + "개"));
        System.out.println("---");
    }

    public void printProductExceptSizeQuantity() {
        System.out.println("제품명: " + getName());
        System.out.println("가격: " + getPrice() + "원");
        System.out.println("설명: " + getDescription());
        System.out.println("제품 분류: " + getSubCategory().getName());
    }

    public void deductQuantity(String size, long quantity) {
        this.sizeQuantities.put(size, this.sizeQuantities.get(size) - quantity);
    }
}
