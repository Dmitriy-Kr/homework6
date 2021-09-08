package Mymap;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;

public class MyMap<K, V> {

    int size;

    private MapNode<K, V>[] table = (MapNode<K, V>[]) new MapNode[8];

    Set<Node<K, V>> mapSat;

    Set<K> keySet;

    public int getSize() {
        return size;
    }

    public static class Node<K, V> {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + " = " + value;
        }
    }

    private class MapNode<K, V> extends Node<K, V> {
        MapNode<K, V> next;

        MapNode(K key, V value) {
            super(key, value);
        }
    }

    public Set<Node<K, V>> mapSat() {
        if (mapSat == null) {
            mapSat = new AbstractSet<Node<K, V>>() {
                @Override
                public Iterator<Node<K, V>> iterator() {
                    return new Iterator<Node<K, V>>() {
                        MapNode<K, V> currentNode;
                        int currentIndex;

                        {
                            while (currentNode == null && currentIndex < table.length) {
                                currentNode = table[currentIndex++];
                            }
                        }

                        @Override
                        public boolean hasNext() {
                            return currentNode != null;
                        }

                        @Override
                        public Node<K, V> next() {
                            Node<K, V> result = currentNode;
                            if (currentNode.next != null) {
                                currentNode = currentNode.next;
                            } else {
                                currentNode = null;
                                while (currentNode == null && currentIndex < table.length) {
                                    currentNode = table[currentIndex++];
                                }
                            }
                            return result;
                        }
                    };
                }

                @Override
                public int size() {
                    return size;
                }
            };
        }
        return mapSat;
    }


    private int getIndex(K k) {
        return Math.abs(k.hashCode()) % table.length;
    }

    public V put(K key, V value) {
        int index;
        V result = null;

        if (key == null) {
            index = 0;
        } else {
            index = getIndex(key);
        }

        if (table[index] == null) {

            table[index] = new MapNode<>(key, value);
            size++;

        } else {

            MapNode<K, V> current = table[index];

            while (current != null) {
                if (key != null) {
                    if (key.equals(current.key)) {
                        result = current.value;
                        current.value = value;
                        break;
                    }
                } else {
                    if (current.key == null) {
                        result = current.value;
                        current.value = value;
                        break;
                    }
                }
                if (current.next == null) {
                    current.next = new MapNode<>(key, value);
                    size++;
                    break;
                } else {
                    current = current.next;
                }
            }
        }
        return result;
    }

    public boolean containsKey(K key) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                MapNode<K, V> current = table[i];
                while (current != null) {
                    if (current.key == key) {
                        return true;
                    }
                    current = current.next;
                }
            }
        }
        return false;
    }

    public V get(K key) {
        MapNode<K, V> current;
        if (key != null) {
            for (int i = 0; i < table.length; i++) {

                if (table[i] != null) {
                    current = table[i];
                    while (current != null) {
                        if (key.equals(current.key)) {
                            return current.value;
                        }
                        current = current.next;
                    }
                }

            }
        } else {
            if (table[0] != null) {
                current = table[0];
                while (current != null) {
                    if (current.key == null) {
                        return current.value;
                    }
                    current = current.next;
                }
            }
        }
        return null;
    }

    public Set<K> keySet() {
        if (keySet == null) {
            keySet = new AbstractSet<K>() {
                @Override
                public Iterator<K> iterator() {
                    return new Iterator<K>() {
                        MapNode<K, V> currentNode;
                        int currentIndex;

                        {
                            while (currentNode == null && currentIndex < table.length) {
                                currentNode = table[currentIndex++];
                            }
                        }

                        @Override
                        public boolean hasNext() {
                            return currentNode != null;
                        }

                        @Override
                        public K next() {
                            Node<K, V> result = currentNode;
                            if (currentNode.next != null) {
                                currentNode = currentNode.next;
                            } else {
                                currentNode = null;
                                while (currentNode == null && currentIndex < table.length) {
                                    currentNode = table[currentIndex++];
                                }
                            }
                            return result.key;
                        }
                    };
                }

                @Override
                public int size() {
                    return size;
                }
            };
        }
        return keySet;
    }
}
