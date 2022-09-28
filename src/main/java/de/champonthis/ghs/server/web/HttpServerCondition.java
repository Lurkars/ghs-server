/**
 * 
 */
package de.champonthis.ghs.server.web;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * The Class HttpServerCondition.
 */
public class HttpServerCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		return context.getEnvironment().getProperty("server.ssl.enabled", Boolean.class);
	}

}
