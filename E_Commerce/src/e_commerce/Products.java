
package e_commerce;

import java.util.Scanner;

public class Products {
    // Class data members
    Product theProducts[] = new Product[50];
    int count = 0;

    Scanner input = new Scanner(System.in);

    public void addProduct() {
        theProducts[count] = new Product();
        count++;
    }

    public void showAllProducts() {
        System.out.println("-------------------------------");
        System.out.println("Name\t\tBrand\t\tPrice\t\tQuantity");
        for (int i = 0; i < count; i++) {
            System.out.println(theProducts[i].productName + "\t\t"
                    + theProducts[i].brand + "\t\t" + theProducts[i].price + "\t\t"
                    + theProducts[i].quantityCopy);
        }
        System.out.println("-------------------------------");
    }

    public Product getProductBySerialNo(int serialNo) {
        for (int i = 0; i < count; i++) {
            // Assuming serialNo is now represented by the index i
            if (i == serialNo) {
                return theProducts[i];
            }
        }
        return null;
    }}
