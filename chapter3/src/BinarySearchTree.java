public class BinarySearchTree<K extends Comparable<K>, V> implements OrderedST<K, V> {

    private Node<K, V> root;

    @Override
    public K min() {
        if (root == null) return null;
        Node<K, V> node = root;
        while (node.left != null){
            node = node.left;
        }
        return node.k;
    }


    private Node<K, V> min(Node<K, V> node){
        if (node.left == null){
            return node;
        }
        return min(node.left);
    }



    @Override
    public K max() {
        return null;
    }

    @Override
    public int rank(K k) {
        return 0;
    }

    @Override
    public K select(int k) {
        return null;
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }


    private Node<K, V> deleteMin(Node<K, V> node){
        if (node.left == null){
            return node.right;
        } else {
            node.left = deleteMin(node.left);
        }

        return node;
    }

    @Override
    public void deleteMax() {

    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);

    }

    private Node put(Node<K, V> node, K key, V value){
        if (node == null) {
            node = new Node<>(key, value, null, null);
        }else {
            int cmp = key.compareTo(node.k);
            if (cmp > 0){
                node.right = put(node.right, key, value);
            } else if (cmp < 0){
                node.left = put(node.left, key, value);
            } else {
                node.v = value;
            }
        }

        return node;
    }


    @Override
    public V get(K key) {
        Node<K, V> found = find(root, key);
        if (found == null){
            return null;
        } else {
            return found.v;
        }
    }

    private Node find(Node<K, V> node, K key){
        if (node == null) return null;
        int cmp = key.compareTo(node.k);
        if (cmp > 0){
            return find(node.right, key);
        } else if (cmp < 0){
            return find(node.left, key);
        } else {
            return node;
        }
    }

    @Override
    public void delete(K key) {
        Node<K, V> node = find(root, key);
        if (node == null){
            return;
        }
        else {
            Node<K, V> min = min(node.right);
            node.k = min.k;
            node.v = min.v;
            node.right = deleteMin(node.right);
        }

    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }


    private class Node<K extends Comparable<K>, V>{
        K k;
        V v;
        Node<K, V> left;
        Node<K, V> right;

        public Node(K k, V v, Node<K, V> left, Node<K, V> right) {
            this.k = k;
            this.v = v;
            this.left = left;
            this.right = right;
        }
    }
}
