/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr.personal.challengekg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pr.personal.challengekg.entity.Empleado;
import pr.personal.challengekg.entity.EmpleadoUpdate;
import pr.personal.challengekg.repos.EmpleadoRepository;

/**
 *
 * @author PAULRCAMDELL
 */
@RestController
public class EmpleadoAPIController implements EmpleadoAPI {

    @Autowired
    private EmpleadoRepository repository;

    @Override
    public ResponseEntity<Empleado> findEmpleadosByCedula(
            int cedula) throws Exception {

        Empleado empleado = repository.findById(cedula)
                .orElseThrow(null);
        return ResponseEntity.ok(empleado);

    }

    @PutMapping("/{cedula}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Empleado updateEmpleado(@PathVariable("cedula") final String cedula, @RequestBody final EmpleadoUpdate empleadoup) {
        
        Empleado empleado = repository.findById(Integer.parseInt(cedula))
                .orElseThrow(null);
        
        
        empleado.setFecha_nacimiento(empleadoup.getFecha_nacimiento());
        empleado.setFecha_vacunacion(empleadoup.getFecha_vacunacion());
        empleado.setNum_dosis(empleadoup.getNum_dosis());
        empleado.setDireccion(empleadoup.getDireccion());
        empleado.setTelefono(empleadoup.getTelefono());
        empleado.setVacunado(empleadoup.isVacunado());
        empleado.setTipo_vacuna(empleadoup.getTipo_vacuna());
        
        repository.save(empleado);
        
        
        return empleado;
    }

   

   

}
