/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr.personal.challengekg.controller;

import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import pr.personal.challengekg.entity.ERole;
import pr.personal.challengekg.entity.Empleado;
import pr.personal.challengekg.entity.EmpleadoInput;
import pr.personal.challengekg.entity.Role;
import pr.personal.challengekg.entity.User;
import pr.personal.challengekg.payload.response.MessageResponse;
import pr.personal.challengekg.repos.EmpleadoRepository;
import pr.personal.challengekg.repos.RoleRepository;
import pr.personal.challengekg.repos.UserRepository;
import pr.personal.challengekg.security.jwt.JwtUtils;

/**
 *
 * @author PAULRCAMDELL
 */
@RestController
public class AdminAPIController implements AdminAPI{

     @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;
    
    
    
    @Autowired
    private EmpleadoRepository repository;
    
    
    @Override
    public ResponseEntity<Empleado> findEmpleadosByCedula(int cedula) throws Exception {
        Empleado empleado = repository.findById(cedula)
                .orElseThrow(null);
        return ResponseEntity.ok(empleado);

    }

    @Override
    public Collection<Empleado> findEmpleados() {
        return (List<Empleado>) repository.findAll();
    }

    @Override
    public ResponseEntity<?> crearEmpleado(EmpleadoInput body) throws Exception {
        
        Empleado empleado= new Empleado();
        empleado.setCedula(body.getCedula());
        empleado.setNombres(body.getNombres());
        empleado.setApellidos(body.getApellidos());
        empleado.setEmail(body.getEmail());
        
        
        
        
         if (userRepository.existsByUsername(body.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(body.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(body.getEmail(),
                body.getEmail(),
                encoder.encode("12345678"));

        Set<String> strRoles =  new HashSet<>(Arrays.asList(body.getEmail(), "user"));
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        repository.save(empleado);
        
            return ResponseEntity.ok(new MessageResponse("Empleado registrado exitosamente"));
    }

    @Override
    public long deleteEmpleado(int cedula) {
        return cedula;
    }

    

    @Override
    public Collection<Empleado> listByRangeVacunacion(Date since, Date to) {
        return repository.findByDatesVacunacion(since, to);
    }

    @Override
    public Collection<Empleado> listVacunados() {
      return repository.listVacunados();
    }

    @Override
    public ResponseEntity<Empleado> findEmpleadosByVacuna(String tipo) throws Exception {
           return (ResponseEntity<Empleado>) repository.listByTipoVacuna(tipo);
    }


    
}
