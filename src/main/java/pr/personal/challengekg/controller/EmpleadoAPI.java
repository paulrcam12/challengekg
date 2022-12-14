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
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import pr.personal.challengekg.entity.Empleado;
import pr.personal.challengekg.entity.EmpleadoUpdate;

/**
 *
 * @author PAULRCAMDELL
 */


@SecurityRequirement(name = "Bearer Authentication")
@PreAuthorize("hasRole('USER')")
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
            @PathVariable int cedula)
            throws Exception;

    
    
    @Operation(summary = "Actualizar datos de empleado", description = "Ingresar cédula y datos para actualizar", tags = {"empleado"})
    @PutMapping("/{cedula}")
    @ResponseStatus(HttpStatus.OK)
    public Empleado updateEmpleado(@PathVariable("empleado") final String cedula, @RequestBody final EmpleadoUpdate empleado);

    
    
    /*
    @PatchMapping("/{cedula}")
    @ResponseStatus(HttpStatus.OK)
    public Empleado patchEmpleado(@PathVariable("cedula") final String cedula, @RequestBody final Empleado empleado);
*/
}
