package item26.generic;

import item24.inner.adapter.MySet;
import item26.rawtype.example.Stamp;

import java.util.*;

public class Generic {
    private final Collection<Stamp> stamps = new ArrayList<>();

    private final ArrayList<?> collection = new ArrayList<>();


    public void add(Object o) {
//        stamps.add(o);
//        collection.add(Integer.valueOf(22)); // 컴파일 오류
        collection.add(null);

    }

    /**
     * 제네릭을 사용하면 컴파일시 오류가 발생한다.
     */
}
