import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Shibam Mukhopadhyay
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;


  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    sorter = new InsertionSort();
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    sorter = new MukhopadhyayShibamSort();
    String[] original = { "delta", "charlie", "bravo", "foxtrot", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // reverseOrderedStringTest


  @Test
  public void randomlyOrderedStringTest() {
    sorter = new MergeSort();
    String[] original = { "bravo", "delta", "foxtrot", "charlie", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // randomlyOrderedStringTest

  @Test
  public void multipleSameStringTest() {
    sorter = new Quicksort();
    String[] original = { "foxtrot", "alpha", "bravo", "alpha", "delta", "charlie" };
    String[] expected = { "alpha", "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // multipleSameStringTest

  @Test
  public void orderedIntTest() {
    sorter = new InsertionSort();
    Integer[] original = {1, 54, 58, 62, 90};
    Integer[] expected = {1, 54, 58, 62, 90};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // orderedIntTest

  @Test
  public void reverseOrderedIntTest() {
    sorter = new MukhopadhyayShibamSort();
    Integer[] original = {21, 17, 13, 1};
    Integer[] expected = {1, 13, 17, 21};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // reverseOrderedIntTest

  @Test
  public void randomlyOrderedIntTest() {
    sorter = new MergeSort();
    Integer[] original = {73, 54, 67, 102, 13, 9, 3};
    Integer[] expected = {3, 9, 13, 54, 67, 73, 102};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // randomlyOrderedIntTest
  @Test
  public void multipleSameIntTest() {
    sorter = new Quicksort();
    Integer[] original = {42, 79, 112, 29, 79, 42, 112};
    Integer[] expected = {29, 42, 42, 79, 79, 112, 112};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // mulitpleSameIntTest
} // class SortTester
