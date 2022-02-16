package item11;

import java.util.Objects;

public class PhoneNumber_Objects {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber_Objects(short areaCode, short prefix, short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber_Objects that = (PhoneNumber_Objects) o;
        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;
    }

    //hashCode Overriding
    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNum);
    }

}
