import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class SelectSortTest {

    @org.junit.Test
    public void sort() {
        List<Integer> integers = new ArrayList<>();
        for(int i = 0; i< 1000; i++){
            integers.add(i);
        }
        Collections.shuffle(integers);

        int[] arr = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            arr[i] = integers.get(i);
        }

        StopWatch stopWatch = new StopWatch();

        //SelectSort.sort(arr);
        //InsertSort.sort(copy(arr));
        //stopWatch.elapsedTime();
        //stopWatch.reset();
        ShellSort.sort(arr);
        stopWatch.elapsedTime();

        for (int i : arr) {
            System.out.println(i);
        }


    }

    private int[] copy(int[] arr){
        return Arrays.copyOf(arr, arr.length);
    }
}
