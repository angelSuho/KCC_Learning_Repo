package kosa.mission04;

import java.util.List;

public class Order {

    private String orderId;
    private Customer customer;
    private List<Product> products;
    private Option option;

    public Order() {}
    public Order(String orderId, Customer customer, Option option, List<Product> products) {
        this.orderId = orderId;
        this.customer = customer;
        this.option = option;
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public void printProducts() {
        for (Product product : products) {
            product.printProduct();
        }
    }
}
