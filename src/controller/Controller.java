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

public class Controller {

    public void logicaPrograma(){
        MetodosPokedex metodosPokedex = new MetodosPokedex();
        MetodosAdestrador metodosAdestrador = new MetodosAdestrador();
        MetodosPokemon metodosPokemon = new MetodosPokemon();
        WriteReadFilesXmlJson wrdXmlJson = new WriteReadFilesXmlJson();
        Crud crud = new Crud();

        crud.insertar10PokemonsInPokedex(metodosPokedex.getPokemonsList());
        crud.insertar2AdestradoresInAdestrador(metodosAdestrador.getAdestradoresList());
        crud.insertar12PokemonsInPokemonDB(metodosPokemon.getPokemonList(crud.getPokedexFromDB(), crud.getAdestradorFromDB()));

        metodosPokemon.leerDatosPokemons(crud.getPokemonFromDB());
        metodosAdestrador.leerAdestradorList(crud.getAdestradorFromDB());
        wrdXmlJson.writeXmlFilePokemons(crud.getPokemonFromDB());
        wrdXmlJson.writeXmlFileAdestradores(crud.getAdestradorFromDB());
        wrdXmlJson.writeJsonFilePokemon(crud.getPokemonFromDB());
        wrdXmlJson.writeJsonFileAdestradores(crud.getAdestradorFromDB());
        crud.deleteDataFromDb("DELETE FROM Pokemon");
        crud.deleteDataFromDb("DELETE FROM Adestrador");


        Pokemons pokemonsJson = wrdXmlJson.readJsonFilePokemon();
        List<Pokemon> pokemonJsonList = wrdXmlJson.readListPokemonsJson(pokemonsJson);

        Adestradores adestradoresJson = wrdXmlJson.readJsonFileAdestrador();
        List<Adestrador> adestradorJsonList =  wrdXmlJson.readListAdestradoresJson(adestradoresJson);

        Pokemons pokemonsXml = wrdXmlJson.readXmlFilePokemon();
        List<Pokemon> pokemonXmlList = wrdXmlJson.readListPokemonsXml(pokemonsXml);

        Adestradores adestradoresXml = wrdXmlJson.readXmlFileAdestrador();
        List<Adestrador> adestradorXmlList = wrdXmlJson.readListAdestradorXml(adestradoresXml);


        crud.insertar2AdestradoresInAdestrador(pasoIntermedioIntroducirDatosAdestrador(adestradorXmlList));
        crud.insertar12PokemonsInPokemonDB(pasoIntermedioIntroducirDatosPokemon(pokemonXmlList, crud.getAdestradorFromDB(), crud.getPokedexFromDB()));

        //crud.insertar2AdestradoresInAdestrador(pasoIntermedioIntroducirDatosAdestrador(adestradorJsonList));
        //crud.insertar12PokemonsInPokemonDB(pasoIntermedioIntroducirDatosPokemon(pokemonJsonList, crud.getAdestradorFromDB(), crud.getPokedexFromDB()));



    }


    public List<Adestrador> pasoIntermedioIntroducirDatosAdestrador(List<Adestrador> adestradorList){
       List<Adestrador> newAdestradoresList = new ArrayList<>();
       for(Adestrador ad: adestradorList){
           newAdestradoresList.add(new Adestrador(ad.getNacemento(), ad.getNome()));
       }
       return newAdestradoresList;
    }

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
