package de.champonthis.ghs.server.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.lang.NonNull;

public class HttpServerCondition implements Condition {

    private final boolean ssl;

    public HttpServerCondition() {
        this.ssl = false;
    }

    public HttpServerCondition(@Value("${server.ssl.enabled:false}") boolean ssl) {
        this.ssl = ssl;
    }

    @Override
    public boolean matches(@NonNull ConditionContext context, @NonNull AnnotatedTypeMetadata metadata) {
        return this.ssl
                || Boolean.TRUE.equals(context.getEnvironment().getProperty("server.ssl.enabled", Boolean.class));
    }

}
