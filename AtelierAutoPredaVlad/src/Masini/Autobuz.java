package Masini;

public class Autobuz extends Masina {

    private byte nrLocuri;

    public Autobuz(){

    }

    public Autobuz(int nrKM, short anFabricatie, boolean diesel, byte nrLocuri){
        super(nrKM, anFabricatie, diesel);
        this.nrLocuri = nrLocuri;
    }

    public byte getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(byte nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    @Override
    public String toString() {
        return "Autobuz{" +
                "masinaID=" + getMasinaID() +
                ", nrKM=" + getNrKM() +
                ", anFabricatie=" + getAnFabricatie() +
                ", diesel=" + getDiesel() +
                ", nrLocuri=" + nrLocuri +
                '}';
    }

    @Override
    public int politaAsigurare() {
        int suma = 0;
        byte vechime = (byte)(2021 - getAnFabricatie());

        suma = vechime * 200;

        if(getDiesel()){
            suma += 1000;
        }

        if(getNrKM() > 200_000){
            suma += 1000;
        } else if(getNrKM() > 100_000){
            suma += 500;
        }
        return suma;
    }

    @Override
    public double politaAsigurareDISCOUNT() {
        return politaAsigurare() - 0.1*politaAsigurare();
    }
}
