public class ShellSort {
    public static void sort(int[] arr){
        int step = 8;
        while (step >= 1) {
            int off = 0;
            while (off < step){
                for (int i = step + off; i < arr.length; i+= step){
                    for(int j = i; j >=  step; j -= step){
                        if (arr[j] < arr[j - step]){
                            SortUtil.swap(arr, j, j - step);
                        } else {
                            break;
                        }
                    }

                }
                off ++;
            }

            step = step / 2;
        }

    }


    public void sortQuick(int[] arr){
        int step = 4;
        for (int i = step; i < arr.length; i++){
            for(int j = i; j >= step; j-=step){
                if (arr[j] < arr[j - step]){
                    SortUtil.swap(arr, j, j - step);
                } else {
                    break;
                }
            }

        }
    }
}
