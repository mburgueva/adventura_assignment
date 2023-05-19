package cz.vse.adventura.logika;

public class Vec extends Predmet {
    private boolean jePrenosna;

    public Vec(String nazev, boolean jePrenosna) {
        super(nazev);
        this.jePrenosna = jePrenosna;
    }

    public boolean isJePrenosna() {
        return jePrenosna;
    }
}

