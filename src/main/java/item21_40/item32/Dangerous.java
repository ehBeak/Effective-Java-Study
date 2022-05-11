package item21_40.item32;

import java.util.List;

public class Dangerous {

    static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        /**
         * 매개변수화 타입의 변수가 타입이 다른 객체를 참조하면 힙 오염이 발생한다.
         * 이렇게 다른 타입 객체를 참조하는 상황에서는 컴파일러가 자동 생성한 형변환이 실패할 수 있으니,
         * 제네릭 타입 시스템이 약속한 타입 안전성의 근간이 흔들려버린다.
         */
        objects[0] = intList; // 힙 오몀 발생
        String s = stringLists[0].get(0); // ClassCastException(보이지 않는 형변환이 숨어 있기 때문)

        // -> 제네릭 varargs 배열 매개변수에 값을 저장하는 것은 안전하지 않다. 그러나 가능하긴 함 유용하니까
    }

    @SafeVarargs // SafeVarargs 애너테이션을 사용해 그 메서드가 타입 안전함을 보장함 (원래 여기서 사용하면 안된다.)
    static void dangerous2(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList; // 힙 오몀 발생
        String s = stringLists[0].get(0); // ClassCastException(보이지 않는 형변환이 숨어 있기 때문)
    }


}
