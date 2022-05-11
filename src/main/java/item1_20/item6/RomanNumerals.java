package item1_20.item6;

import java.util.regex.Pattern;

/* 똑같은 기능의 객체를 매번 생성하기 보다는 객체 하나를 재사용 하는 편이 나을 때가 많다 */

public class RomanNumerals {
    //private static final Pattern ROMAN
    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})"
            + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    // static boolean
    static boolean isRomanNumeral_O(String s) {
        return ROMAN.matcher(s).matches();
    }

    public static void main(String[] args) {

        /* 불필요한 객체 생성 피하기 */

        // 1. 인스턴스 재사용
        String s_x = new String("bikini");// 사용X : 실행될 때마다 인스턴스를 새로 만든다. String pool X
        String s_o = "bikini"; // 새로운 인스턴스를 만드는 대신, 하나의 String 인스턴스를 사용한다. String pool O ==> 객체 재사용함이 보장

        // 2. 생성자 대신 정적 팩터리 메서드를 사용한다.
        Boolean aBoolean_x = new Boolean(s_o); // deprecated(java9) : 호출할 때마다 새로운 객체 생성
        Boolean aBoolean_o = Boolean.valueOf(s_o); // 정적 팩터리 메서드 사용

        // 3. 생성비용이 비싼 객체는 캐싱하여 재사용한다.
        isRomanNumeral_X(s_o); // 반복사용 X: 내부에서 만드는 Pattern인스턴스가 가비지 컬렉션 대상이 된다.
        RomanNumerals.isRomanNumeral_O(s_o); // Pattern인스턴스를 초기화 과정에서 직접 생성해 캐싱해두고 메서드가 호출될 때마다 재사용


    }


    static boolean isRomanNumeral_X(String s){
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    // inner class에서 static 사용 X(java11)
}
