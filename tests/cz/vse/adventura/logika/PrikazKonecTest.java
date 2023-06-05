package cz.vse.adventura.logika;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PrikazKonecTest.
 */
public class PrikazKonecTest
{
    private PrikazKonec prikazKonec;
    private Hra hra;

    /**
     * Default constructor for test class PrikazKonecTest
     */
    public PrikazKonecTest()
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
        hra = new Hra();
        prikazKonec = new PrikazKonec(hra);
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
     * Test method for {@link cz.vse.adventura.logika.PrikazKonec#provedPrikaz(java.lang.String[])}.
     */
    @Test
    public void testProvedPrikaz()
    {
        String result1 = prikazKonec.provedPrikaz("a");
        assertEquals("Ukončit co? Nechápu, proč jste zadal druhé slovo.", result1);
        assertFalse(hra.konecHry());

        String result2 = prikazKonec.provedPrikaz();
        assertEquals("hra ukončena příkazem konec", result2);
        assertTrue(hra.konecHry());
    }

    /**
     * Test method for {@link cz.vse.adventura.logika.PrikazKonec#getNazev()}.
     */
    @Test
    public void testGetNazev()
    {
        String nazev = prikazKonec.getNazev();
        assertEquals("konec", nazev);
    }
}
