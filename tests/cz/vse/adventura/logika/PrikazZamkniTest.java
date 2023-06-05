package cz.vse.adventura.logika;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PrikazZamkniTest.
 */
public class PrikazZamkniTest
{
    private PrikazZamkni prikazZamkni;
    private HerniPlan herniPlan;

    /**
     * Default constructor for test class PrikazZamkniTest
     */
    public PrikazZamkniTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        herniPlan = new HerniPlan();
        prikazZamkni = new PrikazZamkni(herniPlan);

        Prostor prostor1 = new Prostor("ložnice", "ložnice s posteli a psacím stolem", false); //bedroom
        Prostor prostor2 = new Prostor("obyvák","obyvák s gaučem, konferenčním stolkem a TV", false); //livingRoom
        prostor1.setVychod(prostor2);
        herniPlan.setAktualniProstor(prostor1);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test method for {@link cz.vse.adventura.logika.PrikazZamkni#proved(java.lang.String[])}.
     */
    @Test
    public void testProved()
    {
        Vec klic = new Vec("klic", true);
        herniPlan.getBatoh().seberVec(klic);

        String result1 = prikazZamkni.proved("prostor2");
        assertEquals("Odsud nevedou dveře do prostoru prostor2 !", result1);

        String result2 = prikazZamkni.proved("prostor2");
        assertEquals("Odsud nevedou dveře do prostoru prostor2 !", result2);

        String result3 = prikazZamkni.proved("prostor3");
        assertEquals("Odsud nevedou dveře do prostoru prostor3 !", result3);

        String result4 = prikazZamkni.proved();
        assertEquals("Co mám zamknout? Musíš zadat jméno prostoru", result4);

        herniPlan.getBatoh().odeberVec(klic);
        String result5 = prikazZamkni.proved("prostor2");
        assertEquals("Odsud nevedou dveře do prostoru prostor2 !", result5);
    }


    @Test
    public void testGetNazev()
    {
        String nazev = prikazZamkni.getNazev();
        assertEquals("zamkni", nazev);
    }
}
