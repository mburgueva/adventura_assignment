package cz.vse.adventura.logika;

/**
 *  Třída PrikazPoloz implementuje pro hru příkaz poloz.
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Madina Burgueva
 *@version    pro školní rok 2022/2023
 */
public class PrikazPoloz implements IPrikaz {
    private static final String NAZEV = "polož";
    private HerniPlan plan;

    /**
     * Konstruktor třídy
     */
    public PrikazPoloz(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        return null;
    }

    /**
     * Provádí příkaz "polož". Zkouší odebrat věci z batohu a položit je někam.
     */
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (název věci), tak ....
            return "Co mám položit? Musíš napsat název věci, kterou mám položit.";
        }

        String nazev = parametry[0];

        try {
            Vec vec = plan.getBatoh().odeberVec(nazev);
            plan.getAktualniProstor().seberVec(vec); //insertThing
            return "Věc '" + nazev + "' byla položena v aktuálním prostoru.";
        } catch (IllegalArgumentException exception) {
            return "Tuto věc v batohu nemáš.";
        }
    }

    /**
     * Metoda vrací název příkazu (slovo, které používá hráč pro jeho vyvolání)
     *
     * @return nazev prikazu
     */
    public String getNazev() {
        return NAZEV;
    }
}
