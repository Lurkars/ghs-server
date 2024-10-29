package de.champonthis.ghs.server.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class HttpServerCondition implements Condition {

	@Value("${server.ssl.enabled:false}")
	private boolean ssl;

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		return this.ssl || context.getEnvironment().getProperty("server.ssl.enabled", Boolean.class) == true;
	}

}
