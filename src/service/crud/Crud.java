package service.crud;

import config.HibernateConfig;
import model.Adestrador;
import model.Pokedex;
import model.Pokemon;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * La clase <code>Crud</code> proporciona métodos para realizar operaciones CRUD (crear, leer, eliminar)
 * en las entidades <code>Pokemon</code>, <code>Pokedex</code> y <code>Adestrador</code> utilizando Hibernate.
 * @author cristian
 * @version 1.0
 */
public class Crud {

    /**
     * Inserta una lista de objetos <code>Pokedex</code> en la base de datos.
     *
     * @param pokedexList Lista de objetos <code>Pokedex</code> a insertar.
     */
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

    /**
     * Inserta una lista de objetos <code>Adestrador</code> en la base de datos.
     *
     * @param adestradorList Lista de objetos <code>Adestrador</code> a insertar.
     */
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

    /**
     * Inserta una lista de objetos <code>Pokemon</code> en la base de datos.
     *
     * @param pokemonList Lista de objetos <code>Pokemon</code> a insertar.
     */
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

    /**
     * Recupera una lista de todos los objetos <code>Pokedex</code> desde la base de datos.
     *
     * @return Lista de objetos <code>Pokedex</code> almacenados en la base de datos.
     */
    public List<Pokedex> getPokedexFromDB(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            List<Pokedex> pokedexList = session.createQuery("from Pokedex", Pokedex.class).getResultList();
            transaction.commit();

            return pokedexList;
        }
    }

    /**
     * Recupera una lista de todos los objetos <code>Adestrador</code> desde la base de datos.
     *
     * @return Lista de objetos <code>Adestrador</code> almacenados en la base de datos.
     */
    public List<Adestrador> getAdestradorFromDB(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            List<Adestrador> adestradorList = session.createQuery("from Adestrador", Adestrador.class).getResultList();

            transaction.commit();

            return adestradorList;
        }
    }

    /**
     * Recupera una lista de todos los objetos <code>Pokemon</code> desde la base de datos.
     *
     * @return Lista de objetos <code>Pokemon</code> almacenados en la base de datos.
     */
    public List<Pokemon> getPokemonFromDB(){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            List<Pokemon> pokemonList = session.createQuery("from Pokemon", Pokemon.class).getResultList();


            transaction.commit();

            return pokemonList;
        }
    }

    /**
     * Elimina datos de la base de datos según una consulta HQL proporcionada.
     *
     * @param Query Consulta HQL para eliminar datos de la base de datos.
     */
    public void deleteDataFromDb(String Query){
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.createQuery(Query).executeUpdate();
            transaction.commit();

            System.out.println("Datos borrados correctamente de la base de datos");
        }
    }


}
