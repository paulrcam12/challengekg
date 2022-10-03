/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr.personal.challengekg.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author PAULRCAMDELL
 */
@Schema(description = "Empleado Object")
@Data
@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {

    @Id
    @Column(name = "cedula", nullable = false)
    @OrderColumn
    @NotBlank
    @Size(min = 0, max = 10)
    @JsonProperty(value = "cedula", required = true, index = 10)
    @Schema(description = "Cédula del empleado",
            example = "0704678788", required = true)

    private Integer cedula;

    @JsonProperty(value = "nombres", required = true, index = 20)
    @NotBlank
    @Schema(description = "Nombre del empleado",
            example = "Wilson Paul", required = true)
    private String nombres;

    @JsonProperty(value = "apellidos", required = true, index = 30)
    @NotBlank
    @Schema(description = "Apellidos del empleado",
            example = "Rojas Campuzano", required = true)
    private String apellidos;

    @Email
    @NotBlank
    @JsonProperty(value = "email", required = true, index = 40)
    @Schema(description = "Correo Electrónico del empleado",
            example = "paulrcam12@gmail.com", required = true)
    private String email;

    
    @JsonProperty(value = "fecha_nacimiento", required = true, index = 50)
    @Schema(description = "Fecha de nacimiento del empleado en formato yyyy-mm-dd",
            example = "1997-04-16", required = true)
    private Date fecha_nacimiento;

    @JsonProperty(value = "direccion", required = true, index = 60)
    @Schema(description = "Dirección del empleado",
            example = "Alborada", required = true)
    private String direccion;

    @JsonProperty(value = "telefono", required = true, index = 70)
    @Schema(description = "Teléfono del empleado",
            example = "0987114476", required = true)
    private Integer telefono;

    @JsonProperty(value = "vacunado", required = true, index = 80)
    @Schema(description = "Estado de vacunación de empleado",
            example = "true", required = true)
    private boolean vacunado;

}
