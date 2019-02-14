package ar.com.atletismo.dominio;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author ariel
 */
public class Escuela {
    
    // atributos
    private Integer id;
    private String nombre;
    private List<Aspirante> aspirantesARegistrar; // no persistente

    // metodos
    
    public void agregarAspiranteARegistrar(Aspirante aspirante) {
        if (this.aspirantesARegistrar==null) {
            this.aspirantesARegistrar = new ArrayList<>();
        }
        this.aspirantesARegistrar.add(aspirante);
    }

    public String validarInscripcionDeAspirantes() {
        String mensaje = StringUtils.EMPTY;
        Competencia competencia = null;
        if (this.aspirantesARegistrar!=null) {
            for (Aspirante aspirante : this.aspirantesARegistrar) {
                competencia = aspirante.validarInscripcionACompetencias();
                if (competencia!=null) {
                    mensaje = "El aspirante " + aspirante.toString() + " no tiene categoría seleccionada en la competencia: " + competencia.getDescripcion();
                    break;
                }
            }
        }
        return mensaje;
    }
    
    /**
     * Retorna si la escuela tiene al menos un aspirante a registrar.
     * @return 
     */
    public boolean tieneAspirantesARegistrar() {
        return this.aspirantesARegistrar!=null && this.aspirantesARegistrar.size()>0;
    }

    /**
     * Retorna si el dni ya está ingresado entre los aspirantes a registrar.
     * @param dni
     * @return 
     */
    public boolean tieneAspiranteARegistrar(Integer dni) {
        return this.aspirantesARegistrar.stream()
                                                    .filter(a -> a.getNumeroDeDocumento().equals(dni))
                                                    .findAny()
                                                    .orElse(null) != null;
    }

    // gets y sets
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Aspirante> getAspirantesARegistrar() {
        return aspirantesARegistrar;
    }
    
}
