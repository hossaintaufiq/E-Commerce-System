package ecommerceapp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ECommerceApp {
    private static final String PRODUCTS_FILE = "D:/Versity/3rd sem/Cse-215L/E_Commerce_System/ECommerceApp";
    private static final String CART_FILE = "D://Versity//3rd sem//Cse-215L//E_Commerce_System//ECommerceApp";
    private static final String USERS_FILE = "users.txt";

    private List<Product> products;
    private ShoppingCart cart;
    private AuthService authService;

    public ECommerceApp() {
        // Print the current working directory
        System.out.println("Current Working Directory: " + System.getProperty("user.dir"));

        this.products = loadProducts();
        this.cart = loadCart();
        this.authService = new AuthService();
    }

    private List<Product> loadProducts() {
        List<Product> productList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(PRODUCTS_FILE))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                productList.add(new Product(id, name, price));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return productList;
    }

    private ShoppingCart loadCart() {
        ShoppingCart loadedCart = new ShoppingCart();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CART_FILE))) {
            loadedCart = (ShoppingCart) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return loadedCart;
    }

    private void saveCart() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CART_FILE))) {
            oos.writeObject(cart);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayProducts() {
        System.out.println("Available Products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private void displayCart() {
        System.out.println("Shopping Cart:");
        for (Product product : cart.getCartItems()) {
            System.out.println(product);
        }
        System.out.println("Total: $" + cart.calculateTotal());
    }

    private void addToCart(int productId) {
        Product selectedProduct = products.stream()
                .filter(product -> product.getId() == productId)
                .findFirst()
                .orElse(null);

        if (selectedProduct != null) {
            cart.addToCart(selectedProduct);
            saveCart();
            System.out.println("Added to cart: " + selectedProduct.getName());
        } else {
            System.out.println("Product not found.");
        }
    }

    private void registerUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authService.registerUser(username, password)) {
            System.out.println("Registration successful.");
        } else {
            System.out.println("Username already exists. Please choose a different username.");
        }
    }

    private void loginUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authService.loginUser(username, password)) {
            System.out.println("Login successful.");
            // You can add logic to allow access to certain features after login
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    public static void main(String[] args) {
        ECommerceApp app = new ECommerceApp();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n1. Display Products");
            System.out.println("2. Display Cart");
            System.out.println("3. Add to Cart");
            System.out.println("4. Register");
            System.out.println("5. Login");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    app.displayProducts();
                    break;
                case 2:
                    app.displayCart();
                    break;
                case 3:
                    System.out.print("Enter the product ID to add to cart: ");
                    int productId = scanner.nextInt();
                    app.addToCart(productId);
                    break;
                case 4:
                    app.registerUser();
                    break;
                case 5:
                    app.loginUser();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
