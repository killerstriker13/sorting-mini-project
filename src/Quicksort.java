import java.util.Comparator;
import java.util.Random;

/**
 * Sort using Quicksort.
 *
 * @author Shibam Mukhopadhyay
 * @author Samuel A. Rebelsky (Based upon lab)
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +----------------+----------------------------------------------
  // | Public methods |
  // +----------------+

  /**
   * Sort an array in place.
   *
   * @param vals, an array to sort.
   * @param order, the order by which to sort the values.
   * @return
   *    The same array, now sorted.
   * @pre
   *    order can be applied to any two values in vals.
   * @pre
   *    VALS = vals.
   * @post
   *    vals is a permutation of VALS.
   * @post
   *    For all i, 0 < i < vals.length,
   *      order.compare(vals[i-1], vals[i]) <= 0
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quicksort(values, order, 0, values.length);
  } //  sort(T[], Comparator<? super T>)

  /**
   * Partition an array.
   */
  public <T> void partition(T[] values, Comparator<? super T> order) {
    partition(values, order, 0, values.length);
  } // partition(T[], Comparator<? super T>)

  // +----------------------+----------------------------------------
  // | Semi-private methods |
  // +----------------------+

  /**
   * Sort the subarray of T given by [lb..ub) in place using
   * the Quicksort algorithm.
   */
  <T> void quicksort(T[] values, Comparator<? super T> order,
      int lb, int ub) {
    if (ub - lb > 1) {
      int pivotLoc = partition(values, order, lb, ub);
      quicksort(values, order, lb, pivotLoc);
      quicksort(values, order, pivotLoc + 1, ub);
    }
  } // quicksort(T[], Comparator<? super T>, lb, ub)

  /**
   * Select a pivot and partition the subarray from [lb .. ub) into 
   * the following form.
   *
   * <pre>
   * ---+-----------------+-+----------------+---
   *    | values <= pivot |p| values > pivot |
   * ---+-----------------+-+----------------+---
   *    |                 |                  |
   *    lb                pivotLoc           ub
   * </pre>
   *
   * @return pivotLoc.
   */
  public static <T> int partition(T[] arr, Comparator<? super T> order, int lb, int ub) {
    Random rand = new Random();
    int pivotIndex = lb + rand.nextInt(ub - lb);
    T pivot = arr[pivotIndex];
    swap(arr, pivotIndex, ub - 1);

    int i = lb;
    for (int j = lb; j < ub - 1; j++) {
      if (order.compare(arr[j], pivot) < 0) {
        swap(arr, i, j);
        i++;
      }
    }
    swap(arr, i, ub - 1);
    return i;
  } // partition(T[], Comparator<? super T>, lb, ub)

  private static <T> void swap(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
} // class Quicksort
        

    






