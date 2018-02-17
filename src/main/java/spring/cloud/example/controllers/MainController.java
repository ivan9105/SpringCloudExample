package spring.cloud.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String def(Model model) {
		StringBuilder sb = new StringBuilder();
		sb.append("<h1 class='text-success'>Config sample</h1><br/>");
		sb.append(propertyLink("aggregating-config.yml")).append("\n");
		sb.append(propertyLink("application-config.yml")).append("\n");
		sb.append(propertyLink("bar-config.properties")).append("\n");
		sb.append(propertyLink("books-config.xml")).append("\n");
		sb.append(propertyLink("configserver-config.yml")).append("\n");
		sb.append(propertyLink("eureka-config.yml")).append("\n");
		sb.append(propertyLink("foo-db-config.properties")).append("\n");
		sb.append(propertyLink("foo-development-db-config.properties")).append("\n");
		sb.append(propertyLink("foo-development-config.properties")).append("\n");
		sb.append(propertyLink("foo-config.properties")).append("\n");
		sb.append(propertyLink("logtest-config.yml")).append("\n");
		sb.append(propertyLink("processor-config.yml")).append("\n");
		sb.append(propertyLink("samplebackendservice-development-config.properties")).append("\n");
		sb.append(propertyLink("samplebackendservice-config.properties")).append("\n");
		sb.append(propertyLink("samplefrontendservice-config.properties")).append("\n");
		sb.append(propertyLink("stores-config.yml")).append("\n");
		sb.append(propertyLink("test-config.json")).append("\n");
		sb.append(propertyLink("text-resource-config.txt")).append("\n");
		sb.append(propertyLink("zuul-config.properties")).append("\n");
		model.addAttribute("links", sb.toString());
		return "index";
	}

	private String propertyLink(String propertyFilename) {
		return String.format("<a class='text-primary' href='http://admin:password@localhost:8888/%s'>%s</a><br/>", propertyFilename, propertyFilename);
	}
}
