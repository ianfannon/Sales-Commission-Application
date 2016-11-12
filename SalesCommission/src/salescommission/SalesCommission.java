/*
 * Author: Ian Fannon
 * Course: PRG/420
 * Due Date: November 14, 2016
 * Instructor: Henry Williams
 * Program: Sales Program to calculate the sales commission input on annual sales
 * than output the total annual earnings and display a table of the total sales 
 * amount and total earnings from that amount of up to 50% above the initial 
 * annual sales.
 */
package salescommission;

/**
 *
 * @author Ian James Fannon
 */
public class SalesCommission {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Earnings earn = new Earnings();
        earn.getSalesInput();
        earn.computeSales(earn.getTotalSales());
        earn.displayEarnings(earn.getTotalEarnings());
        earn.displayTable(earn.getTotalSales(), earn.getTotalEarnings());
    }
    
}
