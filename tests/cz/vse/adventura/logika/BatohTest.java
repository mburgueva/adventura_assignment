package cz.vse.adventura.logika;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BatohTest {

    @Test
    public void testSeberVec() {
        Batoh batoh = Batoh.getInstance();
        Vec vec = new Vec("klíče", true); // Create a test item

        // Add the item to the backpack
        batoh.seberVec(vec);

        // Check if the item is in the backpack
        assertTrue(batoh.obsahujeVec("klíče"));
    }

    @Test
    public void testOdeberVec() {
        Batoh batoh = Batoh.getInstance();
        Vec vec = new Vec("klíče", true); // Create a test item

        // Add the item to the backpack
        batoh.seberVec(vec);

        // Remove the item from the backpack
        batoh.odeberVec(vec);

        // Check if the item is no longer in the backpack
        assertFalse(batoh.obsahujeVec("klíče"));
    }

    @Test
    public void testGetObsah() {
        Batoh batoh = Batoh.getInstance();
        Vec vec1 = new Vec("klíče", true); // Create test items
        Vec vec2 = new Vec("nůž", true);

        // Add the items to the backpack
        batoh.seberVec(vec1);
        batoh.seberVec(vec2);
        // Get the contents of the backpack
        List<Vec> obsah = batoh.getObsah();

        // Check if the contents match the items added
        assertTrue(obsah.contains(vec1));
        assertTrue(obsah.contains(vec2));
    }

    @Test
    public void testGetKapacita() {
        Batoh batoh = Batoh.getInstance();

        // Check the capacity of the backpack
        assertEquals(7, batoh.getKapacita());
    }
}
