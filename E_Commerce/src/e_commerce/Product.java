/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e_commerce;

import java.util.Scanner;



public class Product {
   // Class data members
    public String productName;
    public String brand;
    public double price;
    public int quantity;
    public int quantityCopy;

    // Creating object of Scanner class to
    // read input from users
    Scanner input = new Scanner(System.in);

    // Method
    // To add product details
    public Product() {
        input.nextLine(); // Consume the newline character left by previous input

        System.out.println("Enter Product Name:");
        this.productName = input.nextLine();

        System.out.println("Enter Brand:");
        this.brand = input.nextLine();

        System.out.println("Enter Price:");
        this.price = input.nextDouble();

        System.out.println("Enter Quantity of Products:");
        this.quantity = input.nextInt();
        quantityCopy = this.quantity;
    }
}

