import java.util.Comparator;
import java.util.Arrays;

/**
 * Sort using merge sort.
 * @author Shibam Mukhopadhyay
 * @author Alexander Maret (Implemented from the Lab)
 * @author Samuel A. Rebelsky 
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+


    @Override
    public <T> void sort(T[] vals, Comparator<? super T> order) {
        mergeSort(vals, 0, vals.length - 1, order);
    }

    private <T> void mergeSort(T[] vals, int low, int high, Comparator<? super T> order) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(vals, low, mid, order);
            mergeSort(vals, mid + 1, high, order);
            merge(vals, low, mid, high, order);
        }
    }
  // +-----------------+---------------------------------------------
  // | Local utilities |
  // +-----------------+


    /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into
   * the same part of the array.
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    T[] tempL = Arrays.copyOfRange(vals, lo, mid);
    T[] tempR = Arrays.copyOfRange(vals, mid, hi);

    int l = 0;
    int r = 0;
    int i = lo;

    while (l < tempL.length && r < tempR.length){
      if(comparator.compare(tempL[l], tempR[r]) < 0) {
        vals[i] = tempL[l];
        l++;
        i++;
      }
      else{
        vals[i] = tempR[r];
        r++;
        i++;
      }
    }

    if (l < tempL.length) {
      for(int j = i; j < hi; j++) {
        vals[j] = tempL[l];
        j++;
        l++;
      }
    }
    else {
      for(int j = i; j < hi; j++) {
        vals[j] = tempR[r];
        j++;
        r++;
      }
    }

    
  } // merge
} // class MergeSort

