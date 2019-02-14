package ar.com.atletismo.dominio;

import ar.com.atletismo.utils.DateUtils;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author ariel
 */
public class Competencia {
    
    // atributos
    private Integer id;
    private Date fecha;
    private String descripcion;
    private Set<Categoria> categorias;
    private Boolean seleccionada; // no persistente
    private Categoria categoriaSeleccionada; // no persistente

    // constructor
    public Competencia() {
        super();
    }
    
    public Competencia(Competencia competencia) {
        this();
        this.id = competencia.getId();
        this.fecha = competencia.getFecha();
        this.descripcion = competencia.getDescripcion();
        this.seleccionada = competencia.getSeleccionada();
        this.llenarCategorias(competencia.getCategorias());
    }
    
    // metodos
    public Categoria getCategoriaPorDefecto(Aspirante aspirante) {
        for (Iterator<Categoria> itCategoria = categorias.iterator(); itCategoria.hasNext();) {
            Categoria categoria = itCategoria.next();
            if (categoria.pertenece(aspirante)) {
                return categoria;
            }
        }
        return null;
    }
    
    public String getHoraMinuto() {
        return DateUtils.getHoraMinuto(this.fecha);
    }
    
    public String getFechaFormat() {
        return DateUtils.getFecha(this.fecha);
    }
    
    private void llenarCategorias(Set<Categoria> categorias) {
        this.categorias = new HashSet<Categoria>();
        for (Iterator<Categoria> itCategoria = categorias.iterator(); itCategoria.hasNext();) {
            Categoria categoria = itCategoria.next();
            this.categorias.add(categoria);
        }
    }
    
    public boolean tieneCategoriaSeleccionada() {
        return this.categoriaSeleccionada!=null;
    }
    
    // gets y sets
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getSeleccionada() {
        return seleccionada;
    }

    public void setSeleccionada(Boolean seleccionada) {
        this.seleccionada = seleccionada;
    }

    public Categoria getCategoriaSeleccionada() {
        return categoriaSeleccionada;
    }

    public void setCategoriaSeleccionada(Categoria categoriaSeleccionada) {
        this.categoriaSeleccionada = categoriaSeleccionada;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
