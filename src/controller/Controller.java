package controller;

import model.Adestrador;
import service.crud.Crud;
import service.ficherosxmljson.WriteReadFilesXmlJson;
import service.metodosclases.MetodosAdestrador;
import service.metodosclases.MetodosPokedex;
import service.metodosclases.MetodosPokemon;

import java.util.List;

public class Controller {

    public void logicaPrograma(){
        MetodosPokedex metodosPokedex = new MetodosPokedex();
        MetodosAdestrador metodosAdestrador = new MetodosAdestrador();
        MetodosPokemon metodosPokemon = new MetodosPokemon();
        WriteReadFilesXmlJson wrdXmlJson = new WriteReadFilesXmlJson();
        Crud crud = new Crud();

        //crud.insertar10PokemonsInPokedex(metodosPokedex.getPokemonsList());
        //crud.insertar2AdestradoresInAdestrador(metodosAdestrador.getAdestradoresList());
        //crud.insertar12PokemonsInPokemonDB(metodosPokemon.getPokemonList(crud.getPokedexFromDB(), crud.getAdestradorFromDB()));

        //metodosPokemon.leerDatosPokemons(crud.getPokemonFromDB());
        //metodosAdestrador.leerAdestradorList(crud.getAdestradorFromDB());
        wrdXmlJson.writeXmlFilePokemons(crud.getPokemonFromDB());
        wrdXmlJson.writeXmlFileAdestradores(crud.getAdestradorFromDB());
        //wrdXmlJson.writeJsonFilePokemon(crud.getPokemonFromDB());
        //wrdXmlJson.writeJsonFileAdestradores(crud.getAdestradorFromDB());
        //crud.deleteDataFromDb("DELETE FROM Pokemon");
        //crud.deleteDataFromDb("DELETE FROM Adestrador");
    }
}
