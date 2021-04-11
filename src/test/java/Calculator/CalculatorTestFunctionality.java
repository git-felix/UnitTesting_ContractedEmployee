package Calculator;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTestFunctionality {

    @BeforeAll
    static void initializeALl(){
        System.out.println("This method will be called once, before running the Test Suit");
    }

    @BeforeEach
    void initialize(){
        System.out.println("This method will be called before each test");
    }

}
