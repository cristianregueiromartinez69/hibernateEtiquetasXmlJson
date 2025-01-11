package model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Representa una entidad de la base de datos correspondiente a una entrada en la "Pokedex".
 * Contiene información sobre el nombre, peso y otros detalles de una pokedex.
 * Esta clase también mapea las relaciones con los pokemons que están asociados con esta Pokedex.
 * Los datos se pueden serializar/deserializar en formato XML y JSON.
 * @author cristian
 * @version 1.0
 */
@Entity
@Table(name = "pokedex")
@JacksonXmlRootElement(localName = "Pokedex")
@JsonRootName(value = "pokedex")
public class Pokedex {

    /**
     * Identificador único de la pokedex.
     * Este campo es generado automáticamente por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    @JsonProperty("id")
    @JsonIgnore
    private Integer id;

    /**
     * Nombre del pokemon en la pokedex.
     * Este campo es obligatorio y tiene una longitud máxima de 50 caracteres.
     */
    @Column(name = "nome", nullable = false, length = 50)
    @JacksonXmlProperty(localName = "nome")
    @JsonProperty("nome")
    private String nome;

    /**
     * Peso de del pokemon de la pokedex, representado como un número decimal.
     * Tiene una precisión de 10 dígitos y 2 decimales.
     */
    @Column(name = "peso", precision = 10, scale = 2)
    @JacksonXmlProperty(localName = "peso")
    @JsonProperty("peso")
    private BigDecimal peso;

    /**
     * Información adicional sobre el pokemon de la pokedex.
     * Este campo puede contener texto libre y es almacenado como texto.
     */
    @Column(name = "misc")
    @Type(type = "org.hibernate.type.TextType")
    @JacksonXmlProperty(localName = "misc")
    @JsonProperty("misc")
    private String misc;

    /**
     * Relación con los pokemons que están asociados a esta pokedex.
     * Se utiliza la carga anticipada (EAGER) para obtener todos los pokemons al acceder a la pokedex.
     */
    @OneToMany(mappedBy = "pokedexentry", fetch = FetchType.EAGER)
    @JsonManagedReference("pokemons")
    @JacksonXmlElementWrapper(localName = "pokemons")
    @JacksonXmlProperty(localName = "pokemon")
    @JsonProperty("pokemons")
    private Set<Pokemon> pokemons;

    /**
     * Constructor completo para crear una instancia de Pokedex con todos los atributos.
     *
     * @param id      Identificador de la pokedex.
     * @param nome    Nombre de la pokedex.
     * @param peso    Peso de la pokedex.
     * @param misc    Información adicional de la pokedex.
     * @param pokemons Conjunto de pokemons asociados a esta pokedex.
     */
    public Pokedex(Integer id, String nome, BigDecimal peso, String misc, Set<Pokemon> pokemons) {
        this.id = id;
        this.nome = nome;
        this.peso = peso;
        this.misc = misc;
        this.pokemons = pokemons;
    }

    /**
     * Constructor para crear una instancia de Pokedex sin los pokemons asociados.
     *
     * @param nome Nombre de la pokedex.
     * @param peso Peso de la pokedex.
     * @param misc Información adicional de la pokedex.
     */
    public Pokedex(String nome, BigDecimal peso, String misc) {
        this.nome = nome;
        this.peso = peso;
        this.misc = misc;
    }


    /**
     * Constructor para crear una instancia de Pokedex con los pokemons asociados.
     *
     * @param nome    Nombre de la pokedex.
     * @param peso    Peso de la pokedex.
     * @param misc    Información adicional de la pokedex.
     * @param pokemons Conjunto de pokemons asociados a esta pokedex.
     */
    public Pokedex(String nome, BigDecimal peso, String misc, Set<Pokemon> pokemons) {
        this.nome = nome;
        this.peso = peso;
        this.misc = misc;
        this.pokemons = pokemons;
    }

    //constructor vacío
    public Pokedex() {
    }

    /**
     * Getter y setter de la clase
     * @return los atributos correspondientes
     */
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

    /**
     * Genera una representación en cadena (String) de la instancia de Pokedex.
     * @return Cadena con la información de la pokedex.
     */
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