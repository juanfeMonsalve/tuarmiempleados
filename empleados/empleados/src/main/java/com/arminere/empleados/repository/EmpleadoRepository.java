package com.arminere.empleados.repository;

import com.arminere.empleados.entity.Empleado;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoRepository extends CrudRepository<Empleado, String> {
    Empleado getEmpleadoByCorreoElectronico(String email);
}
