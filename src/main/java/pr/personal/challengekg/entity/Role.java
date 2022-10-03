/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr.personal.challengekg.entity;

import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author PAULRCAMDELL
 */
@Data
@Entity
@Table(name = "roles")
public class Role {
    
   	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;

	
	
    
}
