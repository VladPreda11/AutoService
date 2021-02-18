package Angajati;

import java.util.*;
import java.lang.String;

public class AngajatCRUD{

    private List<Angajat> angajati = new ArrayList<>();
    private short nrAngajati; //il folosesc sa validez ca atelierul este deschis

    //ADAUGARE
    public void adaugareAngajat(char tipAngajat, String nume, String prenume, Date dataNasterii, Date dataAngajarii) {

        if(tipAngajat == 'D'){
            angajati.add(new Director(nume, prenume, dataNasterii, dataAngajarii));
        } else if(tipAngajat == 'M'){
            angajati.add(new Mecanic(nume, prenume, dataNasterii, dataAngajarii));
        } else if(tipAngajat == 'A'){
            angajati.add(new Asistent(nume, prenume, dataNasterii, dataAngajarii));
        }

        nrAngajati++;

        System.out.println("Angajatul a fost adaugat!");

        if(nrAngajati >= 1){
            System.out.println("Atelierul este deschis cu " + nrAngajati + " angajati!");
        } else {
            System.out.println("Atelierul este inchis :(");
        }
    }

    //AFISARE
    public void afisareAngajati() {
        if(angajati.size() == 0) {
            System.out.println("Atelierul este gol!");
        }

       for(int i = 0; i < angajati.size(); i++ ) {
           System.out.println(angajati.get(i));
       }
    }

    //STERGERE
    public void stergereAngajat(byte angajatID) {
        boolean ok = false;             //il folosesc sa verific daca angajatul exista

        if(angajati.size() == 0) {
            System.out.println("Atelierul este gol!");
        }

        for(Angajat angajat : angajati) {
            if(angajat.getAngajatID() == angajatID) {
                ok = true;
                angajati.remove(angajat);
                System.out.println("A fost dat afara angajatul cu ID-ul " + angajat.getAngajatID());
                nrAngajati--;
                if(nrAngajati >= 1){
                    System.out.println("Atelierul este deschis cu " + nrAngajati + " angajati!");
                } else {
                    System.out.println("Atelierul este inchis :(");
                }
                return;
            }
        }

        if(!ok){
            System.out.println("Angajatul nu exista. Introduceti un alt ID.");
        }

        if(nrAngajati >= 1){
            System.out.println("Atelierul este deschis cu " + nrAngajati + " angajati!");
        } else {
            System.out.println("Atelierul este inchis :(");
        }
    }

    //EDITARE
    public void editareAngajat(byte angajatID,String nume,String prenume,Date dataNasterii, Date dataAngajarii) {
        boolean ok = false;             //il folosesc sa verific daca angajatul exista

        if(angajati.size() == 0) {
            System.out.println("Atelierul este gol!");
            return;
        }

        for(Angajat angajat : angajati) {
            if(angajat.getAngajatID() == angajatID) {
                ok = true;
                angajat.setNume(nume);
                angajat.setPrenume(prenume);
                angajat.setDataNasterii(dataNasterii);
                angajat.setDataAngajarii(dataAngajarii);
                System.out.println("S-a editat angajatul cu id-ul " + angajat.getAngajatID());
                return;
            }
        }

        if(!ok){
            System.out.println("Angajatul nu exista. Introduceti un alt ID.");
        }
    }

    //CALCUL SALARIU
    public void calculSalariu(byte angajatID) {
        double salariu = 0.0;
        boolean ok = false;             //il folosesc sa verific daca angajatul exista

        for(Angajat angajat : angajati) {
            if(angajat.getAngajatID() == angajatID) {
                ok = true;

                Date dataAng = angajat.getDataAngajarii();
                Calendar calendar = angajat.dateToCalendar(dataAng); //convertim date-ul in calendar pentru a putea calcula vechimea

                Calendar today = new GregorianCalendar();
                today.setTime(new Date());

                double yearsInBetween = today.get(Calendar.YEAR) - calendar.get(Calendar.YEAR); //calculam vechimea

                salariu = (double)(angajat.getCoeficientSalariat() * 1000 * yearsInBetween);
                System.out.println("Angajatul cu ID-ul " + angajat.getAngajatID() + " are salariul: " + salariu);
            }
        }
        if(!ok){
            System.out.println("Angajatul nu exista. Introduceti un alt ID");
        }
    }

