package spring.cloud.example.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableGlobalAuthentication
public class CustomGlobalAuthenticationConfiguration {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		auth.inMemoryAuthentication()
				.passwordEncoder(encoder)
				.withUser("user").password(encoder.encode("password")).roles("USER")
				.and().withUser("admin").password(encoder.encode("password")).roles("USER", "ADMIN");
	}
}
