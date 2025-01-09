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

public class WriteReadFilesXmlJson {

    public void writeXmlFilePokemons(List<Pokemon> pokemonList) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        try {
            File file = new File("pokemon.xml");
            Pokemons pokemons = new Pokemons(pokemonList);
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(file, pokemons);

            System.out.println("Pokemons escritos correctamente en el fiochero xml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void writeXmlFileAdestradores(List<Adestrador> adestradorList) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        try {
            File file = new File("adestrador.xml");
            Adestradores adestradores = new Adestradores(adestradorList);
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(file, adestradores);
            System.out.println("adestradores escritos correctamente en el fichero xml");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

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
            e.printStackTrace();
        }
    }


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
            System.out.println("Ups, error al escribir en el JSON de adestrador");
        }
    }

    public Pokemons readXmlFilePokemon(){
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        try{
            return xmlMapper.readValue(new File("pokemon.xml"), Pokemons.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Adestradores readXmlFileAdestrador(){
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        try{
            return xmlMapper.readValue(new File("adestrador.xml"), Adestradores.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Pokemons readJsonFilePokemon(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try{
            return objectMapper.readValue(new File("pokemon.json"), Pokemons.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Adestradores readJsonFileAdestrador(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try{
            return objectMapper.readValue(new File("adestrador.json"), Adestradores.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Adestrador> readListAdestradoresJson(Adestradores adestradores){
        return adestradores.getAdestradoresJson();
    }

    public List<Pokemon> readListPokemonsJson(Pokemons pokemons){
        return pokemons.getPokemonsJson();
    }

    public List<Adestrador> readListAdestradorXml(Adestradores adestradores){
        return adestradores.getAdestradorList();
    }

    public List<Pokemon> readListPokemonsXml(Pokemons pokemons){
        return pokemons.getPokemons();
    }





}
