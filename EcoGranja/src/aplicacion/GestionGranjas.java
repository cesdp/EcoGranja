package aplicacion;

import gui.FachadaGUI;
import baseDatos.FachadaBase;

public class GestionGranjas
{
    FachadaGUI fgui;
    FachadaBase fbd;
   
    public GestionGranjas(FachadaGUI fgui, FachadaBase fbd)
    {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    public java.util.List<Granja> buscaGranjas(String nombre,String cif,String provincia,String pais,String direccion,String tipo,String usuario)
    {
        return fbd.buscaGranjas(nombre, cif, provincia, pais, direccion, tipo,usuario);
    }
    
    public void insertarGranja(Granja granja, Usuario u)
    {
        fbd.insertarGranja(granja, u);
    }
    
    public void modificarGranja(Granja granja)
    {
        fbd.modificarGranja(granja);
    }
    
    public void borrarGranjas(String nombre)
    {
        fbd.borrarGranjas(nombre);
    }
}