    //ALOCAREA MASINII LA PRIMUL ANGAJAT DISPONIBIL
    public boolean alocaMasinaAngajatLiber(char tipMasina){
        boolean ok = false;           // il folosesc sa verific daca angajatul exista

        int standard = 0;
        int autobuz = 0;            //astea le folosesc ca sa setez nr de masini pe care le poate avea un angajat
        int camion = 0;

        Random random = new Random();       // il folosesc ca sa aloc un timp random pentru repararea unei masini

        if(tipMasina == 'S'){       //daca e masina STANDARD
            for(Angajat angajat : angajati) {
                if(angajat.getNrStandard() < 3) {
                    ok = true;
                    standard = angajat.getNrStandard() + 1;
                    angajat.setNrStandard(standard);
                    System.out.println("Masina dumneavoastra a fost adaugata la angajatul cu ID-ul: " +  angajat.getAngajatID());
                    System.out.println("Masina va fi disponibila in " + (random.nextInt(10) + 1) + " zile");
                    return true;
                }
            }
        } else if (tipMasina == 'A'){       //daca e AUTOBUZ
            for(Angajat angajat : angajati) {
                if(angajat.getNrAutobuze() == 0) {
                    ok = true;
                    autobuz = angajat.getNrAutobuze() + 1;
                    angajat.setNrAutobuze(autobuz);
                    System.out.println("Masina dumneavoastra a fost adaugata la angajatul cu ID-ul: " + angajat.getAngajatID());
                    System.out.println("Masina va fi disponibila in " + (random.nextInt(10) + 1) + " zile");
                    return true;
                }
            }
        } else if (tipMasina == 'C'){       //daca e CAMION
            for(Angajat angajat : angajati) {
                if(angajat.getNrCamioane() == 0) {
                    ok = true;
                    camion = angajat.getNrCamioane() + 1;
                    angajat.setNrCamioane(camion);
                    System.out.println("Masina dumneavoastra a fost adaugata la angajatul cu ID-ul: " + angajat.getAngajatID());
                    System.out.println("Masina va fi disponibila in " + (random.nextInt(10) + 1) + " zile");
                    return true;
                }
            }
        }

        if(!ok){
            System.out.println("Nu exista angajat disponibil!");
        }

        return false;
    }

    //ALOCAREA MASINII UNUI ANUMIT ANGAJAT
    public boolean alocaMasinaAngajatSpecific(char tipMasina, byte angajatID){
        boolean ok = false;      //il folosesc sa verific daca angajatul exista
        boolean ok1 = false;    //folosit ca sa vad daca angajatul e disponibil

        int standard = 0;
        int autobuz = 0;            //astea le folosesc ca sa setez nr de masini pe care le poate avea un angajat
        int camion = 0;

        Random random = new Random();       // il folosesc ca sa aloc un timp random pentru repararea unei masini

        if(tipMasina == 'S'){       //daca e masina STANDARD
            for(Angajat angajat : angajati) {
                if(angajat.getAngajatID() == angajatID) {
                    ok = true;
                    if (angajat.getNrStandard() < 3) {
                        ok1 = true;
                        standard = angajat.getNrStandard() + 1;
                        angajat.setNrStandard(standard);
                        System.out.println("Masina dumneavoastra a fost adaugata la angajatul cu ID-ul: " + angajat.getAngajatID());
                        System.out.println("Masina va fi disponibila in " + (random.nextInt(10) + 1) + " zile");
                        return true;
                    }
                }
            }
        } else if (tipMasina == 'A'){       //daca e AUTOBUZ
            for(Angajat angajat : angajati) {
                if(angajat.getAngajatID() == angajatID){
                    ok = true;
                    if(angajat.getNrAutobuze() == 0) {
                        ok1 = true;
                        autobuz = angajat.getNrAutobuze() + 1;
                        angajat.setNrAutobuze(autobuz);
                        System.out.println("Masina dumneavoastra a fost adaugata la angajatul cu ID-ul: " + angajat.getAngajatID());
                        System.out.println("Masina va fi disponibila in " + (random.nextInt(10) + 1) + " zile");
                        return true;
                    }
                }
            }
        } else if (tipMasina == 'C'){       //daca e CAMION
            for(Angajat angajat : angajati) {
                if(angajat.getAngajatID() == angajatID) {
                    ok = true;
                    if (angajat.getNrCamioane() == 0) {
                        ok1 = true;
                        camion = angajat.getNrCamioane() + 1;
                        angajat.setNrCamioane(camion);
                        System.out.println("Masina dumneavoastra a fost adaugata la angajatul cu ID-ul: " + angajat.getAngajatID());
                        System.out.println("Masina va fi disponibila in " + (random.nextInt(10) + 1) + " zile");
                        return true;
                    }
                }
            }
        }

        if(!ok){
            System.out.println("Angajatul nu exista! Introduceti alt ID");
        } else if(ok == true && ok1 == false){
            System.out.println("Angajatul cu ID-ul " + angajatID + " nu este disponibil!");
        }

        return false;
    }

}
