package Angajati;

import java.util.Date;

public class Director extends Angajat{

    public Director(){

    }

    public Director(String nume, String prenume, Date dataNasterii,
                    Date dataAngajarii){
        super(nume, prenume, dataNasterii, dataAngajarii, 2);
    }
}
