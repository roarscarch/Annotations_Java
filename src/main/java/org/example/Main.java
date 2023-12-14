/*
* trim
* how to get fields
* why isAccessible
* how to get a class of an object
* instance of method for hardcore checking
*
* what is reflection in java?
*
*
* */

package org.example;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@interface NotBlank {}

@Retention(RetentionPolicy.RUNTIME)
@interface Positive {}

class ValidationProcessor {
    public void validate(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(NotBlank.class)) {
                validateNotBlank(field, obj);
            }

            if (field.isAnnotationPresent(Positive.class)) {
                validatePositive(field, obj);
            }
        }
    }

    private void validateNotBlank(Field field, Object obj) {
        try {
            String value = (String) field.get(obj);

            if (value == null || value.trim().isEmpty()) {
                throwValidationException(field.getName() + " cannot be blank.");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    private void validatePositive(Field field, Object obj) {
        try {
            double numericValue = ((Number) field.get(obj)).doubleValue();

            if (numericValue <= 0) {
                throwValidationException(field.getName() + " must be positive.");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    private void throwValidationException(String message) {
        throw new RuntimeException("Validation failed: " + message);
    }
}

class User {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Positive
    private int age;

    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("anu", "an ur", 15);

        ValidationProcessor processor = new ValidationProcessor();

        processor.validate(user);
        System.out.println("Validation successful.");
    }
}
