
package e_commerce_final;

import java.util.Scanner;

public class Products {
     // Class data members
    Product theProducts[] = new Product[50];
    public static int count;
 
    Scanner input = new Scanner(System.in);
 
    // Method 1
    //  To compare books
    public int compareproductObjects(Product b1, Product b2)
    {
 
        // If book name matches
        if (b1.authorName.equalsIgnoreCase(b2.authorName)) {
 
            // Printing book exists
            System.out.println(
                "product of this Name Already Exists.");
            return 0;
        }
 
        // if book serial matches
        if (b1.sNo == b2.sNo) {
 
            // Print product exists
            System.out.println(
                "product of this Serial No Already Exists.");
 
            return 0;
        }
        return 1;
    }
 
    // Method 2
    // To add book
    public void addproduct(Product b)
    {
 
        for (int i = 0; i < count; i++) {
 
            if(this.compareproductObjects(b, this.theProducts[i])== 0)
                return;
        }
 
        if (count < 50) {
 
            theProducts[count] = b;
            count++;
        }
        else {
 
            System.out.println(
                "No Space to Add More products.");
        }
    }
 
    // Method 3
    // To search book by serial number
    public void searchBySno()
    {
 
        // Display message
        System.out.println(
            "\t\t\t\tSEARCH BY SERIAL NUMBER\n");
 
        // Class data members
        int sNo;
        System.out.println("Enter Serial No of product:");
        sNo = input.nextInt();
 
        int flag = 0;
        System.out.println(
            "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
 
        for (int i = 0; i < count; i++) {
            if (sNo == theProducts[i].sNo) {
                System.out.println(
                    theProducts[i].sNo + "\t\t"
                    + theProducts[i].authorName+ "\t\t"
                    + theProducts[i].authorName + "\t\t"
                    + theProducts[i].productQtyCopy + "\t\t"
                    + theProducts[i].productQty);
                flag++;
                return;
            }
        }
        if (flag == 0)
            System.out.println("No Product for Serial No "
                               + sNo + " Found.");
    }
 
    // Method 4
    // To search author by name
    public void searchByAuthorName()
    {
 
        // Display message
        System.out.println(
            "\t\t\t\tSEARCH BY AUTHOR'S NAME");
 
        input.nextLine();
 
        System.out.println("Enter Author Name:");
        String authorName = input.nextLine();
 
        int flag = 0;
 
        System.out.println(
            "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
 
        for (int i = 0; i < count; i++) {
 
            // if author matches any of its product
            if (authorName.equalsIgnoreCase(
                    theProducts[i].authorName)) {
 
                // Print below corresponding credentials
                System.out.println(
                    theProducts[i].sNo + "\t\t"
                    + theProducts[i].authorName + "\t\t"
                    + theProducts[i].authorName + "\t\t"
                    + theProducts[i].productQtyCopy + "\t\t"
                    + theProducts[i].productQty);
                flag++;
            }
        }
 
        // Else no product matches for author
        if (flag == 0)
            System.out.println("No Products of " + authorName
                               + " Found.");
    }
 
    // Method 5
    // To display all products
    public void showAllProducts()
    {
 
        System.out.println("\t\t\t\tSHOWING ALL ProductsS\n");
        System.out.println(
            "S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
 
        for (int i = 0; i < count; i++) {
 
            System.out.println(
                theProducts[i].sNo + "\t\t"
                + theProducts[i].authorName + "\t\t"
                + theProducts[i].authorName + "\t\t"
                + theProducts[i].productQtyCopy + "\t\t"
                + theProducts[i].productQty);
        }
    }
 
    // Method 6
    // To edit the product
    public void upgradeProductQty()
    {
 
        System.out.println(
            "\t\t\t\tUPGRADE QUANTITY OF A product\n");
        System.out.println("Enter Serial No of product");
 
        int sNo = input.nextInt();
 
        for (int i = 0; i < count; i++) {
 
            if (sNo == theProducts[i].sNo) {
 
                // Display message
                System.out.println(
                    "Enter No of products to be Added:");
 
                int addingQty = input.nextInt();
                theProducts[i].productQty += addingQty;
                theProducts[i].productQtyCopy += addingQty;
 
                return;
            }
        }
    }
 
    // Method 7
    // To create menu
    public void dispMenu()
    {
 
        // Displaying menu
        System.out.println(
            "----------------------------------------------------------------------------------------------------------");
        System.out.println("Press 1 to Add new product.");
        System.out.println("Press 0 to Exit Application.");
        System.out.println(
            "Press 2 to Upgrade Quantity of a product.");
        System.out.println("Press 3 to Search a product.");
        System.out.println("Press 4 to Show All products.");
        System.out.println("Press 5 to Register Student.");
        System.out.println(
            "Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out product. ");
        System.out.println("Press 8 to Check In product");
        System.out.println(
            "-------------------------------------------------------------------------------------------------------");
    }
 
    // Method 8
    // To search the library
    public int isAvailable(int sNo)
    {
 
        for (int i = 0; i < count; i++) {
            if (sNo == theProducts[i].sNo) {
                if (theProducts[i].productQtyCopy > 0) {
 
                    System.out.println(
                        "product is Available.");
                    return i;
                }
                System.out.println("product is Unavailable");
                return -1;
            }
        }
 
        System.out.println("No product of Serial Number "
                           + " Available in Library.");
        return -1;
    }
 
    // Method 9
    // To remove the product from the library
    public Product checkOutProduct()
    {
 
        System.out.println(
            "Enter Serial No of product to be Checked Out.");
        int sNo = input.nextInt();
 
        int productIndex = isAvailable(sNo);
 
        if (productIndex != -1) {
            theProducts[productIndex].productQtyCopy--;
            return theProducts[productIndex];
        }
        return null;
    }
 
    // Method 10
    // To add theproduct to the Library
    public void checkInProduct(Product b)
    {
        for (int i = 0; i < count; i++) {
            if (b.equals(theProducts[i])) {
                theProducts[i].productQtyCopy++;
                return;
            }
        }
    }
}
