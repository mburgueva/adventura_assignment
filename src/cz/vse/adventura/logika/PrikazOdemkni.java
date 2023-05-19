package cz.vse.adventura.logika;

/**
 *  Třída PrikazOdemkni implementuje pro hru příkaz odemkni.
 *
 */
public class PrikazOdemkni implements IPrikaz {
    private static final String NAZEV = "odemkni"; //unlock
    private HerniPlan plan;

    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, je potřeba zjistit, zda jsem v prostoru
     *                    vedle prostoru, který se má odemknout
     */
    public PrikazOdemkni(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  Provádí příkaz "odemkni". Zjišťuje, zda z aktuálního prostoru vede
     *  východ do zadaného prostoru. Pokud prostor existuje a je zamčený,
     *  tak se zjistí, zda v batohu je potřebný klíč. Pokud ano, odemkne
     *  se prostor.
     *
     * @param parametry - jako parametr obsahuje jméno prostoru,
     *                         do kterého se má jít
     * @return zpráva, kterou vypíše hra hráči
     */
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Co mám odemknout? Musíš zadat jméno prostoru";
        }

        String prostor = parametry[0];
        // hledá zadaný prostor mezi východy
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(prostor);

        if (sousedniProstor == null) {
            return "Odsud nevedou dveře do prostoru " + prostor + "!"; //There's no door into the area from here.
        } else {
            if (sousedniProstor.jeZamceno()) { //isLocked
                if (plan.getBatoh().obsahujeVec(sousedniProstor.getKlic())) { //getTheKey
                    sousedniProstor.zamknout(false); //lock
                    return "Podařilo se ti otevřít dveře do prostoru " // You managed to open the door to the space
                            + prostor + ". Nyní je cesta volná."; //Now the way is clear
                } else {
                    return "Pro odemčení dveří do " + prostor + " potřebuješ mít " //To unlock the door you will need the keys
                            + "u sebe klíč.";
                }
            } else {
                return "Místnost " + prostor + " již byla odemčená!"; //The room was unlocked
            }
        }
    }

    @Override
    public String provedPrikaz(String... parametry) {
        return null;
    }

    /**
     *  Metoda vrací název příkazu (slovo, které používá hráč pro jeho vyvolání)
     *
     *  @return název příkazu
     */
    public String getNazev() {
        return NAZEV;
    }
}
