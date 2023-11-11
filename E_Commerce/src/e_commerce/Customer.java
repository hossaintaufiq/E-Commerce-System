
package e_commerce;

import java.util.Scanner;

public class Customer {
     String customerName;
    String regNum;

    Product cart[] = new Product[10];
    int cartCount = 0;

    Scanner input = new Scanner(System.in);

    public Customer(String customerName, String regNum) {
        this.customerName = customerName;
        this.regNum = regNum;
    }

    public void addToCart(Product product) {
        if (cartCount < 10) {
            cart[cartCount] = product;
            cartCount++;
        } else {
            System.out.println("Your cart is full. Cannot add more products.");
        }
    }

    public void showCart() {
        System.out.println("Your Cart:");
        for (int i = 0; i < cartCount; i++) {
            System.out.println("Name: " + cart[i].productName);
            System.out.println("Brand: " + cart[i].brand);
            System.out.println("Price: " + cart[i].price);
            System.out.println("Quantity: " + cart[i].quantityCopy);
            System.out.println("-------------------------------");
        }
    }

    public void clearCart() {
        cart = new Product[10];
        cartCount = 0;
        System.out.println("Your cart has been cleared.");
    }

    public void editCart(int serialNo, int newQuantity) {
        for (int i = 0; i < cartCount; i++) {
            if (i == serialNo) {
                cart[i].quantityCopy = newQuantity;
                System.out.println("Product quantity updated in your cart.");
                return;
            }
        }
        System.out.println("Product with Serial No " + serialNo + " not found in your cart.");
    }

    public void removeProductFromCart(int serialNo) {
        for (int i = 0; i < cartCount; i++) {
            if (i == serialNo) {
                for (int j = i; j < cartCount - 1; j++) {
                    cart[j] = cart[j + 1];
                }
                cartCount--;
                System.out.println("Product removed from your cart.");
                return;
            }
        }
        System.out.println("Product with Serial No " + serialNo + " not found in your cart.");
    }
}
