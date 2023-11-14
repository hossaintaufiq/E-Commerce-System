package ecommerce;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ECommerce {

    private static final String CART_FILE = "cart.txt";
    private static final String USERS_FILE = "users.txt";
    private static String loggedInUser = null;

    public static void main(String[] args) {
        List<Product> products = initializeProducts();

        // Displaying information of all products
        displayAllProducts(products);

        // Login or Register
        AuthenticationManager authenticationManager = new AuthenticationManager();

        while (true) {
            if (loggedInUser == null) {
                System.out.println("\nWelcome to the E-Commerce System!");
                System.out.println("Choose an option:");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Exit");

                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter your choice (1-3): ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                switch (choice) {
                    case 1:
                        loggedInUser = authenticationManager.login();
                        break;
                    case 2:
                        authenticationManager.register();
                        break;
                    case 3:
                        System.out.println("Exiting the program. Thank you!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                        break;
                }
            } else {
                // User is logged in
                displayMenu();

                // User input for menu option
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter your choice (1-5): ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Search by brand
                        System.out.print("Enter a brand to search for products: ");
                        scanner.nextLine();  // Consume the newline character
                        String searchBrand = scanner.nextLine();
                        searchByBrand(products, searchBrand);
                        break;
                    case 2:
                        // View cart
                        viewCart();
                        break;
                    case 3:
                        // Add to cart
                        addToCart(products);
                        break;
                    case 4:
                        // Logout
                        loggedInUser = null;
                        System.out.println("Logged out successfully.");
                        break;
                    case 5:
                        // Exit
                        System.out.println("Exiting the program. Thank you!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                        break;
                }
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("1. Search by Brand");
        System.out.println("2. View Cart");
        System.out.println("3. Add to Cart");
        System.out.println("4. Logout");
        System.out.println("5. Exit");
    }

    private static void searchByBrand(List<Product> products, String searchBrand) {
        // Clear the console
        clearConsole();

        System.out.println("Products with brand '" + searchBrand + "':");
        boolean found = false;

        for (Product product : products) {
            if (product.getBrand().equalsIgnoreCase(searchBrand)) {
                displayProduct(product);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No products found with brand '" + searchBrand + "'.");
        }

        // Wait for Enter to go back to the home page
        System.out.println("\nPress Enter to go back to the home page...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        clearConsole();
    }

    private static void displayProduct(Product product) {
        System.out.println("Name: " + product.getName());
        System.out.println("Brand: " + product.getBrand());
        System.out.println("Price: $" + product.getPrice());
        System.out.println("------------------------");
    }

    private static void displayAllProducts(List<Product> products) {
        System.out.println("List of Products:");
        for (Product product : products) {
            displayProduct(product);
        }
    }

    private static void clearConsole() {
        // Clear the console by printing empty lines
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private static List<Product> initializeProducts() {
        List<Product> products = new ArrayList<>();

        // Adding 5 Apple products
        products.add(new Product("iPhone 13", "Apple", 1099.99));
        products.add(new Product("iPad Pro", "Apple", 799.99));
        products.add(new Product("MacBook Air", "Apple", 1299.99));
        products.add(new Product("AirPods Pro", "Apple", 249.99));
        products.add(new Product("Apple Watch Series 7", "Apple", 499.99));

        // Adding 5 Samsung products
        products.add(new Product("Galaxy S21", "Samsung", 899.99));
        products.add(new Product("Galaxy Tab S7", "Samsung", 649.99));
        products.add(new Product("Samsung Notebook 9", "Samsung", 1299.99));
        products.add(new Product("Galaxy Buds Pro", "Samsung", 199.99));
        products.add(new Product("Samsung Galaxy Watch 4", "Samsung", 349.99));

        // Adding 5 Sony products
        products.add(new Product("Sony Xperia 1 III", "Sony", 1299.99));
        products.add(new Product("Sony WH-1000XM4", "Sony", 349.99));
        products.add(new Product("Sony Bravia XR A80J", "Sony", 1599.99));
        products.add(new Product("Sony WF-1000XM4", "Sony", 279.99));
        products.add(new Product("Sony Alpha 7 III", "Sony", 1999.99));

        // Adding 5 HP products
        products.add(new Product("HP Spectre x360", "HP", 1299.99));
        products.add(new Product("HP Envy 13", "HP", 999.99));
        products.add(new Product("HP Pavilion Gaming Laptop", "HP", 799.99));
        products.add(new Product("HP OfficeJet Pro 9015", "HP", 229.99));
        products.add(new Product("HP Sprocket Portable Photo Printer", "HP", 99.99));

        return products;
    }

    
    private static void viewCart() {
    try {
        // Read the cart from the file
        FileReader fileReader = new FileReader(CART_FILE);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<String> cartItems = new ArrayList<>();

        System.out.println("Cart:");

        String line;
        int itemIndex = 1;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(itemIndex + ". " + line);
            cartItems.add(line);
            itemIndex++;
        }

        bufferedReader.close();

        if (!cartItems.isEmpty()) {
            // Ask the user if they want to delete an item
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the number of the item to delete (0 to go back): ");
            int deleteChoice = scanner.nextInt();

            if (deleteChoice > 0 && deleteChoice <= cartItems.size()) {
                // Remove the selected item from the cart
                cartItems.remove(deleteChoice - 1);

                // Write the updated cart back to the file
                try {
                    FileWriter fileWriter = new FileWriter(CART_FILE);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    for (String cartItem : cartItems) {
                        bufferedWriter.write(cartItem);
                        bufferedWriter.newLine();
                    }

                    bufferedWriter.close();
                } catch (IOException e) {
                    System.out.println("Error writing to the cart file: " + e.getMessage());
                }

                System.out.println("Item removed from the cart.");
            } else if (deleteChoice != 0) {
                System.out.println("Invalid choice. No changes made to the cart.");
            }
        }

    } catch (IOException e) {
        System.out.println("Error reading the cart file: " + e.getMessage());
    }

    // Wait for Enter to go back to the home page
    System.out.println("\nPress Enter to go back to the home page...");
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
    clearConsole();
}



    private static void addToCart(List<Product> products) {
        // Clear the console
        clearConsole();

        // Displaying information of all products before adding to cart
        displayAllProducts(products);

        // User input for adding to cart
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the product to add to the cart: ");
        String productName = scanner.nextLine();

        // Check if the entered product name is valid
        boolean validProduct = false;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                validProduct = true;
                break;
            }
        }

        if (validProduct) {
            System.out.print("Enter the quantity to add to the cart: ");
            int quantity = scanner.nextInt();

            // Append the product and quantity to the cart file
            try {
                FileWriter fileWriter = new FileWriter(CART_FILE, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(productName + "\t\t" + quantity);
                bufferedWriter.newLine();

                bufferedWriter.close();
            } catch (IOException e) {
                System.out.println("Error writing to the cart file: " + e.getMessage());
            }

            System.out.println(quantity + " " + productName + "(s) added to the cart.");

        } else {
            System.out.println("Invalid product name. Please enter a valid product name.");
        }

        // Wait for Enter to go back to the home page
        System.out.println("\nPress Enter to go back to the home page...");
        scanner.nextLine();  // Consume the newline character
        scanner.nextLine();
        clearConsole();
    }
}