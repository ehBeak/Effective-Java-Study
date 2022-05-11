package item1_20.item6;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* 어댑터는 실제 작업은 뒷단 객체에 위임하고 자신은 제2의 인터페이스 역할을 해주는 객체 */
public class ExampleAdapter {

    public static void main(String[] args) {

        Map<Long, String> map = new HashMap<>();
        map.put(1L, "하나"); map.put(1L, "일");
        map.put(2L, "둘"); map.put(2L, "이");

//        Set<K> keySet();
        Set<Long> set1 = map.keySet();

        map.put(3L, "셋"); map.put(3L, "삼");
        Set<Long> set2 = map.keySet();

        // true : 매번 같은 인스턴스 반환, 반환된 Set인스턴스가 일반적으로 가변이더라도 변환된 인스턴스 들은 기능적으로 모두 똑같다.
        // 즉 반환한 객체 중 하나를 수정하면 다른 모든 객체가 따라서 바뀐다.(Pattern)
        // 모두가 똑같은 Map인스턴스를 대변하기 때문이다.
        System.out.println("set1 == set2 : " + (set1 == set2));


    }

}
