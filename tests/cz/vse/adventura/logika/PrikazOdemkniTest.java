package cz.vse.adventura.logika;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PrikazOdemkniTest.
 */
public class PrikazOdemkniTest {
    private PrikazOdemkni prikazOdemkni;
    private HerniPlan herniPlan;

    /**
     * Default constructor for test class PrikazOdemkniTest
     */
    public PrikazOdemkniTest() {
    }

    /**
     * Sets up the test fixture.
     * <p>
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        herniPlan = new HerniPlan();
        prikazOdemkni = new PrikazOdemkni(herniPlan);
    }

    /**
     * Tears down the test fixture.
     * <p>
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }

    /**
     * Test method for {@link cz.vse.adventura.logika.PrikazOdemkni#provedPrikaz(java.lang.String[])}.
     */
    @Test
    public void testProvedPrikaz() {
        Prostor prostor1 = new Prostor("obyvák","obyvák s gaučem, konferenčním stolkem a TV", false); //livingRoom
        Prostor prostor2 = new Prostor("předsíň","předsíň, ve které se nacházejí kufr, klíče od bytu", false); //hall
        prostor2.zamknout(); // Locking the second room
        prostor1.setVychod(prostor2); // Connecting the first room to the second room
        herniPlan.setAktualniProstor(prostor1); // Setting the current room to the first room
        herniPlan.getBatoh().seberVec(new Vec("klíče", true)); // Adding the "klíče" (keys) to the inventory

        String[] parametry = {"prostor2"};
        String result = prikazOdemkni.provedPrikaz(parametry);
        String expected = "Odsud nevedou dveře do prostoru prostor2!";
        assertEquals(expected, result);

        parametry[0] = "prostor2";
        result = prikazOdemkni.provedPrikaz(parametry);
        expected = "Odsud nevedou dveře do prostoru prostor2!";
        assertEquals(expected, result);

        parametry[0] = "prostor3";
        result = prikazOdemkni.provedPrikaz(parametry);
        expected = "Odsud nevedou dveře do prostoru prostor3!";
        assertEquals(expected, result);

        parametry[0] = "";
        result = prikazOdemkni.provedPrikaz(parametry);
        expected = "Odsud nevedou dveře do prostoru !";
        assertEquals(expected, result);

        herniPlan.getBatoh().odeberVec(new Vec("klíče", true)); // Removing the "klíče" (keys) from the inventory
        parametry[0] = "prostor2";
        result = prikazOdemkni.provedPrikaz(parametry);
        expected = "Odsud nevedou dveře do prostoru prostor2!";
        assertEquals(expected, result);
    }

}

