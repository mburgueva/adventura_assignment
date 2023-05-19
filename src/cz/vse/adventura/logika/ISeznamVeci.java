package cz.vse.adventura.logika;

public interface ISeznamVeci { //listOfThings
        public boolean obsahujeVec(String nazev); //containsThing name
        public Vec vlozVec(Vec vec); //insertThing thing
        public Vec odeberVec(String nazev); //removeThing
        public Vec odeberVec(Vec vec);
        public Vec odebranaVec(Vec vec); //removedThing
    }
