package service.ficherosxmljson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.Adestrador;
import model.Pokemon;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class WriteReadFilesXmlJson {

    public void writeXmlFilePokemons(List<Pokemon> pokemonList) {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        try {
            File file = new File("pokemon.xml");
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(file, pokemonList);

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
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(file, adestradorList);
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
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, pokemonList);
            System.out.println("fichero de pokemon escrito correctamente en el json");
        }catch (IOException e){
            System.out.println("Ups, ha ocurrido un error al escribir en el fichero json de pokemon");
        }
    }


    public void writeJsonFileAdestradores(List<Adestrador> adestradorList){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try{
            File file = new File("adestrador.json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, adestradorList);
            System.out.println("fichero de adestradores escrito correctamente en el json");
        }catch (IOException e){
            System.out.println("Ups, error al escribir en el JSON de adestrador");
        }
    }

    public List<Pokemon> readXmlFilePokemon(){
        XmlMapper xmlMapper = new XmlMapper();

        try{
            return xmlMapper.readValue(new File("pokemon.xml"), xmlMapper.getTypeFactory().constructCollectionType(List.class, Pokemon.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
