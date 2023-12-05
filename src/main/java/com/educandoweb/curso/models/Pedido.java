package com.educandoweb.curso.models;

import com.educandoweb.curso.enuns.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
    private  static  final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd 'T' HH:mm:ss 'Z'" ,timezone = "GMT")
    private Instant momento;
    private Integer statusPedido;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    public Pedido() {
    }
    public Pedido(Long id, Instant momento, StatusPedido statusPedido,Usuario cliente) {
        super();
        this.id = id;
        this.momento = momento;
        setStatusPedido(statusPedido);
        this.cliente = cliente;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomento() {
        return momento;
    }

    public void setMomento(Instant momento) {
        this.momento = momento;
    }
    public StatusPedido getStatusPedido() {
        return StatusPedido.valueOf(statusPedido);
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        if(statusPedido != null) {
            this.statusPedido = statusPedido.getCodigo();
        }
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }
}
