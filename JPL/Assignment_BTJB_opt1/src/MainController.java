import java.util.Scanner;

public class MainController {

    public Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.ques4();
    }

    // Cau 1
    public void ques1() {
        System.out.println("Enter n: ");
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Cau 2
    public void ques2() {
        float sum = 0;
        int n;
        do {
            System.out.println("Input n: ");
            n = scanner.nextInt();
        } while (n <= 0);

        for (int i = 1; i <= n ; i++) {
            sum += 1.0/i;
        }
        System.out.println("Sum = " + sum);
    }

    // Cau 3
    public void ques3() {
        System.out.println("Input n: ");
        int n = scanner.nextInt();
        double s = 0;
        for (int i = 1; i <= n; i++) {
            int x = 2 * i - 1;
            int factorial = 1;
            for (int j = 1; j <= x; j++) {
                factorial *= j;
            }
            s += 1.0 / factorial;
        }
        System.out.println("S = " + s);
    }

    // Cau 4
    public void ques4() {
        System.out.println("Input n: ");
        int n = scanner.nextInt();
        String a = String.valueOf(n);
        int s = 0;
        int s2 = 1;
        for (int i = 0; i < a.length(); i++) {
            int s1 = Integer.parseInt(String.valueOf(a.charAt(i)));
            s += s1;
            s2 *= s1;
        }
        System.out.println(s);
        System.out.println(s2);

    }

}
