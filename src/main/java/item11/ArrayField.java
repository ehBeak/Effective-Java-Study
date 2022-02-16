package item11;

import java.util.Arrays;
import java.util.Objects;

public class ArrayField {
    private int[] array;
    private int size;

    public ArrayField(int[] array, int size) {
        this.array = array;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayField that = (ArrayField) o;
        return size == that.size && Arrays.equals(array, that.array);
    }

    //hashCode
    @Override
    public int hashCode() {
        int result = Integer.hashCode(size);
        if (array.length == 0) {
            result = result * 31 + 0;
        } else {
            result = result * 31 + Arrays.hashCode(array);
        }
        return result;
    }
}
