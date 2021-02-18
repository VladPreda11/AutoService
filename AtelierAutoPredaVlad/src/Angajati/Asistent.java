package Angajati;

import java.util.Date;

public class Asistent extends Angajat{

    public Asistent(){

    }

    public Asistent(String nume, String prenume, Date dataNasterii,
                   Date dataAngajarii){
        super(nume, prenume, dataNasterii, dataAngajarii, 1);
    }
}
