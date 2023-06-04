package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.model.PaymentObserver;
import se.kth.iv1350.POS.model.Printer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Prints the total revenue to a file. The log file is called TotalRevenueFileOutput.txt in the current directory
 */
public class TotalRevenueFileOutput implements PaymentObserver {
    private double totalPayment;

    @Override
    public void newPayment(double payment) {
        totalPayment += payment;
        try{
            FileWriter outputText = new FileWriter("TotalRevenueFileOutput.txt");
            BufferedWriter fileWriter = new BufferedWriter(outputText);
            fileWriter.write("The total revenue is now: " + totalPayment);
            fileWriter.close();
        }catch (IOException ioe){
            System.out.println("CAN NOT LOG.");
            ioe.printStackTrace();
        }
    }
}
