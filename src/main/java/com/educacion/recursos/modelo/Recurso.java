package com.educacion.recursos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalTime;

@Entity
@Table(name = "recursos")
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ─── Campos existentes ───────────────────────────────────
    private String titulo;
    private String tipo;
    private String url;
    private Boolean disponible;
    private String nombreDocente;

    // ─── Campos nuevos del alumno ────────────────────────────
    private String nombreAlumno;
    private Integer edad;
    private Integer horasEnAcademia;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private String nombreProfesor;
    private String materiaReforzamiento;

    // ─── Constructor vacío (obligatorio para JPA) ────────────
    public Recurso() {
    }

    // ─── Constructor con parámetros existentes ───────────────
    public Recurso(String titulo, String tipo, String url, Boolean disponible, String nombreDocente) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.url = url;
        this.disponible = disponible;
        this.nombreDocente = nombreDocente;
    }

    // ─── Getters y Setters existentes ────────────────────────
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    // ─── Getters y Setters nuevos del alumno ─────────────────
    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getHorasEnAcademia() {
        return horasEnAcademia;
    }

    public void setHorasEnAcademia(Integer horasEnAcademia) {
        this.horasEnAcademia = horasEnAcademia;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getMateriaReforzamiento() {
        return materiaReforzamiento;
    }

    public void setMateriaReforzamiento(String materiaReforzamiento) {
        this.materiaReforzamiento = materiaReforzamiento;
    }
}