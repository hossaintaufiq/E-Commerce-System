
package e_commerce_final;

import java.util.Scanner;

public class Product {
      // Class data members
    public int sNo;
    public String product;
    public String authorName;
    public int productQty;
    public int productQtyCopy;
 
    // Creating object of Scanner class to
    // read input from users
    Scanner input = new Scanner(System.in);
 
    // Method
    // To add book details
    public Product()

    {
        // Display message for taking input later
        // taking input via
        // nextInt() and nextLine() standard methods
        System.out.println("Enter Serial No of product:");
        this.sNo = input.nextInt();
        input.nextLine();
 
        System.out.println("Enter product Name:");
        this.product = input.nextLine();
 
        System.out.println("Enter Author Name:");
        this.authorName = input.nextLine();
 
        System.out.println("Enter Quantity of products:");
        this.productQty = input.nextInt();
        productQtyCopy = this.productQty;
    }
}
