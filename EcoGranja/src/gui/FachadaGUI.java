package gui;

import aplicacion.UsuarioAdministrador;
import aplicacion.UsuarioCliente;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FachadaGUI 
{
    private final aplicacion.FachadaAplicacion fachadaAplicacion;
    
    public FachadaGUI(aplicacion.FachadaAplicacion fa)
    {
        fachadaAplicacion = fa;
    }
    
    public ImageIcon cargarImagen(javax.swing.JDialog padre, int ancho, int alto)
    {
        ImageIcon imagen = null;
        JFileChooser selectorArchivos = new JFileChooser();
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int resultado = selectorArchivos.showOpenDialog(padre);
        
        File archivo = selectorArchivos.getSelectedFile();
        
        if(archivo != null)
            imagen = new ImageIcon((new ImageIcon(archivo.getAbsolutePath()).getImage()).getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
        
        return imagen;
    }
    
    public void mostrarAviso(String cadena)
    {
        new VAviso(cadena).setVisible(true);
    }
    
    public void mostrarAviso(JDialog padre, String cadena)
    {
        new VAviso(padre, cadena).setVisible(true);
    }
    
    public void abrirInicioSesion()
    {
        new VAutenticacion(fachadaAplicacion).setVisible(true);
    }
    
    public void abrirRegistroUsuario()
    {
        (new VRegistro(fachadaAplicacion)).setVisible(true);
    }
    
    public void abrirPrincipalClientes(UsuarioCliente usuario)
    {
        (new VClientePrincipal(fachadaAplicacion, usuario)).setVisible(true);
    }
    
    public void abrirPrincipalGranjeros(UsuarioCliente usuario)
    {
        (new VGranjeroPrincipal(fachadaAplicacion, usuario)).setVisible(true);
    }
    
    public void abrirPrincipalAdministradores(UsuarioAdministrador usuario)
    {
        (new VAdministradorPrincipal(fachadaAplicacion, usuario)).setVisible(true);
    }
    
    public void abrirClientePerfil(JFrame padre, UsuarioCliente usuario)
    {
        (new VClientePerfil(padre, fachadaAplicacion, usuario)).setVisible(true);
    }
    
    public void abrirClientePedidos(JFrame padre, UsuarioCliente usuario)
    {
        (new VClientePedidos(padre, fachadaAplicacion, usuario)).setVisible(true);
    }
    
    public void abrirGranjeroGranjas(JFrame padre, UsuarioCliente usuario)
    {
        (new VGranjas(padre, fachadaAplicacion, usuario)).setVisible(true);
    }
    
    public void abrirGranjeroModificarGranja(JDialog padre, UsuarioCliente usuario, aplicacion.Granja granja)
    {
        (new VModificarGranja(padre, fachadaAplicacion, usuario, granja)).setVisible(true);
    }
    
    public void abrirGranjeroPerfil(JFrame padre, UsuarioCliente usuario)
    {
        (new VGranjeroPerfil(padre, fachadaAplicacion, usuario)).setVisible(true);
    }
    
    public void abrirAdministradorPendientes(JFrame padre, UsuarioAdministrador usuario)
    {
        (new VAdministradorPendientes(padre, fachadaAplicacion, usuario)).setVisible(true);
    }
    
    public void abrirAdministradorTotal(JFrame padre, UsuarioAdministrador usuario)
    {
        (new VAdministradorTotal(padre ,fachadaAplicacion,usuario)).setVisible(true);
    }
    
    public void abrirAdministradorPerfil(JFrame padre, UsuarioAdministrador usuario)
    {
        (new VAdministradorPerfil(padre, fachadaAplicacion, usuario)).setVisible(true);
    }
}
