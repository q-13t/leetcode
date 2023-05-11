package le.test;

// @SuppressWarnings(value = { "unused" })
public class Algorithms {
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
     * Is not inplace function.
     * </p>
     * {@code Time(N)}.
     * </p>
     * {@code Space(N+K)}. N -> size of {@code Array}, K -> biggest Number in
     * {@code Array}.
     * 
     * @param array to sort.
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
        // Add each element from ARRAY to SORTED at CUNT position
        for (int i = length - 1; i >= 0; i--) {
            sorted[--count[array[i]]] = array[i];
        }
        // Free up memory and return sorted array
        System.gc();
        return sorted;
    }

}
