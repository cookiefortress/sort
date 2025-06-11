public class MergeSort {
    public static void sort(int[] arr) {
        if (arr.length < 2)
            return;
        sortRecursive(arr, 0, arr.length - 1);
    }

    private static void sortRecursive(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sortRecursive(arr, left, mid);
            sortRecursive(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] L = new int[mid - left + 1];
        int[] R = new int[right - mid];

        for (int i = 0; i < L.length; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < R.length; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < L.length && j < R.length) {
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        }
        while (i < L.length)
            arr[k++] = L[i++];
        while (j < R.length)
            arr[k++] = R[j++];
    }
}
