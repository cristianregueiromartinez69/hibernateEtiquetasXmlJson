package service.crud;

import config.HibernateConfig;
import model.Adestrador;
import model.Pokedex;
import model.Pokemon;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Crud {

    public void insertar10PokemonsInPokedex(List<Pokedex> pokedexList){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            for (Pokedex pokedex : pokedexList) {
                session.save(pokedex);
            }
            transaction.commit();
            System.out.println("Pokemons guardados en la base de datos pokedex correctamente");
        }
    }

    public void insertar2AdestradoresInAdestrador(List<Adestrador> adestradorList){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            for (Adestrador adestrador : adestradorList) {
                session.save(adestrador);
            }

            transaction.commit();

            System.out.println("Adestradores guardados en la base de datos adestradores correctamente");
        }
    }

    public void insertar12PokemonsInPokemonDB(List<Pokemon> pokemonList){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            for (Pokemon pokemon : pokemonList) {
                session.save(pokemon);
            }
            transaction.commit();

            System.out.println("Pokemons insertados en la base pokemon correctamente");
        }
    }

    public List<Pokedex> getPokedexFromDB(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            List<Pokedex> pokedexList = session.createQuery("from Pokedex", Pokedex.class).getResultList();
            transaction.commit();

            return pokedexList;
        }
    }

    public List<Adestrador> getAdestradorFromDB(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            List<Adestrador> adestradorList = session.createQuery("from Adestrador", Adestrador.class).getResultList();

            transaction.commit();

            return adestradorList;
        }
    }

    public List<Pokemon> getPokemonFromDB(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            List<Pokemon> pokemonList = session.createQuery("from Pokemon", Pokemon.class).getResultList();


            transaction.commit();

            return pokemonList;
        }
    }

    public void deleteDataFromDb(String Query){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.createQuery(Query).executeUpdate();
            transaction.commit();

            System.out.println("Datos borrados correctamente de la base de datos");
        }
    }


}
