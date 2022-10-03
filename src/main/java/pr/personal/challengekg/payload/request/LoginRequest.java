/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr.personal.challengekg.payload.request;

import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 *
 * @author PAULRCAMDELL
 */
@Data
public class LoginRequest {
    	@NotBlank
	private String username;

	@NotBlank
	private String password;
}
