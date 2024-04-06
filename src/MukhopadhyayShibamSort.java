import java.util.Comparator;
import java.util.Random;
/**
 * This is called IntroSort which is a hybrid sorting algorithm combining Quicksort, 
 * Heap Sort and Insertion Sort. It starts with Quick Sort, switches to Heap Sort when
 * the recursion depth exceeds a certain threshold, and finally falls back to Insertion
 * Sort for small subarrays. ChatGPT wrote this code for me. More information in the 
 * README.md file.
 * 
 * @author Shibam Mukhopadhyay
 */
public class MukhopadhyayShibamSort implements Sorter {
    public static Sorter SORTER = new MukhopadhyayShibamSort();
    
    // Create a sorter.
    MukhopadhyayShibamSort() {
    }

    @Override
    public <T> void sort(T[] values, Comparator<? super T> order) {
        int maxDepth = (int) (Math.log(values.length) * 2);
        introsort(values, order, 0, values.length, maxDepth);
    }

    private <T> void introsort(T[] values, Comparator<? super T> order, int lb, int ub, int maxDepth) {
        if (ub - lb > 1) {
            if (maxDepth == 0) {
                heapsort(values, order, lb, ub);
            } else {
                int pivotLoc = partition(values, order, lb, ub);
                introsort(values, order, lb, pivotLoc, maxDepth - 1);
                introsort(values, order, pivotLoc + 1, ub, maxDepth - 1);
            }
        }
    }

    private <T> void heapsort(T[] values, Comparator<? super T> order, int lb, int ub) {
        // Convert the array into a heap
        for (int i = (ub - lb) / 2 - 1; i >= 0; i--) {
            heapify(values, order, i, ub - lb, lb);
        }
        // Extract elements from the heap one by one
        for (int i = ub - lb - 1; i >= 0; i--) {
            swap(values, lb, lb + i);
            heapify(values, order, 0, i, lb);
        }
    }

    private <T> void heapify(T[] values, Comparator<? super T> order, int i, int n, int offset) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && order.compare(values[left + offset], values[largest + offset]) > 0) {
            largest = left;
        }

        if (right < n && order.compare(values[right + offset], values[largest + offset]) > 0) {
            largest = right;
        }

        if (largest != i) {
            swap(values, offset + i, offset + largest);
            heapify(values, order, largest, n, offset);
        }
    }

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
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

