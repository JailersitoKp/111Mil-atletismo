package ar.com.atletismo.enums;

/**
 *
 * @author ariel
 */
public enum EstadoInscripcion {
    
    APROBADA (1, "Aprobada"), 
    PREAPROBADA(2, "Pre-Aprobada");
    
    private int idEstado;
    private String descripcion;
    
    private EstadoInscripcion(int id, String descripcion) {
        this.idEstado = id;
        this.descripcion = descripcion;
    }
    
    public int getId() {
        return this.idEstado;
    }
    
}
