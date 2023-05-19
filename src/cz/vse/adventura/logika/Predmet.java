package cz.vse.adventura.logika;

// Třída Vec dědí vlastnosti třídy Predmet a přidává další informaci o tom, zda je předmět přenositelný nebo ne.
public class Predmet { //Thing
    private String nazev; //name
    private int vaha; //weight

    public Predmet(String nazev) {
        this.nazev = nazev; //name
        this.vaha = vaha; //weight
    }

    public Predmet() {
    }

    public String getNazev() {
        return nazev;
    }

    public int getVaha() {
        return vaha;
    }
}

