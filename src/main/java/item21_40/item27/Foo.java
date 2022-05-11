package item21_40.item27;

import java.util.HashSet;
import java.util.Set;

public class Foo {
    Set<Lark> exaltation = new HashSet();//Unchecked assignment: 'java.util.HashSet' to 'java.util.Set<item21_40.item27.Lark>'
    Set<Lark> exaltation2 = new HashSet<>();// <>연산자를 사용하면 올바를 실제 타입 매개변수(Lark)를 추론


}
