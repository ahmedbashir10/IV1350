package se.kth.iv1350.POS.Tester;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.POS.model.CashRegister;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashRegisterTest {

    private CashRegister cashRegister;

    @BeforeEach
    void setUp() {
        cashRegister = new CashRegister();
    }

    /**
     */
    @AfterEach
    void tearDown() {
       cashRegister = null;
    }

    /**
     * Checks if the method "increaseAmount" increases the amount to the correct
     * number
     */
    @Test
   void increaseAmountATest(){
       cashRegister = new CashRegister();
       cashRegister.increaseAmount(10);
       cashRegister.increaseAmount(40);
       assertEquals(50, cashRegister.getAmount(), "The amount is not changed to the correct number");
   }

    /**
     * Checks if the method "increaseAmount" increases the amount to the correct
     * number
     */
    @Test
    void increaseAmountBTest(){
        cashRegister = new CashRegister();
        cashRegister.increaseAmount(100);
        cashRegister.increaseAmount(200);
        cashRegister.increaseAmount(30);
        assertEquals(330, cashRegister.getAmount(), "The amount is not changed to the correct number");
    }


}
