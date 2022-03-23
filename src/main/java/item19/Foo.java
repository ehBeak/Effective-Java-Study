package item19;

import java.util.AbstractList;

public class Foo {

    // 상속을 고려해 설계하고 문서화 해라, 그러지 않았다면 상속을 금지해라

    /*
    *  상속용 클래스를 재정의 하는 경우
    *  1. 문서로 남기기
    *  2. 실제 상속용 클래스를 하위 클래스를 통해서 테스트
    *  3. 상속용 클래스의 생성자는 직접적으로든 간접적으로든 재정의 가능 메서드를 호출해서는 안 된다.
    *
    *  Cloneable, Serializable 인터페이스를 구현하는 상속용 클래스를 만드는 경우
    *  1. 생성자와 같은 제약을 둔다.
    *  2. Serializable을 구현한 상속용 클래스가 readResolve나 writeReplace 메서드를 갖는다면, 이 메서드들은 private이 아닌, protected로 선언해야한다.
    *  3. 상속 클래스를 만든 것은 좋지 않은 생각*/


    // 가장 좋은 방법 : 상쇽용으로 설계하지 않은 크래스는 상속을 금지하는 것이다 (final, 모든 생성자를 private, package-private, public 정적 팩터리)
    // 꼭 상속 받아야 겠다면, 재정의 가능 메서드를 사용하지 않게 만들고 이를 문서로 남기기
}
