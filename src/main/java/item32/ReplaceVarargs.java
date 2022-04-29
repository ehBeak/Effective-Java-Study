package item32;

import java.util.ArrayList;
import java.util.List;

public class ReplaceVarargs {

    // 제네릭 varargs 매개변수를 List로 대체한 예 - 타입 안전하다.
    static <T> List<T> flatten(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }


}
