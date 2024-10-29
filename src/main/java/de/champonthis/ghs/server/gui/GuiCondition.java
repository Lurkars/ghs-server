package de.champonthis.ghs.server.gui;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class GuiCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		return !"true".equals(context.getEnvironment().getProperty("java.awt.headless"));
	}

}
