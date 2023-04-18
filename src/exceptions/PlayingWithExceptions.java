package exceptions;

import java.util.Scanner;

public class PlayingWithExceptions {

    public float divide(int numerator, int divisor) throws Exception {
        // In general: testing this precondition does not make much sense for integer division
        //             as the division operator does this job for us.. but we want to learn exceptions :).
        if (divisor == 0) {
            // Precondition not fulfilled
            Exception e = new Exception("Do not divide /0");
            throw e;
        }
        return (float) numerator / divisor;
    }

    public float divide2(int numerator, int divisor) throws ArithmeticException {
        if (divisor == 0) {
            ArithmeticException e = new ArithmeticException("Do not divide /0");
            throw e;
        }
        return (float) numerator / divisor;
    }

    public float divide3(int numerator, int divisor) throws UserTooDumpException {
        if (divisor == 0) {
            UserTooDumpException e = new UserTooDumpException("Do not divide /0");
            throw e;
        }
        return (float) numerator / divisor;
    }

    // we propagate an exception by adding throws in the method header
    public float callDivide3(int numerator, int divisor) throws UserTooDumpException {
        //try {
        return divide3(numerator, divisor);
        /*}
        catch (UserTooDumpException e)
        {
            return 0;
        }*/
    }

    public static void main (String[] args) {

        PlayingWithExceptions ex = new PlayingWithExceptions();
        Scanner in = new Scanner(System.in);

        System.out.print("Enter numerator: ");
        int numerator = in.nextInt();
        System.out.print("Enter denominator: ");
        int divisor = in.nextInt();

        //System.out.print("Result: " + numerator / divisor);
        try {
            //System.out.print("Result: " + ex.divide(numerator, divisor));
            //System.out.print("Result: " + ex.divide2(numerator, divisor));
            //System.out.print("Result: " + ex.divide3(numerator, divisor));
            System.out.print("Result: " + ex.callDivide3(numerator, divisor));
        }
        catch (ArithmeticException e) {
            System.out.print("ArithmeticException " + e.getMessage());
        }
        catch (UserTooDumpException e) {
            System.out.print(e.bePoliteAndExplainToUser());
        }
        catch (Exception e) {
            System.out.print("General exception" + e.getMessage());
        }
        finally {
            // usually you close databases, write to files, ... in a finally statement
            System.out.print("Goodbye!");
        }
    }
}
