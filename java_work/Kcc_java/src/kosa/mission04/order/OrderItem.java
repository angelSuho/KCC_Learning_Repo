package kosa.mission04.order;

import kosa.mission04.Product;

public class OrderItem {
    private Product product;
    private String size;
    private long quantity;

    public OrderItem() {}

    public OrderItem(Product product, String size, long quantity) {
        this.product = product;
        this.product.deductQuantity(size, quantity);
        this.size = size;
        this.quantity = quantity;
    }

    public long getPrice() {
        return this.product.getPrice();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void printOrderItem() {
        System.out.println("제품명: " + product.getName());
        System.out.println("사이즈: " + this.size);
        System.out.println("수량: " + this.quantity);
    }
}
