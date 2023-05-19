package cz.vse.adventura.logika;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;


public class Batoh implements ISeznamVeci { // batoh - backpack
    private static Batoh instance = null;
    private List<Vec> seznamVeci; //listOfThings

    // Součást domácího úkolu - Implementace Singletonu
    /**
     * Privátní konstruktor třídy Batoh.
     */
    private Batoh() { //backpack
        seznamVeci = new ArrayList<>(); //listOfThings
    }

    /**
     * Vrací jedinou instanci třídy Batoh (singleton).
     *
     * @return instance Batoh
     */
    public static Batoh getInstance() { //Backkpack
        if (instance == null) {
            instance = new Batoh();
        }
        return instance;
    }
        private final int KAPACITA = 7; // kapacita batohu // capacity of the backpack
        private Map<String, Vec> veci = new HashMap<>(); // nová mapa do které můžeme vložit předměty // vec - thing

        public String toString() {
            if(veci.size() == 0) { // prvky uložené v mapě
                return "Batoh je prazdný. ";
            }
            String vysledek = ""; // result
            for (String vec: veci.keySet()) {
                vysledek += vec + ", ";
            }
            return vysledek;
        }
        public boolean obsahujeVec(String nazev) { //containsThing
            return veci.containsKey(nazev);
        }
        public Vec vlozVec(Vec vec) { //insertTheThing
            veci.put(vec.getNazev(), vec); //things.put(getName), thing
            if (veci.containsKey(vec.getNazev()))
                return vec;
            return null;
        }
        public Vec odeberVec(String nazev) { //removeTheThing
            return veci.remove(nazev);
        }
        public Vec odeberVec(Vec vec) { //removeTheThing
            return null;
        }
        public Vec odebranaVec(Vec vec) { // removedThing
            return null;
        }
        public int getKapacita() { //capacity
            return KAPACITA;
        }
    }
