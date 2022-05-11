package item1_20.item11;

public class PhoneNumber_lazy {
    private final short areaCode, prefix, lineNum;

    public PhoneNumber_lazy(short areaCode, short prefix, short lineNum) {
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
        PhoneNumber_lazy that = (PhoneNumber_lazy) o;
        return areaCode == that.areaCode && prefix == that.prefix && lineNum == that.lineNum;
    }

    private int hashCode = 0;
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Short.hashCode(areaCode);
            result = result * 31 + Short.hashCode(prefix);
            result = result * 31 + Short.hashCode(lineNum);
        }
        return result;
    }
}
