package item28;

import java.util.ArrayList;
import java.util.List;

public class Foo1 {

    public static void main(String[] args) {

        /**
         * 배열: 런타임에서 실패한다.
         */
        Object[] objectArray = new Long[1];
        objectArray[0] = "타입이 달라 넣을 수 없다."; // ArrayStoreException

        /**
         * 제네릭: 컴파일에서 실패한다
         */
//        List<Object> ol = new ArrayList<Long>();
    }
}
