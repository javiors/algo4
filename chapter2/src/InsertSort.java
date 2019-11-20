public class InsertSort {

    public static void sort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            for(int j = i; j > 0; j--){
                if (arr[j] < arr[j - 1]){
                    SortUtil.swap(arr, j, j - 1);
                } else {
                    break;
                }
            }

        }
    }

    public static void sortMove(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int temp = arr[i];
            for(int j = i - 1; j > 0; j--){
                if (arr[j] < temp){
                   arr[j + 1] = arr[j];
                } else {
                   arr[j + 1] = temp;
                   break;
                }
            }

        }
    }

}
