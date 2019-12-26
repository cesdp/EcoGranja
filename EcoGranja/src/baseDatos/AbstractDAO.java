package baseDatos;

public abstract class AbstractDAO 
{
    private aplicacion.FachadaAplicacion fachadaAplicacion;
    private java.sql.Connection conexion;

    protected java.sql.Connection getConexion()
    {
        return conexion;
    }
    
    protected void setConexion(java.sql.Connection conexion)
    {
        this.conexion = conexion;
    }
   
   protected void setFachadaAplicacion(aplicacion.FachadaAplicacion fa)
   {
       fachadaAplicacion = fa;
   }
   
   protected aplicacion.FachadaAplicacion getFachadaAplicacion()
   {
       return fachadaAplicacion;
   }
}
