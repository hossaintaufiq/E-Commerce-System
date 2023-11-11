
package e_commerce_system_.updated;

// Import statements remain unchanged
import java.util.Scanner;

public class e_commerce_system_.updated {

   public static void main(String[] args)
    {
        // Creating object of Scanner class
        // to take input from user
        Scanner input = new Scanner(System.in);
 
        // Displaying menu
        System.out.println(
            "********************Welcome to the Online Shop!********************");
        System.out.println(
            "                  Select From The Following Options:               ");
        System.out.println(
            "**********************************************************************");
 
        // Creating object of book class
        Products ob = new Products();
        // Creating object of students class
        Customers obStudent = new Customers();
 
        int choice;
        int searchChoice;
 
        // Creating menu
        // using do-while loop
        do {
 
            ob.dispMenu();
            choice = input.nextInt();
 
            // Switch case
            switch (choice) {
 
                // Case
            case 1:
               Product b = new Product();
                ob.addproduct(b);
                break;
 
                // Case
            case 2:
                ob.upgradeProductQty();
                break;
 
            // Case
            case 3:
 
                System.out.println(
                    " press 1 to Search with product Serial No.");
                System.out.println(
                    " Press 2 to Search with product's Author Name.");
                searchChoice = input.nextInt();
 
                // Nested switch
                switch (searchChoice) {
 
                    // Case
                case 1:
                    ob.searchBySno();
                    break;
 
                    // Case
                case 2:
                    ob.searchByAuthorName();
                }
                break;
 
                // Case
            case 4:
                ob.showAllProducts();
                break;
 
                // Case
            case 5:
                Customer s = new Customer();
                obStudent.addStudent(s);
                break;
 
                // Case
            case 6:
                obStudent.showAllCustomers();
                break;
 
                // Case
            case 7:
                obStudent.checkOutProduct(ob);
                break;
 
                // Case
            case 8:
                obStudent.checkInProduct(ob);
                break;
 
                // Default case that will execute for sure
                // if above cases does not match
            default:
 
                // Print statement
                System.out.println("ENTER BETWEEN 0 TO 8.");
            }
 
        }
 
        // Checking condition at last where we are
        // checking case entered value is not zero
        while (choice != 0);
    }
}

// new codes ends

