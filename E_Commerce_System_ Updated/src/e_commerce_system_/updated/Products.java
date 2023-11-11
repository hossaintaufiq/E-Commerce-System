
package e_commerce_system_.updated;

import java.util.Scanner;

public class Products {
     // Class data members
   Product theProducts[] = new Product[50];
    int count = 0;

    public void addProduct(Product b) {
        theProducts[count] = b;
        count++;
    }

    public void showAllProducts() {
        System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
        for (int i = 0; i < count; i++) {
            System.out.println(theProducts[i].sNo + "\t\t" + theProducts[i].product + "\t\t"
                    + theProducts[i].authorName + "\t\t" + theProducts[i].productQtyCopy + "\t\t"
                    + theProducts[i].productQty);
        }
    }

    public Product getProductBySerialNo(int serialNo) {
        for (int i = 0; i < count; i++) {
            if (theProducts[i].sNo == serialNo) {
                return theProducts[i];
            }
        }
        return null;
    }
}
