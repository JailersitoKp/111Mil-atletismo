package ar.com.atletismo.dominio;

import java.io.Serializable;

public class Inscripcion implements Serializable {

    // atributos
    private Aspirante aspirante;
    private Competencia competencia;
    private Categoria categoria;
    private Estado estado;

    // constructor

    public Inscripcion() {
        super();
    }
    
    public Inscripcion(Aspirante aspirante, Competencia competencia, Categoria categoria, Estado estado) {
        this();
        this.aspirante = aspirante;
        this.competencia = competencia;
        this.categoria = categoria;
        this.estado = estado;
        aspirante.agregarInscripcion(this);
    }
    
    // gets y sets
    public Aspirante getAspirante() {
        return aspirante;
    }

    public void setAspirante(Aspirante aspirante) {
        this.aspirante = aspirante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
