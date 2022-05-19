package item21_40.item39.one;


public class Sample {

    @Test(ArithmeticException.class)
    public static void m1() {
        int i=0;
        i=i/i;
    }

    @Test(ArithmeticException.class)
    public static void m2(){
        int[] a = new int[0];
        int i = a[1];
    }

    @Test(ArithmeticException.class)
    public static void m3(){

    }
}
