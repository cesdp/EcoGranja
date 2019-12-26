
package aplicacion;

public class Granja 
{
    private String nombre, cif, provincia, pais, direccion, tipo;
    
    public Granja(String nombre,String cif,String provincia,String pais,String direccion,String tipo)
    {
        this.nombre = nombre;
        this.cif = cif;
        this.provincia = provincia;
        this.pais = pais;
        this.direccion = direccion;
        this.tipo = tipo;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getCif() 
    {
        return cif;
    }

    public String getProvincia()
    {
        return provincia;
    }

    public String getPais()
    {
        return pais;
    }

    public String getDireccion()
    {
        return direccion;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public void setCif(String cif) 
    {
        this.cif = cif;
    }

    public void setProvincia(String provincia) 
    {
        this.provincia = provincia;
    }

    public void setPais(String pais) 
    {
        this.pais = pais;
    }

    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }
}
