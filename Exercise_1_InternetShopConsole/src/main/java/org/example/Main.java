package org.example;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        System.out.println("""
                Hello EveryOne, You may add your item to cart,\s
                \tThen will See it and and already Order it \s
                 \t\tHave a nice shopping!\t<(^_^)>""");

        Scanner scanner = new Scanner(System.in);
        User user = new User("Customer1");
        Cart cart = new Cart();

        Product product1 = new Product(1, "Omen", 999.99, "High-performance laptop", "Laptop");
        Product product2 = new Product(2, "KiPhone", 499.99, "Latest smartphone model", "Smartphone");
        Product product3 = new Product(3, "AirPords", 149.99, "Wireless noise-canceling headphones", "Headphones");

        while (true) {
            System.out.println("\nWelcome to our online store!");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Search product by Name or Category");
            System.out.println("4. View Cart");
            System.out.println("5. Remove from Cart");
            System.out.println("6. Checkout");
            System.out.println("7. View Order History");
            System.out.println("8. Exit");
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

                    Product selectedProduct = null;
                        switch (productId) {
                            case 1:
                                selectedProduct = product1;
                                break;
                            case 2:
                                selectedProduct = product2;
                                break;
                            case 3:
                                selectedProduct = product3;
                                break;
                            default:
                                System.out.println("Try choose from suggested id)))");
                                break;
                        }
                    if (selectedProduct != null) {
                        cart.addProduct(selectedProduct);
                        System.out.println("You choose: " + selectedProduct);

                        // Create a list containing only the selected product
                        List<Product> selectedProducts = new ArrayList<>();
                        selectedProducts.add(selectedProduct);

                        // Create a new order with the selected product and add it to the user's order history
                        Order newOrder = new Order(selectedProducts, "TestCustomer");
                        user.addToOrderHistory(newOrder);
                    }
                    break;
                case 3:
                    System.out.println("\n1. Search by product name");
                    System.out.println("2. Search by category");
                    System.out.print("Please choose an option: ");

                    int searchOption = scanner.nextInt();
                    scanner.nextLine();

                    switch (searchOption) {
                        case 1:
                            System.out.print("Enter product name to search: 'Omen', 'KiPhone', 'AirPords' ");
                            String productName = scanner.nextLine();

                            boolean found = false;
                            if (product1.getName().equals(productName)) {
                                System.out.println("Product found:\n" + product1);
                                found = true;
                            } else if (product2.getName().equals(productName)) {
                                System.out.println("Product found:\n" + product2);
                                found = true;
                            } else if (product3.getName().equals(productName)) {
                                System.out.println("Product found:\n" + product3);
                                found = true;
                            }

                            if (!found) {
                                System.out.println("No product found with the given name.");
                            }
                            break;
                        case 2:
                            System.out.print("Enter product category to search: 'Laptop', 'Smartphone', 'Headphones' ");
                            String productCategory = scanner.nextLine();

                            boolean founds = false;
                            if (product1.getCategory().equals(productCategory)) {
                                System.out.println("Product found:\n" + product1);
                                founds = true;
                            } else if (product2.getCategory().equals(productCategory)) {
                                System.out.println("Product found:\n" + product2);
                                founds = true;
                            } else if (product3.getCategory().equals(productCategory)) {
                                System.out.println("Product found:\n" + product3);
                                founds = true;
                            }

                            if (!founds) {
                                System.out.println("No product found with the given category.");
                            }
                            break;
                        default:
                            System.out.println("Invalid option.");
                    }
                    break;
                case 4:
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
                case 5:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Your cart is empty. Unable to checkout.");
                    } else {
                        System.out.println("Checkout process initiated...");

                        System.out.print("Enter the number of the item you want to remove: '1' '2' '3' ");
                        int itemToRemoveIndex = scanner.nextInt();
                        scanner.nextLine();
                        switch (itemToRemoveIndex) {
                            case 1:
                                cart.removeProduct(product1);
                                break;
                            case 2:
                                cart.removeProduct(product2);
                                break;
                            case 3:
                                cart.removeProduct(product3);
                                break;
                            default:
                                System.out.println("Try remove available elements");
                        }
                    }
                    break;
                case 6:
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
                case 7:
                    System.out.println("Order History:");
                    List<Order> orderHistory = user.getOrderHistory();
                    if (orderHistory.isEmpty()) {
                        System.out.println("Your order history is empty.");
                    } else {
                        for (Order order : orderHistory) {
                            System.out.println(order);
                        }
                    }
                    break;
                case 8:
                    System.out.println("Thank you for shopping with us! Goodbye!");
                    cart.clearCart();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}