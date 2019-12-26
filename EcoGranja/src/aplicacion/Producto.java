/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import javax.swing.ImageIcon;

/**
 *
 * @author alumnogreibd
 */
public class Producto {
    
    private String nombre;
    private String categoria;
    private String descripcion;
    private ImageIcon imagen;
    private Float coste;

    public Producto(String nombre, String categoria,String descripcion, ImageIcon imagen, Float coste) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion=descripcion;
        this.imagen = imagen;
        this.coste = coste;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    
    public ImageIcon getImagen() {
        return imagen;
    }

    public Float getCoste() {
        return coste;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public void setCoste(Float coste) {
        this.coste = coste;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
