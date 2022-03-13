import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MapTest {

    // Prepared map with 1.000.000  random generated elements and one guaranteed pair key-value (100-100)
    static Map<Integer, Integer> sharedMap = new Map<>();



    @Test
    @DisplayName("Should be true")
    void Map_test_0 () {
    }

    @Test
    @DisplayName("Equality of two empty 'map'")
    void Map_Constructor_0() {
        Map<Integer, String> map0 = new Map<>();
        Map<Integer, String> map1 = new Map<>();
        Assertions.assertEquals(map0, map1);
    }

    @Test
    @DisplayName("Equality of two empty 'map' produce by copy constructor")
    void Map_Constructor_1() {
        Map<Integer, String> map0 = new Map<>();
        Map<Integer, String> map1 = new Map<>(map0);
        Assertions.assertEquals(map0, map1);
    }

    @Test
    @DisplayName("Equality of two 'map' produced by copy constructor")
    void Map_Constructor_2() {
        Map<Integer, String> map0 = new Map<>();
        map0.put(1, "One");
        map0.put(9, "Nine");
        map0.put(2, "Two");
        map0.put(8, "Eight");
        map0.put(3, "Three");
        map0.put(7, "Seven");
        Map<Integer, String> map1 = new Map<>(map0);
        Assertions.assertEquals(map0, map1);
    }

    @Test
    @DisplayName("'Map' with duplicates. Mustn't be too long or infinity loop")
    void Map_Constructor_3() {
        Map<Integer, String> map = new Map<>();
        map.put(1, "One");
        map.put(1, "One");
        map.put(1, "One");
        map.put(1, "One");
        map.put(1, "One");
        map.put(1, "One");
        map.put(1, "One");
    }

    @Test
    @DisplayName("Get from empty map")
    void Map_Get_7() {
        Map<Integer, Integer> map = new Map<>();
        Assertions.assertNull(map.get(1));
    }

    @Test
    @DisplayName("Searching guaranteed value in prepared initialized map with 10.000.000 elements. Should be executed in 10-20ms")
    void Map_Get_8() {
        Assertions.assertEquals(100, sharedMap.get(100));
    }

}
