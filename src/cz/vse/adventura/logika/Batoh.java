package cz.vse.adventura.logika;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
 * Třída Batoh - popisuje batoh.
 *
 *  Tato třída je součástí textové hry.
 *
 *  "Batoh" reprezentuje "úložný prostor" pro sebrané věci (příkazem seber).
 *  Věci jsou přenositelné. Jsou vkládány do batohu. Lze je z batohu odebrat.
 *
 * @author    Madina Burgueva
 * @version   pro letní semestr 2023/2024
 */
public class Batoh implements ISeznamVeci { // batoh - backpack
    private static Batoh instance = null;
    private List<Vec> seznamVeci; //listOfThings

    // Součást domácího úkolu - Implementace Singletonu
    /**
     * Privátní konstruktor třídy Batoh.
     */
    public Batoh() { //backpack
        seznamVeci = new ArrayList<Vec>(); //listOfThings
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


    public Vec seberVec(Vec vec) { //insertTheThing
            veci.put(vec.getNazev(), vec); //things.put(getName), thing
            if (veci.containsKey(vec.getNazev()))
                return vec;
            return null;
        }
        public Vec odeberVec(String nazev) { //removeTheThing
            return veci.remove(nazev);
        }
        public Vec odeberVec(Vec vec) { //removeTheThing
            return veci.remove(vec.getNazev());
        }

        public List<Vec> getObsah(){
            List<Vec> vratitVec = new ArrayList<Vec>(this.veci.values());
            return vratitVec;
        }
        public Vec odebranaVec(Vec vec) { // removedThing
            return null;
        }
        public int getKapacita() { //capacity
            return KAPACITA;
        }
    }
