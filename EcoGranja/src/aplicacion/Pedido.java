package aplicacion;

import java.sql.Timestamp;
import java.util.List;

public class Pedido
{
    private Integer id;
    private String comprador;
    private boolean usaSaldoPropio;
    private Timestamp fechaCompra;
    private Double total;
    private Integer metodoPago;
    private java.util.List<ItemPedido> componentes;

    public Pedido(String comprador, boolean usaSaldoPropio, Timestamp fechaCompra, Integer metodoPago) 
    {
        this.comprador = comprador;
        this.usaSaldoPropio = usaSaldoPropio;
        this.fechaCompra = fechaCompra;
        this.metodoPago = metodoPago;
        this.componentes = new java.util.ArrayList<>();
    }

    public Pedido(Integer id, String comprador, boolean usaSaldoPropio, Timestamp fechaCompra, Double total, Integer metodoPago) {
        this.id = id;
        this.comprador = comprador;
        this.usaSaldoPropio = usaSaldoPropio;
        this.fechaCompra = fechaCompra;
        this.total = total;
        this.metodoPago = metodoPago;
        this.componentes = new java.util.ArrayList<>();
    }

    public Integer getId() 
    {
        return id;
    }

    public String getComprador() 
    {
        return comprador;
    }

    public boolean isUsaSaldoPropio() 
    {
        return usaSaldoPropio;
    }

    public Timestamp getFechaCompra() 
    {
        return fechaCompra;
    }

    public Double getTotal() 
    {
        return total;
    }

    public Integer getMetodoPago()
    {
        return metodoPago;
    }

    public List<ItemPedido> getComponentes() 
    {
        return componentes;
    }

    public void setUsaSaldoPropio(boolean usaSaldoPropio) 
    {
        this.usaSaldoPropio = usaSaldoPropio;
    }

    public void setMetodoPago(Integer metodoPago) 
    {
        this.metodoPago = metodoPago;
    }

    public void setComponentes(List<ItemPedido> componentes) 
    {
        this.componentes = componentes;
    }
}
