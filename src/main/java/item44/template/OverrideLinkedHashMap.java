package item44.template;

import java.util.LinkedHashMap;
import java.util.Map;

public class OverrideLinkedHashMap<K,V> extends LinkedHashMap<K,V> {

    // 템플릿 메서드 타입
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > 100;
    }
}
