package org.acme;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Stereotype;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ApplicationScoped
@Stereotype
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
}
