package model.clasewrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import model.Adestrador;

import java.util.List;

/**
 * Esta clase sirve como contenedor para una lista de objetos {@link Adestrador}.
 * Se utiliza para manejar los datos de los entrenadores en formatos XML y JSON.
 * Las anotaciones de Jackson permiten la serialización y deserialización de estos objetos a los respectivos formatos
 * @author cristian
 * @version 1.0
 */
public class Adestradores {

    /**
     * Lista de entrenadores, que se utiliza para la serialización y deserialización en formato XML.
     */
    @JacksonXmlElementWrapper(localName = "adestradrores")
    @JacksonXmlProperty(localName = "adestrador")
    private List<Adestrador> adestradorList;

    /**
     * Lista de entrenadores, que se utiliza para la serialización y deserialización en formato JSON.
     */
    @JsonProperty("adestradores")
    private List<Adestrador> adestradoresJson;

    /**
     * Constructor que inicializa la lista de entrenadores.
     *
     * @param adestradorList la lista de entrenadores a ser asignada.
     */
    public Adestradores(List<Adestrador> adestradorList) {
        this.adestradorList = adestradorList;
    }

    /**
     * Constructor vacío que permite la creación de una instancia sin inicializar las listas.
     */
    public Adestradores() {

    }


    /**
     * Getter y setter de los atributos de la clase
     * @return los valores correspondientes
     */
    public List<Adestrador> getAdestradorList() {
        return adestradorList;
    }

    public void setPokemons(List<Adestrador> adestradorList) {
        this.adestradorList = adestradorList;
    }

    public List<Adestrador> getAdestradoresJson() {
        return adestradoresJson;
    }
    public void setAdestradoresJson(List<Adestrador> adestradoresJson) {
        this.adestradoresJson = adestradoresJson;
    }
}

