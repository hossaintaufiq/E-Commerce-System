
package e_commerce_system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addProduct(Product product) {
        items.add(product);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Product product : items) {
            total += product.getPrice();
        }
        return total;
    }
}
