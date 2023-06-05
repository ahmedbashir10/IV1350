package se.kth.iv1350.POS.Inheritance;

import se.kth.iv1350.POS.Exception.InvalidNumberException;

import java.util.Date;


/**
 * Contains calculations that makes comparison between different days and times
 * more flexible
 */
public class DateByInheritance extends Date {

    /**
     * Returns the difference between a given day and time and the current day and time.
     * @param day The given day
     * @param hour The given hour
     * @param minute The given minute
     * @param second The given second
     * @return A stringBuilder that contains the difference in days and time.
     */
    public StringBuilder dateDifference(int day, int hour, int minute, int second) {
        StringBuilder builder = new StringBuilder();
        try {
            builder.append("Difference in days is " + dateDifference(day) + "\n");
            builder.append("Difference in time is " + hoursDifference(hour) + " hour, "
                    + minutesDifference(minute)+ " minutes and " + secondsDifference(second) + " seconds" + "\n");
        }catch(InvalidNumberException exc) {
            System.out.println(exc.getMessage());
        }

        return builder;
    }

    /**
     * Compares a given hour and the current hour
     * @param hourToCompare The given hour
     * @return The difference between the current hour and the given hour
     * @throws InvalidNumberException Is thrown when a the given hour is negative or more than 23
     */
    private int hoursDifference(int hourToCompare) throws InvalidNumberException {

        if (0 > hourToCompare || hourToCompare > 23) {
            throw new InvalidNumberException(hourToCompare);
        }
        return Math.abs(super.getHours() - hourToCompare);

    }

    /**
     * Compares a given minute and the current minute
     * @param minuteToCompare The given minute
     * @return The difference between the current minute and the given minute
     * @throws InvalidNumberException Is thrown when a the given minute is negative or more than 59
     */
    private int minutesDifference(int minuteToCompare) throws InvalidNumberException {

        if (0 > minuteToCompare || minuteToCompare > 59) {
            throw new InvalidNumberException(minuteToCompare);
        }
        return Math.abs(super.getMinutes() - minuteToCompare);

    }

    /**
     * Compares a given second and the current second
     * @param secondToCompare The given second
     * @return The difference between the current second and the given second
     * @throws InvalidNumberException Is thrown when a the given second is negative or more than 59
     */
    private int secondsDifference(int secondToCompare) throws InvalidNumberException {

        if (0 > secondToCompare || secondToCompare > 59) {
            throw new InvalidNumberException(secondToCompare);
        }
        return Math.abs(super.getSeconds() - secondToCompare);

    }

    /**
     * Compares a given day and the current day of the month, it has to be the same month
     * @param dateToCompare The given day
     * @return The difference between the current day and the given day
     * @throws InvalidNumberException Is thrown when a the given day is negative or more than 31
     */
    private int dateDifference(int dateToCompare) throws InvalidNumberException {

        if (0 > dateToCompare || dateToCompare > 31) {
            throw new InvalidNumberException(dateToCompare);
        }
        return Math.abs(super.getDate() - dateToCompare);

    }



}