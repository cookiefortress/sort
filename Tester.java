import java.io.IOException;
import java.util.Arrays;

public class Tester {

    private static final int RUNS = 5;

    public static void main(String[] args) throws IOException {
        String[] datasets = {
            "dataset_1000000.txt",
            "dataset_10000000.txt"
        };

        for (String filename : datasets) {
            System.out.println("======================================");
            System.out.println("Dataset: " + filename);
            int[] data = Loader.load(filename);


            benchmarkSort("Merge Sort",     data, MergeSort::sort);
            benchmarkSort("Quick Sort",     data, QuickSort::sort);
            benchmarkSort("Radix Sort",     data, RadixSort::sort);

            System.out.println("======================================\n");
        }
    }

    @FunctionalInterface
    interface SortFunction {
        void sort(int[] array);
    }

    private static void benchmarkSort(String name, int[] original, SortFunction sortFunction) {
        long[] times = new long[RUNS];

        System.out.println("Running " + name + "...");
        for (int i = 0; i < RUNS; i++) {
            int[] copy = Arrays.copyOf(original, original.length);
            long start = System.nanoTime();
            sortFunction.sort(copy);
            long end = System.nanoTime();
            times[i] = end - start;
            System.out.printf("  Run %d: %d ms%n", i + 1, times[i] / 1_000_000);
        }

        Arrays.sort(times);
        long sum = 0;
        for (int i = 0; i < RUNS - 1; i++) { // discard the longest time
            sum += times[i];
        }

        long avg = sum / (RUNS - 1);
        System.out.printf("  -> Average (without longest): %d ms%n%n", avg / 1_000_000);
    }
}
