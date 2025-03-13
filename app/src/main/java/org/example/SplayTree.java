package org.example;

class SplayTree {
    private static class Node {
        KeyValuePair data;
        Node left, right;

        Node(KeyValuePair data) {
            this.data = data;
        }
    }

    private Node root;

    private Node rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    private Node splay(Node root, String key) {
        if (root == null || root.data.getKey().equals(key)) return root;

        if (key.compareTo(root.data.getKey()) < 0) {
            if (root.left == null) return root;
            if (key.compareTo(root.left.data.getKey()) < 0) {
                root.left.left = splay(root.left.left, key);
                root = rightRotate(root);
            } else if (key.compareTo(root.left.data.getKey()) > 0) {
                root.left.right = splay(root.left.right, key);
                if (root.left.right != null)
                    root.left = leftRotate(root.left);
            }
            return (root.left == null) ? root : rightRotate(root);
        } else {
            if (root.right == null) return root;
            if (key.compareTo(root.right.data.getKey()) > 0) {
                root.right.right = splay(root.right.right, key);
                root = leftRotate(root);
            } else if (key.compareTo(root.right.data.getKey()) < 0) {
                root.right.left = splay(root.right.left, key);
                if (root.right.left != null)
                    root.right = rightRotate(root.right);
            }
            return (root.right == null) ? root : leftRotate(root);
        }
    }

    public void insert(String key, String value) {
        KeyValuePair kv = new KeyValuePair(key, value);
        if (root == null) {
            root = new Node(kv);
            return;
        }
        root = splay(root, key);
        if (key.equals(root.data.getKey())) {
            root.data.setValue(value);
            return;
        }
        Node newNode = new Node(kv);
        if (key.compareTo(root.data.getKey()) < 0) {
            newNode.right = root;
            newNode.left = root.left;
            root.left = null;
        } else {
            newNode.left = root;
            newNode.right = root.right;
            root.right = null;
        }
        root = newNode;
    }

    public String get(String key) {
        root = splay(root, key);
        return (root != null && root.data.getKey().equals(key)) ? root.data.getValue() : "";
    }

    public void delete(String key) {
        if (root == null) return;
        root = splay(root, key);
        if (!root.data.getKey().equals(key)) return;
        if (root.left == null) {
            root = root.right;
        } else {
            Node temp = root.right;
            root = root.left;
            root = splay(root, key);
            root.right = temp;
        }
    }
}
