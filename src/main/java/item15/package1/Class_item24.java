package item15.package1;

public class Class_item24 {

    private Class_package_private package_private;

    // package-private 클래스를 사용하는 클래스 내에서 private static 으로 중첩시킴
    private static class class1 {

        private String a;

    }


    // pg.97 톱 레벨로 두면 같은 패키지의 모든 클래스가 접근할 수 있지만
    // private static으로 중첩시키면 바깥 클래스 하나에서만 접근할 수 있다.
    public void outer() {

    }
}
