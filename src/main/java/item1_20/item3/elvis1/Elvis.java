package item1_20.item3.elvis1;

/**
 * Elvis is singleton
 */
public class Elvis {
    // public static final 필드에 바로 초기화
    public static final Elvis INSTANCE = new Elvis();

    // private 생성자로 외부에서 호출 못하도록함
    private Elvis() {

    }
}

