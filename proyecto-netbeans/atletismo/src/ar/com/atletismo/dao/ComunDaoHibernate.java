package ar.com.atletismo.dao;

import ar.com.atletismo.dominio.Competencia;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ariel
 */
public abstract class ComunDaoHibernate<T> {
    
    // atributos
    protected SessionFactory sessionFactory;

    // constructor
    protected ComunDaoHibernate(SessionFactory sessionFactory) {
        super();
        this.sessionFactory = sessionFactory;
    }

    // metodos
    protected List<T> buscarTodos(Class clazz) {
        Session session = this.sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(clazz);
        Root<T> root = query.from(clazz);
        query.select(root);
        List<T> competencias = session.createQuery(query).list();
        session.close();
        return competencias;
    }

}
