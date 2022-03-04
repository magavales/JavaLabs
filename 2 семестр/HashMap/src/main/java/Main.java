public class Main {
    public static void main(String[] args) {
        HashMap map = new HashMap<>();
        map.put("KING", 1);
        map.put("Two", 2);
        map.put("BLAKE", 2);
        HashMap newMap = new HashMap<>(map);
        map.put("KING", 10);
    }
}
