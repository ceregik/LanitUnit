import java.util.Scanner;

public class Calc {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Calc calc = new Calc();
        char action = scanner.nextLine().toCharArray()[0];
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("" + calc.doAction(action,a,b));

    }

    public int doAction(char action, int a,int b){

        switch (action) {
            case ('+'):
                return a+b;
            case ('-'):
                return a-b;
            case ('*'):
                return a*b;
            case ('/'):
                try {
                    return  a/b;
                } catch (ArithmeticException  e){
                    System.out.println("division by zero");
                    return -1;
                }
        }
        return -1;
    }

}
