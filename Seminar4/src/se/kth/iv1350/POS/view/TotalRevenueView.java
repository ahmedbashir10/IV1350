package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.model.PaymentObserver;

public class TotalRevenueView implements PaymentObserver {
    private double totalPayment;
    @Override
    public void newPayment(double payment) {
        totalPayment += payment;
        System.out.println("The total revenue from totalRevenueView is now: " + totalPayment + " \n");
    }
}
