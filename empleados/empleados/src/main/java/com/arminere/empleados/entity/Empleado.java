package com.arminere.empleados.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Data
public class Empleado {
    @Id
    private String identificacion;
    @Column
    private  String primerApellido;
    @Column
    private String segundoApellido;
    @Column
    private String primerNombre;
    @Column
    private String otrosNombre;
    @Column
    private String pais;
    @Column
    private String tipoId;
    @Column
    private String correoElectronico;
    @Column
    private LocalDateTime fechaIngreso;
    @Column
    private String area;
    @Column
    private String estado;
    @Column
    private LocalDateTime fechaRegistro;
    @Column
    private String foto;
}
