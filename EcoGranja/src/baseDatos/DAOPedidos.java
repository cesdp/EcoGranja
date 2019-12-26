package baseDatos;

import aplicacion.ItemPedido;
import aplicacion.Pedido;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOPedidos extends AbstractDAO
{
    public DAOPedidos (Connection conexion, aplicacion.FachadaAplicacion fa)
    {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
    public java.util.List<Pedido> recuperaPedidos(String cliente)
    {
        java.util.List<Pedido> pedidos = new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmPedido=null;
        PreparedStatement stmItemPedido=null;
        ResultSet rsPedido;
        ResultSet rsItemPedido;

        con=this.getConexion();

        try
        {
            con.setAutoCommit(false);
            stmPedido=con.prepareStatement("select id,comprador,usasaldopropio,fechacompra,total,metodopago"
                                         + " from pedido"
                                         + " where comprador=?");
            
            stmPedido.setString(1, cliente);
            rsPedido=stmPedido.executeQuery();
            
            while (rsPedido.next()) 
            {
                pedidos.add(new Pedido(rsPedido.getInt("id"),rsPedido.getString("comprador"),
                                       rsPedido.getBoolean("usasaldopropio"),rsPedido.getTimestamp("fechaCompra"),
                                       rsPedido.getDouble("total"),rsPedido.getInt("metodoPago")));
            }
            
            stmItemPedido=con.prepareStatement("select unidadescompr,devolucion,administrador,lote,fechacaducidad,producto,granja,fechadevolucion,fechaprocesado,unidadesdev"
                                              + " from incluye natural join lote "
                                              + " where comprador=? and pedido=?");
            
            for (Pedido pedido : pedidos) 
            {
                stmItemPedido.setString(1, cliente);
                stmItemPedido.setInt(2, pedido.getId());
                
                rsItemPedido=stmItemPedido.executeQuery();
                
                while (rsItemPedido.next()) 
                {
                    pedido.getComponentes().add(new ItemPedido(pedido.getId(),rsItemPedido.getInt("unidadescompr"),rsItemPedido.getBoolean("devolucion"),rsItemPedido.getString("administrador"),cliente,
                            new BigInteger(rsItemPedido.getString("lote")),rsItemPedido.getDate("fechacaducidad"),rsItemPedido.getString("granja"),rsItemPedido.getString("producto"),
                            rsItemPedido.getTimestamp("fechadevolucion"),rsItemPedido.getTimestamp("fechaprocesado"),rsItemPedido.getInt("unidadesdev")));
                }
            }
            con.commit();
            
        }
        catch (SQLException e)
        {
            try {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().mostrarAviso(e.getMessage());
                con.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().mostrarAviso(e.getMessage());
            }
        }
        finally
        {
          try {stmPedido.close();stmItemPedido.close();con.setAutoCommit(true);} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        
        }
        
        return pedidos;
    }
    
    public void devuelveItem(ItemPedido a,Integer idPedido,String comprador)
    {
        Connection con;
        PreparedStatement stmPedido = null;

        // Se establce la conexion con el servidor
        con = super.getConexion();

        try 
        {
            stmPedido = con.prepareStatement("update incluye "+
                                    "set unidadesdev=?,"
                                    + " fechadevolucion=current_timestamp "
                                    + " where pedido=? and comprador=? and"
                                    + " unidadescompr=? and lote=? and producto=? and granja=?");
            
            stmPedido.setInt(1, a.getUnidadesDev());
            stmPedido.setInt(2, idPedido);
            stmPedido.setString(3, comprador);
            stmPedido.setInt(4, a.getUnidadesCompr());
            stmPedido.setLong(5, a.getLote().longValue());
            stmPedido.setString(6,a.getProducto());
            stmPedido.setString(7,a.getGranja());
            stmPedido.executeUpdate();
           
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().mostrarAviso(e.getMessage());
        } 
        finally 
        { 
            try { stmPedido.close();} catch (SQLException e) { System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public java.util.List<ItemPedido> itemsADevolver(String idCliente,Integer idPedido,Timestamp fecha)
    {
        java.util.List<ItemPedido> items=new java.util.ArrayList<>();
        Connection con;
        String consulta;
        PreparedStatement stmItemPedido=null;
        ResultSet rsItemPedido;

        con=this.getConexion();

        try
        {
            consulta = "select * from incluye natural join lote where fechadevolucion is not null and fechaprocesado is null and comprador like ?";
            
            if(idPedido!=null)
                consulta += " and pedido = ?";
            
            if(fecha!=null)
                consulta += " and fechaDevolucion >= ? and fechaDevolucion <= ?";
            
            stmItemPedido=con.prepareStatement(consulta);
            
            stmItemPedido.setString(1, "%" + idCliente + "%");
            
            if(idPedido != null)
            {
                stmItemPedido.setInt(2, idPedido);
                
                if(fecha != null)
                {
                    stmItemPedido.setTimestamp(3, fecha);
                    fecha.setTime(fecha.getTime() + 86399999);                    
                    stmItemPedido.setTimestamp(4, fecha);
                }
            }
            else
                if(fecha != null)
                {
                    stmItemPedido.setTimestamp(2, fecha);   
                    fecha.setTime(fecha.getTime() + 86399999);
                    stmItemPedido.setTimestamp(3, fecha);
                }
            
            rsItemPedido = stmItemPedido.executeQuery();
            
            while(rsItemPedido.next()) 
            {
                items.add(new ItemPedido(rsItemPedido.getInt("pedido"),rsItemPedido.getInt("unidadescompr"),rsItemPedido.getBoolean("devolucion"),rsItemPedido.getString("administrador"),rsItemPedido.getString("comprador"),
                            new BigInteger(rsItemPedido.getString("lote")),rsItemPedido.getDate("fechacaducidad"),rsItemPedido.getString("granja"),rsItemPedido.getString("producto"),
                            rsItemPedido.getTimestamp("fechadevolucion"),rsItemPedido.getTimestamp("fechaprocesado"),rsItemPedido.getInt("unidadesdev")));
            }
        }
        catch (SQLException e)
        {
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().mostrarAviso(e.getMessage());
        }
        finally
        {
          try {stmItemPedido.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return items;
    }
    
    public java.util.List<ItemPedido> itemsDevueltos(String idCliente,String granja,String admin,Integer idPedido,Timestamp fecha)
    {
        java.util.List<ItemPedido> items=new java.util.ArrayList<>();
        Connection con;
        String consulta;
        PreparedStatement stmItemPedido=null;
        ResultSet rsItemPedido;

        con=this.getConexion();

        try
        {
            consulta = "select * from incluye natural join lote  where fechadevolucion is not null and fechaprocesado is not null and comprador like ? and granja like ? and administrador=?";
            
            if(idPedido!=null)
                consulta+=" and pedido=?";

            if(fecha!=null)
                consulta += " and fechaDevolucion >= ? and fechaDevolucion <= ?";
            
            stmItemPedido=con.prepareStatement(consulta);
            
            stmItemPedido.setString(1,"%"+idCliente+"%");
            stmItemPedido.setString(2,"%"+granja+"%");
            stmItemPedido.setString(3,admin);
            
            if(idPedido!=null)
            {
                stmItemPedido.setInt(4,idPedido);
                
                if(fecha!=null)
                {
                    stmItemPedido.setTimestamp(5, fecha);
                    fecha.setTime(fecha.getTime() + 86399999);                    
                    stmItemPedido.setTimestamp(6, fecha);
                }
            }
            else
                if(fecha!=null)
                {
                    stmItemPedido.setTimestamp(4, fecha);
                    fecha.setTime(fecha.getTime() + 86399999);                    
                    stmItemPedido.setTimestamp(5, fecha);
                }

            rsItemPedido=stmItemPedido.executeQuery();
            
            while (rsItemPedido.next()) 
            {
                items.add(new ItemPedido(rsItemPedido.getInt("pedido"),rsItemPedido.getInt("unidadescompr"),rsItemPedido.getBoolean("devolucion"),rsItemPedido.getString("administrador"),rsItemPedido.getString("comprador"),
                            new BigInteger(rsItemPedido.getString("lote")),rsItemPedido.getDate("fechacaducidad"),rsItemPedido.getString("granja"),rsItemPedido.getString("producto"),
                            rsItemPedido.getTimestamp("fechadevolucion"),rsItemPedido.getTimestamp("fechaprocesado"),rsItemPedido.getInt("unidadesdev")));
            }
            
            
        }catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().mostrarAviso(e.getMessage());
        }finally{
          try {stmItemPedido.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return items;
    }
    
    public void efectuaDevolucion(ItemPedido a,String admin,Boolean estado)
    {
        Connection con;
        PreparedStatement stmPedido = null;

        con = super.getConexion();

        try
        { 
            stmPedido = con.prepareStatement("update incluye "+
                                      " set devolucion=?,"
                                    + " administrador=?,"
                                    + " fechaprocesado=current_timestamp "
                                    + " where pedido=? and comprador=? and"
                                    + " unidadescompr=? and lote=? and producto=? and granja=?"
                                    + " and fechadevolucion=?");
            
            stmPedido.setBoolean(1, estado);
            stmPedido.setString(2, admin);
            stmPedido.setInt(3, a.getPedido());
            stmPedido.setString(4, a.getComprador());
            stmPedido.setInt(5, a.getUnidadesCompr());
            stmPedido.setLong(6, a.getLote().longValue());
            stmPedido.setString(7,a.getProducto());
            stmPedido.setString(8,a.getGranja());
            stmPedido.setTimestamp(9,a.getFechaDevolucion());

            stmPedido.executeUpdate();  
        } 
        catch (SQLException e) 
        {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().mostrarAviso(e.getMessage());
        } 
        finally 
        {
            try {stmPedido.close();} catch (SQLException e) { System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public int contarPedidosPendientes()
    {
        Connection con;
        String consulta;
        PreparedStatement stmItemPedido=null;
        ResultSet rsItemPedido;
        int cuenta = 0;

        con=this.getConexion();

        try
        {
            stmItemPedido=con.prepareStatement("select count(pedido) as cuenta" + 
                                            " from (select pedido" +
                                            " from incluye natural join lote" + 
                                            " where fechadevolucion is not null and fechaprocesado is null" +
                                            " group by pedido, comprador) as subconsulta");
            
            rsItemPedido = stmItemPedido.executeQuery();
            
            if(rsItemPedido.next()) 
                cuenta = rsItemPedido.getInt("cuenta");
        }
        catch (SQLException e)
        {
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().mostrarAviso(e.getMessage());
        }
        finally
        {
          try {stmItemPedido.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return cuenta;
    }
    
    public ItemPedido itemMasAntiguo()
    {
        Connection con;
        PreparedStatement stmItemPedido=null;
        ResultSet rsItemPedido;
        ItemPedido ip = null;

        con=this.getConexion();

        try
        {
            stmItemPedido=con.prepareStatement("select * "
                                             + "from incluye "
                                             + "where fechadevolucion = (select min(fechadevolucion) "
                                                                        + "from incluye natural join lote  "
                                                                        + "where fechadevolucion is not null and fechaprocesado is null) "
                                                         + "and fechaprocesado is null");
            
            rsItemPedido = stmItemPedido.executeQuery();
            
            if(rsItemPedido.next()) 
            {
                ip = new ItemPedido(rsItemPedido.getInt("pedido"),rsItemPedido.getInt("unidadescompr"),rsItemPedido.getBoolean("devolucion"),rsItemPedido.getString("administrador"),rsItemPedido.getString("comprador"),
                            new BigInteger(rsItemPedido.getString("lote")),null,rsItemPedido.getString("granja"),rsItemPedido.getString("producto"),
                            rsItemPedido.getTimestamp("fechadevolucion"),rsItemPedido.getTimestamp("fechaprocesado"),rsItemPedido.getInt("unidadesdev"));
            }
        }
        catch (SQLException e)
        {
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().mostrarAviso(e.getMessage());
        }
        finally
        {
          try {stmItemPedido.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return ip;
    }
    
    public float porcentajeItemsDevueltos(String admin)
    {
        Connection con;
        PreparedStatement items = null;
        ResultSet resultado1, resultado2;
        float porcentaje = 100.0f;
        
        con = this.getConexion();
        
        try
        {
            con.setAutoCommit(false);
            items = con.prepareStatement("select count(*) as cuenta from incluye where fechadevolucion is not null and fechaprocesado is not null and devolucion = true and administrador = ?");
            
            items.setString(1, admin);
            resultado1 = items.executeQuery();
            
            items = con.prepareStatement("select count(*) as cuenta from incluye where fechadevolucion is not null and fechaprocesado is not null and administrador = ?");
            
            items.setString(1, admin);
            resultado2 = items.executeQuery();
            
            if(resultado1.next() && resultado2.next()) 
                porcentaje = (resultado1.getFloat("cuenta") / resultado2.getFloat("cuenta")) * 100.0f;
            con.commit();
        }
        catch (SQLException e)
        {
            try {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().mostrarAviso(e.getMessage());
                con.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().mostrarAviso(e.getMessage());
            }
        }
        finally
        {
          try {items.close();con.setAutoCommit(false);} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return porcentaje;
    }
}
    


