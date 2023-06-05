package cz.vse.adventura.logika;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

public class HerniPlanTest {


    @Test
    public void testGetAktualniProstor() {
        HerniPlan herniPlan = new HerniPlan();
        Prostor aktualniProstor = herniPlan.getAktualniProstor();
        assertNotNull(aktualniProstor);
    }

    @Test
    public void testSetAktualniProstor() {
        HerniPlan herniPlan = new HerniPlan();
        Prostor prostor = new Prostor("novy_prostor", "Popis noveho prostoru", false);
        herniPlan.setAktualniProstor(prostor);
        assertEquals(prostor, herniPlan.getAktualniProstor());
    }

    @Test
    public void testGetViteznyProstor() {
        HerniPlan herniPlan = new HerniPlan();
        Prostor viteznyProstor = herniPlan.getViteznyProstor();
        assertNotNull(viteznyProstor);
    }

    @Test
    public void testGetProhravaciProstor1() {
        HerniPlan herniPlan = new HerniPlan();
        Prostor prohravaciProstor1 = herniPlan.getProhravaciProstor1();
        assertNotNull(prohravaciProstor1);
    }

    @Test
    public void testGetProhravaciProstor2() {
        HerniPlan herniPlan = new HerniPlan();
        Prostor prohravaciProstor2 = herniPlan.getProhravaciProstor2();
        assertNotNull(prohravaciProstor2);
    }

    @Test
    public void testGetBatoh() {
        HerniPlan herniPlan = new HerniPlan();
        Batoh batoh = herniPlan.getBatoh();
        assertNotNull(batoh);
    }

    @Test
    public void testSeberVec() {
        HerniPlan herniPlan = new HerniPlan();
        Prostor aktualniProstor = herniPlan.getAktualniProstor();
        Batoh batoh = herniPlan.getBatoh();

        Vec vec1 = new Vec("vec1", true);
        Vec vec2 = new Vec("vec2", false);
        aktualniProstor.poloz(vec1);
        aktualniProstor.poloz(vec2);

        herniPlan.seberVec("vec1");
        assertFalse(aktualniProstor.obsahujeVec("vec1"));
        assertTrue(batoh.obsahujeVec("vec1"));

        try {
            herniPlan.seberVec("vec2");
            fail("Should throw an IllegalStateException");
        } catch (IllegalStateException e) {
            // Expected exception thrown, test passed
        }
    }
}
