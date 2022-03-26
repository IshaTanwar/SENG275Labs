/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lab04;

import org.apache.commons.math3.geometry.spherical.oned.ArcsSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class SplittingTest {

    @Test
    public void OneElement() {
        int[] nums = {1};
        assertFalse(Splitting.canBalance(nums));
    }

    @Test
    public void CantSplit_sumOdd() {
        int[] nums = {1,3,4,5};
        assertFalse(Splitting.canBalance(nums));
    }

    @Test
    public void CanSplit() {
        int[] nums = {2,3,1,4};
        assertTrue(Splitting.canBalance(nums));
    }
    @Test
    public void CantSplit_sumEven() {
        int[] nums = {1,3,4,4};
        assertFalse(Splitting.canBalance(nums));
    }
    @Test
    public void NullArray() {
        int nums[] = null;
        assertFalse(Splitting.canBalance(nums));
    }

}