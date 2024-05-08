package chA;

public class VarExample1 {
    public static void main(String[] args) {
        String x = getData();
        var y = getData();

        System.out.println(x);
        System.out.println(y);
    }

    public static String getData() {
        return "홍길동";
    }
}
