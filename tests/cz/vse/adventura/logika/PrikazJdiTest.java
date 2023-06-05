package cz.vse.adventura.logika;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PrikazJdiTest.
 */
public class PrikazJdiTest
{
    private PrikazJdi prikazJdi;
    private HerniPlan herniPlan;
    private Hra hra;

    /**
     * Default constructor for test class PrikazJdiTest
     */
    public PrikazJdiTest()
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
        hra = new Hra();
        prikazJdi = new PrikazJdi(herniPlan, hra);
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
     * Test method for {@link cz.vse.adventura.logika.PrikazJdi#provedPrikaz(java.lang.String[])}.
     */
    @Test
    public void testProvedPrikaz()
    {
        String result1 = prikazJdi.provedPrikaz("neexistujici_prostor");
        assertEquals("Tam se odsud jít nedá!", result1);

        Prostor aktualniProstor = new Prostor("obyvák","obyvák s gaučem, konferenčním stolkem a TV", false); //livingRoom
        herniPlan.setAktualniProstor(aktualniProstor);

        Prostor sousedniProstor = new Prostor("předsíň","předsíň, ve které se nacházejí kufr, klíče od bytu", false); //hall
        aktualniProstor.setVychod(sousedniProstor);

        String result2 = prikazJdi.provedPrikaz("sousedni_prostor");
        assertEquals("Tam se odsud jít nedá!", result2);
        assertSame(aktualniProstor, herniPlan.getAktualniProstor());

        sousedniProstor.zamknout();
        String result3 = prikazJdi.provedPrikaz("sousedni_prostor");
        assertEquals("Tam se odsud jít nedá!", result3);
        assertSame(aktualniProstor, herniPlan.getAktualniProstor());
    }

    /**
     * Test method for {@link cz.vse.adventura.logika.PrikazJdi#getNazev()}.
     */
    @Test
    public void testGetNazev()
    {
        String nazev = prikazJdi.getNazev();
        assertEquals("jdi", nazev);
    }
}
