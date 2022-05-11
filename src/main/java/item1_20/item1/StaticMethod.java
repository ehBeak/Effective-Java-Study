package item1_20.item1;

public class StaticMethod {// 불변 클래스

    private static final StaticMethod INSTANCE = new StaticMethod();

    private StaticMethod() {


    }



    public static StaticMethod getInstance() {
        return INSTANCE;
    }
}

