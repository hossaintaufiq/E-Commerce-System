package e_commerce_system;

import java.util.List;
import java.util.Scanner;

public class E_Commerce_System {

     
    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        // Sample products
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Product 1", 19.99));
        products.add(new Product(2, "Product 2", 29.99));

        new ProductPage(userManager, products);
    }
}


