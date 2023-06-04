package se.kth.iv1350.POS.Tester;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.POS.model.Identifier;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IdentifierTest {
    private Identifier identifier;

    @BeforeEach
    void setUp(){
        identifier = new Identifier("abc");
    }

    @AfterEach
    void tearDown(){
        identifier = null;
    }


    /**
     * Tests if an instance of identifier is equal to null
     */
    @Test
    void testIdentifierIsNotEqualToNull() {
        assertFalse(identifier.equals(null), "The identifier is equal to Null");
    }

    /**
     * Tests if an instance of identifier is equal to itself
     */
    @Test
    void testIdentifierIsEqualToItself() {
        assertTrue(identifier.equals(identifier), "The identifier is not equal to itself");
    }

    /**
     * Tests if an instance of identifier is equal to an object of another type
     */
    @Test
    void testIdentifierIsNotEqualToOtherType() {
        assertFalse(identifier.equals(new Object()), "The identifier is equal to an object of antoher type");
    }

    /**
     * Tests if an instance of identifier is equal to other identifier object
     */
    @Test
    void testIdentifierIsNotEqualToOtherHolder() {
        assertFalse(identifier.equals(new Identifier("def")),
                "The identifier was equal to another identifier that has another barcode");
    }




}
