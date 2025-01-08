package model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pokedex")
@JacksonXmlRootElement(localName = "Pokedex")
@JsonRootName(value = "pokedex")
public class Pokedex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    @JsonProperty("id")
    private Integer id;

    @Column(name = "nome", nullable = false, length = 50)
    @JacksonXmlProperty(localName = "nome")
    @JsonProperty("nome")
    private String nome;

    @Column(name = "peso", precision = 10, scale = 2)
    @JacksonXmlProperty(localName = "peso")
    @JsonProperty("peso")
    private BigDecimal peso;

    @Column(name = "misc")
    @Type(type = "org.hibernate.type.TextType")
    @JacksonXmlProperty(localName = "misc")
    @JsonProperty("misc")
    private String misc;

    @OneToMany(mappedBy = "pokedexentry", fetch = FetchType.EAGER)
    @JacksonXmlElementWrapper(localName = "pokemons")
    @JacksonXmlProperty(localName = "pokemon")
    @JsonProperty("pokemons")
    @JsonManagedReference
    private Set<model.Pokemon> pokemons = new LinkedHashSet<>();

    public Pokedex(Integer id, String nome, BigDecimal peso, String misc, Set<Pokemon> pokemons) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.misc = misc;
        this.pokemons = pokemons;
    }

    public Pokedex(String nome, BigDecimal peso, String misc) {
        this.nome = nome;
        this.peso = peso;
        this.misc = misc;
    }

    public Pokedex(String nome, BigDecimal peso, String misc, Set<Pokemon> pokemons) {
        this.nome = nome;
        this.peso = peso;
        this.misc = misc;
        this.pokemons = pokemons;
    }

    public Pokedex() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getMisc() {
        return misc;
    }

    public void setMisc(String misc) {
        this.misc = misc;
    }

    public Set<model.Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<model.Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {
        return "\nPokedex: " +
                "\nid: " + id +
                "\nnome: " + nome +
                "\npeso: " + peso +
                "\nmisc: " + misc  +
                "\npokemons: " + pokemons;
    }
}