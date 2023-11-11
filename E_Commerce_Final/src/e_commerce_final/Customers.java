
package e_commerce_final;

import java.util.Scanner;

public class Customers {
     // Creating objects of Scanner and students class
    Scanner input = new Scanner(System.in);
    Customer theCustomers[] = new Customer[50];
 
    public static int count = 0;
 
    // Method 1
    // To add books
    public void addStudent(Customer s)
    {
        for (int i = 0; i < count; i++) {
 
            if (s.regNum.equalsIgnoreCase(
                    theCustomers[i].regNum)) {
 
                // Print statement
                System.out.println(
                    "Student of Reg Num " + s.regNum
                    + " is Already Registered.");
 
                return;
            }
        }
 
        if (count <= 50) {
            theCustomers[count] = s;
            count++;
        }
    }
 
    // Method 2
    // Displaying all students
    public void showAllCustomers()
    {
        // Printing student name and
        // corresponding registered number
        System.out.println("Student Name\t\tReg Number");
        for (int i = 0; i < count; i++) {
 
            System.out.println(theCustomers[i].customerName
                               + "\t\t"
                               + theCustomers[i].regNum);
        }
    }
 
    // Method 3
    // To check the Student
    public int isCustomer()
    {
        // Display message only
        System.out.println("Enter Reg Number:");
 
        String regNum = input.nextLine();
 
        for (int i = 0; i < count; i++) {
 
            if (theCustomers[i].regNum.equalsIgnoreCase(
                    regNum)) {
                return i;
            }
        }
 
        // Print statements
        System.out.println("Customer is not Registered.");
        System.out.println("Get Registered First.");
 
        return -1;
    }
 
    // Method 4
    // To remove the book
    public void checkOutProduct(Products product)
    {
        int customerIndex = this.isCustomer();
 
        if (customerIndex != -1) {
            System.out.println("checking out");
 
            product.showAllProducts();
            Product b = product.checkOutProduct();
 
            System.out.println("checking out");
            if (b != null) {
 
                if (theCustomers[customerIndex].productsCount//(customersCount)
                    <= 3) {
 
                    System.out.println("adding book");
                    theCustomers[customerIndex].borrowedProducts
                        [theCustomers[customerIndex]
                             .productsCount]
                        = b;
                    theCustomers[customerIndex].productsCount++;
 
                    return;
                }
                else {
 
                    System.out.println(
                        "Student Can not Borrow more than 3 Products.");
                    return;
                }
            }
            System.out.println("Book is not Available.");
        }
    }
 
    // Method 5
    // To add the book
    public void checkInProduct(Products product)
    {
        int customerIndex = this.isCustomer();
        if (customerIndex != -1) {
 
            // Printing credentials corresponding to student
            System.out.println(
                "S.No\t\t\tBook Name\t\t\tAuthor Name");
 
            Customer s = theCustomers[customerIndex];
 
            for (int i = 0; i < s.productsCount; i++) {
 
                System.out.println(
                    s.borrowedProducts[i].sNo + "\t\t\t"
                    + s.borrowedProducts[i].authorName + "\t\t\t"
                    + s.borrowedProducts[i].authorName);
            }
 
            // Display message only
            System.out.println(
                "Enter Serial Number of Book to be Checked In:");
 
            int sNo = input.nextInt();
 
            for (int i = 0; i < s.productsCount; i++) {
                if (sNo == s.borrowedProducts[i].sNo) {
                    product.checkInProduct(s.borrowedProducts[i]);
                    s.borrowedProducts[i] = null;
 
                    return;
                }
            }
 
            System.out.println("Productsof Serial No " + sNo
                               + "not Found");
        }
    }
}
