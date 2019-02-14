package ar.com.atletismo.dao;

import ar.com.atletismo.dominio.Aspirante;

/**
 *
 * @author ariel
 */
public interface AspiranteDao {

    public Aspirante buscarAspirantePorNumeroDeDocumetno(Integer numeroDeDocumento);    
    
}
