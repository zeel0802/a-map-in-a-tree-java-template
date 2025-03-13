package org.example;

public class TreeMap {
    private final SplayTree splayTree;

    public TreeMap() {
        this.splayTree = new SplayTree();
    }

    public void insert(String key, String value) {
        splayTree.insert(key, value);
    }

    public String get(String key) {
        return splayTree.get(key);
    }

    public void delete(String key) {
        splayTree.delete(key);
    }
}
