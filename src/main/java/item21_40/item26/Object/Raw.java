package item21_40.item26.Object;

import java.util.ArrayList;
import java.util.List;

public class Raw {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
//        unsafeAdd(list, Integer.valueOf(1));// 컴파일 오류 발생
        String s = list.get(0);
    }

    // list -> list<Object> : 컴파일 오류 발생
    public static void unsafeAdd(List<Object> list, Object o) {
        list.add(o);
    }
}

/**
 * 제네릭 하위 타입 규칙
 * List: 타입에 관여하지 않는다. -> List<String> 넘길 수 있다. -> List의 하위 타입인 List<String>
 * List<Object>: 모든 타입을 허용한다. -> List<String> 넘길 수 없다. -> List<Object>의 하위타입이 아님
 * List<Object> 같은 매개변수화 타입을 사용할 때와 달리 List 같은 로 타입을 사용하면 타입 안전성을 잃게 된다.
 */
