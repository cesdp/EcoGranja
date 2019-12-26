package aplicacion;

import javax.swing.ImageIcon;

public abstract class Usuario 
{
    private String nombreCuenta, clave, email, direccion;
    private ImageIcon imagenUsuario;
    private String extension;
    
    public Usuario(String nombreCuenta, String clave, String email, String direccion, ImageIcon imagenUsuario)
    {
        this.nombreCuenta = nombreCuenta;
        this.clave = clave;
        this.email = email;
        this.direccion = direccion;
        this.imagenUsuario = imagenUsuario;
        
        extension = null;
    }

    public String getNombreCuenta() 
    {
        return nombreCuenta;
    }

    public String getClave() 
    {
        return clave;
    }

    public String getEmail() 
    {
        return email;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public ImageIcon getImagenUsuario() 
    {
        return imagenUsuario;
    }

    public String getExtension() 
    {
        return extension;
    }

    public void setNombreCuenta(String nombreCuenta)
    {
        this.nombreCuenta = nombreCuenta;
    }

    public void setClave(String clave)
    {
        this.clave = clave;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public void setImagenUsuario(ImageIcon imagenUsuario) 
    {
        this.imagenUsuario = imagenUsuario;
    }
    
    public void setExtension(String extension)
    {
        this.extension = extension;
    }
}
