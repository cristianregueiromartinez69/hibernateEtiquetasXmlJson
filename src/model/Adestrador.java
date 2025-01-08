package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "adestrador")
@JacksonXmlRootElement(localName = "adestrador")
@JsonRootName(value = "adestrador")
public class Adestrador {
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

    @OneToMany(mappedBy = "adestrador", fetch = FetchType.EAGER)
    @JacksonXmlElementWrapper(localName = "pokemons")
    @JacksonXmlProperty(localName = "pokemon")
    @JsonProperty("pokemons")
    @JsonManagedReference
    private Set<model.Pokemon> pokemons = new LinkedHashSet<>();

    public Adestrador(Integer id, String nome, LocalDate nacemento, Set<Pokemon> pokemons) {
        this.id = id;
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokemons = pokemons;
    }

    public Adestrador(LocalDate nacemento, String nome) {
        this.nacemento = nacemento;
        this.nome = nome;
    }

    public Adestrador(String nome, LocalDate nacemento, Set<Pokemon> pokemons) {
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokemons = pokemons;
    }

    public Adestrador() {
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

    public Set<model.Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<model.Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("\nAdestrador:")
                .append("\nId: ").append(id)
                .append("\nNome: ").append(nome)
                .append("\nNacemento: ").append(nacemento)
                .append("\npokemons:").append(pokemons);

        if (pokemons != null) {
            sb.append("\nPokemon:")
                    .append("\nId: ").append(id)
                    .append("\nNome: ").append(nome)
                    .append("\nNacemento: ").append(nacemento);
        } else {
            sb.append("Null");
        }

        return sb.toString();
    }
}