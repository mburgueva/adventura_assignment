package cz.vse.adventura.logika;


import java.util.Iterator;
import java.util.List;

/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan { //GamePlan
    private List<Vec> seznamVeci; //listOfThings

    // Součást domácího úkolu - Implementace Iteratoru

    /**
     * Vrací iterátor pro seznam předmětů v herním plánu.
     *
     * @return iterátor předmětů v herním plánu
     */
    public Iterator<Vec> getIteratorVeci() {
        return seznamVeci.iterator();
    } //listOfThings
    private Prostor aktualniProstor; //currentSpace
    private Prostor viteznyProstor; //winningSpace
    private Prostor prohravaciProstor; //losingSpace
    private Batoh batoh; //backpack
    
     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() { //GamePlan
        zalozProstoryHry(); //createGameSpaces

    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() { //createGameSpaces
        // vytvářejí se jednotlivé prostory
        Prostor loznice = new Prostor("ložnice", "ložnice s posteli a psacím stolem", false); //bedroom
        Prostor obyvak = new Prostor("obyvák","obyvák s gaučem, konferenčním stolkem a TV", false); //livingRoom
        Prostor predsin = new Prostor("předsíň","předsíň, ve které se nacházejí již sbalené věci", false); //hall
        Prostor ulice = new Prostor("ulice","ulice, na které bydlím", true); //street
        Prostor vecerka = new Prostor("večerka","večerka, kam chodím na nákup", false); //shop
        Prostor autobusovaZastavka = new Prostor("autobusová zastávka", "autobusová zastávka u doma", false); //busStaton
        Prostor bus119 = new Prostor("bus 119", "bus 119, který jede na letiště", false);
        Prostor bus225 = new Prostor("bus 225", "bus 225, který jede do Velké Ohrady", false);
        Prostor spatnaCesta = new Prostor("špatná cesta", "Pozor, špatná cesta, vrať se zpátky", false); //wrongWay
        Prostor terminal1 = new Prostor("terminal 1", "terminal s lety mimo EU", false);
        Prostor terminal2 = new Prostor("terminal 2", "terminal s lety po EU", false);

        // přiřazují se průchody mezi prostory (sousedící prostory)
        loznice.setVychod(obyvak); //Exit
        obyvak.setVychod(loznice);
        obyvak.setVychod(predsin);
        predsin.setVychod(obyvak);
        predsin.setVychod(ulice);
        ulice.setVychod(predsin);
        ulice.setVychod(vecerka);
        vecerka.setVychod(ulice);
        ulice.setVychod(autobusovaZastavka);
        autobusovaZastavka.setVychod(ulice);
        autobusovaZastavka.setVychod(bus119);
        autobusovaZastavka.setVychod(bus225);
        bus225.setVychod(spatnaCesta);
        spatnaCesta.setVychod(bus225);
        bus119.setVychod(autobusovaZastavka);
        bus119.setVychod(terminal1);
        terminal1.setVychod(terminal2); // nelze se vratit zpatky do busu
        terminal2.setVychod(terminal1);

        //věci, které lze vložit do batohu

        aktualniProstor = loznice;  // hra začíná v ložnici // currentSpace = bedroom
    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    } //currentSpace
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }//currentSpace
    public Batoh getBatoh() {
        return this.batoh;
    } //backpack
}
