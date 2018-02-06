package spring.cloud.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import spring.cloud.example.config.model.Server;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties()
public class YAMLConfig {
	private Server server;

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}
}
