/*
* trim
* how to get fields
* why isAccessible
* how to get a class of an object
* instance of method for hardcore checking
*
* what is reflection in java?
* When do we use fail in Test?
* How to handle exceptions in Test?
*
*
* */

package org.example;
public class Main {
    public static void main(String[] args) {
        User user = new User("anu", "an ur", 15);

        ValidationProcessor processor = new ValidationProcessor();

        processor.validate(user);
        System.out.println("Validation successful.");
    }
}
