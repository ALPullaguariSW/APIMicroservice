package com.taller.PaqueteTuristico.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

@Entity
@Table(name = "paquetes_turisticos")
public class PaqueteTuristico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(max = 500, message = "La descripción no puede exceder los 500 caracteres")
    @Column(name = "descripcion", length = 500)
    private String descripcion;

    // Validación para asegurarse de que la duración sea un número positivo
    @NotNull(message = "La duración no puede ser nula")
    @Min(value = 1, message = "La duración debe ser al menos 1 día")
    @Positive(message = "La duración debe ser un número positivo")
    @Column(name = "duracion_dias", nullable = false)
    private int duracionDias;

    // Validación para asegurarse de que la fecha de inicio sea una fecha futura o presente
    @NotNull(message = "La fecha de inicio no puede ser nula")
    @FutureOrPresent(message = "La fecha de inicio debe ser hoy o una fecha futura")
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    // Validación para asegurarse de que el precio sea un número positivo
    @NotNull(message = "El precio no puede ser nulo")
    @Positive(message = "El precio debe ser un número positivo")
    @Column(name = "precio", nullable = false)
    private Double precio;

    // Validación adicional para verificar que el código de paquete sea numérico
    @Pattern(regexp = "^\\d+$", message = "El código de paquete debe ser numérico")
    @Column(name = "codigo_paquete", nullable = false, length = 20)
    private String codigoPaquete;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
