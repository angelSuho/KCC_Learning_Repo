package kosa.mission04.order;

import kosa.mission04.Customer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Order {

    private String orderId;
    private Customer customer;
    private List<OrderItem> orderItems;
    private Option option;
    private String orderDateTime;
    private long orderAmount;

    public Order() {}
    public Order(String orderId, Customer customer, Option option, List<OrderItem> orderItems) {
        this.orderId = orderId;
        this.customer = customer;
        this.option = option;
        this.orderItems = orderItems;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yy-MM-dd hh:mm:ss");
        orderDateTime = format.format(LocalDateTime.now());
        orderAmount += orderItems.stream().mapToLong(OrderItem::getPrice).sum();
    }

    public long getOrderAmount() {
        return this.orderAmount;
    }

    public void printOrder() {
        System.out.println("주문 번호: " + orderId);
        
        orderItems.stream()
        	.forEach(o -> o.printOrderItem());
        
        System.out.println("주문 시각: " + orderDateTime);
        System.out.println("주문 종류: " + option.getType());
        System.out.println("고객 성명: " + customer.getNickname());
    }
}
