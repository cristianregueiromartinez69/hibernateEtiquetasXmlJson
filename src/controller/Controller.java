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

        // Elimina datos de la base de datos
        crud.deleteDataFromDb("DELETE FROM Pokemon");
        crud.deleteDataFromDb("DELETE FROM Adestrador");

        // Lee los datos desde archivos XML y JSON
        Pokemons pokemonsJson = wrdXmlJson.readJsonFilePokemon();
        List<Pokemon> pokemonJsonList = wrdXmlJson.readListPokemonsJson(pokemonsJson);

        Adestradores adestradoresJson = wrdXmlJson.readJsonFileAdestrador();
        List<Adestrador> adestradorJsonList =  wrdXmlJson.readListAdestradoresJson(adestradoresJson);

        Pokemons pokemonsXml = wrdXmlJson.readXmlFilePokemon();
        List<Pokemon> pokemonXmlList = wrdXmlJson.readListPokemonsXml(pokemonsXml);

        Adestradores adestradoresXml = wrdXmlJson.readXmlFileAdestrador();
        List<Adestrador> adestradorXmlList = wrdXmlJson.readListAdestradorXml(adestradoresXml);

        // Inserta los datos leídos desde archivos en la base de datos
        crud.insertar2AdestradoresInAdestrador(pasoIntermedioIntroducirDatosAdestrador(adestradorXmlList));
        crud.insertar12PokemonsInPokemonDB(pasoIntermedioIntroducirDatosPokemon(pokemonXmlList, crud.getAdestradorFromDB(), crud.getPokedexFromDB()));

        //crud.insertar2AdestradoresInAdestrador(pasoIntermedioIntroducirDatosAdestrador(adestradorJsonList));
        //crud.insertar12PokemonsInPokemonDB(pasoIntermedioIntroducirDatosPokemon(pokemonJsonList, crud.getAdestradorFromDB(), crud.getPokedexFromDB()));



    }

    /**
     * Realiza un proceso intermedio para introducir los datos de los adestradores
     * en la base de datos.
     *
     * @param adestradorList Lista de entrenadores (Adestradores) que se van a procesar.
     * @return Una nueva lista de entrenadores procesados.
     */
    public List<Adestrador> pasoIntermedioIntroducirDatosAdestrador(List<Adestrador> adestradorList){
       List<Adestrador> newAdestradoresList = new ArrayList<>();
       for(Adestrador ad: adestradorList){
           newAdestradoresList.add(new Adestrador(ad.getNacemento(), ad.getNome()));
       }
       return newAdestradoresList;
    }

    /**
     * Realiza un proceso intermedio para introducir los datos de los pokémons
     * en la base de datos.
     *
     * @param pokemonList Lista de Pokémon que se van a procesar.
     * @param adestradorList Lista de entrenadores a asociar con los Pokémon.
     * @param pokedexList Lista de Pokédex a asociar con los Pokémon.
     * @return Una lista de Pokémon procesados y asociados a entrenadores y Pokédex.
     */
    public List<Pokemon> pasoIntermedioIntroducirDatosPokemon(List<Pokemon> pokemonList, List<Adestrador> adestradorList, List<Pokedex> pokedexList){
        List<Pokemon> pokemons = new ArrayList<>();
        Pokemon pokemon1 = new Pokemon(pokemonList.getFirst().getNome(), pokemonList.getFirst().getNacemento(), pokedexList.getFirst(), adestradorList.getFirst());
        Pokemon pokemon2 = new Pokemon(pokemonList.get(1).getNome(), pokemonList.get(1).getNacemento(), pokedexList.get(1),  adestradorList.getFirst());
        Pokemon pokemon3 = new Pokemon(pokemonList.get(2).getNome(), pokemonList.get(2).getNacemento(), pokedexList.get(2),  adestradorList.getFirst());
        Pokemon pokemon4 = new Pokemon(pokemonList.get(3).getNome(), pokemonList.get(3).getNacemento(), pokedexList.get(3),  adestradorList.getFirst());
        Pokemon pokemon5 = new Pokemon(pokemonList.get(4).getNome(), pokemonList.get(4).getNacemento(), pokedexList.get(4),  adestradorList.getFirst());
        Pokemon pokemon6 = new Pokemon(pokemonList.get(5).getNome(), pokemonList.get(5).getNacemento(), pokedexList.get(5),  adestradorList.getFirst());
        Pokemon pokemon7 = new Pokemon(pokemonList.get(6).getNome(), pokemonList.get(6).getNacemento(), pokedexList.get(6), adestradorList.get(1));
        Pokemon pokemon8 = new Pokemon(pokemonList.get(7).getNome(), pokemonList.get(7).getNacemento(), pokedexList.get(7), adestradorList.get(1));
        Pokemon pokemon9 = new Pokemon(pokemonList.get(8).getNome(), pokemonList.get(8).getNacemento(), pokedexList.get(8), adestradorList.get(1));
        Pokemon pokemon10 = new Pokemon(pokemonList.get(9).getNome(), pokemonList.get(9).getNacemento(), pokedexList.get(9), adestradorList.get(1));
        Pokemon pokemon11 = new Pokemon(pokemonList.get(10).getNome(), pokemonList.get(10).getNacemento(), null, adestradorList.get(1));
        Pokemon pokemon12 = new Pokemon(pokemonList.get(11).getNome(), pokemonList.get(11).getNacemento(), null, adestradorList.get(1));

        pokemons.add(pokemon1);
        pokemons.add(pokemon2);
        pokemons.add(pokemon3);
        pokemons.add(pokemon4);
        pokemons.add(pokemon5);
        pokemons.add(pokemon6);
        pokemons.add(pokemon7);
        pokemons.add(pokemon8);
        pokemons.add(pokemon9);
        pokemons.add(pokemon10);
        pokemons.add(pokemon11);
        pokemons.add(pokemon12);

       return pokemons;
    }
}
