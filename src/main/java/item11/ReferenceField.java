package item11;

import java.util.Objects;

public class ReferenceField {

    private PhoneNumber phoneNumber;
    private int name;

    public ReferenceField(PhoneNumber phoneNumber, int name) {
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReferenceField that = (ReferenceField) o;
        return name == that.name && Objects.equals(phoneNumber, that.phoneNumber);
    }

    // hashCode
    @Override
    public int hashCode() {
        int result = Integer.hashCode(name);
        if (phoneNumber != null) {
            result = result * 31 + 0;
        } else {
            result = result * 31 + phoneNumber.hashCode();
        }
        return result;
    }
}
