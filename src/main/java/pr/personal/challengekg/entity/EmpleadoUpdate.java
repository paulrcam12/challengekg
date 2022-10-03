/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr.personal.challengekg.entity;

import java.sql.Date;
import lombok.Data;

/**
 *
 * @author PAULRCAMDELL
 */
@Data
public class EmpleadoUpdate {
    
    
    Date fecha_nacimiento;
    String direccion;
    int telefono;
    boolean vacunado;
    String tipo_vacuna;
    Date fecha_vacunacion;
    int num_dosis;
    
   
            
}
