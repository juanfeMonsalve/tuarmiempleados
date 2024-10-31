package com.arminere.empleados.controller;

import com.arminere.empleados.dto.EmpleadoDto;
import com.arminere.empleados.service.EmpleadoService;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/getEmpleados/{page}/{pageSize}")
    public ResponseEntity<List<EmpleadoDto>> getEmpleado(@PathVariable("page") int page,@PathVariable("pageSize") int pageSize){
        List<EmpleadoDto> empleadoDtos = empleadoService.getEmpleados();
        int fromIndex = (page - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, empleadoDtos.size());

        if (fromIndex > empleadoDtos.size()) {
            return ResponseEntity.ok(new ArrayList<>());
        }
        return ResponseEntity.ok(empleadoDtos.subList(fromIndex,toIndex));
    }

    @PostMapping("/insertEmpleado")
    public ResponseEntity<EmpleadoDto> insertEmpleado(@RequestBody @Valid EmpleadoDto empleadoDto){
        return ResponseEntity.ok(empleadoService.insertarEmpleado(empleadoDto));
    }
    @PostMapping("/updateEmpleado")
    public ResponseEntity<EmpleadoDto> updateEmpleado(@RequestBody @Valid EmpleadoDto empleadoDto){
        return ResponseEntity.ok(empleadoService.actualizarEmpleado(empleadoDto));
    }
}
