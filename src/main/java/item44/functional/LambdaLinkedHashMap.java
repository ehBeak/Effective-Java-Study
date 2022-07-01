package item44.functional;

import java.util.Map;

public class LambdaLinkedHashMap {
    public static void main(String[] args) {
        EldestRemovalFunction<Integer, Integer> eldestRemovalFunction = ((map, eldest) -> map.size() > 100);

    }
}
