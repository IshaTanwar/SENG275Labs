package lab04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class WordUtilitiesTest {

    @Test
    public void EmptyStringTest() {
        assertEquals("",WordUtilities.swapCase(""));
    }

    @Test
    public void UppercaseTest() {
        assertEquals("upper",WordUtilities.swapCase("UPPER"));
    }

    @Test
    public void LowercaseTest() {
        assertEquals(" LOWER",WordUtilities.swapCase(" lower"));
    }

    @Test
    public void NullTest() {
        assertEquals(null,WordUtilities.swapCase(null));
    }
}