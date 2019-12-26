package aplicacion;

import gui.FachadaGUI;
import baseDatos.FachadaBase;
import java.sql.Timestamp;

public class GestionPedidos
{
    FachadaGUI fgui;
    FachadaBase fbd;
   
    public GestionPedidos(FachadaGUI fgui, FachadaBase fbd)
    {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    public java.util.List<Pedido> recuperaPedidos(String cliente)
    {
        return fbd.recuperaPedidos(cliente);
    }
    
    public void devuelveItem(ItemPedido a,Integer idPedido,String comprador)
    {
        fbd.devuelveItem(a, idPedido,comprador);
    }
    
    public java.util.List<ItemPedido> itemsADevolver(String idCliente,Integer idPedido,Timestamp fecha)
    {
        return fbd.itemsADevolver(idCliente,idPedido,fecha);
    }
    
    public java.util.List<ItemPedido> itemsDevueltos(String idCliente,String granja,String admin,Integer idPedido,Timestamp fecha)
    {
        return fbd.itemsDevueltos(idCliente, granja,admin ,idPedido, fecha);
    }
    
    public void efectuaDevolucion(ItemPedido a,String admin,Boolean estado)
    {
        fbd.efectuaDevolucion(a, admin, estado);
    }

    public int contarPedidosPendientes()
    {
        return fbd.contarPedidosPendientes();
    }
    
    public ItemPedido itemMasAntiguo()
    {
        return fbd.itemMasAntiguo();
    }
    
    public float porcentajeItemsDevueltos(String admin)
    {
        return fbd.porcentajeItemsDevueltos(admin);
    }
}
