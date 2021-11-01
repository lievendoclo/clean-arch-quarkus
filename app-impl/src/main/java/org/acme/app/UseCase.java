package org.acme.app;

import javax.enterprise.inject.Stereotype;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Singleton
@Transactional
@Stereotype
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
}
