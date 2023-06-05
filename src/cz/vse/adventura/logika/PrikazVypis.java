package cz.vse.adventura.logika;

public class PrikazVypis implements IPrikaz {
    private static final String NAZEV = "vypiš"; //print out
    private HerniPlan plan;

    /**
     * Konstruktor třídy
     *
     * @param plan herní plán, ve kterém se bude ve hře "chodit"
     */
    public PrikazVypis(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        Prostor aktualniProstor = plan.getAktualniProstor();
        Batoh batoh = plan.getBatoh(); //getTheBackPack

        StringBuilder vypis = new StringBuilder();

        // Vypíše název a popis prostoru
        vypis.append("Nacházíš se v prostoru ").append(aktualniProstor.getNazev()).append("\n");
        vypis.append(aktualniProstor.getPopis()).append("\n\n"); //getTheDiscription

        // Vypíše východy z prostoru
        vypis.append("Východy: ");
        for (Prostor vychod : aktualniProstor.getVychody()) {
            vypis.append(vychod.getNazev()).append(" ");
        }
        vypis.append("\n");

        // Vypíše věci v prostoru
        vypis.append("Věci v prostoru: ");
        if (aktualniProstor.getVeciVProstoru().isEmpty()) { //currentSpace.getThings
            vypis.append("žádné");
        } else {
            for (Vec vec : aktualniProstor.getVeciVProstoru()) { //getThings
                vypis.append(vec.getNazev()).append(" ");
            }
        }
        vypis.append("\n");

        // Vypíše věci v batohu
        vypis.append("Věci v batohu: ");
        if (batoh.getObsah().isEmpty()) { //getTheContents
            vypis.append("žádné");
        } else {
            for (Vec vec : batoh.getObsah()) { //getTheContents
                vypis.append(vec.getNazev()).append(" ");
            }
        }
        vypis.append("\n");

        return vypis.toString();
    }

    @Override
    public String proved(String... parametry) {
        return null;
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}

