package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    // Додавання товару у кошик
    public void addProduct(Product product) {
        products.add(product);
    }

    // Видалення товару з кошика
    public void removeProduct(Product product) {
        products.remove(product);
    }

    // Очистка кошика
    public void clearCart() {
        products.clear();
    }

    // Отримання списку товарів у кошику
    public List<Product> getProducts() {
        return products;
    }

    // Розрахунок загальної суми товарів у замовленні
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

}
