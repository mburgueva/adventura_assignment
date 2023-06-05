package cz.vse.adventura.logika;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HraTest.
 */
public class HraTest
{
    private Hra hra;

    /**
     * Default constructor for test class HraTest
     */
    public HraTest()
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
     * Test method for {@link cz.vse.adventura.logika.Hra#vratUvitani()}.
     */
    @Test
    public void testVratUvitani()
    {
        String uvitani = hra.vratUvitani();
        assertNotNull(uvitani);
        assertFalse(uvitani.isEmpty());
    }

    /**
     * Test method for {@link cz.vse.adventura.logika.Hra#vratEpilog()}.
     */
    @Test
    public void testVratEpilog()
    {
        String epilog = hra.vratEpilog();
        assertNotNull(epilog);
        assertFalse(epilog.isEmpty());
    }

    /**
     * Test method for {@link cz.vse.adventura.logika.Hra#zpracujPrikaz(java.lang.String)}.
     */
    @Test
    public void testZpracujPrikaz()
    {
        String vysledek1 = hra.zpracujPrikaz("napoveda");
        assertNotNull(vysledek1);
        assertFalse(vysledek1.isEmpty());

        String vysledek2 = hra.zpracujPrikaz("jdi neexistujici_mistnost");
        assertNotNull(vysledek2);
        assertFalse(vysledek2.isEmpty());

        String vysledek3 = hra.zpracujPrikaz("konec");
        assertNotNull(vysledek3);
        assertFalse(vysledek3.isEmpty());
        assertTrue(hra.konecHry());
    }

    /**
     * Test method for {@link cz.vse.adventura.logika.Hra#getHerniPlan()}.
     */
    @Test
    public void testGetHerniPlan()
    {
        HerniPlan herniPlan = hra.getHerniPlan();
        assertNotNull(herniPlan);
    }
}
