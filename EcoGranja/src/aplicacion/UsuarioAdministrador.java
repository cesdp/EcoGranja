package aplicacion;

import javax.swing.ImageIcon;

public class UsuarioAdministrador extends Usuario
{
    private int numeroAdmin;
    
    public UsuarioAdministrador(String nombreCuenta, String clave, String email, String direccion, ImageIcon imagenUsuario, int numeroAdmin)
    {
        super(nombreCuenta, clave, email, direccion, imagenUsuario);
        
        this.numeroAdmin = numeroAdmin;
    }

    public int getNumeroAdmin() 
    {
        return numeroAdmin;
    }

    public void setNumeroAdmin(int numeroAdmin) 
    {
        this.numeroAdmin = numeroAdmin;
    }
}
