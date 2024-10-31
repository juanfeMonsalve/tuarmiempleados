package com.arminere.empleados.dto;

import com.arminere.empleados.util.RegexUtils;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import lombok.Data;
import jakarta.validation.constraints.Pattern;

@Data
public class EmpleadoDto {
    @NotNull(message = "El campo no puede ser nulo")
    @Size(max = 20, message = "El tamaño máximo permitido es 20")
    @Pattern(regexp = RegexUtils.REGEX_02, message = "Formato inválido")
    private String identificacion;
    @NotNull(message = "El campo no puede ser nulo")
    @Size(max = 20, message = "El tamaño máximo permitido es 20")
    @Pattern(regexp = RegexUtils.REGEX_01, message = "Formato inválido")
    private String primerApellido;
    @NotNull(message = "El campo no puede ser nulo")
    @Size(max = 20, message = "El tamaño máximo permitido es 20")
    @Pattern(regexp = RegexUtils.REGEX_01, message = "Formato inválido")
    private String segundoApellido;
    @NotNull(message = "El campo no puede ser nulo")
    @Size(max = 20, message = "El tamaño máximo permitido es 20")
    @Pattern(regexp = RegexUtils.REGEX_01, message = "Formato inválido")
    private String primerNombre;
    @Size(max = 50, message = "El tamaño máximo permitido es 50")
    @Pattern(regexp = RegexUtils.REGEX_01, message = "Formato inválido")
    private String otrosNombre;
    private String pais;
    private String tipoId;
    private String correoElectronico;
    private LocalDateTime fechaIngreso;
    private String area;
    private String estado;
    private LocalDateTime fechaRegistro;
    private String foto;
}
