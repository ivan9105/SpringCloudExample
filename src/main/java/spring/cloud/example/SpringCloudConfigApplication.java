package spring.cloud.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.example.config.YAMLConfig;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
@ComponentScan("spring.cloud.example")
public class SpringCloudConfigApplication {
	@Autowired
	private YAMLConfig yamlConfig;

	@RequestMapping("/")
	public String defConfig() {
		return "Test: " /*yamlConfig.getConfig().getName() + "\n"*/;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigApplication.class, args);
	}
}
