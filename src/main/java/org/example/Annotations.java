package org.example;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Annotations {
    @Retention(RetentionPolicy.RUNTIME)
    @interface NotBlank {}

    @Retention(RetentionPolicy.RUNTIME)
    @interface Positive {}

}
