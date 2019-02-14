package ar.com.atletismo.dao;

import java.util.List;
import ar.com.atletismo.dominio.Escuela;

/**
 *
 * @author ariel
 */
public interface EscuelaDao {

    public List<Escuela> buscarEscuelas();

    public void registrarAspirantes(List<Escuela> escuelas);
    
}
