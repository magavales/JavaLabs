public class Main {
    public static void main(String[] args) {
        HashMap map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("One", 2);
        map.remove("One");
    }
}
