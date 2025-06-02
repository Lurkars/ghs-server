package de.champonthis.ghs.server.gui;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.lang.NonNull;

public class GuiCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, @NonNull AnnotatedTypeMetadata metadata) {
		return !"true".equals(context.getEnvironment().getProperty("java.awt.headless"));
	}

}
