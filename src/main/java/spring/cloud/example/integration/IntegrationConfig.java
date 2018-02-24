package spring.cloud.example.integration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("/integration/integration.xml")
public class IntegrationConfig {
}
