package Angajati;

import java.util.Calendar;
import java.util.Date;

public class Angajat{

    private byte angajatID;
    private String nume;
    private String prenume;
    private Date dataNasterii;
    private Date dataAngajarii;
    private double coeficientSalariat;

    private static byte increment = 0;   //folosit pentru a autoincrementa ID-ul

    private int nrStandard = 0;          // nr de masini standard pe care le poate avea un angajat
    private int nrAutobuze = 0;          // nr de autobuze
    private int nrCamioane = 0;          // nr de camioane

    public Angajat(){

    }

    public Angajat(String nume, String prenume, Date dataNasterii,
                   Date dataAngajarii, double coeficientSalariat){
        this.angajatID = ++increment;
        this.nume = nume;
        this.prenume = prenume;
        this.dataNasterii = dataNasterii;
        this.dataAngajarii = dataAngajarii;
        setCoeficientSalariat(coeficientSalariat);
    }

    //Getters and Setters

    public byte getAngajatID() {
        return angajatID;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setDataNasterii(Date dataNasterii) {
        this.dataNasterii = dataNasterii;
    }

    public Date getDataAngajarii() {
        return dataAngajarii;
    }

    public void setDataAngajarii(Date dataAngajarii) {
        this.dataAngajarii = dataAngajarii;
    }

    public double getCoeficientSalariat() {
        return coeficientSalariat;
    }

    private void setCoeficientSalariat(double coeficientSalariat) {
        this.coeficientSalariat = coeficientSalariat;
    }

    public int getNrStandard() {
        return nrStandard;
    }

    public void setNrStandard(int nrStandard) {
        this.nrStandard = nrStandard;
    }

    public int getNrAutobuze() {
        return nrAutobuze;
    }

    public void setNrAutobuze(int nrAutobuze) {
        this.nrAutobuze = nrAutobuze;
    }

    public int getNrCamioane() {
        return nrCamioane;
    }

    public void setNrCamioane(int nrCamioane) {
        this.nrCamioane = nrCamioane;
    }

    @Override
    public String toString() {
        return "Angajat: " +
                "ID = " + angajatID +
                ", nume = " + nume + '\'' +
                ", prenume = " + prenume + '\'' +
                ", dataNasterii = " + dataNasterii +
                ", dataAngajarii = " + dataAngajarii +
                ", coeficientSalariat = " + coeficientSalariat +
                '.';
    }

    // convertesc un Date intr-un Calendar
    // ma ajuta la calculul salariului
    public Calendar dateToCalendar(Date dataAngajarii) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataAngajarii);
        return calendar;
    }
}
