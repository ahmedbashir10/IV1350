package se.kth.iv1350.POS.Tester;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.POS.integration.InventorySystem;
import se.kth.iv1350.POS.integration.ItemDTO;
import se.kth.iv1350.POS.model.Identifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvertorySystemTest {

    private InventorySystem inventorySystem;

    @BeforeEach
    void tearUp(){
        inventorySystem = new InventorySystem();
    }

    @AfterEach
    void tearDown(){
        inventorySystem = null;
    }


    @Test
    void getItemDTOByIdentifierTest() {
        ItemDTO tomatoItemDTO = new ItemDTO("Milk", 4.90, 0.12);
        Identifier identifier = new Identifier("m1020k");
        assertEquals(inventorySystem.getItemDTO(identifier), tomatoItemDTO, "The identifier is not providing item");

    }
}
