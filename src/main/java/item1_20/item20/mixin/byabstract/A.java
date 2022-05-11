package item1_20.item20.mixin.byabstract;

public class A {

    private C c = new C() { // 추상 메서드도 컴포지션으로 믹스인을 적용할 수 있음
        @Override
        void comparable() {

        }
    };

    // A 클래스의 주된 기능
    public void a() {

    }
}
