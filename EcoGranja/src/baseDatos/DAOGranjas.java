package baseDatos;

import aplicacion.Granja;
import aplicacion.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOGranjas extends AbstractDAO {
    
    public DAOGranjas (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public java.util.List<Granja> buscaGranjas(String nombre,String cif,String provincia,String pais,String direccion,String tipo,String usuario){
        java.util.List<Granja> resultado=new java.util.ArrayList<>();
        Connection con;
        PreparedStatement stmGranja=null;
        ResultSet rsGranja;

        con=this.getConexion();

        try{
            stmGranja=con.prepareStatement("select nombre,cif,provincia,pais,direccion,tipo"
                                          + " from granja"
                                          + " where nombre like ? and cif like ? and provincia like ? and pais like ? and direccion like ? and tipo like ? and productor like ?");
            stmGranja.setString(1, "%"+nombre+"%");
            stmGranja.setString(2, "%"+cif+"%");
            stmGranja.setString(3, "%"+provincia+"%");
            stmGranja.setString(4, "%"+pais+"%");
            stmGranja.setString(5, "%"+direccion+"%");
            stmGranja.setString(6, "%"+tipo+"%");
             stmGranja.setString(7, "%"+usuario+"%");
            rsGranja=stmGranja.executeQuery();
            while (rsGranja.next()) {
                // Se añade al resultado el lirbo, el numero ejemplar, el localizador y el prestamo que posee actualmente
                resultado.add(new Granja(rsGranja.getString("nombre"),
                        rsGranja.getString("cif"),
                        rsGranja.getString("provincia"),
                        rsGranja.getString("pais"),
                        rsGranja.getString("direccion"),
                        rsGranja.getString("tipo")));

            }
            
        }catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().mostrarAviso(e.getMessage());
        }finally{
          try {stmGranja.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    // Se presta el ejemplar dado j, al usuario dado u
    public void insertarGranja(Granja granja, Usuario u){
        Connection con;
        PreparedStatement stmGranja = null;

        // Se establce la conexion con el servidor
        con = super.getConexion();

        try {
            
            stmGranja = con.prepareStatement("insert into granja(nombre,cif,provincia,pais,direccion,tipo,productor) "
                    + "values (?,?,?,?,?,?,?)");
            
            stmGranja.setString(1, granja.getNombre());
            stmGranja.setString(2, granja.getCif());
            stmGranja.setString(3, granja.getProvincia());
            stmGranja.setString(4, granja.getPais());
            stmGranja.setString(5, granja.getDireccion());
            stmGranja.setString(6, granja.getTipo());
            stmGranja.setString(7, u.getNombreCuenta());
            stmGranja.executeUpdate();
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().mostrarAviso(e.getMessage());
        } finally {
            try {
                stmGranja.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public void modificarGranja(Granja granja){
        Connection con;
        PreparedStatement stmGranja = null;

        // Se establce la conexion con el servidor
        con = super.getConexion();

        try {
            
            stmGranja = con.prepareStatement("update granja "+
                                    "set cif=?, "+
                                    "    provincia=?, "+
                                    "    pais=?, "+
                                    "    direccion=?, "+
                                    "    tipo=? "+
                                    "where nombre=?");
            
            stmGranja.setString(1, granja.getCif());
            stmGranja.setString(2, granja.getProvincia());
            stmGranja.setString(3, granja.getPais());
            stmGranja.setString(4, granja.getDireccion());
            stmGranja.setString(5, granja.getTipo());
            stmGranja.setString(6, granja.getNombre());
            stmGranja.executeUpdate();
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().mostrarAviso(e.getMessage());
        } finally {
            try {
                stmGranja.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public void borrarGranjas(String nombre){
        Connection con;
        PreparedStatement stmGranja=null;

        //Se establece la conexion con el servidor
        con=super.getConexion();

        try {
            stmGranja=con.prepareStatement("delete from granja where nombre = ?");
            stmGranja.setString(1, nombre);
            stmGranja.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().mostrarAviso(e.getMessage());
        }finally{
          try {stmGranja.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
}
