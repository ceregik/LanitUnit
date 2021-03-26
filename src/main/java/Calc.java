import java.io.IOException;
import java.util.Scanner;

public class Calc {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Calc calc = new Calc();
        char action = scanner.nextLine().toCharArray()[0];
        int a = scanner.nextInt();
        String b = "s";
        System.out.println("" + calc.doAction(action,a,b));

    }

    public Object doAction(Object actionO, Object aO,Object bO){
            char action = (char) actionO;
            int a = (Integer) aO;
            int b = (Integer) bO;

            switch (action) {
                case ('+'):
                    return a + b;
                case ('-'):
                    return a - b;
                case ('*'):
                    return a * b;
                case ('/'):
                    try {
                        return a / b;
                    } catch (ArithmeticException e) {
                        System.out.println("division by zero");
                        return false;
                    }
            }
            return false;
        }
    }

