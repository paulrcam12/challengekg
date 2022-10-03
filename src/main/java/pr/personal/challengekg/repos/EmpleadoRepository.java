/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr.personal.challengekg.repos;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pr.personal.challengekg.entity.Empleado;

/**
 *
 * @author PAULRCAMDELL
 */
@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Integer>{
    
    
   
   @Query (value= "SELECT * FROM public.empleados WHERE vacunado =?1",
   nativeQuery = true)
   Collection<Empleado>  listVacunadosByState(boolean state);
   
   
   @Query (value= "SELECT * FROM public.empleados WHERE tipo_vacuna = ?1",
   nativeQuery = true)
   Collection<Empleado>  listByTipoVacuna(String tipo_vacuna);
   //List<Empleado> findBytipo_vacuna(String tipo_vacuna);
   
   @Query (value= "SELECT * FROM public.empleados WHERE fecha_vacunacion BETWEEN ?1 AND ?2",
   nativeQuery = true)
   Collection<Empleado> findByDatesVacunacion(Date since, Date to);
    
}
