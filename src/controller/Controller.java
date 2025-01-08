package controller;

import service.crud.Crud;
import service.metodosclases.MetodosAdestrador;
import service.metodosclases.MetodosPokedex;
import service.metodosclases.MetodosPokemon;

public class Controller {

    public void logicaPrograma(){
        MetodosPokedex metodosPokedex = new MetodosPokedex();
        MetodosAdestrador metodosAdestrador = new MetodosAdestrador();
        MetodosPokemon metodosPokemon = new MetodosPokemon();
        Crud crud = new Crud();

        //crud.insertar10PokemonsInPokedex(metodosPokedex.getPokemonsList());
        //crud.insertar2AdestradoresInAdestrador(metodosAdestrador.getAdestradoresList());
        //crud.insertar12PokemonsInPokemonDB(metodosPokemon.getPokemonList(crud.getPokedexFromDB(), crud.getAdestradorFromDB()));

        metodosPokemon.leerDatosPokemons(crud.getPokemonFromDB());
    }
}
