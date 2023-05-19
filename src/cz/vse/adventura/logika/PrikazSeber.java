package cz.vse.adventura.logika;

class PrikazSeber implements IPrikaz {
    private static final String NAZEV = "seber"; //pick up, grab
    private HerniPlan plan;

    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, ve kterém se bude ve hře "sbírat"
     */
    public PrikazSeber(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     *  Provádí příkaz "seber". Zkouší sebrat věci z prostoru a vkládá je do batohu.
     *
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (název věci), tak ....
            return "Co mám sebrat - musíš napsat název věci, kterou mám sebrat.";
        }

        String nazev = parametry[0];

        try {
            this.plan.seberVec(nazev); //pick up the thing
        } catch (IllegalStateException exception) {
            return exception.getMessage();
        }

        return "Věc '" + nazev + "' je nyní v batohu.\n" +
                this.plan.getPopisObsahuBatohu(); //description of backpack contents
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
    public String getNazev() {
        return NAZEV;
    }
}
