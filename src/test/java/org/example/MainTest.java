package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class MainTest {
    @Test

    void happyTest(){
        User user= new User("ANurag","1234",15);
        ValidationProcessor validationProcessor= new ValidationProcessor();
        try{
            validationProcessor.validate(user);
            assertTrue(true);
        }
        catch (ValidationException e){
           assertTrue(false);

        }
    }
@Test
void sadTest(){
        User user= new User("ANurag","1234",-15);
        ValidationProcessor validationProcessor= new ValidationProcessor();
        try{
            validationProcessor.validate(user);
            assertTrue(false);
        }
        catch (ValidationException e){
            assertTrue(true);
            System.out.println("Here exception was not expected "+e.getMessage());
        }
    }


}