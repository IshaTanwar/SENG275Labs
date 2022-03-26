package lab01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {
    @Test
    void sayHi() {
        System.out.println("Hello from the test.");
    }

    // A sorted array
    @Test
    void sortedAAA() {
        int[] someArray = {1,2,3,4};       // arrange
        boolean someArraySorted = ArrayUtils.isSorted(someArray);  // act
        assertTrue(someArraySorted);       // assert
    }

    // A sorted array - all at once
    @Test
    void sorted() {
        assertTrue(ArrayUtils.isSorted(new int[] {1,2,3,4}));
    }

    // Empty arrays are sorted
    @Test
    void EmptyTest() {
        int[] someArray = {};     //arrange
        boolean someArraySorted = ArrayUtils.isSorted(someArray);  //act
        assertTrue(someArraySorted);  //assert
    }

    // Arrays of one element are sorted
    @Test
    void OneElementTest() {
        int[] someArray = {1};     //arrange
        boolean someArraySorted = ArrayUtils.isSorted(someArray);  //act
        assertTrue(someArraySorted);  //assert
    }

    // A partially sorted array
    @Test
    void PartialTest() {
        int[] someArray = {1,3,7,2,8};     //arrange
        boolean someArraySorted = ArrayUtils.isSorted(someArray);  //act
        assertFalse(someArraySorted);  //assert
    }

    // A completely unsorted array
    @Test
    void UnsortedTest() {
        int[] someArray = {7,2,7,1};     //arrange
        boolean someArraySorted = ArrayUtils.isSorted(someArray);  //act
        assertFalse(someArraySorted);  //assert
    }
    // An array with duplicate values
    @Test
    void DuplicateTest() {
        int[] someArray = {2,2,3,4,4,4};     //arrange
        boolean someArraySorted = ArrayUtils.isSorted(someArray);  //act
        assertTrue(someArraySorted);  //assert
    }
}
