public class MergeSort {
    public static int[] aux = new int[1000];
    public static void sort(int[] arr, int low, int hi){
        int mid = low + (hi - low) >> 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, hi);
        merge(arr, low, mid, hi);

    }

    public static void merge(int[] arr, int low, int mid, int hi){
        int i = low;
        int j = mid + 1;

        for (int k = low; k <= hi; k++){
            aux[k] = arr[k];
        }

        for (int k = low; k<=hi; k++){
            if (i > mid){
                arr[k] = aux[j++];
            } else if (j > hi){
                arr[k] = aux[i++];
            } else
            if (aux[i] > aux[j]){
                arr[k] = aux[j++];
            }else {
                arr[k] = aux[i++];
            }
        }



    }

}
