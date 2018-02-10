package spring.cloud.example.custom;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.cloud.config.server.config.ConfigServerMvcConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Collections;

@Configuration
@EnableWebMvc
@ConditionalOnWebApplication
public class CustomWebConfig extends ConfigServerMvcConfiguration {
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		super.configureContentNegotiation(configurer);
		//ServletPathExtensionContentNegotiationStrategy has bug with switch content-type text/yaml - text/plain
		configurer.strategies(Collections.singletonList(new HeaderContentNegotiationStrategy()));
	}
}
