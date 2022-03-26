package lab03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class SpecificationTest {

    @ParameterizedTest(name="x{0}, y{1}")
    @CsvSource({"0, 0", "1279, 0", "1279, 719", "0, 719"})
    void insideDisplayAreaTestTrue(int x, int y) {
        assertTrue(Specification.insideDisplayArea(x,y));
    }

    @ParameterizedTest(name="x{0}, y{1}")
    @CsvSource({"-1, 0", "0,-1","1280, 0", "1279,-1", "1280, 719", "1289, 720", "0, 720", "-1, 719"})
    void insideDisplayAreaTestFalse(int x, int y) {
        assertFalse(Specification.insideDisplayArea(x,y));
    }

    @ParameterizedTest(name="input{0}, motorcycle{1}")
    @MethodSource("TrueTestCases")
    void messageIsValid(String input, boolean motorcycle) {
        assertTrue(Specification.messageIsValid(input, motorcycle));
    }
    private static Stream<Arguments> TrueTestCases() {
        return Stream.of(
                Arguments.of("AB",false),
                Arguments.of("AB",true),
                Arguments.of("ABCDEF",false),
                Arguments.of("ABCDEF",true),
                Arguments.of("AB-CD",false),
                Arguments.of("AB-CD",true),
                Arguments.of("AB CD",false),
                Arguments.of("AB CD", true),
                Arguments.of("ABCD12",false),
                Arguments.of("ABCD12",true),
                Arguments.of("A B 1",false),
                Arguments.of("A B 1", true),
                Arguments.of("1-2345A",false),
                Arguments.of("1-234A", true),
                Arguments.of("1-A 2", true),
                Arguments.of("1-A 2", false)
        );
    }

    @ParameterizedTest(name="input{0}, motorcycle{1}")
    @MethodSource("FalseTestCases")
    void messageIsNotValid(String input, boolean motorcycle) {
        assertFalse(Specification.messageIsValid(input, motorcycle));
    }
    private static Stream<Arguments> FalseTestCases() {
        return Stream.of(
                Arguments.of("A",false),
                Arguments.of("A",true),
                Arguments.of("ABCDEFGH",false),
                Arguments.of("ABCDEFGH",true),
                Arguments.of("AB--D",false),
                Arguments.of("AB--D",true),
                Arguments.of("AB  D",false),
                Arguments.of("AB  D", true),
                Arguments.of("123456",false),
                Arguments.of("123456",true),
                Arguments.of("A - 1",false),
                Arguments.of("A - 1", true),
                Arguments.of("1-234-A",false),
                Arguments.of("1-234-A",true)
        );
    }
}