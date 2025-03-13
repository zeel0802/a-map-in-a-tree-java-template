package org.example;

public class App {
    public static void main(String[] args) {
        TreeMap map = new TreeMap();

        // Insert key-value pairs
        map.insert("keyOne", "valueOne");
        map.insert("keyTwo", "valueTwo");
        map.insert("keyThree", "valueThree");

        // Retrieve values
        System.out.println("Get keyOne: " + map.get("keyOne"));  // Expected: valueOne
        System.out.println("Get keyThree: " + map.get("keyThree"));  // Expected: valueThree
        System.out.println("Get keyDoesNotExist: " + map.get("keyDoesNotExist"));  // Expected: ""

        // Delete a key-value pair
        map.delete("keyOne");
        System.out.println("After deleting keyOne, get keyOne: " + map.get("keyOne"));  // Expected: ""
    }
}
