package myPackage;

public class Calculation {

    private static int value1 = 2;
    private static int value2 = 3;
    private static int result1 = add(value1, value2);
    private static int result2 = sub(value1, value2);

    public static int add(int a, int b) {
        System.out.println("adding " + a + " and " + b);
        int c = a + b;
        c = a + b;
        c = a + b;
        c = a + b;
        c = a + b;
        return c;
    }

    public static int add_duplicate(int a, int b) {
        System.out.println("adding " + a + " and " + b);
        int c = a + b;
        c = a + b;
        c = a + b;
        c = a + b;
        c = a + b;
        return c;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        System.out.println(value1 + " + " + value2 + " = " + result1);
        System.out.println(value1 + " - " + value2 + " = " + result2);
    }
}