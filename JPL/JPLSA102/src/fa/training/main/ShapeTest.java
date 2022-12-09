package fa.training.main;

import fa.training.entities.Rectangle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ShapeTest {
    public static Scanner scanner = new Scanner(System.in);

//    public static final String ANSI_RED = "\u001B[31m";

    public static Rectangle[] rectangles;

    public static void main(String[] args) {
        showMennu();
    }

    public static void showMennu() {
        int choice = 0;
        do {
            System.out.println("======== Menu ==========");
            System.out.println("1. Input the length and the width the rectangle.");
            System.out.println("2. Display Length, Width, Perimeter, Square");
            System.out.println("3. Display rectangle has the maximum area.");
            System.out.println("4. Display rectangle has the minimum area.");
            System.out.print("Enter number: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inputRectangle();
                    break;
                case 2:
                    showRectangle();
                    break;
                case 3:
                    maxArea();
                    break;
                case 4:
                    minArea();
                    break;
                default:
                    break;
            }

        } while (choice < 5);
    }

    private static void minArea() {
        int min = Integer.MAX_VALUE;
        for (Rectangle re: rectangles
        ) {
            if (re.calculateArea() < min) {
                min = re.calculateArea();
            }
        }
        for (Rectangle re: rectangles
        ) {
            if (re.calculateArea() == min) {
                System.out.println("Rectangle: length = " + re.getLength() +
                        ", width = " + re.getWidth() +
                        ", perimeter = " + re.calculatePerimeter() +
                        ", area = " + re.calculateArea());
            }
        }
    }

    private static void maxArea() {
        int temp = 0;
        for (Rectangle re: rectangles
             ) {
            if (re.calculateArea() > temp) {
                temp = re.calculateArea();
            }
        }
        for (Rectangle re: rectangles
        ) {
            if (re.calculateArea() == temp) {
                System.out.println("Rectangle: length = " + re.getLength() +
                        ", width = " + re.getWidth() +
                        ", perimeter = " + re.calculatePerimeter() +
                        ", area = " + re.calculateArea());
            }
        }
    }

    private static void showRectangle() {
        try {
            for (Rectangle re: rectangles
            ) {
                System.out.println("Rectangle: length = " + re.getLength() +
                        ", width = " + re.getWidth() +
                        ", perimeter = " + re.calculatePerimeter() +
                        ", area = " + re.calculateArea());
            }
        } catch (Exception e) {
            System.out.println("List Rectangle is empty !");
        }
    }

    private static void inputRectangle() {
        int lengthArray = 0;
        System.out.print("Enter n: ");
        lengthArray = scanner.nextInt();
        if (lengthArray == 0) {
            System.out.println("N must over 0");
            showMennu();
        }
        rectangles = new Rectangle[lengthArray];
        for (int i = 0; i < rectangles.length; i++) {
            System.out.println("Rectangle " + (i + 1) + ": ");
            System.out.print("Enter length: ");
            int length = scanner.nextInt();
            System.out.print("Enter width: ");
            int width = scanner.nextInt();
            Rectangle rectangle = new Rectangle(length, width);
            rectangles[i] = rectangle;
        }
    }
}
