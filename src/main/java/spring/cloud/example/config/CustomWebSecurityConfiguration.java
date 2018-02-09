package spring.cloud.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		auth.inMemoryAuthentication()
				.passwordEncoder(encoder)
				.withUser("user").password(encoder.encode("password")).roles("USER")
				.and().withUser("admin").password(encoder.encode("password")).roles("USER", "ADMIN");
	}
}
