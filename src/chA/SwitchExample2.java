package chA;

public class SwitchExample2 {
    public static void main(String[] args) {
        method1();
        method2();
    }

    public static void method1() {
        String grade = "B";
        int score;

        switch (grade) {
            case "A":
                score=100;
                break;
        
            case "B":
                int res = 100 - 20;
                score=res;
                break;
        
            default:
                score=60;
        }
        System.out.println("score: "+ score);
    }

    public static void method2() {
        String grade = "B";
        int score = switch(grade) {
            case "A" -> 100;
            case "B" -> {
                int result = 100 -20;
                yield result;
            }
            default -> 60;
        };
        System.out.println("score: "+ score);
    }
}
