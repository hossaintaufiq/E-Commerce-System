package e_commerce_system;

import java.util.List;
import java.util.Scanner;

public class E_Commerce_System {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();

        System.out.print("Do you have an account? (yes/no): ");
        String response = scanner.nextLine().toLowerCase();

        if (response.equals("yes")) {
            System.out.print("Enter your email: ");
            String email = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();
            User loggedInUser = userManager.login(email, password);

            if (loggedInUser != null) {
                System.out.println("Welcome, " + loggedInUser.getName() + "!");
                // Add e-commerce functionality here
            } else {
                System.out.println("Invalid login. Please try again.");
            }
        } else if (response.equals("no")) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter your email: ");
            String email = scanner.nextLine();
            System.out.print("Create a password: ");
            String password = scanner.nextLine();
            userManager.registerUser(name, email, password);

            System.out.println("Registration successful. You can now log in.");
        } else {
            System.out.println("Invalid input. Please type 'yes' or 'no'.");
        }
    }

}
