package pr.personal.challengekg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
@SpringBootApplication
public class ChallengekgApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChallengekgApplication.class, args);
	}

}
