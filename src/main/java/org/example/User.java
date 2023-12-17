package org.example;


class User {
    @Annotations.NotBlank
    private String username;

    @Annotations.NotBlank
    private String password;

    @Annotations.Positive
    private int age;

    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
