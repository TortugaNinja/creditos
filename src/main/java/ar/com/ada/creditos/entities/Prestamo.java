package ar.com.ada.creditos.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//Las anotaciones se crearon dar caracteristicas a la clase sin tener que crear atributos.
//@Entity indica cual clase actuara como entidad
//@Table indica a cual tabla va a persistirse ese objeto
@Entity
@Table(name = "prestamo")
public class Prestamo {
    @Id //es PK
    @Column(name = "prestamo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //como es autoincremental se utiliza @GeneratedValue.
    private int prestamoId;
    private BigDecimal importe;
    private Date fecha;
    private int cuota;
    @Column(name = "fecha_alta")
    private Date fechaAlta;
// esto es lo que tenemos que pensar en objetos: clienteId no le pertenece a prestamo sino que es al contrario.
// entonces no es un atributo si no, un OBJETO.
    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id") //la primera es la FK, la segunda la PK en sus respectivas tablas.
    private Cliente cliente;

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.cliente.getPrestamos().add(this);
    }

    
}