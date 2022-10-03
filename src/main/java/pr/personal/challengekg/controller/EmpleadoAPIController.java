/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr.personal.challengekg.controller;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pr.personal.challengekg.entity.Empleado;
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
            int cedula,
            String empleadoAuthorization) throws Exception {

        Empleado empleado = repository.findById(cedula)
                .orElseThrow(null);
        return ResponseEntity.ok(empleado);

    }

    @Override
    public List<Empleado> findEmpleados() {
        return (List<Empleado>) repository.findAll();
    }

    @PutMapping("/{cedula}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Empleado updateEmpleado(@PathVariable("cedula") final String cedula, @RequestBody final Empleado empleado) {
        return empleado;
    }

    @PatchMapping("/{cedula}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Empleado patchEmpleado(@PathVariable("cedula") final String cedula, @RequestBody final Empleado empleado) {
        return empleado;
    }

    @Override
    public ResponseEntity<Empleado> crearEmpleado(Empleado body,
            String empleadoAuthorization) throws Exception {
        return new ResponseEntity<>(repository.save(body), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.HEAD, value = "/")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public Empleado headEmpleado() {
        return new Empleado();
    }

    @DeleteMapping("/{cedula}")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public long deleteEmpleado(@PathVariable final int cedula) {
        return cedula;
    }

}
