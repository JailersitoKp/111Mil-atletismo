package ar.com.atletismo.run;

import ar.com.atletismo.controller.GestorInscripcionesAspirantes;
import ar.com.atletismo.hibernate.HibernateUtil;

/**
 * Inicio del sistema.
 * 
 * @author ariel
 */
public class Atletismo {
    
    public static void main (String[] args) {
        
        // llamo aqui para que inicie la sessionfactory cuando levanta el sistema
        HibernateUtil.getInstance().getSessionFactory();
        
        // pantalla inscripcion de aspirantes
        new GestorInscripcionesAspirantes().run();
    }

}
