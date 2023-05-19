package cz.vse.adventura.logika;

class PrikazMluv implements IPrikaz {
    private static final String NAZEV = "mluv"; //speak
    private HerniPlan plan;
    private Hra hra;

    /**
     * Konstruktor třídy
     *
     * @param plan herní plán, ve kterém se bude ve hře "mluvit"
     * @param hra  instance hry
     */
    public PrikazMluv(HerniPlan plan, Hra hra) {
        this.plan = plan;
        this.hra = hra;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // Pokud chybí druhé slovo, tak ...
            return "Musíš zadat druhé slovo.";
        }

        if (parametry.length == 1) {
            if (plan.getAktualniProstor().getNazev().equals("Terminal2")) {
                hra.setKonecHry(true);
                return "Dostal jsi se na správný terminál. Gratuluji, stíháš svůj let!";
            } else if (plan.getAktualniProstor().getNazev().equals("Terminal1")) {
                return "Špatná odpověď, zkus to ještě jednou.";
            } else {
                return "Nemůžeš mluvit v tomto prostoru.";
            }
        }

        return "Neplatný počet parametrů.";
    }

    @Override
    public String proved(String... parametry) {
        return null;
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
