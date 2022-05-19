package item21_40.item39.marker;

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
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable cause = wrappedExc.getCause();
                    System.out.println(m+" 실패: " + cause);
                } catch (Exception e) {
                    System.out.println("잘못 사용한 @Test" + m);
                }
            }
        }
        System.out.printf("성공: %d, 실패: %d%n", passed, tests - passed);
    }
}
