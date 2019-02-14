package ar.com.atletismo.test.categoria;

import ar.com.atletismo.dominio.Categoria;
import ar.com.atletismo.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author ariel
 */
public class CategoriaTest {

    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void configuration() throws Exception {
        sessionFactory = HibernateUtil.getInstance().getSessionFactory();
    }

    @Test
    public void test1() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Categoria c1 = new Categoria("Prueba", 1, 15);
        session.save(c1);
        session.getTransaction().commit();
        session.close();
        Assert.assertFalse(session.isOpen());
    }
    
}
