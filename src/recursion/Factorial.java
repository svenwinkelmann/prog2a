package recursion;

import acm.program.ConsoleProgram;

public class Factorial extends ConsoleProgram {

    public long iterativeFac(int n) {
        long product = 1;
        for (long k = 1; k <= n; k++)
            product *= k;
        return  product;
    }

    public long recursiveFac(int n) {
        if (n == 0)   // base case
            return 1;

        return n * recursiveFac(n - 1);   // recursive case
    }

    public int sum(int n)
    {
        if (n == 0)
            return 0;
        return n + sum(n-1);
    }


    public void run() {
        int factN = 5;

        setFont("Arial-bold-32");
        println("Iterative output: " + iterativeFac(factN));
        println("Recursive output: " + recursiveFac(factN));
    }
}
