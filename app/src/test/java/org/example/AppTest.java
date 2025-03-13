package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void testInsertAndGet() {
        TreeMap map = new TreeMap();
        map.insert("apple", "red");
        map.insert("banana", "yellow");
        assertEquals("red", map.get("apple"));
        assertEquals("yellow", map.get("banana"));
    }

    @Test
    void testDelete() {
        TreeMap map = new TreeMap();
        map.insert("car", "blue");
        map.delete("car");
        assertEquals("", map.get("car"));
    }
}
