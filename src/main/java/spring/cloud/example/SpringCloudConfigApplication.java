package spring.cloud.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.example.config.YAMLConfig;
import spring.cloud.example.rabbitmq.Runner;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
@ComponentScan("spring.cloud.example")
@EnableConfigServer
public class SpringCloudConfigApplication {
	@Autowired
	private YAMLConfig yamlConfig;

	@Autowired
	private Runner rabbitmqRunner;

	@RequestMapping("/rabbitmq")
	public String rabbitmqRun() throws Exception {
		rabbitmqRunner.run("");
		return "";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigApplication.class, args);
	}
}
