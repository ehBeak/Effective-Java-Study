package item21_40.item28.generic;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

//안전성 보장 못함
public class Chooser<T> {

    private final T[] choiceArray;

    public Chooser(Collection<T> choices) {
        this.choiceArray = (T[]) choices.toArray();// 안전성 보장 못함
    }



    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
