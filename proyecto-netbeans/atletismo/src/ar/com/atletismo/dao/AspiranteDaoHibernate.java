package ar.com.atletismo.dao;

import ar.com.atletismo.dominio.Aspirante;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ariel
 */
public class AspiranteDaoHibernate extends ComunDaoHibernate<Aspirante> implements AspiranteDao {
    
    // constructor
    public AspiranteDaoHibernate(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    
    // metodos
    @Override
    public Aspirante buscarAspirantePorNumeroDeDocumetno(Integer numeroDeDocumento) {
        Session session = this.sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Aspirante> query = builder.createQuery(Aspirante.class);
        Root<Aspirante> root = query.from(Aspirante.class);
        query.select(root);
        query.where(builder.equal(root.get("numeroDeDocumento"), numeroDeDocumento));
        Aspirante aspirante =  session.createQuery(query).uniqueResult();
        session.close();
        return aspirante;
    }
    
}
