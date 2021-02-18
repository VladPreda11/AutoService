package Masini;

import java.util.ArrayList;
import java.util.List;

public class MasinaCRUD {
    private List<Masina> masini = new ArrayList<>();

    //ADAUGARE
    public void adaugaMasina(char tipMasina, int nrKM, short anFabricatie, boolean diesel, byte valoareProprie){

        if(tipMasina == 'S'){
            masini.add(new Standard(nrKM, anFabricatie, diesel, valoareProprie));
        } else if(tipMasina == 'A'){
            masini.add(new Autobuz(nrKM, anFabricatie, diesel, valoareProprie));
        } else if(tipMasina == 'C'){
            masini.add(new Camion(nrKM, anFabricatie, diesel, valoareProprie));
        }
    }

    //AFISARE
    public void afisareMasiniAsteptare() {
        if(masini.size() == 0) {
            System.out.println("Nu sunt masini in asteptare!");
        }

        for(int i = 0; i < masini.size(); i++ ) {
            System.out.println(masini.get(i));
        }
    }
}
