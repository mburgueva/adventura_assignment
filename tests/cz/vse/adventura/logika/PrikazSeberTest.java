package cz.vse.adventura.logika;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PrikazSeberTest.
 */
public class PrikazSeberTest
{
    private PrikazSeber prikazSeber;
    private HerniPlan herniPlan;

    /**
     * Default constructor for test class PrikazSeberTest
     */
    public PrikazSeberTest()
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
        prikazSeber = new PrikazSeber(herniPlan);
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
     * Test method for {@link cz.vse.adventura.logika.PrikazSeber#provedPrikaz(java.lang.String[])}.
     */
    @Test
    public void testProvedPrikaz()
    {
        Prostor aktualniProstor = new Prostor("obyvák","obyvák s gaučem, konferenčním stolkem a TV", false); //livingRoom
        herniPlan.setAktualniProstor(aktualniProstor);
        Vec vec1 = new Vec("vec1", true);
        Vec vec2 = new Vec("vec2", true);
        Vec vec3 = new Vec("vec3", false);
        Vec vec4 = new Vec("vec4", false);
        aktualniProstor.poloz(vec1);
        aktualniProstor.poloz(vec2);
        aktualniProstor.poloz(vec3);
        aktualniProstor.poloz(vec4);

        String[] parametry = { "vec1" };
        String result = prikazSeber.provedPrikaz(parametry);
        String expected = "Věc 'vec1' je nyní u tebe.\nvec1, ";
        assertEquals(expected, result);
        assertEquals(true, herniPlan.getBatoh().obsahujeVec("vec1"));
        assertEquals(false, aktualniProstor.obsahujeVec("vec1"));

        parametry[0] = "vec2";
        result = prikazSeber.provedPrikaz(parametry);
        expected = "Věc 'vec2' je nyní u tebe.\nvec2, vec1, ";
        assertEquals(expected, result);
        assertEquals(true, herniPlan.getBatoh().obsahujeVec("vec2"));
        assertEquals(false, aktualniProstor.obsahujeVec("vec2"));

        parametry[0] = "vec3";
        result = prikazSeber.provedPrikaz(parametry);
        expected = "Item can't be picked up";
        assertEquals(expected, result);
        assertEquals(false, herniPlan.getBatoh().obsahujeVec("vec3"));
        assertEquals(true, aktualniProstor.obsahujeVec("vec3"));

        parametry[0] = "vec4";
        result = prikazSeber.provedPrikaz(parametry);
        expected = "Item can't be picked up";
        assertEquals(expected, result);
        assertEquals(false, herniPlan.getBatoh().obsahujeVec("vec4"));
        assertEquals(true, aktualniProstor.obsahujeVec("vec4"));

        parametry[0] = "neexistujici";
        result = prikazSeber.provedPrikaz(parametry);
        expected = "The item is not in the room";
        assertEquals(expected, result);
    }

    /**
     * Test method for {@link cz.vse.adventura.logika.PrikazSeber#getNazev()}.
     */
    @Test
    public void testGetNazev()
    {
        String nazev = prikazSeber.getNazev();
        assertEquals("seber", nazev);
    }
}
