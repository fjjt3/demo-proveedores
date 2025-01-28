package com.prueba_metrica.demo_proveedores.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("nombre")
    private String nombre;

    @Column(name = "fecha_alta")
    @JsonProperty("fechaAlta")
    private LocalDate fechaAlta;

    @Column(name = "client_id")
    @JsonProperty("clientId")
    private Long clientId;

    public Proveedor() {

    }

    public Proveedor(Long id, String nombre, LocalDate fechaAlta, Long clientId) {
        this.id = id;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
        this.clientId = clientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
