package model.clasewrapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import model.Pokemon;

import java.util.List;

public class Pokemons {
    @JacksonXmlElementWrapper(localName = "pokemons")
    @JacksonXmlProperty(localName = "pokemon")
    private List<Pokemon> pokemons;

    private List<Pokemon> pokemonsJson;

    public Pokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

   public Pokemons() {

   }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }


    public void setPokemonsJson(List<Pokemon> pokemonsJson) {
        this.pokemonsJson = pokemonsJson;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @JsonProperty("pokemonsJson")
    public List<Pokemon> getPokemonsJson() {
        return pokemonsJson;
    }
}
