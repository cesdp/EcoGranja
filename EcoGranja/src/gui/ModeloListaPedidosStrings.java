/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import aplicacion.ItemPedido;

/**
 *
 * @author basesdatos
 */
public class ModeloListaPedidosStrings extends javax.swing.AbstractListModel {
    java.util.List<String> elementos;

    public ModeloListaPedidosStrings(){
        this.elementos=new java.util.ArrayList<String>();
    }

    public int getSize(){
        return this.elementos.size();
    }

    public String getElementAt(int i){
        return elementos.get(i);
    }

    public void nuevoElemento(String e){
        this.elementos.add(e);
        fireIntervalAdded(this, this.elementos.size()-1, this.elementos.size()-1);
    }

    public void borrarElemento(int i){
        String e;
        e=this.elementos.get(i);
        this.elementos.remove(i);
        fireIntervalRemoved(this,i,i);
    }

    public void setElementos(java.util.List<String> elementos){
        this.elementos=elementos;
        fireContentsChanged(this, 0, elementos.size()-1);
    }

    public java.util.List<String> getElementos(){
        return this.elementos;
    }
    
    public void cargaItemPedido(java.util.List<ItemPedido> elementos){
        this.elementos=new java.util.ArrayList<String>();
        for(int i=0;i<elementos.size();i++){
            String texto="<html> ";
            texto+=String.valueOf(elementos.get(i).getUnidadesCompr())+"x ";
            texto+=String.valueOf(elementos.get(i).getProducto())+" de ";
            texto+=String.valueOf(elementos.get(i).getGranja())+"</html>";
            this.elementos.add(texto);
        }
        fireContentsChanged(this, 0, elementos.size()-1);
    }
}
