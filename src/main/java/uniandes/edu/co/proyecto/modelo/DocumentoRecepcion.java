package uniandes.edu.co.proyecto.modelo;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "documentorecepcion")
public class DocumentoRecepcion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_doc_entrega_id")
    @SequenceGenerator(name = "seq_doc_entrega_id", sequenceName = "SEQ_DOC_ENTREGA_ID", allocationSize = 1)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "FECHAENTREGADO")
    private Date fechaEntregado;

    @ManyToOne
    @JoinColumn(name = "BODEGA_BODEGA_ID")
    private Bodega idBodega;

    @OneToOne
    @JoinColumn(name = "ORDENCOMPRA_ORDENCOMPRA_ID")
    private OrdenCompra ordenCompra;

    // Constructores
    public DocumentoRecepcion(Date fechaEntregado, Bodega idBodega, OrdenCompra ordenCompra) {
        this.fechaEntregado = fechaEntregado;
        this.idBodega = idBodega;
        this.ordenCompra = ordenCompra;
    }

    public DocumentoRecepcion() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaEntregado() {
        return fechaEntregado;
    }

    public void setFechaEntregado(Date fechaEntregado) {
        this.fechaEntregado = fechaEntregado;
    }

    public Bodega getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Bodega idBodega) {
        this.idBodega = idBodega;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }
}
