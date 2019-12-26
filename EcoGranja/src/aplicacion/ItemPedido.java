/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author alumnogreibd
 */
public class ItemPedido {
    private Integer pedido;
    private Integer unidadesCompr;
    private boolean devolucion;
    private String administrador;
    private String comprador;
    private BigInteger lote;
    private Date fechaCaducidad;
    private String granja;
    private String producto;
    private Timestamp fechaDevolucion;
    private Timestamp fechaProcesado;
    private Integer unidadesDev;

    public ItemPedido(Integer pedido,Integer unidadesCompr, boolean devolucion, String administrador,String comprador ,BigInteger lote, Date fechaCaducidad, String granja, String producto, Timestamp fechaDevolucion, Timestamp fechaProcesado, Integer unidadesDev) {
        this.pedido=pedido;
        this.unidadesCompr = unidadesCompr;
        this.devolucion = devolucion;
        this.administrador = administrador;
        this.comprador=comprador;
        this.lote = lote;
        this.fechaCaducidad = fechaCaducidad;
        this.granja = granja;
        this.producto = producto;
        this.fechaDevolucion = fechaDevolucion;
        this.fechaProcesado = fechaProcesado;
        this.unidadesDev = unidadesDev;
    }

    public ItemPedido(Integer pedido,Integer unidadesCompr, BigInteger lote, Date fechaCaducidad, String granja, String producto) {
        this.pedido=pedido;
        this.unidadesCompr = unidadesCompr;
        this.lote = lote;
        this.fechaCaducidad = fechaCaducidad;
        this.granja = granja;
        this.producto = producto;
    }

    public Integer getPedido() {
        return pedido;
    }
 
    public Integer getUnidadesCompr() {
        return unidadesCompr;
    }

    public boolean isDevolucion() {
        return devolucion;
    }

    public String getAdministrador() {
        return administrador;
    }

    public BigInteger getLote() {
        return lote;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public String getComprador() {
        return comprador;
    }

    public String getGranja() {
        return granja;
    }

    public String getProducto() {
        return producto;
    }

    public Timestamp getFechaDevolucion() {
        return fechaDevolucion;
    }

    public Timestamp getFechaProcesado() {
        return fechaProcesado;
    }

    public Integer getUnidadesDev() {
        return unidadesDev;
    }

    public void setDevolucion(boolean devolucion) {
        this.devolucion = devolucion;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    public void setFechaDevolucion(Timestamp fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setFechaProcesado(Timestamp fechaProcesado) {
        this.fechaProcesado = fechaProcesado;
    }

    public void setUnidadesDev(Integer unidadesDev) {
        this.unidadesDev = unidadesDev;
    }
    
    
    
}
