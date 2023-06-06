package se.kth.iv1350.POS.startup;

import se.kth.iv1350.POS.Composition.DateByComposition;
import se.kth.iv1350.POS.Inheritance.DateByInheritance;

public class Main {

    public static void main(String[] args) {
        DateByInheritance dateByInheritance = new DateByInheritance();
        DateByComposition dateByComposition = new DateByComposition();


        System.out.println("The current date is " + dateByInheritance + "\n");
        System.out.println("*********************************************************************************");
        System.out.println("                                Inheritance                                      ");
        System.out.println("*********************************************************************************" + "\n");
        System.out.println("The current date and time is compared to day " + 18 + " of this month "
                + "and the time " + 23 + ":" + 20 + ":" + 43);
        System.out.println(dateByInheritance.dateDifference(18, 16, 10, 37));

        System.out.println("*********************************************************************************");
        System.out.println("                                Composition                                      ");
        System.out.println("*********************************************************************************" + "\n");
        System.out.println("The current date and time is compared to day " + 18 + " of this month "
                + "and the time " + 23 + ":" + 20 + ":" + 43);
        System.out.print(dateByComposition.dateDifference(18, 16, 10, 37));

    }

}