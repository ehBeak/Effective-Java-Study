package item13.case5;

public class HashTable_O {

    private Entry_O[] buckets;

    private static class Entry_O {
        final Object key;
        Object value;
        Entry_O next;

        public Entry_O(Object key, Object value, Entry_O next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        // 이 엔트리가 가리키는 연결 리스트를 재귀적으로 복사
        Entry_O deepCopy() {
            return new Entry_O(key, value,
                    next == null ? null : next.deepCopy());
        }
    }

    // 복잡한 가변 상태를 갖는 클래스용 재귀적 clone 메서드
    @Override
    protected HashTable_O clone() {
        try {
            HashTable_O result = (HashTable_O) super.clone();
            result.buckets = new Entry_O[buckets.length]; // 버킷 크기 할당
            // 기존의 버킷을 순회하며 비지 않은 각 버킷에 대해 깊은 복사를 수행한다.
            // -> 재귀 호출로 스택 오버 플로우가 발생할 수 있음
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    result.buckets[i] = buckets[i].deepCopy();//?
                }
            }
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
