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
import java.sql.Date;
import java.util.Collection;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import pr.personal.challengekg.entity.EmpleadoInput;

/**
 *
 * @author PAULRCAMDELL
 */


@SecurityRequirement(name = "Bearer Authentication")
@PreAuthorize("hasRole('ADMIN')")
@Tag(name = "admin", description = "APIs de administrador")
@RequestMapping("/api/v1/admin")
public interface AdminAPI {
    
    @Operation(summary = "Buscar empleado por cédula", description = "Retorna el empleado", tags = {"admin"})
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

  
    
    @Operation(summary = "Crear empleado", description = "Crear empleado, tienes que estar loggeado.", tags = {"admin"})
    @ApiResponses(value = {
        @ApiResponse(description = "Operación exitosa", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Empleado.class))})})
    @PostMapping(value = "/", consumes = {"application/json", "application/x-www-form-urlencoded"})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crearEmpleado(
            @NotNull
            @Parameter(description = "Objeto empleado", required = true)
            @Valid @RequestBody EmpleadoInput body)
            throws Exception;
    @Operation(summary = "Obtener empleados", description = "Enlistar todos los empleados", tags = {"admin"})
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Empleado> findEmpleados();


    
     @Operation(summary = "Obtener empleados por tipo de vacuna", description = "Enlistar empleados por tipo de vacuna", tags = {"admin"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operación correcta", content = @Content(schema = @Schema(implementation = Empleado.class))),
        @ApiResponse(responseCode = "400", description = "valor inválido", content = @Content),
        @ApiResponse(responseCode = "404", description = "Empleado no encontrado", content = @Content)})
    @RequestMapping(value = "/vacuna/{tipo}", produces = {"application/json", "application/vnd.api+json"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Collection<Empleado> findEmpleadosByVacuna(
            @Parameter(description = "Tipo de Vacuna", required = true)
            @PathVariable String tipo)
            throws Exception;

  
      @Operation(summary = "Obtener empleados por estado de vacunación", description = "Enlistar empleados por estado de vacunación", tags = {"admin"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operación correcta", content = @Content(schema = @Schema(implementation = Empleado.class))),
        @ApiResponse(responseCode = "400", description = "estado inválido", content = @Content),
        @ApiResponse(responseCode = "404", description = "Empleado no encontrado", content = @Content)})
    @RequestMapping(value = "/estado/{state}", produces = {"application/json", "application/vnd.api+json"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Collection<Empleado> findEmpleadosByState(
            @Parameter(description = "Estado de Vacunación", required = true)
            @PathVariable boolean state)
            throws Exception;

    
    
    
    
    @Operation(summary = "Obtener empleados por rango de vacunacion", description = "Enlistar empleados por rango de vacunacion", tags = {"admin"})
    @RequestMapping(value = "/{since}/{to}", produces = {"application/json", "application/vnd.api+json"}, method = RequestMethod.GET)
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Empleado> listByRangeVacunacion(
            @Parameter(description = "fecha inicial", required = true)
            @PathVariable Date since,
            @Parameter(description = "fecha final", required = true)
            @PathVariable Date to);

    
    @DeleteMapping("/{cedula}")
    @ResponseStatus(HttpStatus.OK)
    public long deleteEmpleado(@PathVariable final int cedula);
}
