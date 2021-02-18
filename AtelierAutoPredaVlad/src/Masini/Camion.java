package Masini;

public class Camion extends Masina {

    private byte tonaj;

    public Camion(){

    }

    public Camion(int nrKM, short anFabricatie, boolean diesel, byte tonaj){
        super(nrKM, anFabricatie, diesel);
        this.tonaj = tonaj;
    }

    public byte getTonaj() {
        return tonaj;
    }

    public void setTonaj(byte tonaj) {
        this.tonaj = tonaj;
    }

    @Override
    public String toString() {
        return "Camion{" +
                "masinaID=" + getMasinaID() +
                ", nrKM=" + getNrKM() +
                ", anFabricatie=" + getAnFabricatie() +
                ", diesel=" + getDiesel() +
                ", tonaj=" + tonaj +
                '}';
    }

    @Override
    public int politaAsigurare() {
        int suma = 0;
        byte vechime = (byte)(2021 - getAnFabricatie());

        suma = vechime * 300;

        if(getNrKM() > 800_000){
            suma += 700;
        }
        return suma;
    }

    @Override
    public double politaAsigurareDISCOUNT() {
        return politaAsigurare() - 0.15*politaAsigurare();
    }
}
