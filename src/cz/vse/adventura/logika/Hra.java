package cz.vse.adventura.logika;

/**
 *  Třída Hra - třída představující logiku adventury.
 * 
 *  Toto je hlavní třída  logiky aplikace.  Tato třída vytváří instanci třídy HerniPlan, která inicializuje mistnosti hry
 *  a vytváří seznam platných příkazů a instance tříd provádějící jednotlivé příkazy.
 *  Vypisuje uvítací a ukončovací text hry.
 *  Také vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */

public class Hra implements IHra { //Game
    private SeznamPrikazu platnePrikazy;    // obsahuje seznam přípustných příkazů // ListOfStatements validStatements
    private HerniPlan herniPlan; //gamePlan
    private boolean konecHry = false; //endOfTheGame

    /**
     *  Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan) a seznam platných příkazů.
     */
    public Hra() { //Game
        herniPlan = new HerniPlan(); //gamePlan
        platnePrikazy = new SeznamPrikazu(); //validInstructions = ListOfStatements
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy)); //validStatements.insertStatement()
        platnePrikazy.vlozPrikaz(new PrikazJdi(herniPlan)); //validStatements.insertStatement()
        platnePrikazy.vlozPrikaz(new PrikazKonec(this)); //validStatements.insertStatement()
        platnePrikazy.vlozPrikaz(new PrikazSeber(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazPoloz(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazZamkni(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazOdemkni(herniPlan));
    }

    /**
     *  Vrátí úvodní zprávu pro hráče.
     */
    public String vratUvitani() { //returnWelcome
        return "Vítejte!\n" +
               "Chystáš se na dovolenou do Řecka, musíš dorazit na letiště.\n" +
               "Napište 'nápověda', pokud si nevíte rady, jak hrát dál.\n" +
               "\n" +
               herniPlan.getAktualniProstor().dlouhyPopis(); //gamePlan.getCurrentSpace().longDescription
    }
    
    /**
     *  Vrátí závěrečnou zprávu pro hráče.
     */
    public String vratEpilog() {
        return "Dík, že jste si zahráli.  Ahoj.";
    } //returnEpilog
    
    /** 
     * Vrací true, pokud hra skončila.
     */
     public boolean konecHry() {
        return konecHry;
    } //endOfGame

    /**
     *  Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     *  Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     *  Pokud ano spustí samotné provádění příkazu.
     *
     *@param  radek  text, který zadal uživatel jako příkaz do hry.
     *@return          vrací se řetězec, který se má vypsat na obrazovku
     */
     public String zpracujPrikaz(String radek) { //processTheStatement
        String [] slova = radek.split("[ \t]+"); //words = row
        String slovoPrikazu = slova[0]; //wordOfTheStatement = words
        String []parametry = new String[slova.length-1]; //parameters = words
        for(int i=0 ;i<parametry.length;i++){ //parameters
           	parametry[i]= slova[i+1]; //parameters
        }
        String textKVypsani=" .... "; //textToWrite
        if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) { //validStatements.isValidStatement(wordOfStatement)
            IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu); //IStatement statement = validStatements.returnStatement
            textKVypsani = prikaz.provedPrikaz(parametry); //textToWrite = statement.processStatement(parameters)
        }
        else {
            textKVypsani="Nevím co tím myslíš? Tento příkaz neznám. "; //textToWrite
        }
        return textKVypsani; //textToWrite
    }
    
    
     /**
     *  Nastaví, že je konec hry, metodu využívá třída PrikazKonec,
     *  mohou ji použít i další implementace rozhraní Prikaz.
     *  
     *  @param  konecHry  hodnota false= konec hry, true = hra pokračuje
     */
    void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    } //endOfGame
    
     /**
     *  Metoda vrátí odkaz na herní plán, je využita hlavně v testech,
     *  kde se jejím prostřednictvím získává aktualní místnost hry.
     *  
     *  @return     odkaz na herní plán
     */
     public HerniPlan getHerniPlan(){
        return herniPlan;
     } //GamePlan
    
}

