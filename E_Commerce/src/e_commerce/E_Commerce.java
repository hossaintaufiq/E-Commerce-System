
package e_commerce;

import java.util.Scanner;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;
class AuthenticationManager {

    private static final String USERS_FILE = "users.txt";

    public String login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (validateLogin(username, password)) {
            return username;
        } else {
            System.out.println("Invalid username or password.");
            return null;
        }
    }

    public void register() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a new username: ");
        String newUsername = scanner.nextLine();

        // Check if the username already exists
        if (usernameExists(newUsername)) {
            System.out.println("Username already exists. Please choose a different username.");
            return;
        }

        System.out.print("Enter a password: ");
        String newPassword = scanner.nextLine();

        // Save the new user information to the file
        try {
            FileWriter fileWriter = new FileWriter(USERS_FILE, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(newUsername + "\t" + newPassword);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing to the users file: " + e.getMessage());
        }

        System.out.println("Registration successful.");
    }

    private boolean validateLogin(String username, String password) {
        try {
            FileReader fileReader = new FileReader(USERS_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] userInfo = line.split("\t");
                if (userInfo.length == 2 && userInfo[0].equals(username) && userInfo[1].equals(password)) {
                    bufferedReader.close();
                    return true;
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading the users file: " + e.getMessage());
        }

        return false;
    }

    private boolean usernameExists(String username) {
        try {
            FileReader fileReader = new FileReader(USERS_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] userInfo = line.split("\t");
                if (userInfo.length == 2 && userInfo[0].equals(username)) {
                    bufferedReader.close();
                    return true;
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading the users file: " + e.getMessage());
        }

        return false;
    }
}

class Product {
    private String name;
    private String brand;
    private double price;

    public Product(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }
}

public class E_Commerce {

    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143"); // ANSI escape code to clear console in Unix-like systems
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
         Scanner input = new Scanner(System.in);

        System.out.println("********************Welcome to the Online Shop!********************");

        int choice;

        do {
            clearConsole();
            displayAuthenticationMenu();
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 0:
                    System.out.println("Thank you for visiting our site!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            // Pause to let the user read the output before clearing the console
            if (choice != 0) {
                System.out.println("Press Enter to continue...");
                input.nextLine(); // Consume the Enter key press
                input.nextLine(); // Consume the Enter key press
            }

        } while (choice != 0);
    }

    private static void displayAuthenticationMenu() {
        System.out.println("Select an Option:");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("0. Exit");
    }

    private static void registerUser() {
        Scanner input = new Scanner(System.in);

        System.out.println("Registration:");

        System.out.println("Enter Customer Name:");
        String customerName = input.nextLine();

        System.out.println("Enter Registration Number:");
        String regNum = input.nextLine();

        // Create a new customer and add to the system
        Customer newCustomer = new Customer(customerName, regNum);
        Customers.addCustomer(newCustomer);

        System.out.println("Registration successful. You can now log in.");
    }

    private static void loginUser() {
        Scanner input = new Scanner(System.in);

        System.out.println("Login:");

        System.out.println("Enter Registration Number:");
        String regNum = input.nextLine();

        // Check if the customer is registered
        int customerIndex = Customers.findCustomerIndex(regNum);

        if (customerIndex != -1) {
            System.out.println("Login successful. Welcome back, " + Customers.theCustomers[customerIndex].customerName + "!");
            shoppingMenu(Customers.theCustomers[customerIndex]);
        } else {
            System.out.println("Customer not found. Please register first.");
        }
    }

    private static void shoppingMenu(Customer customer) {
        Scanner input = new Scanner(System.in);

        int choice;

        do {
            clearConsole();
            displayMainMenu();
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    // Show all products
                    Products.showAllProducts();
                    break;
                case 2:
                    // Show all customers
                    Customers.showAllCustomers();
                    break;
                case 3:
                    // Add product to cart
                    addProductToCart(input, customer);
                    break;
                case 4:
                    // Remove product from cart
                    removeProductFromCart(input, customer);
                    break;
                case 5:
                    // Edit cart
                    editCart(input, customer);
                    break;
                case 6:
                    // Checkout
                    checkout(customer);
                    break;
                case 0:
                    System.out.println("Thank you for shopping with us!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            // Pause to let the user read the output before clearing the console
            if (choice != 0) {
                System.out.println("Press Enter to continue...");
                input.nextLine(); // Consume the Enter key press
                input.nextLine(); // Consume the Enter key press
            }

        } while (choice != 0);
    }

    private static void displayMainMenu() {
        System.out.println("Select From The Following Options:");
        System.out.println("1. View All Products");
        System.out.println("2. View All Customers");
        System.out.println("3. Add Product to Cart");
        System.out.println("4. Remove Product from Cart");
        System.out.println("5. Edit Cart");
        System.out.println("6. Checkout");
        System.out.println("0. Exit");
    }

    private static void addProductToCart(Scanner input, Customer customer) {
        System.out.println("Enter the Serial No of the product you want to add to your cart:");
        int serialNo = input.nextInt();
        customer.addToCart(Products.getProductBySerialNo(serialNo));
    }

    private static void removeProductFromCart(Scanner input, Customer customer) {
        System.out.println("Enter the Serial No of the product you want to remove from your cart:");
        int serialNo = input.nextInt();
        customer.removeProductFromCart(serialNo);
    }

    private static void editCart(Scanner input, Customer customer) {
        customer.showCart();
        System.out.println("Enter the Serial No of the product you want to edit in your cart:");
        int serialNo = input.nextInt();
        System.out.println("Enter the new quantity:");
        int newQuantity = input.nextInt();
        customer.editCart(serialNo, newQuantity);
    }

    private static void checkout(Customer customer) {
        System.out.println("Checking out...");
        customer.showCart();
        customer.clearCart();
    }
}