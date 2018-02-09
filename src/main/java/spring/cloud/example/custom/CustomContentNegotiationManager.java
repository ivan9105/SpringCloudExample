package spring.cloud.example.custom;

import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Collection;
import java.util.List;

//Todo custom content manager
public class CustomContentNegotiationManager extends ContentNegotiationManager {

	public CustomContentNegotiationManager(ContentNegotiationStrategy... strategies) {
		super(strategies);
		getStrategies().add(new YMLContentNegotiationStrategy());
	}

	public CustomContentNegotiationManager(Collection<ContentNegotiationStrategy> strategies) {
		super(strategies);
		getStrategies().add(new YMLContentNegotiationStrategy());
	}

	public CustomContentNegotiationManager() {
		getStrategies().add(new YMLContentNegotiationStrategy());
	}

	public static class YMLContentNegotiationStrategy implements ContentNegotiationStrategy {
		@Override
		public List<MediaType> resolveMediaTypes(NativeWebRequest webRequest) throws HttpMediaTypeNotAcceptableException {
			//Todo
			return null;
		}
	}
}
