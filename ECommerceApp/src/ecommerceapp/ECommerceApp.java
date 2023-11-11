
package ecommerceapp;

import java.util.Scanner;

public class ECommerceApp {
    // ... existing code ...

    private AuthService authService;

    public ECommerceApp() {
        this.products = loadProducts();
        this.cart = loadCart();
        this.authService = new AuthService();
    }

    // ... existing code ...

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
                    app.addToCart();
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

