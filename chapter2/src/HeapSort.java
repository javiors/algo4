public class HeapSort {
    public static void sort(int[] arr){


    }


    private static void sink(int[] arr, int n){
        int left = 2 * n;
        int right = 2 * n + 1;

        int max = 0;
        if (left <= arr.length){
            max = arr[left];
        }

        if (right <= arr.length){
            int rightValue = arr[right];
        }
    }
}
