/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;
import aplicacion.Pedido;
import java.sql.Timestamp;
import javax.swing.table.*;
/**
 *
 * @author basesdatos
 */
public class ModeloTablaPedidosCliente extends AbstractTableModel{
    private java.util.List<Pedido> pedidos;

    public ModeloTablaPedidosCliente(){
        this.pedidos=new java.util.ArrayList<>();
    }

    @Override
    public int getColumnCount (){
        return 5;
    }

    @Override
    public int getRowCount(){
        return pedidos.size();
    }
    
    @Override
    public String getColumnName(int col){
        String nombre="";

        switch (col){
            case 0: nombre= "Id"; break;
            case 1: nombre= "SaldoPropio"; break;
            case 2: nombre="fechaCompra"; break;
            case 3: nombre="Total";break;
            case 4: nombre="MetodoPago";break;     
        }
        return nombre;
    }

    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= java.lang.Integer.class; break;
            case 1: clase= java.lang.Boolean.class; break;
            case 2: clase=java.sql.Timestamp.class; break;
            case 3: clase= java.lang.Double.class; break;
            case 4: clase= java.lang.Integer.class; break;   
           
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
            case 0: resultado= pedidos.get(row).getId(); break;
            case 1: resultado= pedidos.get(row).isUsaSaldoPropio(); break;
            case 2: resultado=pedidos.get(row).getFechaCompra();break;
            case 3: resultado= pedidos.get(row).getTotal();break;
            case 4: resultado=pedidos.get(row).getMetodoPago();break;
        }    
        return resultado;
    }

    
    public void setFilas(java.util.List<Pedido> pedidos){
        this.pedidos=pedidos;
        fireTableDataChanged();
    }

    public void nuevoPedido(Pedido e){
        this.pedidos.add(e);
        fireTableRowsInserted(this.pedidos.size()-1, this.pedidos.size()-1);
    }

    public void borrarPedido(int indice){
        this.pedidos.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public java.util.List<Pedido> getFilas(){
        return this.pedidos;
    }

    public Pedido obtenerPedido(int i){
        return this.pedidos.get(i);
    }
}
