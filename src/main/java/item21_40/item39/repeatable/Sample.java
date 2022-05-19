package item21_40.item39.repeatable;

import java.util.ArrayList;
import java.util.List;

public class Sample {
    @Test(IndexOutOfBoundsException.class)
    @Test(NullPointerException.class)
    public static void doubleBad() {
        List<String> list = new ArrayList<>();
        list.addAll(5, null);
    }
}
