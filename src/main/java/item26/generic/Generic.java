package item26.generic;

import item26.rawtype.example.Stamp;

import java.util.ArrayList;
import java.util.Collection;

public class Generic {
    private final Collection<Stamp> stamps = new ArrayList<>();

    public void add(Object o) {
//        stamps.add(o);
    }
    /**
     * 제네릭을 사용하면 컴파일시 오류가 발생한다.
     */
}
