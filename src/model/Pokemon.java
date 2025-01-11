package model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;
import java.time.LocalDate;


/**
 * La clase {@code Pokemon} representa un Pokémon en el sistema, almacenando su información básica,
 * incluyendo su identificador, nombre, fecha de nacimiento, y las relaciones con la Pokedex y el adestrador
 * al que pertenece.
 * @author cristian
 * @version 1.0
 */
@Entity
@Table(name = "pokemon")
@JacksonXmlRootElement(localName = "pokemon")
@JsonRootName(value = "pokemon")
public class Pokemon {

    /**
     * El identificador único del Pokémon.
     * Este campo está marcado como la clave primaria de la tabla.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    @JsonProperty("id")
    @JsonIgnore
    private Integer id;

    /**
     * El nombre del Pokémon.
     * Este campo es obligatorio y no puede ser nulo.
     */
    @Column(name = "nome", nullable = false, length = 50)
    @JacksonXmlProperty(localName = "nome")
    @JsonProperty("nome")
    private String nome;

    /**
     * La fecha de nacimiento del Pokémon.
     * Se utiliza para representar la fecha en formato {@code yyyy-MM-dd}.
     */
    @Column(name = "nacemento")
    @JacksonXmlProperty(localName = "nacemento")
    @JsonProperty("nacemento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate nacemento;

    /**
     * La Pokedex a la que pertenece el Pokémon.
     * Relación Many-to-One con la entidad {@link Pokedex}.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pokedexentry")
    @JacksonXmlProperty(localName = "pokedexEntry")
    @JsonProperty("pokedex_entry")
    @JsonManagedReference
    private Pokedex pokedexentry;

    /**
     * El adestrador (entrenador) del Pokémon.
     * Relación Many-to-One con la entidad {@link Adestrador}.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "adestrador")
    @JacksonXmlProperty(localName = "adestrador")
    @JsonProperty("adestrador")
    @JsonManagedReference
    private Adestrador adestrador;

    /**
     * Constructor con todos los parámetros.
     *
     * @param id El identificador único del Pokémon.
     * @param nome El nombre del Pokémon.
     * @param nacemento La fecha de nacimiento del Pokémon.
     * @param pokedexentry La Pokedex a la que pertenece el Pokémon.
     * @param adestrador El adestrador del Pokémon.
     */
    public Pokemon(Integer id, String nome, LocalDate nacemento, Pokedex pokedexentry, Adestrador adestrador) {
        this.id = id;
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokedexentry = pokedexentry;
        this.adestrador = adestrador;
    }


    /**
     * Constructor sin el identificador del Pokémon.
     *
     * @param nome El nombre del Pokémon.
     * @param nacemento La fecha de nacimiento del Pokémon.
     * @param pokedexentry La Pokedex a la que pertenece el Pokémon.
     */
    public Pokemon(String nome, LocalDate nacemento, Pokedex pokedexentry) {
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokedexentry = pokedexentry;
    }

    /**
     * Constructor sin el identificador y sin el adestrador del Pokémon.
     *
     * @param nome El nombre del Pokémon.
     * @param nacemento La fecha de nacimiento del Pokémon.
     */
    public Pokemon(String nome, LocalDate nacemento) {
        this.nome = nome;
        this.nacemento = nacemento;
    }

    /**
     * Constructor sin el identificador del Pokémon.
     *
     * @param nome El nombre del Pokémon.
     * @param nacemento La fecha de nacimiento del Pokémon.
     * @param pokedexentry La Pokedex a la que pertenece el Pokémon.
     * @param adestrador El adestrador del Pokémon.
     */
    public Pokemon(String nome, LocalDate nacemento, Pokedex pokedexentry, Adestrador adestrador) {
        this.nome = nome;
        this.nacemento = nacemento;
        this.pokedexentry = pokedexentry;
        this.adestrador = adestrador;
    }

    //constructor vacío
    public Pokemon() {
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


    /**
     * Devuelve una representación en cadena del objeto {@code Pokemon}.
     *
     * @return Una representación en cadena del Pokémon, incluyendo información de su Pokedex y adestrador.
     */
    @Override
    public String toString() {
        return "\nPokemon: " +
                "\nId: " + id +
                "\nNombre: " + nome +
                "\nNacemento: " + nacemento +
                "\nEntrada en la pokedex: " + pokedexentry +
                "\nInformación del adestrador: " + adestrador;
    }

}