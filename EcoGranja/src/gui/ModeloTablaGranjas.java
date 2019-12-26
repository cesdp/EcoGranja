/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;
import aplicacion.Granja;
import javax.swing.table.*;
/**
 *
 * @author basesdatos
 */
public class ModeloTablaGranjas extends AbstractTableModel{
    private java.util.List<Granja> granjas;

    public ModeloTablaGranjas(){
        this.granjas=new java.util.ArrayList<>();
    }

    @Override
    public int getColumnCount (){
        return 6;
    }

    @Override
    public int getRowCount(){
        return granjas.size();
    }

    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Nombre"; break;
            case 1: nombre= "CIF"; break;
            case 2: nombre="Provincia"; break;
            case 3: nombre="Pais";break;
            case 4: nombre="Dirección";break;   
            case 5: nombre="Tipo";break;       
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase= java.lang.String.class; break;
            case 2: clase=java.lang.String.class; break;
            case 3: clase= java.lang.String.class; break;
            case 4: clase= java.lang.String.class; break;
            case 5: clase=java.lang.String.class; break;    
           
        }
        return clase;
    }

    @Override
    public boolean isCellEditable(int row, int col){
       return false;
    }

    @Override
    public Object getValueAt(int row, int col){
        Object resultado=null;

        switch (col){
            case 0: resultado= granjas.get(row).getNombre(); break;
            case 1: resultado= granjas.get(row).getCif(); break;
            case 2: resultado=granjas.get(row).getProvincia();break;
            case 3: resultado= granjas.get(row).getPais();break;
            case 4: resultado=granjas.get(row).getDireccion();break;
            case 5: resultado= granjas.get(row).getTipo();break;    
        }    
        return resultado;
    }

    
    public void setFilas(java.util.List<Granja> granjas){
        this.granjas=granjas;
        fireTableDataChanged();
    }

    public void nuevoEjemplar(Granja e){
        this.granjas.add(e);
        fireTableRowsInserted(this.granjas.size()-1, this.granjas.size()-1);
    }

    public void borrarEjemplar(int indice){
        this.granjas.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public java.util.List<Granja> getFilas(){
        return this.granjas;
    }

    public Granja obtenerEjemplar(int i){
        return this.granjas.get(i);
    }
}
