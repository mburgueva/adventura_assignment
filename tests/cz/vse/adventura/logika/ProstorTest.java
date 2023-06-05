package cz.vse.adventura.logika;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*******************************************************************************
 * Testovací třída ProstorTest slouží ke komplexnímu otestování
 * třídy Prostor
 *
 * @author    Jarmila Pavlíčková
 * @version   pro skolní rok 2016/2017
 */
public class ProstorTest
{
    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /**
     * Testuje, zda jsou správně nastaveny průchody mezi prostory hry. Prostory
     * nemusí odpovídat vlastní hře, 
     */
    @Test
    public  void testLzeProjit() {
        Prostor obyvak = new Prostor("obyvák","obyvák s gaučem, konferenčním stolkem a TV", false); //livingRoom
        Prostor predsin = new Prostor("předsíň","předsíň, ve které se nacházejí kufr, klíče od bytu", false); //hall
        obyvak.setVychod(predsin);
        predsin.setVychod(obyvak);
        assertEquals(predsin, obyvak.vratSousedniProstor("předsíň"));
        assertEquals(obyvak, predsin.vratSousedniProstor("obyvák"));
    }

}
