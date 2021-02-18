package Masini;

public abstract class Masina {

    private int masinaID;
    private int nrKM;
    private short anFabricatie;
    private boolean diesel;

    private static int incrementMasina = 0; //folosit la autoincrementarea ID-ului

    public Masina(){

    }

    public Masina(int nrKM, short anFabricatie, boolean diesel){
        this.masinaID = ++incrementMasina;
        this.nrKM = nrKM;
        this.anFabricatie = anFabricatie;
        this.diesel = diesel;
    }

    //Getters
    public int getMasinaID() {
        return masinaID;
    }

    public int getNrKM() {
        return nrKM;
    }

    public short getAnFabricatie() {
        return anFabricatie;
    }


    public boolean getDiesel() {
        return diesel;
    }

    @Override
    public String toString() {
        return "Masina: " +
                "masinaID = " + masinaID +
                ", nrKM = " + nrKM +
                ", anFabricatie = " + anFabricatie +
                ", diesel = " + diesel +
                '.';
    }

    public abstract int politaAsigurare();

    public abstract double politaAsigurareDISCOUNT();

}
