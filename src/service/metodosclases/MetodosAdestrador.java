package service.metodosclases;

import model.Adestrador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de gestionar los métodos relacionados con la creación y manejo de una lista de adestradores.
 * Contiene métodos para obtener una lista de adestradores predefinidos y para imprimir los datos de esa lista.
 * @author cristian
 * @version 1.0
 */
public class MetodosAdestrador {

    /**
     * Metodo que crea una lista de adestradores con datos predefinidos.
     * Se crean dos objetos de tipo Adestrador con fechas de nacimiento y nombres específicos.
     *
     * @return Lista de adestradores con dos elementos predefinidos.
     */
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

    /**
     * Metodo para imprimir los datos de los adestradores contenidos en la lista proporcionada.
     *
     * @param adestradorList Lista de objetos Adestrador que se desea imprimir.
     */

    public void leerAdestradorList(List<Adestrador> adestradorList){
        for(Adestrador ad : adestradorList){
            System.out.println(ad);
        }
    }

}
