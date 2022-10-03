/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr.personal.challengekg.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pr.personal.challengekg.entity.Empleado;

/**
 *
 * @author PAULRCAMDELL
 */
@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Integer>{
    
   
    
}
