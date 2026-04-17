package de.champonthis.ghs.server.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class HttpServerCondition implements Condition {

    private final boolean ssl;

    public HttpServerCondition() {
        this.ssl = false;
    }

    public HttpServerCondition(@Value("${server.ssl.enabled:false}") boolean ssl) {
        this.ssl = ssl;
    }

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return this.ssl
                || Boolean.TRUE.equals(context.getEnvironment().getProperty("server.ssl.enabled", Boolean.class));
    }

}
