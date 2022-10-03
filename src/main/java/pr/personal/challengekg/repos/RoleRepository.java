/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr.personal.challengekg.repos;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pr.personal.challengekg.entity.ERole;
import pr.personal.challengekg.entity.Role;

/**
 *
 * @author PAULRCAMDELL
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
     Optional<Role> findByName(ERole name);
}
