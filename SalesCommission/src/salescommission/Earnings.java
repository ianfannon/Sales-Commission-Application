/*
 * This class hold all the methods and fields for the program
 */
package salescommission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
/**
 * @author Ian James Fannon
 */
public class Earnings {
    
    private final double salary;
    private double commissionRate;
    private double totalEarnings;
    private double totalSales;
    private final NumberFormat format;    
    /**
     * Constructor to initialize the variables
     */
    public Earnings() {
        this.salary = 85_000.00;
        this.commissionRate = .10;
        this.totalEarnings = 0.0;
        this.totalSales = 0.0;
        this.format = NumberFormat.getCurrencyInstance();
    }
        
    public double getTotalSales() {
        return this.totalSales;
    }
        
    public double getTotalEarnings() {
        return this.totalEarnings;
    }
        
    /**
     * The method getSalesInput gets the total sales amount from the user
     * @return the total sales amount
     */
    public double getSalesInput() {
        boolean retry = false;
        do {
            // The input is surounded with a try-catch incase an error is thrown
            try {
                InputStreamReader iStream = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(iStream);
                System.out.print("Please enter your total sales: ");
                String sales = br.readLine();
                totalSales = Double.parseDouble(sales);
                if (totalSales <= 0.0) {
                    totalSales = 0.0;
                    retry = true;
                } else if (totalSales >= 1000000.00) {
                    System.out.println("Number entered is out of range.");
                    retry = false;
                } else {
                    retry = true;
                }
            } catch (NumberFormatException | IOException ex) {
                System.out.println("Invalid input, enter an integer.  Error: " + ex);
            }
        } while (!retry);
        return totalSales;
    }
    
    /**
     * The method computeSales computes the sales commissionRate
     * @param newTotalSales is the total sales amount to be passed
     * @return the commissionRate on the total sales amount plus the salary 
     */
    public double computeSales(double newTotalSales) {
        if (newTotalSales < 120000) {
            commissionRate = 0.0;
            totalEarnings = commissionRate * newTotalSales + salary;
        } else if (newTotalSales >= 120000 && newTotalSales < 150000) {
            commissionRate = 0.15;
            totalEarnings = commissionRate * newTotalSales + salary;
        } else if (newTotalSales >= 150000 && newTotalSales < 300000) {
            commissionRate = 0.17;
            totalEarnings = commissionRate * newTotalSales + salary;
        } else if (newTotalSales >= 300000 && newTotalSales < 450000) {
            commissionRate = 0.19;
            totalEarnings = commissionRate * newTotalSales + salary;
        } else if (newTotalSales >= 450000 && newTotalSales < 600000) {
            commissionRate = 0.21;
            totalEarnings = commissionRate * newTotalSales + salary;
        } else if (newTotalSales >= 600000 && newTotalSales < 750000)  {
            commissionRate = 0.23;
            totalEarnings = commissionRate * newTotalSales + salary;
        } else if (newTotalSales >= 750000 && newTotalSales < 900000)  {
            commissionRate = 0.25;
            totalEarnings = commissionRate * newTotalSales + salary;
        }
        return totalEarnings;
    }
    
    /**
     * The method displayEarnings displays the salary plus the sales commissionRate
     * @param newTotalEarnings is the total annual amount
     */
    public void displayEarnings(double newTotalEarnings) {
        
        System.out.println("\n\nTotal Annual Earnings");
        System.out.println("---------------------");
        System.out.println("     " + format.format(Math.ceil(newTotalEarnings)) + "\n");
    }
    
    /**
     * The method displayTable displays a table of potential earnings from total sales.
     * @param newTotalSales is the total sales amount being passed by value.
     * @param newTotalEarnings  is the total earnings being passed by value.
     */    
    public void displayTable(double newTotalSales, double newTotalEarnings) {
        double Sales = newTotalSales + (newTotalSales / 2);
        System.out.println("Total Sales\tTotal Compensation");
        System.out.println("-----------\t------------------");
        for (double i = newTotalSales; i <= Sales; i+= 20000) {
            if (i < 120000) {
                commissionRate = 0.0;
                newTotalEarnings = commissionRate * i + salary;
            } else if (i >= 120000 && i < 150000) {
                commissionRate = 0.15;
                newTotalEarnings = commissionRate * i + salary;
            } else if (i >= 150000 && i < 300000) {
                commissionRate = 0.17;
                newTotalEarnings = commissionRate * i + salary;
            } else if (i >= 300000 && i < 450000) {
                commissionRate = 0.19;
                newTotalEarnings = commissionRate * i + salary;
            } else if (i >= 450000 && i < 600000) {
                commissionRate = 0.21;
                newTotalEarnings = commissionRate * i + salary;
            } else if (i >= 600000 && i < 750000)  {
                commissionRate = 0.23;
                newTotalEarnings = commissionRate * i + salary;
            } else if (i >= 750000 && i < 900000)  {
                commissionRate = 0.25;
                newTotalEarnings = commissionRate * i + salary;
            }
            double Earnings = commissionRate * i + newTotalSales;
            for (double j = newTotalEarnings; j < Earnings; j+= salary + Earnings + 20000) {
                System.out.println(format.format(i) + "\t" + format.format(j));
            }
            System.out.println();
        }
    }
}