public class BinarySearchST<K extends Comparable<K>, V> implements OrderedST<K, V> {
        Item<K, V>[] items;
    int offset = 0;

    public BinarySearchST(int capacity) {
        this.items = new Item[capacity];
    }

    @Override
    public K min() {
        return isEmpty()? null: items[0].key;
    }

    @Override
    public K max() {
        return isEmpty()? null: (K)items[offset - 1].key;
    }

    @Override
    public int rank(K key) {
        int lo = 0;
        int hi = offset - 1;
        while (lo <= hi){
            int rank = lo + (hi - lo) >> 2;
            if (items[rank].key.compareTo(key) == 0){
                return rank;
            } else if (items[rank].key.compareTo(key) > 0){
                hi = rank - 1;
            }else if (items[rank].key.compareTo(key) < 0){
                lo = rank + 1;
            }
        }

        return lo;
    }

    @Override
    public K select(int k) {
        return null;
    }

    @Override
    public void deleteMin() {
        if (!isEmpty()){
            for (int i = 0; i < offset - 1; i++){
                items[i] = items[i + 1];
            }
            offset--;
            items[offset] = null;
        }

    }

    @Override
    public void deleteMax() {
        if (!isEmpty()){
            items[offset - 1] = null;
            offset--;
        }

    }

    @Override
    public void put(K key, V value) {
        int rank = rank(key);
        Comparable<K> k = items[rank].key;
        if (k.compareTo(key) == 0){
            items[rank].value = value;
            return;
        }

        offset++;
        for (int i = offset; i > rank; i--){
            items[i] = items[i - 1];
        }
        items[rank].value = value;

    }

    @Override
    public V get(K key) {
        int rank = rank(key);
        Comparable<K> k = items[rank].key;
        if (k.compareTo(key) == 0) return (V)items[rank].value;
        return null;
    }

    @Override
    public void delete(K key) {


    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return offset;
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }

    private class Item <K extends Comparable<K>, V>{
        K key;
        V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
