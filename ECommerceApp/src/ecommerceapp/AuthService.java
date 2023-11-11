
package ecommerceapp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthService {
    private static final String USERS_FILE = "users.txt";

    private List<User> users;

    public AuthService() {
        this.users = loadUsers();
    }

    private List<User> loadUsers() {
        List<User> userList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(USERS_FILE))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                String username = parts[0];
                String password = parts[1];
                userList.add(new User(username, password));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public boolean registerUser(String username, String password) {
        if (getUserByUsername(username) == null) {
            users.add(new User(username, password));
            saveUsers();
            return true;
        }
        return false;
    }

    public boolean loginUser(String username, String password) {
        User user = getUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    private User getUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    private void saveUsers() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USERS_FILE))) {
            for (User user : users) {
                writer.println(user.getUsername() + "," + user.getPassword());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

