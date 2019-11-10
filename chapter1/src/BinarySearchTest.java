import static org.junit.Assert.*;

public class BinarySearchTest {

    @org.junit.Test
    public void search() {

        int[] arr = new int[]{1, 3, 6, 43, 64, 98, 230};
        int found = BinarySearch.search(arr, 0);
        assertEquals(found, -1);
        found = BinarySearch.search(arr, 1);
        assertEquals(found, 0);

        found = BinarySearch.search(arr, 230);
        assertEquals(found, arr.length - 1);

        found = BinarySearch.search(arr, 43);
        assertEquals(found, 3);

    }
}
