package com.educandoweb.curso.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
@Entity
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant momento;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Pedido() {
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

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Pedido(Long id, Instant momento, Usuario cliente) {
        this.id = id;
        this.momento = momento;
        this.cliente = cliente;
    }
}
