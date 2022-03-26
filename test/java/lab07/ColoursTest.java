package lab07;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import net.jqwik.api.*;
import net.jqwik.api.arbitraries.*;
import net.jqwik.api.constraints.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class ColoursTest {

    /*
     * Create property tests that test combinations of valid and invalid values.
     */
    @Property
    void pass(@ForAll @IntRange(min = 0, max = 255) int r, @ForAll @IntRange(min = 0, max = 255) int b, @ForAll @IntRange(min = 0, max = 255) int g) {
        assertThat(Colours.rgbBytesToInt(r,b,g)).isEqualTo(r * 256 + b * 16 + g);
    }

    @Property
    void invalidR(@ForAll("invalidRange") int r, @ForAll @IntRange(min = 1, max = 99) int b, @ForAll @IntRange(min = 1, max = 99) int g) {
        assertThrows(IllegalArgumentException.class, () -> Colours.rgbBytesToInt(r,b,g));
    }

    @Provide
    private Arbitrary<Integer> invalidRange() {
        return Arbitraries.oneOf(Arbitraries.integers().lessOrEqual(-1), Arbitraries.integers().greaterOrEqual(256));
    }

}