public class BinarySearch {

    public static int search(int[] ts, int t){
        int start = 0;
        int end = ts.length -1;
        while (start <= end){
            //注意：有溢出风险
            //int mid = (start + end) / 2;
            //修正无溢出版本
            int mid = start + (end - start) / 2;
            if (ts[mid] == t){
                return mid;
            } else if (ts[mid] > t){
                end = mid - 1;
            } else if (ts[mid] < t){
                start = mid + 1;
            }
        }

        return -1;
    }
}
