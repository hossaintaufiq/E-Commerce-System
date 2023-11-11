/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e_commerce_system_.updated;

import java.util.Scanner;


public class Customer {
      // Class member variables
    String customerName;
    String regNum;
 
    Product borrowedProducts[] = new Product[3];
    public int productsCount = 0;
 
    // Creating object of Scanner class to
    // take input from user
    Scanner input = new Scanner(System.in);
 
    // Constructor
    public Customer()
    {
        // Print statement
        System.out.println("Enter Student Name:");
 
        // This keywords refers to current instance
        this.customerName = input.nextLine();
 
        // Print statement
        System.out.println("Enter Registration Number:");
        this.regNum = input.nextLine();
    }
}
