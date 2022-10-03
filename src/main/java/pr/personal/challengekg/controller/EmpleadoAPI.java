/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr.personal.challengekg.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Collection;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import pr.personal.challengekg.entity.Empleado;

/**
 *
 * @author PAULRCAMDELL
 */
@Tag(name = "empleado", description = "API de Empleados")
@RequestMapping("/api/v1/empleados")
public interface EmpleadoAPI {

    @Operation(summary = "Buscar empleado por cédula", description = "Retorna el empleado", tags = {"empleado"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operación correcta", content = @Content(schema = @Schema(implementation = Empleado.class))),
        @ApiResponse(responseCode = "400", description = "Cédula inválida", content = @Content),
        @ApiResponse(responseCode = "404", description = "Empleado no encontrado", content = @Content)})
    @RequestMapping(value = "/{cedula}", produces = {"application/json", "application/vnd.api+json"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Empleado> findEmpleadosByCedula(
            @Parameter(description = "Cédula de empleado", required = true)
            @PathVariable int cedula,
            @NotNull @Parameter(description = "Selecciona el tipo de data para buscar", required = true)
            @Valid @RequestHeader(value = "empleadoAuthorization", required = true) String empleadoAuthorization)
            throws Exception;

    @Operation(summary = "Obtener empleados", description = "Enlistar todos los empleados", tags = {"empleado"})
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Empleado> findEmpleados();

    @PutMapping("/{cedula}")
    @ResponseStatus(HttpStatus.OK)
    public Empleado updateEmpleado(@PathVariable("empleado") final String cedula, @RequestBody final Empleado empleado);

    @PatchMapping("/{cedula}")
    @ResponseStatus(HttpStatus.OK)
    public Empleado patchEmpleado(@PathVariable("cedula") final String cedula, @RequestBody final Empleado empleado);

    
    
    @Operation(summary = "Crear empleado", description = "Crear empleado, tienes que estar loggeado.", tags = {"empleado"})
    @ApiResponses(value = {
        @ApiResponse(description = "Operación exitosa", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Empleado.class))})})
    @PostMapping(value = "/", consumes = {"application/json", "application/x-www-form-urlencoded"})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Empleado> crearEmpleado(
            @NotNull
            @Parameter(description = "Objeto empleado", required = true)
            @Valid @RequestBody Empleado body,
            @NotNull @Parameter(description = "Seleccionar el tipo de data", required = true)
            @Valid @RequestHeader(value = "empleadoAuthorization", required = true) String empleadoAuthorization)
            throws Exception;

    
    
    
    
    @RequestMapping(method = RequestMethod.HEAD, value = "/")
    @ResponseStatus(HttpStatus.OK)
    public Empleado headEmpleado();

    @DeleteMapping("/{cedula}")
    @ResponseStatus(HttpStatus.OK)
    public long deleteEmpleado(@PathVariable final int cedula);
}
