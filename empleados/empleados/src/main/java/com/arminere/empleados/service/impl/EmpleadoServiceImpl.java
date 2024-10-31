package com.arminere.empleados.service.impl;

import com.arminere.empleados.dto.EmpleadoDto;
import com.arminere.empleados.entity.Empleado;
import com.arminere.empleados.exception.custom.DateNotRangeException;
import com.arminere.empleados.exception.custom.ResourcesNotFoundException;
import com.arminere.empleados.mapper.EmpleadoMapper;
import com.arminere.empleados.repository.EmpleadoRepository;
import com.arminere.empleados.service.EmpleadoService;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    private final String dominio = "@tuarmi"; // teniendo mas tiempo este dato lo recibiria de base de datos junto con el complemento segun el pais

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public EmpleadoDto insertarEmpleado(EmpleadoDto empleadoDto) {
        if(empleadoRepository.findById(empleadoDto.getIdentificacion()).isPresent())
            throw new ResourcesNotFoundException("El usuario ya existe");

        validarFechaIngreso(empleadoDto.getFechaIngreso());
        empleadoDto.setCorreoElectronico(generarEmail(empleadoDto.getPrimerNombre(),empleadoDto.getPrimerApellido(),empleadoDto.getPais()));

        empleadoDto.setEstado("Activo");
        empleadoRepository.save(EmpleadoMapper.mapToEmpleado(empleadoDto, new Empleado()));
        return empleadoDto;
    }
    private void validarFechaIngreso(LocalDateTime fecha){
        LocalDateTime ahora =  LocalDateTime.now();
        LocalDateTime haceUnMes = ahora.minus(1, ChronoUnit.MONTHS);
        if (fecha.isAfter(ahora) || fecha.isBefore(haceUnMes)){
            throw new DateNotRangeException("La fecha de ingreso es inferior a hace un mes o mayor al dia de hoy");
        }
    }

    private String generarEmail(String primerNombre, String primerApellido, String pais) {

        String dominioComplete = dominio + (pais.equals("Colombia") ? ".com.co" : ".us");
        int id = 1;
        String email = primerNombre+primerApellido+dominioComplete;
        boolean emailExiste = true;
        while (emailExiste){
            if (empleadoRepository.getEmpleadoByCorreoElectronico(email) != null){
                email = primerNombre + primerApellido + id + dominioComplete;
                id++;
            }else {
                emailExiste = false;
            }
        }
        return email.toLowerCase();
    }

    @Override
    public EmpleadoDto actualizarEmpleado(EmpleadoDto empleadoDto) {
        Empleado empleadoOld = empleadoRepository
                .findById(empleadoDto.getIdentificacion())
                .orElseThrow(() -> new ResourcesNotFoundException("No se ha encontrado el empleado para actualizar"));


        if (!empleadoOld.getPrimerNombre().equals(empleadoDto.getPrimerNombre()) || !empleadoOld.getPrimerApellido().equals(empleadoDto.getPrimerApellido())){
            empleadoDto.setCorreoElectronico(generarEmail(empleadoDto.getPrimerNombre(),empleadoDto.getPrimerApellido(),empleadoDto.getPais()));
        }
        empleadoRepository.save(EmpleadoMapper.mapToEmpleado(empleadoDto, new Empleado()));
        return empleadoDto;
    }

    @Override
    public List<EmpleadoDto> getEmpleados() {
        return StreamSupport
                .stream(empleadoRepository.findAll()
                        .spliterator(),false)
                .map(data -> EmpleadoMapper.mapToEmpleadoDto(data,new EmpleadoDto())).collect(Collectors.toList());

    }
}
