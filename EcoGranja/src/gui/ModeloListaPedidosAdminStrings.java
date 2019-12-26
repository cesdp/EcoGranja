package gui;

import aplicacion.ItemPedido;

public class ModeloListaPedidosAdminStrings extends javax.swing.AbstractListModel 
{
    java.util.List<String> elementos;

    public ModeloListaPedidosAdminStrings()
    {
        this.elementos = new java.util.ArrayList<>();
    }

    @Override
    public int getSize()
    {
        return this.elementos.size();
    }

    @Override
    public String getElementAt(int i)
    {
        return elementos.get(i);
    }

    public void nuevoElemento(String e)
    {
        this.elementos.add(e);
        fireIntervalAdded(this, this.elementos.size()-1, this.elementos.size()-1);
    }

    public void borrarElemento(int i)
    {
        String e;
        e=this.elementos.get(i);
        this.elementos.remove(i);
        fireIntervalRemoved(this,i,i);
    }

    public void setElementos(java.util.List<String> elementos)
    {
        this.elementos=elementos;
        fireContentsChanged(this, 0, elementos.size()-1);
    }

    public java.util.List<String> getElementos()
    {
        return this.elementos;
    }
    
    public void cargaItemPedido(ItemPedido elementos)
    {
        this.elementos=new java.util.ArrayList<>();
        String texto="<html> ";
        texto+=String.valueOf(elementos.getUnidadesDev())+"x \n ";
        texto+=String.valueOf(elementos.getProducto())+" \n GRANJA: ";
        texto+=String.valueOf(elementos.getGranja())+"</html>";
        this.elementos.add(texto);
        fireContentsChanged(this, 0, 0);
    }
}
