package day09;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Junit5_ParameterizedTest {

    @ParameterizedTest
    @ValueSource(ints = {5,6,7,11,8,9,100})
    public void test1(int myNumber){

        System.out.println("myNumber = " + myNumber);
        // assert 5,6,7,8,9 all less than 10
        assertTrue(myNumber < 10);

        

    }
}
