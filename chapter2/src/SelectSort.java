public class SelectSort {
    public static void sort(int [] arr){
        for (int i = 0; i< arr.length; i++){
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[index]) index = j;
            }
            SortUtil.swap(arr, i, index);
        }
    }

}
