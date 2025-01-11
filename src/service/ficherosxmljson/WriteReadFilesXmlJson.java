package service.ficherosxmljson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.Adestrador;
import model.Pokemon;
import model.clasewrapper.Adestradores;
import model.clasewrapper.Pokemons;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * La clase <code>WriteReadFilesXmlJson</code> proporciona métodos para leer y escribir archivos en formatos XML y JSON.
 * Los archivos contienen listas de objetos <code>Pokemon</code> y <code>Adestrador</code>, y los métodos gestionan
 * tanto la serialización como la deserialización de los datos.
 * @author cristian
 * @version 1.0
 */
public class WriteReadFilesXmlJson {


    /**
     * Escribe una lista de objetos <code>Pokemon</code> en un archivo XML.
     *
     * @param pokemonList Lista de objetos <code>Pokemon</code> a escribir en el archivo XML.
     */
    public void writeXmlFilePokemons(List<Pokemon> pokemonList) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        try {
            File file = new File("pokemon.xml");
            Pokemons pokemons = new Pokemons(pokemonList);
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(file, pokemons);

            System.out.println("Pokemons escritos correctamente en el fichero xml");
        } catch (IOException ex) {
            System.out.println("Ups, ha ocurrido un error al escribir el fichero xml de pokemons");
            //ex.printStackTrace(); Lo uso para mirar los errores que puede dar
        }

    }

    /**
     * Escribe una lista de objetos <code>Adestrador</code> en un archivo XML.
     *
     * @param adestradorList Lista de objetos <code>Adestrador</code> a escribir en el archivo XML.
     */
    public void writeXmlFileAdestradores(List<Adestrador> adestradorList) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        try {
            File file = new File("adestrador.xml");
            Adestradores adestradores = new Adestradores(adestradorList);
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(file, adestradores);
            System.out.println("adestradores escritos correctamente en el fichero xml");
        } catch (IOException ex) {
            System.out.println("Ups, ha ocurrido un error al escribir el fichero xml de adestradores");
            //ex.printStackTrace(); Lo uso para comprobar errores
        }

    }

    /**
     * Escribe una lista de objetos <code>Pokemon</code> en un archivo JSON.
     *
     * @param pokemonList Lista de objetos <code>Pokemon</code> a escribir en el archivo JSON.
     */
    public void writeJsonFilePokemon(List<Pokemon> pokemonList){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try{
            File file = new File("pokemon.json");
            Pokemons pokemons = new Pokemons();
            pokemons.setPokemonsJson(pokemonList);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, pokemons);
            System.out.println("fichero de pokemon escrito correctamente en el json");
        }catch (IOException e){
            System.out.println("Ups, ha ocurrido un error al escribir el fichero json de pokemons");
            //ex.printStackTrace(); Lo uso para comprobar errores
        }
    }


    /**
     * Escribe una lista de objetos <code>Adestrador</code> en un archivo JSON.
     *
     * @param adestradorList Lista de objetos <code>Adestrador</code> a escribir en el archivo JSON.
     */
    public void writeJsonFileAdestradores(List<Adestrador> adestradorList){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try{
            File file = new File("adestrador.json");
            Adestradores adestradores = new Adestradores();
            adestradores.setAdestradoresJson(adestradorList);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, adestradores);
            System.out.println("fichero de adestradores escrito correctamente en el json");
        }catch (IOException e){
            System.out.println("Ups, ha ocurrido un error al escribir el fichero json de adestradores");
            //ex.printStackTrace(); Lo uso para comprobar errores
        }
    }

    /**
     * Lee el archivo XML que contiene una lista de objetos <code>Pokemon</code> y lo convierte en un objeto <code>Pokemons</code>.
     *
     * @return El objeto <code>Pokemons</code> con la lista de objetos <code>Pokemon</code> leída del archivo XML.
     */
    public Pokemons readXmlFilePokemon(){
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        try{
            return xmlMapper.readValue(new File("pokemon.xml"), Pokemons.class);
        } catch (IOException e) {
            System.out.println("Ups, ha ocurrido un error al leer el fichero xml de pokemons");
            //ex.printStackTrace(); Lo uso para comprobar errores
        }
        return null;
    }

    /**
     * Lee el archivo XML que contiene una lista de objetos <code>Adestrador</code> y lo convierte en un objeto <code>Adestradores</code>.
     *
     * @return El objeto <code>Adestradores</code> con la lista de objetos <code>Adestrador</code> leída del archivo XML.
     */
    public Adestradores readXmlFileAdestrador(){
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        try{
            return xmlMapper.readValue(new File("adestrador.xml"), Adestradores.class);
        } catch (IOException e) {
            System.out.println("Ups, ha ocurrido un error al leer el fichero xml de adestradores");
            //ex.printStackTrace(); Lo uso para comprobar errores
        }
        return null;
    }

    /**
     * Lee el archivo JSON que contiene una lista de objetos <code>Pokemon</code> y lo convierte en un objeto <code>Pokemons</code>.
     *
     * @return El objeto <code>Pokemons</code> con la lista de objetos <code>Pokemon</code> leída del archivo JSON.
     */
    public Pokemons readJsonFilePokemon(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try{
            return objectMapper.readValue(new File("pokemon.json"), Pokemons.class);
        } catch (IOException e) {
            System.out.println("Ups, ha ocurrido un error al leer el fichero json de pokemons");
            //ex.printStackTrace(); Lo uso para comprobar errores
        }
        return null;
    }

    /**
     * Lee el archivo JSON que contiene una lista de objetos <code>Adestrador</code> y lo convierte en un objeto <code>Adestradores</code>.
     *
     * @return El objeto <code>Adestradores</code> con la lista de objetos <code>Adestrador</code> leída del archivo JSON.
     */
    public Adestradores readJsonFileAdestrador(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try{
            return objectMapper.readValue(new File("adestrador.json"), Adestradores.class);
        } catch (IOException e) {
            System.out.println("Ups, ha ocurrido un error al leer el fichero json de adestradores");
            //ex.printStackTrace(); Lo uso para comprobar errores
        }
        return null;
    }

    /**
     * Extrae la lista de objetos <code>Adestrador</code> de un objeto <code>Adestradores</code>.
     *
     * @param adestradores El objeto <code>Adestradores</code> del cual extraer la lista de <code>Adestrador</code>.
     * @return La lista de objetos <code>Adestrador</code>.
     */
    public List<Adestrador> readListAdestradoresJson(Adestradores adestradores){
        return adestradores.getAdestradoresJson();
    }

    /**
     * Extrae la lista de objetos <code>Pokemon</code> de un objeto <code>Pokemons</code>.
     *
     * @param pokemons El objeto <code>Pokemons</code> del cual extraer la lista de <code>Pokemon</code>.
     * @return La lista de objetos <code>Pokemon</code>.
     */
    public List<Pokemon> readListPokemonsJson(Pokemons pokemons){
        return pokemons.getPokemonsJson();
    }

    /**
     * Extrae la lista de objetos <code>Adestrador</code> de un objeto <code>Adestradores</code>.
     *
     * @param adestradores El objeto <code>Adestradores</code> del cual extraer la lista de <code>Adestrador</code>.
     * @return La lista de objetos <code>Adestrador</code>.
     */
    public List<Adestrador> readListAdestradorXml(Adestradores adestradores){
        return adestradores.getAdestradorList();
    }

    /**
     * Extrae la lista de objetos <code>Pokemon</code> de un objeto <code>Pokemons</code>.
     *
     * @param pokemons El objeto <code>Pokemons</code> del cual extraer la lista de <code>Pokemon</code>.
     * @return La lista de objetos <code>Pokemon</code>.
     */
    public List<Pokemon> readListPokemonsXml(Pokemons pokemons){
        return pokemons.getPokemons();
    }





}
