/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e_commerce_system;

/**
 *
 * @author Hp
 */
public class Customer {
     private String name;
    private String email;
    private String password;
    private ShoppingCart cart;

    public Customer(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        cart = new ShoppingCart();
    }

    public void addToCart(Product product) {
        cart.addProduct(product);
    }

    public double checkout() {
        return cart.calculateTotal();
    }

    public String getName(){
        return name;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
