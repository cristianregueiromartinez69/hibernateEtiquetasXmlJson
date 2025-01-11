package model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Clase que representa a un adestrador (entrenador) de pokemons.
 * Esta clase está mapeada a una tabla en la base de datos y permite la
 * serialización y deserialización de los datos en formato XML y JSON.
 * @author cristian
 * @version 1.0
 */
@Entity
@Table(name = "adestrador")
@JacksonXmlRootElement(localName = "adestrador")
@JsonRootName(value = "adestrador")
public class Adestrador {

    /**
     * Identificador único del adestrador. Es generado automáticamente por la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    @JsonProperty("id")
    @JsonIgnore
    private Integer id;

    /**
     * Nombre del adestrador.
     */
    @Column(name = "nome", nullable = false, length = 50)
    @JacksonXmlProperty(localName = "nome")
    @JsonProperty("nome")
    private String nome;

    /**
     * Fecha de nacimiento del adestrador.
     */
    @Column(name = "nacemento")
    @JacksonXmlProperty(localName = "nacemento")
    @JsonProperty("nacemento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate nacemento;

    /**
     * Conjunto de pokemons asociados al adestrador.
     * Se obtiene mediante la relación de uno a muchos con la entidad  Pokemon.
     */
    @OneToMany(mappedBy = "adestrador", fetch = FetchType.EAGER)
    @JsonManagedReference("pokemons")
    @JacksonXmlElementWrapper(localName = "pokemons")
    @JacksonXmlProperty(localName = "pokemon")
    @JsonProperty("pokemons")
    private Set<Pokemon> pokemons;


    /**
     * Constructor que inicializa el adestrador con todos los campos.
     *
     * @param id       el identificador único del adestrador.
     * @param nome     el nombre del adestrador.
     * @param nacemento la fecha de nacimiento del adestrador.
     * @param pokemons el conjunto de pokemons asociados al adestrador.
     */
    public Adestrador(Integer id, String nome, LocalDate nacemento, Set<Pokemon> pokemons) {
        this.id = id;
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokemons = pokemons;
    }


    /**
     * Constructor que inicializa el adestrador con nombre y fecha de nacimiento.
     *
     * @param nacemento la fecha de nacimiento del adestrador.
     * @param nome      el nombre del adestrador.
     */
    public Adestrador(LocalDate nacemento, String nome) {
        this.nacemento = nacemento;
        this.nome = nome;
    }

    /**
     * Constructor que inicializa el adestrador con nombre, fecha de nacimiento
     * y conjunto de pokemons.
     *
     * @param nome     el nombre del adestrador.
     * @param nacemento la fecha de nacimiento del adestrador.
     * @param pokemons el conjunto de pokemons asociados al adestrador.
     */
    public Adestrador(String nome, LocalDate nacemento, Set<Pokemon> pokemons) {
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokemons = pokemons;
    }

    //constructor vacío
    public Adestrador() {
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

    /**
     * Representación en forma de cadena del objeto Adestrador.
     * Incluye la información del adestrador y sus pokemons asociados.
     * @return una cadena con la representación del adestrador y sus pokemons.
     */
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