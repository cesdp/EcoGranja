package baseDatos;

import aplicacion.Usuario;
import aplicacion.UsuarioAdministrador;
import aplicacion.UsuarioCliente;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class DAOUsuarios extends AbstractDAO {
    
    public DAOUsuarios (Connection conexion, aplicacion.FachadaAplicacion fa)
    {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public Usuario validarUsuario(String idUsuario, String clave)
    {
        Usuario resultado=null;
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsUsuario;
        ImageIcon imagen;

        con=this.getConexion();

        try 
        {
            if(clave != null)
            {
                con.setAutoCommit(false);
                stmUsuario=con.prepareStatement("select nombrecuenta,pgp_sym_decrypt(clave::bytea,'AES_KEY') as clave, email,direccion,imagenusuario,esproductor,esconsumidor,numerosocio,nombrepropio,apellidos,dni,numerocuenta,direccionenvio,localidad,provincia,pais,telefonocontacto,saldopropio "+
                                            "from  usuarioclienteproductorcomprador "+
                                            "where nombrecuenta = ? and pgp_sym_decrypt(clave::bytea,'AES_KEY')=?");
                
                stmUsuario.setString(1, idUsuario);
                stmUsuario.setString(2, clave);
                rsUsuario=stmUsuario.executeQuery();

                if (rsUsuario.next())
                {                 
                    if(rsUsuario.getBytes("imagenUsuario") == null)
                        imagen = null;
                    else
                        imagen = new ImageIcon(rsUsuario.getBytes("imagenUsuario"));
                    
                    if(rsUsuario.getBoolean("esproductor") == true && rsUsuario.getBoolean("esconsumidor") == true)
                    {
                        resultado = new UsuarioCliente(rsUsuario.getString("nombrecuenta"), rsUsuario.getString("clave"),
                            rsUsuario.getString("email"), rsUsuario.getString("direccion"),
                            imagen, rsUsuario.getInt("numerosocio"),
                            rsUsuario.getString("nombrepropio"),rsUsuario.getString("apellidos"),
                            rsUsuario.getString("dni"),rsUsuario.getString("numerocuenta"),
                            rsUsuario.getString("direccionenvio"),rsUsuario.getString("localidad"),
                            rsUsuario.getString("provincia"),rsUsuario.getString("pais"),rsUsuario.getString("telefonocontacto"),rsUsuario.getFloat("saldopropio"));
                    }
                    else if(rsUsuario.getBoolean("esproductor") == true && rsUsuario.getBoolean("esconsumidor") == false)
                    {
                        resultado = new UsuarioCliente(rsUsuario.getString("nombrecuenta"), rsUsuario.getString("clave"),
                            rsUsuario.getString("email"), rsUsuario.getString("direccion"),
                            imagen, rsUsuario.getInt("numerosocio"),
                            rsUsuario.getString("nombrepropio"),rsUsuario.getString("apellidos"),
                            rsUsuario.getString("dni"),rsUsuario.getString("numerocuenta"));
                        ((UsuarioCliente)resultado).setSaldoPropio(rsUsuario.getFloat("saldopropio"));
                    }
                    else if(rsUsuario.getBoolean("esproductor") == false && rsUsuario.getBoolean("esconsumidor") == true)
                    {
                        resultado = new UsuarioCliente(rsUsuario.getString("nombrecuenta"), rsUsuario.getString("clave"),
                            rsUsuario.getString("email"), rsUsuario.getString("direccion"),
                            imagen, rsUsuario.getInt("numerosocio"),
                            rsUsuario.getString("nombrepropio"),rsUsuario.getString("apellidos"),
                            rsUsuario.getString("direccionenvio"),rsUsuario.getString("localidad"),
                            rsUsuario.getString("provincia"),rsUsuario.getString("pais"),rsUsuario.getString("telefonocontacto"),rsUsuario.getFloat("saldopropio"));
                    }
                    else
                        throw(new SQLException("Incoherencia en el tipo de usuario."));
                }

                stmUsuario=con.prepareStatement("select nombrecuenta,pgp_sym_decrypt(clave::bytea,'AES_KEY') as clave ,email,direccion,imagenusuario,numeroadmin "+
                                            "from  usuarioadministrador "+
                                            "where nombrecuenta = ? and pgp_sym_decrypt(clave::bytea,'AES_KEY')=?");

                stmUsuario.setString(1, idUsuario);
                stmUsuario.setString(2, clave);
                rsUsuario=stmUsuario.executeQuery();

                if (rsUsuario.next())
                {
                    if(rsUsuario.getBytes("imagenUsuario") == null)
                        imagen = null;
                    else
                        imagen = new ImageIcon(rsUsuario.getBytes("imagenUsuario"));
                    
                    resultado = new UsuarioAdministrador(rsUsuario.getString("nombrecuenta"), rsUsuario.getString("clave"),
                        rsUsuario.getString("email"), rsUsuario.getString("direccion"),
                        imagen,rsUsuario.getInt("numeroAdmin"));

                }
            }
            else
            {
                stmUsuario=con.prepareStatement("select nombrecuenta,pgp_sym_decrypt(clave::bytea,'AES_KEY') as clave, email,direccion,imagenusuario,esproductor,esconsumidor,numerosocio,nombrepropio,apellidos,dni,numerocuenta,direccionenvio,localidad,provincia,pais,telefonocontacto "+
                                            "from  usuarioclienteproductorcomprador "+
                                            "where nombrecuenta = ?");
                
                stmUsuario.setString(1, idUsuario);
                rsUsuario=stmUsuario.executeQuery();

                if (rsUsuario.next())
                {
                    if(rsUsuario.getBytes("imagenUsuario") == null)
                        imagen = null;
                    else
                        imagen = new ImageIcon(rsUsuario.getBytes("imagenUsuario"));
                    
                    resultado = new UsuarioCliente(rsUsuario.getString("nombrecuenta"), rsUsuario.getString("clave"),
                        rsUsuario.getString("email"), rsUsuario.getString("direccion"),
                        imagen,rsUsuario.getInt("numerosocio"),
                        rsUsuario.getString("nombrepropio"),rsUsuario.getString("apellidos"),
                        rsUsuario.getString("dni"),rsUsuario.getString("numerocuenta"),
                        rsUsuario.getString("direccionenvio"),rsUsuario.getString("localidad"),
                        rsUsuario.getString("provincia"),rsUsuario.getString("pais"),rsUsuario.getString("telefonocontacto"),rsUsuario.getFloat("saldopropio"));

                }

                stmUsuario=con.prepareStatement("select nombrecuenta,pgp_sym_decrypt(clave::bytea,'AES_KEY') as clave ,email,direccion,imagenusuario,numeroadmin "+
                                            "from  usuarioadministrador "+
                                            "where nombrecuenta = ?");

                stmUsuario.setString(1, idUsuario);
                rsUsuario=stmUsuario.executeQuery();

                if (rsUsuario.next())
                {
                    if(rsUsuario.getBytes("imagenUsuario") == null)
                        imagen = null;
                    else
                        imagen = new ImageIcon(rsUsuario.getBytes("imagenUsuario"));
                    
                    resultado = new UsuarioAdministrador(rsUsuario.getString("nombrecuenta"), rsUsuario.getString("clave"),
                        rsUsuario.getString("email"), rsUsuario.getString("direccion"),
                        imagen,rsUsuario.getInt("numeroAdmin"));

                }
            }
            con.commit();
        } 
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().mostrarAviso(e.getMessage());
            try {
                con.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().mostrarAviso(e.getMessage());
            }
        }
        finally
        {
            try {stmUsuario.close();con.setAutoCommit(true);} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return resultado;
    }
    
    public String comprobarEmail(String email)
    {
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsUsuario;
        String retorno = null;

        con=this.getConexion();

        try 
        {
            con.setAutoCommit(false);
            stmUsuario=con.prepareStatement("select * "+
                                            "from  usuarioadministrador "+
                                            "where email = ?");
                
            stmUsuario.setString(1, email);
            rsUsuario=stmUsuario.executeQuery();
            
            if(rsUsuario.next())
                retorno = rsUsuario.getString("email");
            
            stmUsuario=con.prepareStatement("select * "+
                                            "from  usuarioclienteproductorcomprador "+
                                            "where email = ?");
            
            stmUsuario.setString(1, email);
            rsUsuario=stmUsuario.executeQuery();
            
            if(rsUsuario.next())
                retorno = rsUsuario.getString("email");
            con.commit();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().mostrarAviso(e.getMessage());
            try {
                con.rollback();
            } catch (SQLException ex) {
                System.out.println(e.getMessage());
                this.getFachadaAplicacion().mostrarAviso(e.getMessage());
            }
        }
        finally
        {
            try {stmUsuario.close();con.setAutoCommit(true);} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        
        return retorno;
    }
    
    public void registrarUsuario(String nombreUsuario, String correo, String direccion, String clave, String tipoUsuario)
    {
        Connection con;
        PreparedStatement stmUsuario = null;
        
        con = getConexion();
        
        try
        {
            stmUsuario = con.prepareStatement("insert into usuarioclienteproductorcomprador(nombrecuenta, clave, email, direccion, esproductor, esconsumidor) values(?, PGP_SYM_ENCRYPT(?,'AES_KEY'), ?, ?, ?, ?)");
            
            stmUsuario.setString(1, nombreUsuario);
            stmUsuario.setString(2, clave);
            stmUsuario.setString(3, correo);
            stmUsuario.setString(4, direccion);
            
            switch (tipoUsuario) 
            {
                case "Cliente":
                    stmUsuario.setBoolean(5, false);
                    stmUsuario.setBoolean(6, true);
                    break;
                case "Granjero":
                    stmUsuario.setBoolean(5, true);
                    stmUsuario.setBoolean(6, false);
                    break;
                default:
                    stmUsuario.setBoolean(5, true);
                    stmUsuario.setBoolean(6, true);
            }
             
            stmUsuario.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().mostrarAviso(e.getMessage());
        }
        finally
        {
            try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public void actualizarUsuario(Usuario usuario, String nombreOriginal)
    {
        Connection con;
        PreparedStatement stmUsuario = null;
        byte[] bytes;
        
        con=this.getConexion();
        
        try
        {         
            if(usuario.getImagenUsuario() != null)
            {
                BufferedImage bi = new BufferedImage(usuario.getImagenUsuario().getIconWidth(), usuario.getImagenUsuario().getIconHeight(), BufferedImage.TYPE_INT_RGB);
                usuario.getImagenUsuario().paintIcon(null, bi.createGraphics(), 0,0);
                java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
                javax.imageio.ImageIO.write(bi, "jpg", baos);
                bytes = baos.toByteArray();
            }
            else
                bytes = null;
            
            if(usuario instanceof UsuarioAdministrador)
            {
                stmUsuario = con.prepareStatement("update usuarioadministrador set nombrecuenta = ?, clave = PGP_SYM_ENCRYPT(?,'AES_KEY'), email = ?, direccion = ?, imagenusuario = ? where nombrecuenta = ?");
            
                stmUsuario.setString(6, nombreOriginal);
            }
            else if(usuario instanceof UsuarioCliente && ((UsuarioCliente)usuario).isConsumidor())
            {
                stmUsuario = con.prepareStatement("update usuarioclienteproductorcomprador set nombrecuenta = ?, clave = PGP_SYM_ENCRYPT(?,'AES_KEY'), email = ?, direccion = ?, imagenusuario = ?, nombrepropio = ?, apellidos = ?, direccionenvio = ?, localidad = ?, provincia = ?, pais = ?, telefonocontacto = ? where nombrecuenta = ?");

                UsuarioCliente u = (UsuarioCliente)usuario;

                stmUsuario.setString(6, u.getNombrePropio());
                stmUsuario.setString(7, u.getApellidos());
                stmUsuario.setString(8, u.getDireccionEnvio());
                stmUsuario.setString(9, u.getLocalidad());
                stmUsuario.setString(10, u.getProvincia());
                stmUsuario.setString(11, u.getPais());
                stmUsuario.setString(12, u.getTelefonoContacto());
                stmUsuario.setString(13, nombreOriginal);
            }
            else
            {
                stmUsuario = con.prepareStatement("update usuarioclienteproductorcomprador set nombrecuenta = ?, clave = PGP_SYM_ENCRYPT(?,'AES_KEY'), email = ?, direccion = ?, imagenusuario = ?, nombrepropio = ?, apellidos = ?, dni = ?, numerocuenta = ? where nombrecuenta = ?");
                
                UsuarioCliente u = (UsuarioCliente)usuario;

                stmUsuario.setString(6, u.getNombrePropio());
                stmUsuario.setString(7, u.getApellidos());
                stmUsuario.setString(8, u.getDni());
                stmUsuario.setString(9, u.getNumeroCuenta());
                stmUsuario.setString(10, nombreOriginal);
            }
            
            stmUsuario.setString(1, usuario.getNombreCuenta());
            stmUsuario.setString(2, usuario.getClave());
            stmUsuario.setString(3, usuario.getEmail());
            stmUsuario.setString(4, usuario.getDireccion());
            stmUsuario.setBytes(5, bytes);
            
            stmUsuario.executeUpdate();
        }
        catch (SQLException | java.io.IOException e)
        {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().mostrarAviso(e.getMessage());
        }
        finally
        {
            try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
        
    public void eliminarUsuario(aplicacion.Usuario usuario)
    {
        Connection con;
        PreparedStatement borrado = null;
        
        con = getConexion();
        
        try
        {            
            if(usuario instanceof UsuarioAdministrador)
                borrado = con.prepareStatement("delete from usuarioadministrador where nombrecuenta = ?");
            else
                borrado = con.prepareStatement("delete from usuarioclienteproductorcomprador where nombrecuenta = ?");
                
            borrado.setString(1, usuario.getNombreCuenta());
                
            borrado.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().mostrarAviso(e.getMessage());
        }
        finally
        {
            try {borrado.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
}
