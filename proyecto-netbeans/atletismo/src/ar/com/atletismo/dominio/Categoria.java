package ar.com.atletismo.dominio;

import ar.com.atletismo.utils.DateUtils;

/**
 *
 * @author ariel
 */
public class Categoria {

    // atributos
    private Integer id;
    private String descripcion;
    private String sexo;
    private Integer edadDesde;
    private Integer edadHasta;
    
    // constructores
    public Categoria() {
        super();
    }

    public Categoria(String descripcion, Integer edadDesde, Integer edadHasta) {
        this();
        this.descripcion = descripcion;
        this.edadDesde = edadDesde;
        this.edadHasta = edadHasta;
    }

    // metodos
    
    /**
     * Retorna si el aspirante pertenece a dicha categoría, para ello la edad del aspirante debe estar
     * incluída en el período edad desde hasta de la categoría y además tiene que poseer el mismo sexo de la misma.
     * @param aspirante
     * @return 
     */
    public boolean pertenece(Aspirante aspirante) {
        int edadAspirante = DateUtils.getAniosALaFecha(aspirante.getFechaDeNacimiento());
        return edadAspirante>=this.edadDesde && edadAspirante<=this.edadHasta && this.sexo.equals(aspirante.getSexo());
    }
    
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

    public Integer getEdadDesde() {
        return edadDesde;
    }

    public void setEdadDesde(Integer edadDesde) {
        this.edadDesde = edadDesde;
    }

    public Integer getEdadHasta() {
        return edadHasta;
    }

    public void setEdadHasta(Integer edadHasta) {
        this.edadHasta = edadHasta;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
}
