package ar.com.atletismo.dao;

import ar.com.atletismo.dominio.Aspirante;
import ar.com.atletismo.dominio.Competencia;
import ar.com.atletismo.dominio.Escuela;
import ar.com.atletismo.dominio.Estado;
import ar.com.atletismo.dominio.Inscripcion;
import ar.com.atletismo.enums.EstadoInscripcion;
import java.util.Iterator;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ariel
 */
public class EscuelaDaoHibernate extends ComunDaoHibernate implements EscuelaDao {
    
    // constructor
    protected EscuelaDaoHibernate(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    
    // metodos
    @Override
    public List<Escuela> buscarEscuelas() {
        return this.buscarTodos(Escuela.class);
    }

    @Override
    public void registrarAspirantes(List<Escuela> escuelas) {
        Session session = null;
        Transaction tx = null;
        try {
            session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            Estado estadoDefault = session.get(Estado.class, EstadoInscripcion.PREAPROBADA.getId());
            for (Iterator<Escuela> itEscuela = escuelas.iterator(); itEscuela.hasNext();) {
                Escuela escuela = itEscuela.next();
                if (escuela.getAspirantesARegistrar()!=null) {
                    for (Iterator<Aspirante> itAspirante = escuela.getAspirantesARegistrar().iterator(); itAspirante.hasNext();) {
                        Aspirante aspirante = itAspirante.next();
                        for (Iterator<Competencia> iterator = aspirante.getCompetenciasAuxiliares().iterator(); iterator.hasNext();) {
                            Competencia competencia = iterator.next();
                            if (competencia.getSeleccionada()) {
                                session.detach(escuela);        
                                session.detach(competencia);
                            Inscripcion inscripcion = new Inscripcion(aspirante, competencia, competencia.getCategoriaSeleccionada(), estadoDefault);
                            session.save(aspirante);
                            }
                        }
                    }
                }
            }
            tx.commit();
            session.close();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
    }
    
}
