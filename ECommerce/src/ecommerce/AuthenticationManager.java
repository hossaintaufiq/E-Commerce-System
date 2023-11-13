
package ecommerce;
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
