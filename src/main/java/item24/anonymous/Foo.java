package item24.anonymous;


public class Foo {

    public static void main(String[] args) {

        Anonymous anonymous = new Anonymous() {

            public void print() {
                System.out.println("print");
            }
            @Override
            public String getName() {
                return super.getName();
            }

            @Override
            public void setName(String name) {
                super.setName(name);
            }
        };

    }
}
