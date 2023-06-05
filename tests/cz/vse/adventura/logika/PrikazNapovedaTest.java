package cz.vse.adventura.logika;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PrikazNapovedaTest.
 */
public class PrikazNapovedaTest
{
    private PrikazNapoveda prikazNapoveda;
    private SeznamPrikazu platnePrikazy;

    /**
     * Default constructor for test class PrikazNapovedaTest
     */
    public PrikazNapovedaTest()
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
        platnePrikazy = new SeznamPrikazu();
        prikazNapoveda = new PrikazNapoveda(platnePrikazy);
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
     * Test method for {@link cz.vse.adventura.logika.PrikazNapoveda#provedPrikaz(java.lang.String[])}.
     */
    @Test
    public void testProvedPrikaz()
    {
        platnePrikazy.vlozPrikaz(prikazNapoveda);

        String result = prikazNapoveda.provedPrikaz();
        String expected = "Tvým úkolem je dorazit na letiště Václava Havla v Praze.\n\nMůžeš zadat tyto příkazy:\nnápověda ";
        assertEquals(expected, result);
    }

    /**
     * Test method for {@link cz.vse.adventura.logika.PrikazNapoveda#getNazev()}.
     */
    @Test
    public void testGetNazev()
    {
        String nazev = prikazNapoveda.getNazev();
        assertEquals("nápověda", nazev);
    }
}
