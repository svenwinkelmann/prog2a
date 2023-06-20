package application;

import java.util.Scanner;

public class SimpleJavaApplication {
    public static void main(String[] args) {
        // println("Hello World"
        System.out.println("Hello World");

        // reading values from console input:
        System.out.print("Enter String: ");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        System.out.print("Enter Integer: ");
        int a = in.nextInt();
        System.out.println("You entered integer " + a);

        System.out.print("Enter Float: ");
        float b = in.nextFloat();
        System.out.println("You entered float " + b);
    }
}
