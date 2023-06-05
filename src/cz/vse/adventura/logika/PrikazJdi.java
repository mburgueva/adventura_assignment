package cz.vse.adventura.logika;

/**
 *  Třída PrikazJdi implementuje pro hru příkaz jdi.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Jarmila Pavlickova, Luboš Pavlíček
 *@version    pro školní rok 2016/2017
 */
class PrikazJdi implements IPrikaz { //StatementGo
    private static final String NAZEV = "jdi"; //go
    private HerniPlan plan; //GamePlan
    private  Hra hra;
    
    /**
    *  Konstruktor třídy
    *  
    *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
    */    
    public PrikazJdi(HerniPlan plan, Hra hra) {
        this.plan = plan;
        this.hra = hra;
    } //StatementGo

    /**
     *  Provádí příkaz "jdi". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     *  existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     *  (východ) není, vypíše se chybové hlášení.
     *
     *@param parametry - jako  parametr obsahuje jméno prostoru (východu),
     *                         do kterého se má jít.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) { //processTheStatement
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Kam mám jít? Musíš zadat jméno východu"; // "Where should I go? You have to give the name of the exit"
        }

        String smer = parametry[0];

        // zkoušíme přejít do sousedního prostoru
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer); //nextSpace getCurrentSpace
        if (sousedniProstor == null) {
            return "Tam se odsud jít nedá!"; //You can't go there from here.
        }

        else {
            if (!sousedniProstor.getJeZamceno()) {
                plan.setAktualniProstor(sousedniProstor);
                if(plan.getAktualniProstor().equals(plan.getProhravaciProstor1()) || plan.getAktualniProstor().equals(plan.getProhravaciProstor2())){
                    hra.setKonecHry(true);
                    return "You have lost the game";
                }
                if(plan.getAktualniProstor().equals(plan.getViteznyProstor()))
                {
                    hra.setKonecHry(true);
                    return "Congratulations, you have won the game";
                }
                return sousedniProstor.dlouhyPopis();
            }
            else{return "The room is locked";}
        }
    }

    @Override
    public String proved(String... parametry) {
        return null;
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

}
