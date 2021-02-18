package Main;

import Angajati.*;
import Masini.MasinaCRUD;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static AngajatCRUD angajatCRUD = new AngajatCRUD();
    static MasinaCRUD masinaCRUD = new MasinaCRUD();

    public static void main(String[] args) throws ParseException {

        boolean citeste = true;

        citesteStart();
        do {
            String comanda = scanner.next();

            switch (comanda) {
                case "ADAUGA":
                    citesteAdauga();
                    break;
                case "AFISARE":
                    angajatCRUD.afisareAngajati();
                    break;
                case "STERGE":
                    angajatCRUD.stergereAngajat(Byte.parseByte(scanner.next()));
                    break;
                case "EDITARE":
                    citesteEditeaza(Byte.parseByte(scanner.next()));
                    break;
                case "SALARIU":
                    angajatCRUD.calculSalariu(Byte.parseByte(scanner.next()));
                    break;
                case "ADDMASINA":
                    citesteAdaugaMasina();
                    break;
                case "ASTEPTARE":
                    masinaCRUD.afisareMasiniAsteptare();
                    break;
                case "EXIT":
                    System.out.println("Va mai asteptam!");
                    citeste = false;
                    break;
                default:
                    System.out.println("Comanda introdusa nu exista!");
            }
        } while (citeste);
    }

    //---------------------------------------------------------------------------------------------
    static void afiseazaComenzi() {
        System.out.println("Comenzile pe care le poti introduce sunt:");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("ADAUGA - pentru adaugarea unui angajat");
        System.out.println("AFISARE - pentru afisarea angajatilor");
        System.out.println("STERGE <angajatID> - pentru stergea unui angajat (e.g. STERGE 1)");
        System.out.println("EDITARE <angajatID> - pentru editarea unui angajat (e.g. EDITARE 4");
        System.out.println("SALARIU <angajatID> - pentru calcularea salariului unui angajat (e.g. SALARIU 2");
        System.out.println("-------------------------------------------------------------------");
        System.out.println("ADDMASINA - pentru a adauga o masina si a o aloca unui angajat daca este cazul");
        System.out.println("ASTEPTARE - pentru a afisa lista de masini in asteptare");
        System.out.println("EXIT");
    }

    //---------------------------------------------------------------------------------------------
    static void citesteStart() {
        String comanda = "";
        do {
            System.out.println("Te rog introdu comanda START");
            comanda = scanner.next();
        } while (!comanda.equals("START"));
        afiseazaComenzi();
    }

    //---------------------------------------------------------------------------------------------
    // folosesc metoda asta ca sa pot citi datele angajatilor de la tastatura si sa le validez
    static void citesteAdauga() throws ParseException {

        String tip;
        String nume;
        String prenume;
        Date dataNasterii;
        Date dataAngajarii;

        String date;
        String date1;

        boolean tipOK = false;
        boolean numeOK = false;
        boolean prenumeOK = false;
        boolean dataNasteriiOK = false;
        boolean dataAngajariiOK = false;

        System.out.println("Introduceti un tip de angajat D, M sau A (director, mecanic, asistent):");
        do {
            tip = scanner.nextLine();
            if (!tip.equals("D") && !tip.equals("M") && !tip.equals("A") || tip.length() == 0) {
                System.out.println("Va rugam introduceti un tip care sa fie D, M sau A:");
            } else tipOK = true;
        } while (!tipOK);

        System.out.println("Introduceti numele angajatului:");
        do {
            nume = scanner.nextLine();
            if (nume.length() > 30 || nume.length() == 0) {
                System.out.println("Va rugam introduceti un nume care sa aiba intre 1 si 30 de caractere:");
            } else numeOK = true;
        } while (!numeOK);

        System.out.println("Introduceti prenumele angajatului:");
        do {
            prenume = scanner.nextLine();
            if (prenume.length() > 30 || prenume.length() == 0) {
                System.out.println("Va rugam introduceti un prenume care sa aiba intre 1 si 30 de caractere:");
            } else prenumeOK = true;
        } while (!prenumeOK);

        System.out.println("Introduceti data nasterii a angajatului (dd-MM-yyyy):");
        do {
            date = scanner.nextLine();
            dataNasterii = new SimpleDateFormat("dd-MM-yyyy").parse(date);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataNasterii);

            Calendar today = new GregorianCalendar();
            today.setTime(new Date());

            double yearsInBetween = today.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);

            if(calendar.get(Calendar.YEAR) > today.get(Calendar.YEAR)){
                System.out.println("Ati introdus o data din viitor. Introduceti o data curenta:");
            } else if(calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) && calendar.get(Calendar.MONTH) > today.get(Calendar.MONTH)){
                System.out.println("Ati introdus o data din viitor. Introduceti o data curenta:");
            } else if(calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) && calendar.get(Calendar.MONTH) == today.get(Calendar.MONTH)
                    && calendar.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH)){
                System.out.println("Ati introdus o data din viitor. Introduceti o data curenta:");
            }

            if (yearsInBetween < 18) {
                System.out.println("Angajatul nu are minim 18 ani. Introduceti alta data a nasterii:");
            } else dataNasteriiOK = true;
        } while (!dataNasteriiOK);

        System.out.println("Introduceti data angajarii (dd-MM-yyyy):");
        do {
            date1 = scanner.nextLine();
            dataAngajarii = new SimpleDateFormat("dd-MM-yyyy").parse(date1);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataNasterii);

            Calendar today = new GregorianCalendar();
            today.setTime(new Date());

            if(calendar.get(Calendar.YEAR) > today.get(Calendar.YEAR)){
                System.out.println("Ati introdus o data din viitor. Introduceti o data curenta:");
            } else if(calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) && calendar.get(Calendar.MONTH) > today.get(Calendar.MONTH)){
                System.out.println("Ati introdus o data din viitor. Introduceti o data curenta:");
            } else if(calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) && calendar.get(Calendar.MONTH) == today.get(Calendar.MONTH)
                    && calendar.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH)){
                System.out.println("Ati introdus o data din viitor. Introduceti o data curenta:");
            } else dataAngajariiOK = true;
        } while (!dataAngajariiOK);

        if (tip.equals("D")) {
            angajatCRUD.adaugareAngajat('D', nume, prenume, dataNasterii, dataAngajarii);
        } else if (tip.equals("M")) {
            angajatCRUD.adaugareAngajat('M', nume, prenume, dataNasterii, dataAngajarii);
        } else if (tip.equals("A")) {
            angajatCRUD.adaugareAngajat('A', nume, prenume, dataNasterii, dataAngajarii);
        }
    }

    // folosesc metoda asta pentru a citi datele angajatului ce urmeaza a fi editat si pentru a le valida
    static void citesteEditeaza(byte angajatID) throws ParseException {

        String nume;
        String prenume;
        Date dataNasterii;
        Date dataAngajarii;

        String date;
        String date1;

        boolean numeOK = false;
        boolean prenumeOK = false;
        boolean dataNasteriiOK = false;
        boolean dataAngajariiOK = false;

        System.out.println("Introduceti numele angajatului:");
        do {
            nume = scanner.nextLine();
            if (nume.length() > 30 || nume.length() == 0) {
                System.out.println("Va rugam introduceti un nume care sa aiba intre 1 si 30 de caractere:");
            } else numeOK = true;
        } while (!numeOK);

        System.out.println("Introduceti prenumele angajatului:");
        do {
            prenume = scanner.nextLine();
            if (prenume.length() > 30 || prenume.length() == 0) {
                System.out.println("Va rugam introduceti un prenume care sa aiba intre 1 si 30 de caractere:");
            } else prenumeOK = true;
        } while (!prenumeOK);

        System.out.println("Introduceti data nasterii a angajatului (dd-MM-yyyy):");
        do {
            date = scanner.nextLine();
            dataNasterii = new SimpleDateFormat("dd-MM-yyyy").parse(date);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataNasterii);

            Calendar today = new GregorianCalendar();
            today.setTime(new Date());

            double yearsInBetween = today.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);

            if(calendar.get(Calendar.YEAR) > today.get(Calendar.YEAR)){
                System.out.println("Ati introdus o data din viitor. Introduceti o data curenta:");
            } else if(calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) && calendar.get(Calendar.MONTH) > today.get(Calendar.MONTH)){
                System.out.println("Ati introdus o data din viitor. Introduceti o data curenta:");
            } else if(calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) && calendar.get(Calendar.MONTH) == today.get(Calendar.MONTH)
                    && calendar.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH)){
                System.out.println("Ati introdus o data din viitor. Introduceti o data curenta:");
            }

            if (yearsInBetween < 18) {
                System.out.println("Angajatul nu are minim 18 ani. Introduceti alta data a nasterii:");
            } else dataNasteriiOK = true;
        } while (!dataNasteriiOK);

        System.out.println("Introduceti data angajarii (dd-MM-yyyy):");
        do {
            date1 = scanner.nextLine();
            dataAngajarii = new SimpleDateFormat("dd-MM-yyyy").parse(date1);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataNasterii);

            Calendar today = new GregorianCalendar();
            today.setTime(new Date());

            if(calendar.get(Calendar.YEAR) > today.get(Calendar.YEAR)){
                System.out.println("Ati introdus o data din viitor. Introduceti o data curenta:");
            } else if(calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) && calendar.get(Calendar.MONTH) > today.get(Calendar.MONTH)){
                System.out.println("Ati introdus o data din viitor. Introduceti o data curenta:");
            } else if(calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) && calendar.get(Calendar.MONTH) == today.get(Calendar.MONTH)
                    && calendar.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH)){
                System.out.println("Ati introdus o data din viitor. Introduceti o data curenta:");
            } else dataAngajariiOK = true;
        } while (!dataAngajariiOK);

        angajatCRUD.editareAngajat(angajatID,nume,prenume,dataNasterii,dataAngajarii);
    }

    //metoda similara cu cele doua de mai sus
    //o folosesc pentru a citi datele de la tastatura si pentru a afisa operatiile posibile
    static void citesteAdaugaMasina() throws ParseException {

        String tip;
        int nrKM;
        short anFabricatie;
        boolean diesel;

        byte transmisie;
        byte nrLocuri;
        byte tonaj;

        boolean tipOK = false;
        boolean anFabricatieOK = false;

        boolean transmisieOK = false;
        boolean nrLocuriOK = false;
        boolean tonajOK = false;

        String alege;

        byte id;

        System.out.println("Introduceti un tip de masina S, A sau C (standard, autobuz, camion):");
        do {
            tip = scanner.nextLine();
            if (!tip.equals("S") && !tip.equals("A") && !tip.equals("C") || tip.length() == 0) {
                System.out.println("Va rugam introduceti un tip care sa fie S, A sau C:");
            } else tipOK = true;
        } while (!tipOK);

        System.out.println("Introduceti numarul de km ai masinii:");
        nrKM = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduceti anul fabricatiei al masinii:");
        do {
            anFabricatie = Short.parseShort(scanner.nextLine());
            if (anFabricatie > 2021) {
                System.out.println("Va rugam introduceti un an mai mic sau egal cu 2021:");
            } else anFabricatieOK = true;
        } while (!anFabricatieOK);

        System.out.println("Introduceti daca masina este diesel sau nu (true/false):");
        diesel = Boolean.parseBoolean(scanner.nextLine());

        // in cazul in care masina este STANDARD
        if (tip.equals("S")) {
            System.out.println("Te rog sa introduci transmisia (0 - manual / 1 - automat):");
            do {
                transmisie = Byte.parseByte(scanner.next());
                if (transmisie != 0 && transmisie != 1) {
                    System.out.println("Va rugam introduceti 0 pentru transmisie manuala sau 1 pentru transmisie automata:");
                } else transmisieOK = true;
            } while (!transmisieOK);

            System.out.println("Doriti sa alocati masina primului angajat disponibil (A), unui angajat anume (B)," +
                    " sa asteptati (C) sau sa plecati (D)? ");
            alege = scanner.next();
            if (alege.equals("A")) {
                if (!angajatCRUD.alocaMasinaAngajatLiber('S')) {
                    System.out.println("Masina dumneavoastra nu poate fi alocata niciunui angajat.");
                    System.out.println("Doriti sa asteptati (C) sau sa plecati (D)?");
                    alege = scanner.next();
                    if (alege.equals("C")) {
                        masinaCRUD.adaugaMasina('S', nrKM, anFabricatie, diesel, transmisie);
                        System.out.println("Masina este in asteptare");
                    } else if (alege.equals("D")) {
                        System.out.println("O zi buna!");
                    }
                }
            } else if (alege.equals("B")) {
                System.out.println("Introduceti ID-ul angajatului: ");
                id = Byte.parseByte(scanner.next());
                if (!angajatCRUD.alocaMasinaAngajatSpecific('S', id)) {
                    System.out.println("Masina dumneavoastra nu poate fi alocata angajatului cu ID-ul " + id);
                    System.out.println("Doriti sa alocati masina primului angajat liber (A), sa asteptati (C) sau sa plecati (D)?");
                    alege = scanner.next();
                    if (alege.equals("A")) {
                        if (!angajatCRUD.alocaMasinaAngajatLiber('S')) {
                            System.out.println("Masina dumneavoastra nu poate fi alocata niciunui angajat.");
                            System.out.println("Doriti sa asteptati (C) sau sa plecati (D)?");
                            alege = scanner.next();
                            if (alege.equals("C")) {
                                masinaCRUD.adaugaMasina('S', nrKM, anFabricatie, diesel, transmisie);
                                System.out.println("Masina este in asteptare!");
                            } else if (alege.equals("D")) {
                                System.out.println("O zi buna!");
                            }
                        }
                    } else if (alege.equals("C")) {
                        masinaCRUD.adaugaMasina('S', nrKM, anFabricatie, diesel, transmisie);
                        System.out.println("Masina este in asteptare!");
                    } else if (alege.equals("D")) {
                        System.out.println("O zi buna!");
                    }
                }
            } else if (alege.equals("C")) {
                masinaCRUD.adaugaMasina('S', nrKM, anFabricatie, diesel, transmisie);
                System.out.println("Masina este in asteptare!");
            } else if (alege.equals("D")) {
                System.out.println("O zi buna!");
            }

        //in cazul in care masina este AUTOBUZ
        } else if (tip.equals("A")) {
            System.out.println("Te rog sa introduci numarul de locuri:");
            do {
                nrLocuri = Byte.parseByte(scanner.next());
                if (nrLocuri < 18) {
                    System.out.println("Va rugam introduceti minim 18 locuri:");
                } else nrLocuriOK = true;
            } while (!nrLocuriOK);

            System.out.println("Doriti sa alocati masina primului angajat disponibil (A), unui angajat anume (B)," +
                    " sa asteptati (C) sau sa plecati (D)? ");
            alege = scanner.next();
            if (alege.equals("A")) {
                if (!angajatCRUD.alocaMasinaAngajatLiber('A')) {
                    System.out.println("Masina dumneavoastra nu poate fi alocata niciunui angajat.");
                    System.out.println("Doriti sa asteptati (C) sau sa plecati (D)?");
                    alege = scanner.next();
                    if (alege.equals("C")) {
                        masinaCRUD.adaugaMasina('A', nrKM, anFabricatie, diesel, nrLocuri);
                        System.out.println("Masina este in asteptare");
                    } else if (alege.equals("D")) {
                        System.out.println("O zi buna!");
                    }
                }
            } else if (alege.equals("B")) {
                System.out.println("Introduceti ID-ul angajatului: ");
                id = Byte.parseByte(scanner.next());
                if (!angajatCRUD.alocaMasinaAngajatSpecific('A', id)) {
                    System.out.println("Masina dumneavoastra nu poate fi alocata angajatului cu ID-ul " + id);
                    System.out.println("Doriti sa alocati masina primului angajat liber (A), sa asteptati (C) sau sa plecati (D)?");
                    alege = scanner.next();
                    if (alege.equals("A")) {
                        if (!angajatCRUD.alocaMasinaAngajatLiber('A')) {
                            System.out.println("Masina dumneavoastra nu poate fi alocata niciunui angajat.");
                            System.out.println("Doriti sa asteptati (C) sau sa plecati (D)?");
                            alege = scanner.next();
                            if (alege.equals("C")) {
                                masinaCRUD.adaugaMasina('A', nrKM, anFabricatie, diesel, nrLocuri);
                                System.out.println("Masina este in asteptare!");
                            } else if (alege.equals("D")) {
                                System.out.println("O zi buna!");
                            }
                        }
                    } else if (alege.equals("C")) {
                        masinaCRUD.adaugaMasina('A', nrKM, anFabricatie, diesel, nrLocuri);
                        System.out.println("Masina este in asteptare!");
                    } else if (alege.equals("D")) {
                        System.out.println("O zi buna!");
                    }
                }
            } else if (alege.equals("C")) {
                masinaCRUD.adaugaMasina('A', nrKM, anFabricatie, diesel, nrLocuri);
                System.out.println("Masina este in asteptare!");
            } else if (alege.equals("D")) {
                System.out.println("O zi buna!");
            }

        //in cazul in care masina este CAMION
        } else if (tip.equals("C")) {
            System.out.println("Te rog sa introduci tonajul:");
            do {
                tonaj = Byte.parseByte(scanner.next());
                if (tonaj < 3) {
                    System.out.println("Va rugam introduceti un tonaj mai mare sau egal cu 3:");
                } else tonajOK = true;
            } while (!tonajOK);

            System.out.println("Doriti sa alocati masina primului angajat disponibil (A), unui angajat anume (B)," +
                    " sa asteptati (C) sau sa plecati (D)? ");
            alege = scanner.next();
            if (alege.equals("A")) {
                if (!angajatCRUD.alocaMasinaAngajatLiber('C')) {
                    System.out.println("Masina dumneavoastra nu poate fi alocata niciunui angajat.");
                    System.out.println("Doriti sa asteptati (C) sau sa plecati (D)?");
                    alege = scanner.next();
                    if (alege.equals("C")) {
                        masinaCRUD.adaugaMasina('C', nrKM, anFabricatie, diesel, tonaj);
                        System.out.println("Masina este in asteptare");
                    } else if (alege.equals("D")) {
                        System.out.println("O zi buna!");
                    }
                }
            } else if (alege.equals("B")) {
                System.out.println("Introduceti ID-ul angajatului: ");
                id = Byte.parseByte(scanner.next());
                if (!angajatCRUD.alocaMasinaAngajatSpecific('C', id)) {
                    System.out.println("Masina dumneavoastra nu poate fi alocata angajatului cu ID-ul " + id);
                    System.out.println("Doriti sa alocati masina primului angajat liber (A), sa asteptati (C) sau sa plecati (D)?");
                    alege = scanner.next();
                    if (alege.equals("A")) {
                        if (!angajatCRUD.alocaMasinaAngajatLiber('C')) {
                            System.out.println("Masina dumneavoastra nu poate fi alocata niciunui angajat.");
                            System.out.println("Doriti sa asteptati (C) sau sa plecati (D)?");
                            alege = scanner.next();
                            if (alege.equals("C")) {
                                masinaCRUD.adaugaMasina('C', nrKM, anFabricatie, diesel, tonaj);
                                System.out.println("Masina este in asteptare!");
                            } else if (alege.equals("D")) {
                                System.out.println("O zi buna!");
                            }
                        }
                    } else if (alege.equals("C")) {
                        masinaCRUD.adaugaMasina('C', nrKM, anFabricatie, diesel, tonaj);
                        System.out.println("Masina este in asteptare!");
                    } else if (alege.equals("D")) {
                        System.out.println("O zi buna!");
                    }
                }
            } else if (alege.equals("C")) {
                masinaCRUD.adaugaMasina('C', nrKM, anFabricatie, diesel, tonaj);
                System.out.println("Masina este in asteptare!");
            } else if (alege.equals("D")) {
                System.out.println("O zi buna!");
            }
        }
    }
}
