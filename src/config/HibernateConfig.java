package config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Configuración de Hibernate para la creación y gestión de la SessionFactory.
 * Esta clase configura la SessionFactory necesaria para interactuar con la base de datos utilizando Hibernate.
 * Se inicializa de forma estática en el bloque <code>static</code>, cargando los parámetros de configuración
 * desde el archivo <code>resources/properties.xml</code>.
 * @author cristian
 * @version 1.0
 */
public class HibernateConfig {

    /**
     * Registro de servicios estándar para configurar Hibernate.
     */
    private static StandardServiceRegistry standardServiceRegistry;

    /**
     * La fábrica de sesiones (SessionFactory) de Hibernate.
     */
    private static SessionFactory sessionFactory;

    /**
     * Bloque estático que configura Hibernate utilizando el archivo de propiedades
     * especificado y crea una instancia de SessionFactory.
     * El bloque estático intenta cargar la configuración desde el archivo
     * <code>resources/properties.xml</code> y construir la SessionFactory.
     * Si ocurre algún error durante la configuración, el registro de servicios
     * es destruido para evitar inconsistencias.
     */
    static {
        try {
            standardServiceRegistry = new StandardServiceRegistryBuilder().configure("resources/properties.xml").build();
            MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
            Metadata metadata = metadataSources.getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();

        } catch (Exception e) {
            if (standardServiceRegistry != null)
            {
                StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
            }
        }

    }
    /**
     * Obtiene la instancia de SessionFactory configurada.
     *
     * @return La instancia de SessionFactory configurada.
     */
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
