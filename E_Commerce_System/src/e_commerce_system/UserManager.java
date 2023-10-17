
package e_commerce_system;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users;

    public UserManager() {
        users = FileHandler.readUsers();
        if (users == null) {
            users = new ArrayList<>();
        }
    }

    public void registerUser(String name, String email, String password) {
        User user = new User(email, password, name);
        users.add(user);
        FileHandler.writeUsers(users);
    }

    public User login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
