package org.example;

import java.util.List;

public class Order {
    private List<Product> products;
    private String customerName;

    public Order(List<Product> products, String customerName) {
        this.products = products;
        this.customerName = customerName;
    }

    // Розрахунок загальної суми товарів у замовленні
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Products:\n");
        for (Product product : products) {
            stringBuilder.append("- ").append(product.getName()).append(": ").append(product.getPrice())
                    .append("\nDescription: ").append((product.getDescription())).append("\n");
        }
        stringBuilder.append("Total Price: ").append(getTotalPrice()).append("\n");
        return stringBuilder.toString();
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
