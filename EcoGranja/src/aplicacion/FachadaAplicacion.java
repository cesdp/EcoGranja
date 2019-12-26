package aplicacion;

import gui.*;
import java.sql.Timestamp;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class FachadaAplicacion 
{
    private final FachadaGUI gui;
    private final baseDatos.FachadaBase fbd;
    private final GestionUsuarios cu;
    private final GestionGranjas cp;
    private final GestionPedidos cpd;
    
    public FachadaAplicacion()
    {
        gui = new FachadaGUI(this);
        fbd = new baseDatos.FachadaBase(this);
        cu = new GestionUsuarios(gui, fbd);
        cp = new GestionGranjas(gui, fbd);
        cpd= new GestionPedidos(gui,fbd);
    }
    
    public static void main(String[] args) 
    {
        FachadaAplicacion aplicacion;
        
        aplicacion = new FachadaAplicacion();
        aplicacion.iniciarInterfaz();
    }
    
    public javax.swing.ImageIcon cargarImagen(javax.swing.JDialog padre, int ancho, int alto)
    {
        return gui.cargarImagen(padre, ancho, alto);
    }
    
    public void mostrarAviso(String cadena)
    {
        gui.mostrarAviso(cadena);
    }
    
    public void mostrarAviso(javax.swing.JDialog padre, String cadena)
    {
        gui.mostrarAviso(padre, cadena);
    }
    
    public void iniciarInterfaz()
    {
        gui.abrirInicioSesion();
    }
    
    public void abrirRegistroUsuario()
    {
        gui.abrirRegistroUsuario();
    }
    
    public void abrirPrincipalClientes(UsuarioCliente usuario)
    {
        gui.abrirPrincipalClientes(usuario);
    }
    
    public void abrirPrincipalGranjeros(UsuarioCliente usuario)
    {
        gui.abrirPrincipalGranjeros(usuario);
    }
    
    public void abrirPrincipalAdministradores(UsuarioAdministrador usuario)
    {
        gui.abrirPrincipalAdministradores(usuario);
    }
    
    public void abrirClientePerfil(JFrame padre, UsuarioCliente usuario)
    {
        gui.abrirClientePerfil(padre, usuario);
    }
    
    public void abrirClientePedidos(JFrame padre, UsuarioCliente usuario)
    {
        gui.abrirClientePedidos(padre, usuario);
    }
    
    public void abrirGranjeroGranjas(JFrame padre, UsuarioCliente usuario)
    {
        gui.abrirGranjeroGranjas(padre, usuario);
    }
    
    public void abrirGranjeroModificarGranja(JDialog padre, UsuarioCliente usuario, Granja granja)
    {
        gui.abrirGranjeroModificarGranja(padre, usuario, granja);
    }
    
    public void abrirGranjeroPerfil(JFrame padre, UsuarioCliente usuario)
    {
        gui.abrirGranjeroPerfil(padre, usuario);
    }
    
    public void abrirAdministradorPendientes(JFrame padre, UsuarioAdministrador usuario)
    {
        gui.abrirAdministradorPendientes(padre, usuario);
    }
    
    public void abrirAdministradorTotal(JFrame padre, UsuarioAdministrador usuario)
    {
        gui.abrirAdministradorTotal(padre, usuario);
    }
    
    public void abrirAdministradorPerfil(JFrame padre, UsuarioAdministrador usuario)
    {
        gui.abrirAdministradorPerfil(padre, usuario);
    }
    
    public Usuario comprobarAutentificacion(String idUsuario, String clave)
    {
       return cu.comprobarAutentificacion(idUsuario, clave);
    }
    
    public String comprobarEmail(String email)
    {
        return cu.comprobarEmail(email);
    }
    
    public void registrarUsuario(String nombreUsuario, String correo, String direccion, String clave, String tipoUsuario)
    {
        cu.registrarUsuario(nombreUsuario, correo, direccion, clave, tipoUsuario);
    }
    
    public void actualizarUsuario(Usuario usuario, String nombreOriginal)
    {
        cu.actualizarUsuario(usuario, nombreOriginal);
    }
    
    public void eliminarUsuario(Usuario usuario)
    {
        cu.eliminarUsuario(usuario);
    }
    
    public java.util.List<Granja> buscaGranjas(String nombre,String cif,String provincia,String pais,String direccion,String tipo,String usuario)
    {
        return cp.buscaGranjas(nombre, cif, provincia, pais, direccion, tipo,usuario);
    }
    
    public void insertarGranja(Granja granja, Usuario u)
    {
        cp.insertarGranja(granja, u);
    }
    public void modificarGranja(Granja granja)
    {
        cp.modificarGranja(granja);
    }
    
    public void borrarGranjas(String nombre)
    {
        cp.borrarGranjas(nombre);
    }
    
    public java.util.List<Pedido> recuperaPedidos(String cliente)
    {
        return cpd.recuperaPedidos(cliente);
    }
    
    public void devuelveItem(ItemPedido a,Integer idPedido,String comprador)
    {
        cpd.devuelveItem(a, idPedido,comprador);
    }
    
    public java.util.List<ItemPedido> itemsADevolver(String idCliente,Integer idPedido,Timestamp fecha)
    {
        return cpd.itemsADevolver(idCliente,idPedido,fecha);
    }
    
    public java.util.List<ItemPedido> itemsDevueltos(String idCliente,String granja,String admin,Integer idPedido,Timestamp fecha)
    {
        return cpd.itemsDevueltos(idCliente, granja,admin ,idPedido, fecha);
    }
    
    public void efectuaDevolucion(ItemPedido a,String admin,Boolean estado)
    { 
        cpd.efectuaDevolucion(a, admin, estado);
    }
    
    public int contarPedidosPendientes()
    {
        return cpd.contarPedidosPendientes();
    }
    
    public ItemPedido itemMasAntiguo()
    {
        return cpd.itemMasAntiguo();
    }
    
    public float porcentajeItemsDevueltos(String admin)
    {
        return cpd.porcentajeItemsDevueltos(admin);
    }
}
