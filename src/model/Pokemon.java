package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pokemon")
@JacksonXmlRootElement(localName = "pokemon")
@JsonRootName(value = "pokemon")
public class Pokemon {

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

    @Column(name = "nacemento")
    @JacksonXmlProperty(localName = "nacemento")
    @JsonProperty("nacemento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate nacemento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokedexentry")
    @JacksonXmlProperty(localName = "pokedexEntry")
    @JsonProperty("poedex_entry")
    @JsonManagedReference
    private Pokedex pokedexentry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adestrador")
    @JacksonXmlProperty(localName = "adestrador")
    @JsonProperty("adestrador")
    @JsonManagedReference
    private Adestrador adestrador;

    public Pokemon(Integer id, String nome, LocalDate nacemento, Pokedex pokedexentry, Adestrador adestrador) {
        this.id = id;
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokedexentry = pokedexentry;
        this.adestrador = adestrador;
    }


    public Pokemon(String nome, LocalDate nacemento, Pokedex pokedexentry) {
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokedexentry = pokedexentry;
    }

    public Pokemon(String nome, LocalDate nacemento, Pokedex pokedexentry, Adestrador adestrador) {
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokedexentry = pokedexentry;
        this.adestrador = adestrador;
    }

    public Pokemon() {
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

    public LocalDate getNacemento() {
        return nacemento;
    }

    public void setNacemento(LocalDate nacemento) {
        this.nacemento = nacemento;
    }

    public Pokedex getPokedexentry() {
        return pokedexentry;
    }

    public void setPokedexentry(Pokedex pokedexentry) {
        this.pokedexentry = pokedexentry;
    }

    public Adestrador getAdestrador() {
        return adestrador;
    }

    public void setAdestrador(Adestrador adestrador) {
        this.adestrador = adestrador;
    }


    @Override
    public String toString() {
        return "\nPokemon: " +
                "\nid: " + id +
                "\nnome: " + nome  +
                "\nnacemento: " + nacemento +
                "\npokedexentry: " + (pokedexentry != null ? pokedexentry.getId() + " - " + pokedexentry.getNome() : "") +
        "\nadestrador: " + (adestrador != null ? adestrador.getId() + " - " + adestrador.getNome() : "");
    }
}