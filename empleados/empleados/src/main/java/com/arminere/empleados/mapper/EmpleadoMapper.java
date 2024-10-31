package com.arminere.empleados.mapper;

import com.arminere.empleados.dto.EmpleadoDto;
import com.arminere.empleados.entity.Empleado;

public class EmpleadoMapper {

    public static Empleado mapToEmpleado(EmpleadoDto empleadoDto, Empleado empleado){
        empleado.setPais(empleadoDto.getPais());
        empleado.setIdentificacion(empleadoDto.getIdentificacion());
        empleado.setCorreoElectronico(empleadoDto.getCorreoElectronico());
        empleado.setPrimerNombre(empleadoDto.getPrimerNombre());
        empleado.setTipoId(empleadoDto.getTipoId());
        empleado.setOtrosNombre(empleadoDto.getOtrosNombre());
        empleado.setPrimerApellido(empleadoDto.getPrimerApellido());
        empleado.setSegundoApellido(empleadoDto.getSegundoApellido());
        empleado.setFechaIngreso(empleadoDto.getFechaIngreso());
        empleado.setArea(empleadoDto.getArea());
        empleado.setEstado(empleadoDto.getEstado());
        empleado.setFoto(empleadoDto.getFoto());
        return empleado;
    }
    public static EmpleadoDto mapToEmpleadoDto(Empleado empleado,EmpleadoDto empleadoDto){
        empleadoDto.setPais(empleado.getPais());
        empleadoDto.setIdentificacion(empleado.getIdentificacion());
        empleadoDto.setCorreoElectronico(empleado.getCorreoElectronico());
        empleadoDto.setPrimerNombre(empleado.getPrimerNombre());
        empleadoDto.setTipoId(empleado.getTipoId());
        empleadoDto.setOtrosNombre(empleado.getOtrosNombre());
        empleadoDto.setPrimerApellido(empleado.getPrimerApellido());
        empleadoDto.setSegundoApellido(empleado.getSegundoApellido());
        empleadoDto.setFechaIngreso(empleado.getFechaIngreso());
        empleadoDto.setArea(empleado.getArea());
        empleadoDto.setEstado(empleado.getEstado());
        empleadoDto.setFoto(empleado.getFoto());
        return empleadoDto;
    }
}
