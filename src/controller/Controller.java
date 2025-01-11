package controller;

import model.Adestrador;
import model.Pokedex;
import model.Pokemon;
import model.clasewrapper.Adestradores;
import model.clasewrapper.Pokemons;
import service.crud.Crud;
import service.ficherosxmljson.WriteReadFilesXmlJson;
import service.metodosclases.MetodosAdestrador;
import service.metodosclases.MetodosPokedex;
import service.metodosclases.MetodosPokemon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Controladora que gestiona la lógica principal del programa.
 * Esta clase orquesta la interacción entre las clases de servicio, los modelos de datos y la manipulación de archivos.
 * Su función principal es insertar datos en las bases de datos, leer y escribir archivos XML y JSON,
 * y realizar diversas operaciones relacionadas con los Pokémon, entrenadores y la Pokédex.
 * @author cristian
 * @version 1.0
 */
public class Controller {

    /**
     * Lógica principal del programa que gestiona la inserción y lectura de datos,
     * así como la interacción con los archivos de configuración en formato XML y JSON.
     * Este metodo ejecuta la secuencia de operaciones que incluye la inserción de datos en la base de datos,
     * la lectura de la información almacenada, la escritura de archivos XML y JSON, y la eliminación de datos
     * de la base de datos después de realizar estas operaciones.
     */
    public void logicaPrograma(){
        MetodosPokedex metodosPokedex = new MetodosPokedex();
        MetodosAdestrador metodosAdestrador = new MetodosAdestrador();
        MetodosPokemon metodosPokemon = new MetodosPokemon();
        WriteReadFilesXmlJson wrdXmlJson = new WriteReadFilesXmlJson();
        Crud crud = new Crud();

        // Inserta datos iniciales en las bases de datos


        /*
        crud.insertar10PokemonsInPokedex(metodosPokedex.getPokemonsList());
        crud.insertar2AdestradoresInAdestrador(metodosAdestrador.getAdestradoresList());
        crud.insertar12PokemonsInPokemonDB(metodosPokemon.getPokemonList(crud.getPokedexFromDB(), crud.getAdestradorFromDB()));

        // Lee y escribe datos en archivos
        metodosPokemon.leerDatosPokemons(crud.getPokemonFromDB());
        metodosAdestrador.leerAdestradorList(crud.getAdestradorFromDB());
        wrdXmlJson.writeXmlFilePokemons(crud.getPokemonFromDB());
        wrdXmlJson.writeXmlFileAdestradores(crud.getAdestradorFromDB());
        wrdXmlJson.writeJsonFilePokemon(crud.getPokemonFromDB());
        wrdXmlJson.writeJsonFileAdestradores(crud.getAdestradorFromDB());

        */


        // Elimina datos de la base de datos
        //crud.deleteDataFromDb("DELETE FROM Pokemon");
        //crud.deleteDataFromDb("DELETE FROM Adestrador");

        // Lee los datos desde archivos XML y JSON

        Pokemons pokemonsJson = wrdXmlJson.readJsonFilePokemon();
        List<Pokemon> pokemonJsonList = wrdXmlJson.readListPokemonsJson(pokemonsJson);

        Adestradores adestradoresJson = wrdXmlJson.readJsonFileAdestrador();
        List<Adestrador> adestradorJsonList =  wrdXmlJson.readListAdestradoresJson(adestradoresJson);

        Pokemons pokemonsXml = wrdXmlJson.readXmlFilePokemon();
        List<Pokemon> pokemonXmlList = wrdXmlJson.readListPokemonsXml(pokemonsXml);

        Adestradores adestradoresXml = wrdXmlJson.readXmlFileAdestrador();
        List<Adestrador> adestradorXmlList = wrdXmlJson.readListAdestradorXml(adestradoresXml);





        /*
        // Inserta los datos leídos desde archivos en la base de datos
        crud.insertar2AdestradoresInAdestrador(pasoIntermedioIntroducirDatosAdestrador(adestradorXmlList));
        crud.insertar12PokemonsInPokemonDB(pasoIntermedioIntroducirDatosPokemon(pokemonXmlList, crud.getAdestradorFromDB(), crud.getPokedexFromDB()));

        //crud.insertar2AdestradoresInAdestrador(pasoIntermedioIntroducirDatosAdestrador(adestradorJsonList));
        //crud.insertar12PokemonsInPokemonDB(pasoIntermedioIntroducirDatosPokemon(pokemonJsonList, crud.getAdestradorFromDB(), crud.getPokedexFromDB()));


         */


    }


}
