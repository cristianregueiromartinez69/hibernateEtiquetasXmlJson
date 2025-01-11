package model.clasewrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import model.Pokemon;

import java.util.List;

/**
 * Esta clase sirve como contenedor para una lista de objetos Pokemon.
 * Se utiliza para manejar los datos de los pokemons en formatos XML y JSON.
 * Las anotaciones de Jackson permiten la serialización y deserialización de estos objetos a los respectivos formatos.
 * @author cristian
 * @version 1.0
 */
public class Pokemons {

    /**
     * Lista de pokemons, que se utiliza para la serialización y deserialización en formato XML.
     */
    @JacksonXmlElementWrapper(localName = "pokemons")
    @JacksonXmlProperty(localName = "pokemon")
    private List<Pokemon> pokemons;

    /**
     * Lista de pokemons, que se utiliza para la serialización y deserialización en formato JSON.
     */
    private List<Pokemon> pokemonsJson;

    /**
     * Constructor que inicializa la lista de pokemons.
     *
     * @param pokemons la lista de pokemons a ser asignada.
     */
    public Pokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    /**
     * Constructor vacío que permite la creación de una instancia sin inicializar las listas.
     */
   public Pokemons() {

   }

    /**
     * Getter y setter de la clase
     * @param pokemons los atributos correspondientes
     */
    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }


    public void setPokemonsJson(List<Pokemon> pokemonsJson) {
        this.pokemonsJson = pokemonsJson;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    /**
     * Obtiene la lista de pokemons para ser utilizada con JSON.
     *
     * @return la lista de pokemons en formato JSON.
     */
    @JsonProperty("pokemonsJson")
    public List<Pokemon> getPokemonsJson() {
        return pokemonsJson;
    }
}
