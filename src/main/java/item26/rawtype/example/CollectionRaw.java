package item26.rawtype.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionRaw {

    private final List stamps = new ArrayList();

    public void useIterator() {
        for (Iterator i = stamps.iterator(); i.hasNext(); ) {
            Stamp stamp = (Stamp) i.next(); // ClassCastException
            stamp.cancel();
        }
    }

    public void add(Object o) {
        stamps.add(o);
    }

}
