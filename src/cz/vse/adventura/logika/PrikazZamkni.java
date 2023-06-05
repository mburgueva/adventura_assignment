package cz.vse.adventura.logika;

/**
 *  Třída PrikazZamkni implementuje pro hru příkaz zamkni.
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Madina Burgueva
 *@version    pro školní rok 2022/2023
 */
public class PrikazZamkni implements IPrikaz {
    private static final String NAZEV = "zamkni"; //lock
    private HerniPlan plan;

    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, je potřeba zjistit, zda jsem v prostoru
     *                    vedle prostoru, který se má zamknout
     */
    public PrikazZamkni(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  Provádí příkaz "zamkni". Zjišťuji, zda z aktuálního prostoru je
     *  východ do zadaného prostoru. Pokud prostor existuje a je nezamčený,
     *  tak se zjistí, zda v batohu je potřebný klíč. Pokud ano, zammknu
     *  prostor.
     *
     *@param parametry - jako  parametr obsahuje jméno prostoru,
     *                         do kterého se má jít.
     *@return zpráva, kterou vypíše hra hráči
     */
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Co mám zamknout? Musíš zadat jméno prostoru";
        }

        String prostor = parametry[0];
        // hledám zadaný prostor mezi východy
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(prostor); //nextSpace

        if (sousedniProstor == null) {
            return "Odsud nevedou dveře do prostoru "+ prostor +" !";
        }
        else {
            if (!sousedniProstor.getJeZamceno()) { //isn't locked
                if (plan.getBatoh().obsahujeVec("klic")) { //getTheKey
                    sousedniProstor.odemknout(); //unlock
                    return "Podařilo se ti zavřit dveře do prostoru  "
                            + prostor + ". Nyní cesta není volná.";
                }
                else {
                    return "Pro zamčení dveří do "+ prostor +" potřebuješ mít "
                            + "u sebe klic"; //getTheKey
                }
            }
            else {
                return "Místnost "+ prostor +" již byla zamčená!!!";
            }
        }
    }

    @Override
    public String provedPrikaz(String... parametry) {
        return null;
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *
     *  @ return nazev prikazu
     */
    public String getNazev() {
        return NAZEV;
    }

}