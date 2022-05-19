package item21_40.item39.one;

import item21_40.item39.one.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTest {
    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;

        // forName에 매개변수가 args[0]이 들어가는지 모르겠음(작동 놉..)
        Class<?> testClass = Class.forName(args[0]);
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("테스트 %s 실패: 예외를 던지지 않음%n, m");
                } catch (InvocationTargetException wrappedExc) {
                    Throwable cause = wrappedExc.getCause();
                    Class<? extends Throwable> excType = m.getAnnotation(Test.class).value();
                    if (excType.isInstance(cause)) {
                        passed++;
                    } else {
                        System.out.println(m+" 실패: " + cause);
                    }
                } catch (Exception e) {
                    System.out.println("잘못 사용한 @Test" + m);
                }
            }
        }
        System.out.printf("성공: %d, 실패: %d%n", passed, tests - passed);
    }
}
