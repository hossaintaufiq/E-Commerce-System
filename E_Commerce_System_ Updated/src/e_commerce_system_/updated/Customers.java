/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e_commerce_system_.updated;

import java.util.Scanner;

public class Customers {
    Scanner input = new Scanner(System.in);
    Customer theCustomers[] = new Customer[50];
    int count = 0;

    public void addCustomer(Customer s) {
        theCustomers[count] = s;
        count++;
    }

    public void showAllCustomers() {
        System.out.println("Customer Name\t\tReg Number");
        for (int i = 0; i < count; i++) {
            System.out.println(theCustomers[i].customerName + "\t\t" + theCustomers[i].regNum);
        }
    }

    public int findCustomerIndex(String regNum) {
        for (int i = 0; i < count; i++) {
            if (theCustomers[i].regNum.equalsIgnoreCase(regNum)) {
                return i;
            }
        }
        return -1;
    }

    public void addProductToCart(Products products, int serialNo) {
        System.out.println("Enter your registration number:");
        String regNum = input.next();
        int customerIndex = findCustomerIndex(regNum);

        if (customerIndex != -1) {
            Customer[customerIndex].addToCart(products.getProductBySerialNo(serialNo));
            System.out.println("Product added to your cart.");
        } else {
            System.out.println("Customer not found. Please register first.");
        }
    }

    public void removeProductFromCart(int serialNo) {
        // Implement logic to remove product from the customer's cart
    }

    public void editCart(int serialNo, int newQuantity) {
        // Implement logic to edit the quantity of a product in the customer's cart
    }

    public void showCart() {
        // Implement logic to display the customer's cart
    }

    public void clearCart() {
        // Implement logic to clear the customer's cart after checkout
    }
}

