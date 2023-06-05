package cz.vse.adventura.logika;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ProstorTest.
 *
 * This test class is responsible for testing the Prostor class.
 * It includes various test cases to ensure the correctness of the implementation.
 *
 * @author Your Name
 * @version 1.0
 */
public class ProstorTest {
    private Prostor prostor1;
    private Prostor prostor2;
    private Prostor prostor3;
    private Vec vec1;
    private Vec vec2;

    /**
     * Default constructor for test class ProstorTest
     */
    public ProstorTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        prostor1 = new Prostor("hala", "vstupní hala", false);
        prostor2 = new Prostor("chodba", "dlouhá chodba", false);
        prostor3 = new Prostor("bufet", "bufet u vchodu", false);
        vec1 = new Vec("klic", true);
        vec2 = new Vec("penize", false);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }

    /**
     * Test the setVychod method.
     * It checks whether the setVychod method correctly adds an exit to the room.
     */
    @Test
    public void testSetVychod() {
        prostor1.setVychod(prostor2);
        prostor1.setVychod(prostor3);
        assertEquals(2, prostor1.getVychody().size());
    }

    /**
     * Test the vratSousedniProstor method.
     * It checks whether the vratSousedniProstor method returns the correct neighboring room.
     */
    @Test
    public void testVratSousedniProstor() {
        prostor1.setVychod(prostor2);
        prostor1.setVychod(prostor3);
        assertEquals(prostor2, prostor1.vratSousedniProstor("chodba"));
    }

    /**
     * Test the poloz method.
     * It checks whether the poloz method correctly adds an item to the room.
     */
    @Test
    public void testPoloz() {
        prostor1.poloz(vec1);
        prostor1.poloz(vec2);
        assertEquals(2, prostor1.getVeciVProstoru().size());
    }

    /**
     * Test the seberVec method.
     * It checks whether the seberVec method correctly removes an item from the room.
     */
    @Test
    public void testSeberVec() {
        prostor1.poloz(vec1);
        prostor1.poloz(vec2);
        prostor1.seberVec(vec1);
        assertEquals(1, prostor1.getVeciVProstoru().size());
        assertTrue(prostor1.getVeciVProstoru().contains(vec2));
        assertFalse(prostor1.getVeciVProstoru().contains(vec1));
    }

    /**
     * Test the obsahujeVec method.
     * It checks whether the obsahujeVec method correctly identifies if an item is in the room or not.
     */
    @Test
    public void testObsahujeVec() {
        prostor1.poloz(vec1);
        prostor1.poloz(vec2);
        assertTrue(prostor1.obsahujeVec("klic"));
        assertFalse(prostor1.obsahujeVec("telefon"));
    }
}
