package ar.com.atletismo.dominio;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author ariel
 */
public class Aspirante {

    // constantes
    private static final String SEPARADOR_NOMBRE = ", ";
    private static final String SEPARADOR_DNI = " - DNI: ";

    // atributos
    private Integer numeroDeDocumento;
    private String apellido;
    private String nombre;
    private String direccion;
    private Date fechaDeNacimiento;
    private String sexo;
    private Escuela escuela;
    private Set<Inscripcion> inscripciones;
    private List<Competencia> competenciasAuxiliares; // no persistente

    // metodos
    @Override
    public String toString() {
        return this.nombre + SEPARADOR_NOMBRE + this.apellido + SEPARADOR_DNI + this.numeroDeDocumento;
    }
    
    public void agregarInscripcion(Inscripcion inscripcion) {
        if (this.inscripciones==null) {
            this.inscripciones = new HashSet<>();
        }
        this.inscripciones.add(inscripcion);
    }
    
    public Competencia validarInscripcionACompetencias() {
        return this.competenciasAuxiliares.stream()
                                        .filter( c -> c.getSeleccionada() && !c.tieneCategoriaSeleccionada())
                                        .findAny()
                                        .orElse(null);
    }
        
    // gets y sets
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getNumeroDeDocumento() {
        return numeroDeDocumento;
    }

    public void setNumeroDeDocumento(Integer numeroDeDocumento) {
        this.numeroDeDocumento = numeroDeDocumento;
    }

    public Escuela getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }

    public Set<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(Set<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public List<Competencia> getCompetenciasAuxiliares() {
        return competenciasAuxiliares;
    }

    public void setCompetenciasAuxiliares(List<Competencia> competenciasAuxiliares) {
        this.competenciasAuxiliares = competenciasAuxiliares;
    }
    
}
