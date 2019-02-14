package ar.com.atletismo.dao;

import ar.com.atletismo.dominio.Competencia;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ariel
 */
public interface CompetenciaDao {
    
    public List<Competencia> buscarCompetencias(Date fecha);
    
    public List<Competencia> buscarCompetencias();
        
}
