import java.util.Iterator;

public class SequentialSearchST<K, V> implements ST<K, V> {

    private Node first;

    @Override
    public void put(K key, V value) {
        Node temp = first;
        while (temp != null){
            if (temp.key.equals(key)){
                temp.value = value;
                return;
            }
            temp = temp.next;
        }

        first = new Node(key, value, first);
    }

    @Override
    public V get(K key) {
        Node temp = first;
        while (temp != null){
            if (temp.key.equals(key)){
                return temp.value;
            }

            temp = temp.next;
        }

        return null;
    }

    @Override
    public void delete(K key) {

        Node prev = null;
        Node temp = first;
        while (temp != null){
            if (temp.key.equals(key)){
                if (prev != null){
                    prev.next = temp.next;
                } else {
                    first = null;
                }
            }

            prev = temp;
            temp = temp.next;
        }

    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<K> keys() {
        return new Iterable<K>() {
            @Override
            public Iterator<K> iterator() {
                return new SequentialIterator();
            }
        };
    }

    private class SequentialIterator implements Iterator<K> {
        Node head;

        public SequentialIterator() {
            this.head = new Node(null, null, first);
        }

        @Override
        public boolean hasNext() {
            return head.next != null;
        }

        @Override
        public K next() {
            head = head.next;
            return head.key;
        }
    }


    private class Node {
        K key;
        V value;
        Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
