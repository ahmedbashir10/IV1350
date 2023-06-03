package se.kth.iv1350.POS.Tester;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.POS.integration.ItemDTO;
import se.kth.iv1350.POS.model.Identifier;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ItemDTOTest {
    private ItemDTO itemDTOtoTest;

    @BeforeEach
    void tearUp(){
        itemDTOtoTest = new ItemDTO("abc", 1, 2);
    }

    @AfterEach
    void tearDown(){
        itemDTOtoTest = null;
    }

    /**
     * Tests if an instance of itemDTO is equal to null
     */
    @Test
    void testIdentifierIsNotEqualToNull() {
        assertFalse(itemDTOtoTest.equals(null), "The itemDTO is equal to Null");
    }


    /**
     * Tests if an instance of itemDTO is equal to itself
     */
    @Test
    void testIdentifierIsEqualToItself() {
        assertTrue(itemDTOtoTest.equals(itemDTOtoTest), "The itemDTO is not equal to itself");
    }

    /**
     * Tests if an instance of itemDTO is equal to an object of another type
     */
    @Test
    void testIdentifierIsNotEqualToOtherType() {
        assertFalse(itemDTOtoTest.equals(new Object()), "The itemDTO is equal to an object of antoher type");
    }

    /**
     * Tests if an instance of itemDTO is equal to itself
     */
    @Test
    void testIdentifierIsNotEqualToOtherHolder() {
        assertFalse(itemDTOtoTest.equals(new ItemDTO("Burger", 29.90, 0.6)),
                "The ItemDTO was equal to another identifier with other instance variables");
    }
}
