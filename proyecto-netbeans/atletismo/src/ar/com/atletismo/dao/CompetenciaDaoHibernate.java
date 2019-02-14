package ar.com.atletismo.dao;

import ar.com.atletismo.dominio.Competencia;
import java.util.Date;
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
public class CompetenciaDaoHibernate extends ComunDaoHibernate implements CompetenciaDao {
    
    // constructor
    protected CompetenciaDaoHibernate(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Competencia> buscarCompetencias() {
        return this.buscarTodos(Competencia.class);
    }
    
    // metodos
    @Override
    public List<Competencia> buscarCompetencias(Date fecha) {
        Session session = this.sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Competencia> query = builder.createQuery(Competencia.class);
        Root<Competencia> root = query.from(Competencia.class);
        query.select(root);
        query.where(builder.and(
                        builder.lessThanOrEqualTo(root.get("fecha"), fecha) 
        ));
        List<Competencia> competencias = session.createQuery(query).list();
        session.close();      
        return competencias;
    }
    
}
