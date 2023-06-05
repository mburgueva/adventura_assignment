package cz.vse.adventura.logika;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SeznamPrikazuTest.
 *
 * This test class is responsible for testing the SeznamPrikazu class.
 * It includes various test cases to ensure the correctness of the implementation.
 *
 * @author Your Name
 * @version 1.0
 */
public class SeznamPrikazuTest {
    private SeznamPrikazu seznamPrikazu;
    private IPrikaz prikaz1;
    private IPrikaz prikaz2;
    private HerniPlan herniPlan;

    /**
     * Default constructor for test class SeznamPrikazuTest
     */
    public SeznamPrikazuTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        seznamPrikazu = new SeznamPrikazu();
        herniPlan = new HerniPlan(); //gamePlan
        prikaz1 = new PrikazVypis(herniPlan);
        prikaz2 = new PrikazOdemkni(herniPlan);
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
     * Test the vlozPrikaz method.
     * It checks whether the vlozPrikaz method correctly adds a command to the command list.
     */
    @Test
    public void testVlozPrikaz() {
        seznamPrikazu.vlozPrikaz(prikaz1);
        seznamPrikazu.vlozPrikaz(prikaz2);
        assertTrue(seznamPrikazu.jePlatnyPrikaz("vypiš"));
        assertTrue(seznamPrikazu.jePlatnyPrikaz("odemkni"));
    }

    /**
     * Test the vratPrikaz method.
     * It checks whether the vratPrikaz method returns the correct instance of the command class.
     */
    @Test
    public void testVratPrikaz() {
        seznamPrikazu.vlozPrikaz(prikaz1);
        seznamPrikazu.vlozPrikaz(prikaz2);
        assertEquals(prikaz1, seznamPrikazu.vratPrikaz("vypiš"));
        assertEquals(prikaz2, seznamPrikazu.vratPrikaz("odemkni"));
    }

    /**
     * Test the jePlatnyPrikaz method.
     * It checks whether the jePlatnyPrikaz method correctly identifies if a command is valid or not.
     */
    @Test
    public void testJePlatnyPrikaz() {
        seznamPrikazu.vlozPrikaz(prikaz1);
        seznamPrikazu.vlozPrikaz(prikaz2);
        assertTrue(seznamPrikazu.jePlatnyPrikaz("vypiš"));
        assertTrue(seznamPrikazu.jePlatnyPrikaz("odemkni"));
        assertFalse(seznamPrikazu.jePlatnyPrikaz("prikaz3"));
    }

    /**
     * Test the vratNazvyPrikazu method.
     * It checks whether the vratNazvyPrikazu method returns the correct string of command names.
     */
    @Test
    public void testVratNazvyPrikazu() {
        seznamPrikazu.vlozPrikaz(prikaz1);
        seznamPrikazu.vlozPrikaz(prikaz2);
        String expected = "vypiš odemkni ";
        assertEquals(expected, seznamPrikazu.vratNazvyPrikazu());
    }
}
