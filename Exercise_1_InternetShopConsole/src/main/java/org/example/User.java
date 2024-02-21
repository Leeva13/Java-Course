package org.example;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<Order> orderHistory;

    public User(String username) {
        this.username = username;
        this.orderHistory = new ArrayList<>();
    }

    public void addToOrderHistory(Order order) {
        orderHistory.add(order);
    }

    // Getter for order history
    public List<Order> getOrderHistory() {
        return orderHistory;
    }
}
