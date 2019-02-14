package ar.com.atletismo.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author ariel
 */
public class HibernateUtil {

    private static HibernateUtil instance;
    
    private StandardServiceRegistry registry;
    private SessionFactory sessionFactory;
    
    private HibernateUtil() {
        super();
        this.inicioFactory();
    }
    
    public static HibernateUtil getInstance() {
        if (instance==null) {
            instance = new HibernateUtil();
        }
        return instance;
    }
    
    private void inicioFactory() {
        try {
            this.registry = new StandardServiceRegistryBuilder()
                                .configure("resources/hibernate.cfg.xml")
                                .build();
            this.sessionFactory = new MetadataSources(this.registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(this.registry);
        }
    }
    
    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }
    
}
