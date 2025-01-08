package service.metodosclases;

import model.Adestrador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MetodosAdestrador {

    public List<Adestrador> getAdestradoresList(){
        List<Adestrador> adestradores = new ArrayList<>();
        LocalDate dateAd1 = LocalDate.of(1990, 10, 20);
        Adestrador ad1 = new Adestrador(dateAd1, "ash mostaza");

        LocalDate dateAd2 = LocalDate.of(2006, 5, 12);
        Adestrador ad2 = new Adestrador(dateAd2, "tobias");

        adestradores.add(ad1);
        adestradores.add(ad2);

        return adestradores;
    }

    public void leerAdestradorList(List<Adestrador> adestradorList){
        for(Adestrador ad : adestradorList){
            System.out.println(ad);
        }
    }

}
