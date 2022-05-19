package item21_40.item39.many;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTest {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;

        // forName에 매개변수가 args[0]이 들어가는지 모르겠음(작동 놉..)
        Class<?> testClass = Class.forName("java/item21_40/item39/Sample.java");
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.println(m+" 실패: 예외를 던지지 않음");
                } catch (InvocationTargetException wrappedExc) {
                    Throwable cause = wrappedExc.getCause();
                    int oldPassed = passed;
                    Class<? extends Throwable>[] excTypes = m.getAnnotation(Test.class).value();

                    for (Class<? extends Throwable> excType :
                            excTypes) {
                        if (excType.isInstance(excType)) {
                            passed++;
                            break;
                        }
                        if (passed == oldPassed) {
                            System.out.println("실패");
                        }
                    }
                    System.out.println(m+" 실패: " + cause);
                } catch (Exception e) {
                    System.out.println("잘못 사용한 @Test" + m);
                }
            }
        }
        System.out.printf("성공: %d, 실패: %d%n", passed, tests - passed);
    }
}
