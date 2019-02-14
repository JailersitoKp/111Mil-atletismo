package ar.com.atletismo.controller;

import ar.com.atletismo.dao.DaoFactory;
import ar.com.atletismo.dominio.Aspirante;
import ar.com.atletismo.dominio.Competencia;
import ar.com.atletismo.dominio.Escuela;
import ar.com.atletismo.ui.PantallaRegistroAspirantes;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ariel
 */
public class GestorInscripcionesAspirantes implements Runnable{
    
    // constructor
    public GestorInscripcionesAspirantes() {
        super();
    }
    
    // metodos
    public List<Escuela> buscarEscuelas() {
        return DaoFactory.getInstance().getEscuelaDao().buscarEscuelas();
    }

    public List<Competencia> buscarCompetencias(Date fecha) {
        return DaoFactory.getInstance().getCompetenciaDao().buscarCompetencias(fecha);
    }

    public List<Competencia> buscarCompetencias() {
        return DaoFactory.getInstance().getCompetenciaDao().buscarCompetencias();
    }
    
    public Aspirante buscarAspirantePorNumeroDeDocumento(Integer numeroDeDocumento) {
        return DaoFactory.getInstance().getAspiranteDao().buscarAspirantePorNumeroDeDocumetno(numeroDeDocumento);
    }

    public void registrarAspirantes(List<Escuela> escuelas) {
        DaoFactory.getInstance().getEscuelaDao().registrarAspirantes(escuelas);
    }
    
    @Override
    public void run() {
        new PantallaRegistroAspirantes(this).setVisible(true);
    }
    
}
