package ar.com.atletismo.dominio;

/**
 *
 * @author ariel
 */
public class Estado {
    
    // atributos
    private Integer id;
    private String descripcion;

    // gets y sets
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
