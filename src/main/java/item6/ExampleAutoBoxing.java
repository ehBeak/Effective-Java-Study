package item6;

/* 오토박싱 : 불필요한 객체를 만들어내는 예 */
public class ExampleAutoBoxing {

    // 오토박싱 : 기본 타입과 박싱된 기본 타입을 섞어 쓸 때 자동으로 상호 변환해주는 기술
    //==> 오토박싱은 기본 타입과 그에 대응하는 박싱된 기본 타입의 구분을 흐려주지만, 완전히 없애는 것으 아니다.
    public static void main(String[] args) {

        long sum = sum(); // 사용X
        //==> 박싱된 기본 타입보다는 기본 타입을 사용하고, 의도치 않은 오토박싱이 숨어들지 않도록 주의

    }

    private static long sum() {
        Long sum = 0L; // Long변수를 사용해 불필요한 인스턴스가 231개나 만들어짐
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i; // 오토박싱으로 인해 인스턴스 생성으로 성능 저하
        }
        return sum;
    }
}
