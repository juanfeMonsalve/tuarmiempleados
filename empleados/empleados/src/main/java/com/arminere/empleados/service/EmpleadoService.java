package com.arminere.empleados.service;

import com.arminere.empleados.dto.EmpleadoDto;
import java.util.List;

public interface EmpleadoService {

    EmpleadoDto insertarEmpleado(EmpleadoDto empleadoDto);
    EmpleadoDto actualizarEmpleado(EmpleadoDto empleadoDto);

    List<EmpleadoDto> getEmpleados();

}
