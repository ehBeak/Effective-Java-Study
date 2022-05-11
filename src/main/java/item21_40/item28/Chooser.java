package item21_40.item28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser {

    private final Object[] choiceArray;

    public Chooser(Collection choices) {
        choiceArray = choices.toArray();
    }

    // choose 메서드를 호출할 때마다 반환된 Object를 원하는 타입으로 형변환 해야한다.
    // 혹시나 타입이 다른 원소가 들어 있었다면 런타임에 형변환 오류가 날 것이다.
    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
