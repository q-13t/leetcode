package le.test.Algorithms;

import java.util.Arrays;

// @SuppressWarnings(value = { "unused" })
public class Algorithms<T> {
    /**
     * Returns biggest value in array.
     * </p>
     * {@code Time(N)}.
     * </p>
     * {@code Space(1)}.
     * 
     * @param array expected to be unsorted.
     * @return biggest value in array.
     */
    private static final int getMaxValue(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            maxValue = maxValue > array[i] ? maxValue : array[i];
        }
        return maxValue;
    }

    /**
     * Sorts array using {@code Counting} algorithm.
     * Is not inplace function. Best used for arrays with elements being in range
     * [0<9].
     * </p>
     * {@code Time(N+K)}.
     * </p>
     * {@code Space(K)}
     * 
     * </p>
     * N -> size of {@code Array}, K -> length of biggest Number in {@code Array}.
     * 
     * @param array to sort.
     * 
     * @return sorted array.
     */
    public static int[] countingSort(int[] array) {
        int maxValue = getMaxValue(array); // Get biggest element from Array
        int length = array.length;// Initialize length of array for faster code execution
        // Initialize <count> and <sorted> arrays
        int[] count = new int[maxValue + 1];
        int[] sorted = new int[length];
        // Iterate over an array increasing courante of each element respectively
        for (int i = 0; i < length; i++) {
            count[array[i]]++;
        }
        // Iterate over count array SUMMING each element with previous
        for (int i = 1; i <= maxValue; i++) {
            count[i] += count[i - 1];
        }
        // Add each element from ARRAY to SORTED at COUNT position
        for (int i = length - 1; i >= 0; i--) {
            sorted[--count[array[i]]] = array[i];
        }
        // Free up memory and return sorted array
        System.gc();
        return sorted;
    }

    private static void countingSort(int array[], int exp) {
        int length = array.length;
        int output[] = new int[length];
        int i;
        int count[] = new int[10];
        for (i = 0; i < length; i++)
            count[(array[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }
        System.gc();
        for (int j = 0; j < output.length; j++)
            array[j] = output[j];
    }

    /**
     * Sorts array using {@code Radix} algorithm.
     * Is NOT inplace function.
     * *
     * </p>
     * {@code Time(N*K)}.
     * </p>
     * {@code Space(N*K)}
     * </p>
     * N -> size of {@code Array}, K -> length of biggest Number in {@code Array}.
     * 
     * @param array to sort
     */
    public static int[] radixSort(int[] array) {
        // Get length of biggest number in array
        int maxElementLength = String.valueOf(getMaxValue(array)).length();

        // Iterate over length of biggest element
        for (int exp = 1; maxElementLength / exp > 0; exp *= 10)
            countingSort(array, exp);// Perform counting sort for each digit position

        // Free up memory and return sorted array
        System.gc();
        return array;
    }

    /**
     * Sorts array using {@code Insertion} algorithm.
     * Is inplace function.
     * *
     * </p>
     * {@code Time(N^2)}.
     * </p>
     * {@code Space(1)}
     * </p>
     * 
     * @param array to sort
     */
    public static void insertionSort(double[] array) {
        // Iterate over array starting at 1 (0-indexed)
        for (int i = 1; i < array.length; i++) {
            int j = i;
            // Iterate until we meet bigger value or reach start of array
            while (j > 0 && array[j - 1] > array[j]) {
                // Switch elements
                double tmp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = tmp;
            }
        }
    }

    public static void bucketSort(double[] array) {
        double[][] buckets = new double[array.length][array.length];
        for (int i = 0; i < buckets.length; i++) {
            Arrays.fill(buckets[i], Integer.MIN_VALUE);
        }
        int k = 0;

        for (int i = 0; i < array.length; i++) {
            buckets[(int) (array[i] * 10)][k++] = array[i];
        }
        for (int i = 0; i < buckets.length; i++) {
            insertionSort(buckets[i]);
        }
        k = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i].length; j++) {
                if (buckets[i][j] != Integer.MIN_VALUE)
                    array[k++] = buckets[i][j];
            }
        }
    }

    public static double[] convertToPrimitive(Double[] input) {
        double[] output = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            output[i] = input[i];
        }
        return output;
    }

    public static void QuickSort(int[] array, int start, int end) {
        if (start >= end || start < 0) {
            return;
        }
        int pivot = partition(array, start, end);
        QuickSort(array, start, pivot - 1);
        QuickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int i = start + 1;
        for (int j = i; j <= end; j++) {
            if (array[j] < pivot) {
                int tmp = array[i];
                array[i++] = array[j];
                array[j] = tmp;
            }
        }
        int tmp = array[start];
        array[start] = array[i - 1];
        array[i - 1] = tmp;
        return i - 1;
    }
}
