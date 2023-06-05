package cz.vse.adventura.logika;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PrikazVypisTest.
 */
public class PrikazVypisTest
{
    private PrikazVypis prikazVypis;
    private HerniPlan herniPlan;

    /**
     * Default constructor for test class PrikazVypisTest
     */
    public PrikazVypisTest()
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
        prikazVypis = new PrikazVypis(herniPlan);
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
     * Test method for {@link cz.vse.adventura.logika.PrikazVypis#provedPrikaz(java.lang.String[])}.
     */
    @Test
    public void testProvedPrikaz()
    {
        Prostor prostor1 = new Prostor("ložnice", "ložnice s posteli a psacím stolem", false); //bedroom
        Prostor prostor2 = new Prostor("obyvák","obyvák s gaučem, konferenčním stolkem a TV", false); //livingRoom
        Prostor prostor3 = new Prostor("předsíň","předsíň, ve které se nacházejí kufr, klíče od bytu", false); //hall
        prostor1.setVychod(prostor2);
        prostor1.setVychod(prostor3);
        herniPlan.setAktualniProstor(prostor1);

        Vec vec1 = new Vec("vec1", true);
        Vec vec2 = new Vec("vec2", true);
        Vec vec3 = new Vec("vec3", false);
        Vec vec4 = new Vec("vec4", false);
        prostor1.poloz(vec1);
        prostor1.poloz(vec2);
        prostor2.poloz(vec3);
        herniPlan.getBatoh().seberVec(vec4);

        String result = prikazVypis.provedPrikaz();
        String expected = "Nacházíš se v prostoru ložnice\nložnice s posteli a psacím stolem\n\n" +
                "Východy: předsíň obyvák \n" +
                "Věci v prostoru: vec1 vec2 \n" +
                "Věci v batohu: vec4 \n";
        assertEquals(expected, result);
    }

    /**
     * Test method for {@link cz.vse.adventura.logika.PrikazVypis#getNazev()}.
     */
    @Test
    public void testGetNazev()
    {
        String nazev = prikazVypis.getNazev();
        assertEquals("vypiš", nazev);
    }
}
