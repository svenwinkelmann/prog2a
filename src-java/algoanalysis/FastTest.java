package algoanalysis;

import acm.program.ConsoleProgram;
import java.util.HashMap;
import java.util.Map;

public class FastTest extends ConsoleProgram {

    private static final int FACT_N = 20;
    private static final long NUM_ITERATIONS = 100000000;
    private Map<Integer, Long> lookupTable = new HashMap<>();
    private long[] lookupTableArray = new long[FACT_N + 1];

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

    public long stirlingFac(int n) {
        // Approximation
        return Math.round(Math.sqrt(2 * Math.PI * n) * Math.pow(n / Math.E, n));
    }

    public long lookupTableFac(int n) {
        // Dynamic Programming
        if (!this.lookupTable.containsKey(n))
            this.lookupTable.put(n, iterativeFac(n));
        return this.lookupTable.get(n);
    }

    public long lookupTableArrayFac(int n) {
        // Dynamic Programming
        if (this.lookupTableArray[n] == 0)
            this.lookupTableArray[n] = iterativeFac(n);
        return this.lookupTableArray[n];
    }

    public void run() {
        setFont("Arial-bold-32");


        long fac = 0;

        long timeBefore = System.currentTimeMillis();
        for (int i = 0; i < NUM_ITERATIONS; i++)
            fac = iterativeFac(FACT_N);
        long duration = (System.currentTimeMillis() - timeBefore);
        println("Iterative: " + fac + " (" + duration + "ms)");

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < NUM_ITERATIONS; i++)
            fac = recursiveFac(FACT_N);
        duration = (System.currentTimeMillis() - timeBefore);
        println("Recursive: " + fac + " (" + duration + "ms)");

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < NUM_ITERATIONS; i++)
            fac = stirlingFac(FACT_N);
        duration = (System.currentTimeMillis() - timeBefore);
        println("Approximation: " + fac + " (" + duration + "ms)");

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < NUM_ITERATIONS; i++)
            fac = lookupTableFac(FACT_N);
        duration = (System.currentTimeMillis() - timeBefore);
        println("Lookup table with map: " + fac + " (" + duration + "ms)");

        timeBefore = System.currentTimeMillis();
        for (int i = 0; i < NUM_ITERATIONS; i++)
            fac = lookupTableArrayFac(FACT_N);
        duration = (System.currentTimeMillis() - timeBefore);
        println("Lookup table with array: " + fac + " (" + duration + "ms)");
    }
}
