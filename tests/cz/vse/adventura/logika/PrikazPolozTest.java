package cz.vse.adventura.logika;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PrikazPolozTest.
 */
public class PrikazPolozTest
{
    private PrikazPoloz prikazPoloz;
    private HerniPlan herniPlan;

    /**
     * Default constructor for test class PrikazPolozTest
     */
    public PrikazPolozTest()
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
        prikazPoloz = new PrikazPoloz(herniPlan);
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
     * Test method for {@link cz.vse.adventura.logika.PrikazPoloz#provedPrikaz(java.lang.String[])}.
     */
    @Test
    public void testProvedPrikaz()
    {
        Prostor aktualniProstor = new Prostor("obyvák","obyvák s gaučem, konferenčním stolkem a TV", false); //livingRoom
        herniPlan.setAktualniProstor(aktualniProstor);
        Vec vec1 = new Vec("vec1", true);
        Vec vec2 = new Vec("vec2", true);
        Vec vec3 = new Vec("vec3", true);
        Vec vec4 = new Vec("vec4", false);
        herniPlan.getBatoh().seberVec(vec1);
        herniPlan.getBatoh().seberVec(vec2);
        herniPlan.getBatoh().seberVec(vec3);
        herniPlan.getBatoh().seberVec(vec4);

        String[] parametry = { "vec1" };
        String result = prikazPoloz.provedPrikaz(parametry);
        String expected = "Věc 'vec1' byla položena v aktuálním prostoru.";
        assertEquals(expected, result);
        assertEquals(true, aktualniProstor.obsahujeVec("vec1"));
        assertEquals(false, herniPlan.getBatoh().obsahujeVec("vec1"));

        parametry[0] = "vec2";
        result = prikazPoloz.provedPrikaz(parametry);
        expected = "Věc 'vec2' byla položena v aktuálním prostoru.";
        assertEquals(expected, result);
        assertEquals(true, aktualniProstor.obsahujeVec("vec2"));
        assertEquals(false, herniPlan.getBatoh().obsahujeVec("vec2"));

        parametry[0] = "vec3";
        result = prikazPoloz.provedPrikaz(parametry);
        expected = "Věc 'vec3' byla položena v aktuálním prostoru.";
        assertEquals(expected, result);
        assertEquals(true, aktualniProstor.obsahujeVec("vec3"));
        assertEquals(false, herniPlan.getBatoh().obsahujeVec("vec3"));

        parametry[0] = "vec4";
        result = prikazPoloz.provedPrikaz(parametry);
        expected = "Věc 'vec4' byla položena v aktuálním prostoru.";
        assertEquals(expected, result);
        assertEquals(true, aktualniProstor.obsahujeVec("vec4"));
        assertEquals(false, herniPlan.getBatoh().obsahujeVec("vec4"));

        parametry[0] = "neexistujici";
        result = prikazPoloz.provedPrikaz(parametry);
        expected = "Tuto věc v batohu nemáš.";
        assertEquals(expected, result);
    }

    /**
     * Test method for {@link cz.vse.adventura.logika.PrikazPoloz#getNazev()}.
     */
    @Test
    public void testGetNazev()
    {
        String nazev = prikazPoloz.getNazev();
        assertEquals("polož", nazev);
    }
}
