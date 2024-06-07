package kosa.mission04;

public class Product {
    private String name;
    private long price;
    private String description;
    private SubCategory subCategory;

    public Product() {}

    public Product(String name, long price, String description, SubCategory subCategory) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.subCategory = subCategory;
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

    public void printProduct() {
        System.out.println("Name: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Description: " + getDescription());
        System.out.println("SubCategory: " + getSubCategory().getName());
    }
}
