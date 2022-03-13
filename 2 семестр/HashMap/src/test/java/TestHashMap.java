import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestHashMap {

    @Test
    @DisplayName("Should be true")
    void PriorityQueue_Success_0() {
    }

    @Test
    @DisplayName("No parameters constructor and constructor with initialCapacity and loadFactor parametrs")
    void PriorityQueue_Constructors_0() {
        HashMap<String, Integer> map0 = new HashMap<>();
        HashMap<String, Integer> map1 = new HashMap<>(100);
        HashMap<String, Integer> map2 = new HashMap<>(100, 0.65f);
    }

    @Test
    @DisplayName("Constructor of copy")
    void PriorityQueue_Constructors_1() {
        HashMap<String, Integer> map0 = new HashMap<>();
        HashMap<String, Integer> map1 = new HashMap<>(map0);
        HashMap<String, Integer> map2 = new HashMap<>(map0);

        Assertions.assertEquals(map2, map1);
    }

    @Test
    @DisplayName("Test 'isEmpty' function")
    void PriorityQueue_isEmpty_0() {
        HashMap<String, Integer> map = new HashMap<>();
        Assertions.assertTrue(map.isEmpty());
        map.put("KING", 1);
        Assertions.assertFalse(map.isEmpty());
    }

    @Test
    @DisplayName("Test 'getSize' function")
    void PriorityQueue_getSize_0() {
        HashMap<String, Integer> map = new HashMap<>();
        Assertions.assertEquals(0, map.getSize());
        map.put("KING", 1);
        Assertions.assertEquals(1, map.getSize());
    }

    @Test
    @DisplayName("Test 'delete' function")
    void PriorityQueue_remove_0() {
        HashMap<String, Integer> map0 = new HashMap<>();
        map0.put("KING", 1);
        map0.put("Two", 2);
        map0.put("BLAKE", 2);

        map0.remove("KING");


        Assertions.assertEquals(2, map0.getSize());
    }

    @Test
    @DisplayName("Clear function")
    void PriorityQueue_Clear_0() {
        HashMap<String, Integer> map0 = new HashMap<>();
        map0.put("KING", 1);
        map0.put("Two", 2);
        map0.put("BLAKE", 2);
        map0.clear();


        Assertions.assertEquals(0, map0.getSize());
    }

}
