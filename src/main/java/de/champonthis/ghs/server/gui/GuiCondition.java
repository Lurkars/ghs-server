/**
 * 
 */
package de.champonthis.ghs.server.gui;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * The Class GuiCondition.
 */
public class GuiCondition implements Condition {

	/*
	 * @see
	 * org.springframework.context.annotation.Condition#matches(org.springframework.
	 * context.annotation.ConditionContext,
	 * org.springframework.core.type.AnnotatedTypeMetadata)
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		return !"true".equals(context.getEnvironment().getProperty("java.awt.headless"));
	}

}
