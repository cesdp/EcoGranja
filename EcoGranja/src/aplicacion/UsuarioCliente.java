package aplicacion;

import javax.swing.ImageIcon;

public class UsuarioCliente extends Usuario
{
    private String nombrePropio, apellidos;
    private final boolean productor, consumidor;
    private int numeroSocio;
    private float saldoPropio;
    private final String dni, numeroCuenta;
    private String direccionEnvio, localidad, provincia, pais, telefonoContacto;
    
    public UsuarioCliente(String nombreCuenta, String clave, String email, String direccion, ImageIcon imagenUsuario, int numeroSocio, String nombrePropio, String apellidos, String dni, String numeroCuenta, String direccionEnvio, String localidad, String provincia, String pais, String telefonoContacto,float saldopropio)
    {
        super(nombreCuenta, clave, email, direccion, imagenUsuario);
        
        productor = true;
        consumidor = true;
        
        this.numeroSocio = numeroSocio;
        this.nombrePropio = nombrePropio;
        this.apellidos = apellidos;
        
        this.dni = dni;
        this.numeroCuenta = numeroCuenta;
        
        this.direccionEnvio = direccionEnvio;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
        this.telefonoContacto = telefonoContacto;
        
        saldoPropio = saldopropio;
    }
    
    public UsuarioCliente(String nombreCuenta, String clave, String email, String direccion, ImageIcon imagenUsuario, int numeroSocio, String nombrePropio, String apellidos, String dni, String numeroCuenta)
    {
        super(nombreCuenta, clave, email, direccion, imagenUsuario);
        
        productor = true;
        consumidor = false;
        
        this.numeroSocio = numeroSocio;
        this.nombrePropio = nombrePropio;
        this.apellidos = apellidos;
        
        this.dni = dni;
        this.numeroCuenta = numeroCuenta;
        
        direccionEnvio = null;
        localidad = null;
        provincia = null;
        pais = null;
        telefonoContacto = null;
        
        saldoPropio = 0;
    }
    
    public UsuarioCliente(String nombreCuenta, String clave, String email, String direccion, ImageIcon imagenUsuario, int numeroSocio, String nombrePropio, String apellidos, String direccionEnvio, String localidad, String provincia, String pais, String telefonoContacto,float saldopropio)
    {
        super(nombreCuenta, clave, email, direccion, imagenUsuario);
        
        productor = false;
        consumidor = true;
        
        this.numeroSocio = numeroSocio;
        this.nombrePropio = nombrePropio;
        this.apellidos = apellidos;
        
        dni = null;
        numeroCuenta = null;
        
        this.direccionEnvio = direccionEnvio;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
        this.telefonoContacto = telefonoContacto;
        
        saldoPropio = saldopropio;
    }

    public String getNombrePropio()
    {
        return nombrePropio;
    }

    public String getApellidos()
    {
        return apellidos;
    }

    public boolean isProductor()
    {
        return productor;
    }

    public boolean isConsumidor()
    {
        return consumidor;
    }

    public int getNumeroSocio()
    {
        return numeroSocio;
    }

    public float getSaldoPropio()
    {
        return saldoPropio;
    }

    public String getDni()
    {
        return dni;
    }

    public String getNumeroCuenta()
    {
        return numeroCuenta;
    }

    public String getDireccionEnvio()
    {
        return direccionEnvio;
    }

    public String getLocalidad()
    {
        return localidad;
    }

    public String getProvincia()
    {
        return provincia;
    }

    public String getPais()
    {
        return pais;
    }

    public String getTelefonoContacto()
    {
        return telefonoContacto;
    }

    public void setNombrePropio(String nombrePropio) 
    {
        this.nombrePropio = nombrePropio;
    }

    public void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }

    public void setNumeroSocio(int numeroSocio)
    {
        this.numeroSocio = numeroSocio;
    }

    public void setSaldoPropio(float saldoPropio)
    {
        this.saldoPropio = saldoPropio;
    }

    public void setDireccionEnvio(String direccionEnvio)
    {
        this.direccionEnvio = direccionEnvio;
    }

    public void setLocalidad(String localidad)
    {
        this.localidad = localidad;
    }

    public void setProvincia(String provincia)
    {
        this.provincia = provincia;
    }

    public void setPais(String pais)
    {
        this.pais = pais;
    }

    public void setTelefonoContacto(String telefonoContacto)
    {
        this.telefonoContacto = telefonoContacto;
    }
    
}
