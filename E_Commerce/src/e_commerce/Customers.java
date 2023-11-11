/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e_commerce;

import java.util.Scanner;

public class Customers {
 Scanner input = new Scanner(System.in);
    Customer theCustomers[] = new Customer[50];
    int count = 0;

    public void addCustomer(Customer customer) {
        theCustomers[count] = customer;
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
            theCustomers[customerIndex].addToCart(products.getProductBySerialNo(serialNo));
            System.out.println("Product added to your cart.");
        } else {
            System.out.println("Customer not found. Please register first.");
        }
    }

    public void showCart() {
        System.out.println("Enter your registration number:");
        String regNum = input.next();
        int customerIndex = findCustomerIndex(regNum);

        if (customerIndex != -1) {
            Customer customer = theCustomers[customerIndex];
            customer.showCart();
        } else {
            System.out.println("Customer not found. Please register first.");
        }
    }

    public void removeProductFromCart(int serialNo) {
        System.out.println("Enter your registration number:");
        String regNum = input.next();
        int customerIndex = findCustomerIndex(regNum);

        if (customerIndex != -1) {
            Customer customer = theCustomers[customerIndex];
            customer.removeProductFromCart(serialNo);
        } else {
            System.out.println("Customer not found. Please register first.");
        }
    }

    public void editCart(int serialNo, int newQuantity) {
        System.out.println("Enter your registration number:");
        String regNum = input.next();
        int customerIndex = findCustomerIndex(regNum);

        if (customerIndex != -1) {
            Customer customer = theCustomers[customerIndex];
            customer.editCart(serialNo, newQuantity);
        } else {
            System.out.println("Customer not found. Please register first.");
        }
    }

    public void clearCart() {
        System.out.println("Enter your registration number:");
        String regNum = input.next();
        int customerIndex = findCustomerIndex(regNum);

        if (customerIndex != -1) {
            Customer customer = theCustomers[customerIndex];
            customer.clearCart();
        } else {
            System.out.println("Customer not found. Please register first.");
        }
    }
}


