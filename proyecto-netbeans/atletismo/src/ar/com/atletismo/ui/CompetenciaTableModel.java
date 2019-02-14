package ar.com.atletismo.ui;

import ar.com.atletismo.dominio.Competencia;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ariel
 */
public class CompetenciaTableModel extends AbstractTableModel {

    // constantes
    private static final String[] COLUMNAS = {"", "Descripción","Fecha", "Hora"};
    
    // atributos
    private List<Competencia> competencias;
    
    // constructor
    public CompetenciaTableModel() {
        this(new ArrayList<Competencia>());
    }
    
    public CompetenciaTableModel(List<Competencia> competencias) {
        super();
        this.competencias = competencias;
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        Boolean valueOld = this.competencias.get(row).getSeleccionada();
        this.competencias.get(row).setSeleccionada(!valueOld);
        this.fireTableCellUpdated(row, col);
    }
    
        
    // metodos
    @Override
    public int getRowCount() {
        return this.competencias.size();
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNAS[column];
    }

    @Override
    public int getColumnCount() {
        return COLUMNAS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object objReturn = null;
        Competencia competencia  = this.competencias.get(rowIndex);
        switch (columnIndex) {
            case 0:
                objReturn = competencia.getSeleccionada();
                break;
            case 1:
                objReturn = competencia.getDescripcion();
                break;
            case 2:
                objReturn = competencia.getFechaFormat();
                break;
            case 3:
                objReturn = competencia.getHoraMinuto();
                break;
        }
        return objReturn;
    }
    
    @Override
    public Class getColumnClass(int column) {
        switch (column) {
            case 0:
                return Boolean.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            default:
                return String.class;
        }    
    }
    
}
