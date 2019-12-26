package aplicacion;

import gui.FachadaGUI;
import baseDatos.FachadaBase;


public class GestionUsuarios
{
    FachadaGUI fgui;
    FachadaBase fbd;
   

    public GestionUsuarios(FachadaGUI fgui, FachadaBase fbd)
    {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    // Se cormpueba que usuario con los datos pasados por parametro existe en la
    // base de datos y es administrador
    public Usuario comprobarAutentificacion(String idUsuario, String clave)
    {
        Usuario u;

        return fbd.validarUsuario(idUsuario, clave);
    }
    
    public String comprobarEmail(String email)
    {
        return fbd.comprobarEmail(email);
    }
    
    public void registrarUsuario(String nombreUsuario, String correo, String direccion, String clave, String tipoUsuario)
    {
        fbd.registrarUsuario(nombreUsuario, correo, direccion, clave, tipoUsuario);
    }
    
    public void actualizarUsuario(aplicacion.Usuario usuario, String nombreOriginal)
    {
        fbd.actualizarUsuario(usuario, nombreOriginal);
    }
    
    public void eliminarUsuario(Usuario usuario)
    {
        fbd.eliminarUsuario(usuario);
    }
}
