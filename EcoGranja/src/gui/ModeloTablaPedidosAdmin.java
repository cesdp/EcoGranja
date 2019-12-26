/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;
import aplicacion.ItemPedido;
import aplicacion.Pedido;
import java.sql.Timestamp;
import javax.swing.table.*;
/**
 *
 * @author basesdatos
 */
public class ModeloTablaPedidosAdmin extends AbstractTableModel{
    private java.util.List<ItemPedido> pedidos;

    public ModeloTablaPedidosAdmin(){
        this.pedidos=new java.util.ArrayList<>();
    }

    @Override
    public int getColumnCount (){
        return 2;
    }

    @Override
    public int getRowCount(){
        return pedidos.size();
    }
    
    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Comprador"; break;
            case 1: nombre= "Fecha Devolucion"; break;
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.String.class; break;
            case 1: clase=java.sql.Timestamp.class; break;
           
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
            case 0: resultado= pedidos.get(row).getComprador(); break;
            case 1: resultado=pedidos.get(row).getFechaDevolucion();break;
        }    
        return resultado;
    }

    
    public void setFilas(java.util.List<ItemPedido> pedidos){
        this.pedidos=pedidos;
        fireTableDataChanged();
    }

    public void nuevoPedido(ItemPedido e){
        this.pedidos.add(e);
        fireTableRowsInserted(this.pedidos.size()-1, this.pedidos.size()-1);
    }

    public void borrarPedido(int indice){
        this.pedidos.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public java.util.List<ItemPedido> getFilas(){
        return this.pedidos;
    }

    public ItemPedido obtenerPedido(int i){
        return this.pedidos.get(i);
    }
}
