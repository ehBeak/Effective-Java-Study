package item26.rawtype;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

//제네릭을 지원하기 전 컬렉션 선언
public class Raw {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        unsafeAdd(list, Integer.valueOf(1));
        String s = list.get(0);// 컴파일 오류는 없지만, 런타임시 ClassCastException을 던짐
    }

    public static void unsafeAdd(List list, Object o) {
        list.add(o);// unchecked call 경고 뜬다.
    }

}

/**
 * 오류는 가능한 한 발생 즉시, 이상적으로는 컴파일할 때 발견하는 것이 좋다.
 * -> 로우타입을 사용할 경우 한참 뒤인 런타임에서 확인할 수 있음
 */
