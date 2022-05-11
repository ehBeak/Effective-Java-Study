package item1_20.item15.package1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 톱 클래스에 부여할 수 있는 접근 제한자 - public
public class Class_public { // 공개 API: 하위 호환으로 인한 관리 대상

    // public클래스의 인스턴스 필드는 되도록 public이 아니어야 한다.
    public TestClass testClass; // 스레드로부터 안전하지 않다.

    // 보안 허점 -
    public static final TestClass[] VALUES_X = {};

    // 해결 방법1: public 불변 리스트를 추가하기
    private static final TestClass[] VALUES_O1 = {};
    public static final List<TestClass> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_O1));

    // 해결 방법2: 복사본을 반환하는 public 메서드 추가(방어적 복사)
    private static final TestClass[] VALUES_O2 = {};
    public static final TestClass[] values() {
        return VALUES_O2.clone();
    }

}
