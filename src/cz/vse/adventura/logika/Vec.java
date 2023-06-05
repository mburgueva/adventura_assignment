package cz.vse.adventura.logika;

public class Vec {
    private String nazev;
    private boolean jePrenosna;

    public Vec(String nazev, boolean jePrenosna) {
        this.nazev = nazev;
        this.jePrenosna = jePrenosna;
    }
    public String getNazev() {
        return nazev;
    }
    public boolean isJePrenosna() {
        return jePrenosna;
    }
}

