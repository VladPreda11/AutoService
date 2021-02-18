package Angajati;

import java.util.Date;

public class Mecanic extends Angajat{

    public Mecanic(){

    }

    public Mecanic(String nume, String prenume, Date dataNasterii,
                    Date dataAngajarii){
        super(nume, prenume, dataNasterii, dataAngajarii, 1.5);
    }
}
