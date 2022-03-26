package lab04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class CollectionUtilsTest {
    @Test
    public void HasCommon_Col1_lessThan_Col2() {
        ArrayList<Integer> col1 = new ArrayList<>();
        ArrayList<Integer> col2 = new ArrayList<>();
        col1.add(5);
        col2.add(6);
        col2.add(5);
        assertTrue(CollectionUtils.containsAny(col1,col2));
    }
    @Test
    public void HasCommon_NotCol1_lessThan_Col2() {
        ArrayList<Integer> col1 = new ArrayList<>();
        ArrayList<Integer> col2 = new ArrayList<>();
        col1.add(1);
        col1.add(2);
        col2.add(1);
        col2.add(4);
        assertTrue(CollectionUtils.containsAny(col1,col2));
    }
    @Test
    public void NothingInCommon_NotCol1_lessThan_Col2() {
        ArrayList<Integer> col1 = new ArrayList<>();
        ArrayList<Integer> col2 = new ArrayList<>();
        col1.add(1);
        col1.add(2);
        col2.add(3);
        col2.add(4);
        assertFalse(CollectionUtils.containsAny(col1,col2));
    }
    @Test
    public void NothingInCommon_Col1_lessThan_Col2() {
        ArrayList<Integer> col1 = new ArrayList<>();
        ArrayList<Integer> col2 = new ArrayList<>();
        col1.add(1);
        col2.add(3);
        col2.add(4);
        assertFalse(CollectionUtils.containsAny(col1,col2));
    }

}