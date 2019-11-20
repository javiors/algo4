public interface OrderedST<K extends Comparable<K>, V> extends ST<K, V> {
    K min();
    K max();
    int rank(K k);
    K select(int k);
    void deleteMin();
    void deleteMax();

}
