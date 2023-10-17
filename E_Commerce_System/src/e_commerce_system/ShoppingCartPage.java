/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e_commerce_system;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ShoppingCartPage {
    private JFrame frame;
    private UserManager userManager;

    public ShoppingCartPage(UserManager userManager) {
        this.userManager = userManager;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Shopping Cart");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);

        ShoppingCart shoppingCart = userManager.getCurrentUser().getShoppingCart();
        List<Product> items = shoppingCart.getItems();

        JPanel panel = new JPanel();
        frame.add(panel);

        for (Product item : items) {
            panel.add(new JLabel(item.getName()));
        }

        panel.add(new JLabel("Total: $" + shoppingCart.calculateTotal()));

        frame.setVisible(true);
    }
}
