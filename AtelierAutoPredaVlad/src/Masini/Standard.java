package Masini;

public class Standard extends Masina {

    private byte transmisie; // 0 - manual / 1 - automat

    public Standard(){

    }

    public Standard(int nrKM, short anFabricatie, boolean diesel, byte transmisie){
        super(nrKM, anFabricatie, diesel);
        this.transmisie = transmisie;
    }

    public byte getTransmisie() {
        return transmisie;
    }

    public void setTransmisie(byte transmisie) {
        this.transmisie = transmisie;
    }

    @Override
    public String toString() {
        return "Standard{" +
                "masinaID=" + getMasinaID() +
                ", nrKM=" + getNrKM() +
                ", anFabricatie=" + getAnFabricatie() +
                ", diesel=" + getDiesel() +
                ", transmisie=" + transmisie +
                '}';
    }

    @Override
    public int politaAsigurare() {
        int suma = 0;
        byte vechime = (byte)(2021 - getAnFabricatie());

        suma = vechime * 100;

        if(getDiesel()){
            suma += 500;
        }

        if(getNrKM() > 200_000){
            suma += 500;
        }
        return suma;
    }

    @Override
    public double politaAsigurareDISCOUNT() {
        return politaAsigurare() - 0.05*politaAsigurare();
    }
}
