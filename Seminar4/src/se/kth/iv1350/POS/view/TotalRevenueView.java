package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.model.PaymentObserver;

public class TotalRevenueView implements PaymentObserver {
    private double tatalPayment;
    @Override
    public void newPayment(double payment) {
        tatalPayment += payment;
        System.out.println("The total revenue from totalRevenueView is now: " + tatalPayment + " \n");
    }
}
