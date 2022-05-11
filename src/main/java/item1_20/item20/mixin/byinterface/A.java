package item1_20.item20.mixin.byinterface;

// 인터페이스로 믹스인 클래스 사용
public class A implements Comparable<Integer>{

    @Override
    public int compareTo(Integer integer) { // 인스턴스끼리 순서가 있다는 기능 추가(구체적인 구현은 본인이)
        return 0;
    }

    public void a() {// A 클래스의 주된 기능

    }
}
