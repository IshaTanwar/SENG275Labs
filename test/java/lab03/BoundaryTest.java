package lab03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BoundaryTest {

    @Test
    void isUnsafe() {
        assertTrue(Boundary.isUnsafe(86));
    }

    @Test
    void isNotUnsafe() {
        assertFalse(Boundary.isUnsafe(85));
    }

    @ParameterizedTest
    @ValueSource(ints = {5,20})
    void isComfortable(int temperature) {
        assertTrue(Boundary.isComfortable(temperature));
    }

    @ParameterizedTest
    @ValueSource(ints = {4,21})
    void isNotComfortable(int temperature) {
        assertFalse(Boundary.isComfortable(temperature));
    }

    @Test
    void elevatorsRequired_0() {
        assertEquals(0,Boundary.elevatorsRequired(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {2,5})
    void elevatorRequired_1(int storeys) {
        assertEquals(1,Boundary.elevatorsRequired(storeys));
    }

    @Test
    void elevatorsRequired_2() {
        assertEquals(2,Boundary.elevatorsRequired(6));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.99,101})
    void percentageToLetterGrade_Exception(double percent) {
        assertThrows(IllegalArgumentException.class, () -> Boundary.percentageToLetterGrade(percent));
    }

    @ParameterizedTest
    @ValueSource(doubles = {90.99,100})
    void percentageToLetterGrade_Boundary1(double percent) {
        assertEquals("A+", Boundary.percentageToLetterGrade(percent));
    }

    @ParameterizedTest
    @ValueSource(doubles = {85.99,89})
    void percentageToLetterGrade_Boundary2(double percent) {
        assertEquals("A", Boundary.percentageToLetterGrade(percent));
    }

    @ParameterizedTest
    @ValueSource(doubles = {80.99,84})
    void percentageToLetterGrade_Boundary3(double percent) {
        assertEquals("A-", Boundary.percentageToLetterGrade(percent));
    }

    @ParameterizedTest
    @ValueSource(doubles = {77.99,79})
    void percentageToLetterGrade_Boundary4(double percent) {
        assertEquals("B+", Boundary.percentageToLetterGrade(percent));
    }

    @ParameterizedTest
    @ValueSource(doubles = {73.99,76})
    void percentageToLetterGrade_Boundary5(double percent) {
        assertEquals("B", Boundary.percentageToLetterGrade(percent));
    }

    @ParameterizedTest
    @ValueSource(doubles = {70.99,72})
    void percentageToLetterGrade_Boundary6(double percent) {
        assertEquals("B-", Boundary.percentageToLetterGrade(percent));
    }

    @ParameterizedTest
    @ValueSource(doubles = {65.99,69})
    void percentageToLetterGrade_Boundary7(double percent) {
        assertEquals("C+", Boundary.percentageToLetterGrade(percent));
    }

    @ParameterizedTest
    @ValueSource(doubles = {60.99,64})
    void percentageToLetterGrade_Boundary8(double percent) {
        assertEquals("C", Boundary.percentageToLetterGrade(percent));
    }

    @ParameterizedTest
    @ValueSource(doubles = {50.99,59})
    void percentageToLetterGrade_Boundary9(double percent) {
        assertEquals("D", Boundary.percentageToLetterGrade(percent));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.99,49})
    void percentageToLetterGrade_Boundary10(double percent) {
        assertEquals("F", Boundary.percentageToLetterGrade(percent));
    }
}