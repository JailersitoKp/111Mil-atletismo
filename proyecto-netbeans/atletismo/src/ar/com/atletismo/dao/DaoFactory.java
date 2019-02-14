package ar.com.atletismo.dao;

import ar.com.atletismo.hibernate.HibernateUtil;
import org.hibernate.SessionFactory;

/**
 *
 * @author ariel
 */
public class DaoFactory {

    // atributos de clase
    private static DaoFactory instance;
    
    // atributos
    private SessionFactory sessionFactory;
    
    // constructor
    private DaoFactory() {
        super();
        this.sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    }
    
    // metodos de clase
    public static DaoFactory getInstance() {
        if (instance==null) {
            instance = new DaoFactory();
        }
        return instance;
    }
    
    // metodos
    public EscuelaDao getEscuelaDao() {
        return new EscuelaDaoHibernate(this.sessionFactory);
    }
    
    public CompetenciaDao getCompetenciaDao() {
        return new CompetenciaDaoHibernate(this.sessionFactory);
    }

    public AspiranteDao getAspiranteDao() {
        return new AspiranteDaoHibernate(this.sessionFactory);
    }

}
