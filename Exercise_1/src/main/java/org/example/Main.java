package org.example;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("""
                Hello EveryOne, You may add your item to cart,\s
                \tThen will See it and and already Order it \s
                 \t\tHave a nice shopping!\t<(^_^)>""");




        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        Product product1 = new Product(1, "Laptop", 999.99, "High-performance laptop");
        Product product2 = new Product(2, "Smartphone", 499.99, "Latest smartphone model");
        Product product3 = new Product(3, "Headphones", 149.99, "Wireless noise-canceling headphones");

        while (true) {
            System.out.println("\nWelcome to our online store!");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("All Products: \n" + product1 + '\n' + product2 + '\n' + product3 + '\n');
                    break;
                case 2:
                    System.out.print("Enter the ID of the product you want to add to cart: '1', '2', '3' ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                        switch (productId) {
                            case 1:
                                cart.addProduct(product1);
                                System.out.println("You choose: " + product1);
                                break;
                            case 2:
                                cart.addProduct(product2);
                                System.out.println("You choose: " + product2);
                                break;
                            case 3:
                                cart.addProduct(product3);
                                System.out.println("You choose: " + product3);
                                break;
                            default:
                                System.out.println("Try choose from suggested id)))");
                        }
                    break;
                case 3:
                    List<Product> productsInCart = cart.getProducts();
                    if (productsInCart.isEmpty()) {
                        System.out.println("Your cart is empty.");
                    } else {
                        System.out.println("Products in your cart:");
                        for (Product product : productsInCart) {
                            System.out.println("- " + product.getName() + ": $" + product.getPrice());
                        }
                        System.out.println("Total price: $" + cart.getTotalPrice());
                    }
                    break;
                case 4:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Your cart is empty. Unable to checkout.");
                    } else {
                        System.out.println("Checkout process initiated...");

                        // Зчитування даних користувача для замовлення (наприклад, ім'я)
                        System.out.print("Enter your name: ");
                        String customerName = scanner.nextLine();

                        // Створення замовлення
                        Order order = new Order(cart.getProducts(), customerName);

                        // Виведення інформації про замовлення
                        System.out.println("Order details:" + '\n' + "Customer: " + customerName);
                        System.out.println(order);

                        // Очищення кошика після оформлення замовлення
                        cart.clearCart();
                        System.out.println("Your cart has been cleared.");
                    }
                    break;
                case 5:
                    System.out.println("Thank you for shopping with us! Goodbye!");
                    cart.clearCart();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}