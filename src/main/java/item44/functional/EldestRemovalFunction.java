package item44.functional;

import java.util.Map;

@FunctionalInterface
interface EldestRemovalFunction <K,V>{
    boolean remove(Map<K, V> map, Map.Entry<K, V> eldest);
}
