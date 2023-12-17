package org.example;

import java.lang.reflect.Field;

class ValidationProcessor {
    public void validate(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(Annotations.NotBlank.class)) {
                validateNotBlank(field, obj);
            }

            if (field.isAnnotationPresent(Annotations.Positive.class)) {
                validatePositive(field, obj);
            }
        }
    }

    private void validateNotBlank(Field field, Object obj) {
        try {
            String value = (String) field.get(obj);

            if (value == null || value.trim().isEmpty()) {
                throw new ValidationException(field.getName() + " cannot be blank.");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    private void validatePositive(Field field, Object obj) {
        try {
            double numericValue = ((Number) field.get(obj)).doubleValue();

            if (numericValue <= 0) {
                throw  new ValidationException("Value should be greater than 0");
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

