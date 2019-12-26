package baseDatos;

import aplicacion.Granja;
import aplicacion.ItemPedido;
import aplicacion.Pedido;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Properties;

public class FachadaBase
{
    private final aplicacion.FachadaAplicacion fachadaAplicacion;
    private java.sql.Connection conexion;
    private DAOUsuarios daoUsuarios;
    private DAOGranjas daoGranjas;
    private DAOPedidos daoPedidos;
    
    public FachadaBase (aplicacion.FachadaAplicacion fa)
    {    
        Properties configuracion = new Properties();
        fachadaAplicacion = fa;
        FileInputStream arqConfiguracion;

        try 
        {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();
     
            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            
            conexion = java.sql.DriverManager.getConnection("jdbc:" + gestor + "://" +
                    configuracion.getProperty("servidor") + ":" +
                    configuracion.getProperty("puerto") + "/" +
                    configuracion.getProperty("baseDatos"),
                    usuario);
            
            daoUsuarios = new DAOUsuarios(conexion, fa);
            daoGranjas = new DAOGranjas(conexion, fa);
            daoPedidos=new DAOPedidos(conexion,fa);
        }
        catch (FileNotFoundException f)
        {
            System.out.println(f.getMessage());
            fachadaAplicacion.mostrarAviso(f.getMessage());
        } 
        catch (IOException | java.sql.SQLException i)
        {
            System.out.println(i.getMessage());
            fachadaAplicacion.mostrarAviso(i.getMessage());
        } 
    }
    
    public aplicacion.Usuario validarUsuario(String idUsuario, String clave)
    {
        return daoUsuarios.validarUsuario(idUsuario, clave);
    }
    
    public String comprobarEmail(String email)
    {
        return daoUsuarios.comprobarEmail(email);
    }
    
    public void registrarUsuario(String nombreUsuario, String correo, String direccion, String clave, String tipoUsuario)
    {
        daoUsuarios.registrarUsuario(nombreUsuario, correo, direccion, clave, tipoUsuario);
    }
    
    public void actualizarUsuario(aplicacion.Usuario usuario, String nombreOriginal)
    {
        daoUsuarios.actualizarUsuario(usuario, nombreOriginal);
    }
    
    public void eliminarUsuario(aplicacion.Usuario usuario)
    {
        daoUsuarios.eliminarUsuario(usuario);
    }
    
    public java.util.List<Granja> buscaGranjas(String nombre,String cif,String provincia,String pais,String direccion,String tipo,String usuario){
         return daoGranjas.buscaGranjas(nombre, cif, provincia, pais, direccion, tipo,usuario);
    }
     
    public void insertarGranja(Granja granja, aplicacion.Usuario u)
    {
        daoGranjas.insertarGranja(granja, u);
    }
    
    public void modificarGranja(Granja granja)
    {
        daoGranjas.modificarGranja(granja);
    }
    
    public void borrarGranjas(String nombre)
    {
        daoGranjas.borrarGranjas(nombre);
    }
    
    public java.util.List<Pedido> recuperaPedidos(String cliente)
    {
        return daoPedidos.recuperaPedidos(cliente);
    }
    
    public void devuelveItem(ItemPedido a,Integer idPedido,String comprador)
    {
        daoPedidos.devuelveItem(a, idPedido,comprador);
    }
    
    public java.util.List<ItemPedido> itemsADevolver(String idCliente,Integer idPedido,Timestamp fecha)
    {
        return daoPedidos.itemsADevolver(idCliente,idPedido,fecha);
    }
    
    public java.util.List<ItemPedido> itemsDevueltos(String idCliente,String granja,String admin,Integer idPedido,Timestamp fecha)
    {
        return daoPedidos.itemsDevueltos(idCliente, granja,admin ,idPedido, fecha);
    }
    
    public void efectuaDevolucion(ItemPedido a,String admin,Boolean estado)
    {
        daoPedidos.efectuaDevolucion(a, admin, estado);
    }
    
    public int contarPedidosPendientes()
    {
        return daoPedidos.contarPedidosPendientes();
    }
    
    public ItemPedido itemMasAntiguo()
    {
        return daoPedidos.itemMasAntiguo();
    }
    
    public float porcentajeItemsDevueltos(String admin)
    {
        return daoPedidos.porcentajeItemsDevueltos(admin);
    }
}
