/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e_commerce_system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductPage {

    private JFrame frame;
    private List<Product> products;
    private UserManager userManager;

    public ProductPage(UserManager userManager, List<Product> products) {
        this.userManager = userManager;
        this.products = products;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Product Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        frame.add(panel);

        for (Product product : products) {
            JButton addToCartButton = new JButton("Add to Cart");
            addToCartButton.addActionListener(new AddToCartListener(product));
            panel.add(new JLabel(product.getName()));
            panel.add(addToCartButton);
        }

        frame.setVisible(true);
    }

    private class AddToCartListener implements ActionListener {

        private Product product;

        public AddToCartListener(Product product) {
            this.product = product;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ShoppingCart shoppingCart = userManager.getCurrentUser().getShoppingCart();
            shoppingCart.addProduct(product);
            JOptionPane.showMessageDialog(frame, product.getName() + " added to cart.");
        }
    }
}
