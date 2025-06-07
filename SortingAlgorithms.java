import java.io.*;
import java.util.*;

public class SortingAlgorithms {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    // helper to load integers from a file into an array
    public static int[] loadDataset(String filename) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        }
        int[] array = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            array[i] = numbers.get(i);
        }
        return array;
    }

    public static void main(String[] args) throws IOException {
        String[] datasets = {
                "dataset_1000.txt",
                "dataset_10000.txt",
                "dataset_100000.txt"
                // "dataset_1000000.txt", // Uncomment if needed
                // "dataset_10000000.txt" // Be careful: very slow with O(n²) sorts
        };

        System.out.println("If the program appears to freeze, then the sorting operations are likely simply taking longer than expected.");
        System.out.println("Prepare to sort..!\n");

        for (String filename : datasets) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Dataset: " + filename);
            int[] data = loadDataset(filename);

            // Insertion Sort
            int[] insertionData = Arrays.copyOf(data, data.length);
            long startInsertion = System.nanoTime();
            insertionSort(insertionData);
            long endInsertion = System.nanoTime();
            long timeInsertionMs = (endInsertion - startInsertion) / 1_000_000;
            System.out.println("Insertion Sort time: " + timeInsertionMs + " ms");

            // Bubble Sort
            int[] bubbleData = Arrays.copyOf(data, data.length);
            long startBubble = System.nanoTime();
            bubbleSort(bubbleData);
            long endBubble = System.nanoTime();
            long timeBubbleMs = (endBubble - startBubble) / 1_000_000;
            System.out.println("Bubble Sort time: " + timeBubbleMs + " ms");

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        }
    }
}
