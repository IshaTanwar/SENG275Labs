
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

class LeapYearTest {

    @Property
    void leapYear(@ForAll("multipleOf400") @IntRange(min = 1) int year) {
        assertThat(LeapYear.isLeapYear(year)).isTrue();
    }

    @Property
    void InvalidRangeOfYear(@ForAll @IntRange(max = 0) int year) {
        assertThrows(IllegalArgumentException.class, () -> LeapYear.isLeapYear(year));
    }

    @Provide
    private Arbitrary<Integer> multipleOf400() {
        return Arbitraries.integers().filter(n->n%400 == 0);
    }

}