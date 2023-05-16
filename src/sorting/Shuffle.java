package sorting;

import acm.program.ConsoleProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Shuffle extends ConsoleProgram {

    Random rand = new Random();

    int[] arrOfInts = { 5, 55, 2, 7, 45, 3, 1, 8, 23, 12 };

    private int[] randPermDirect(int n) {
        // based on https://de.wikipedia.org/wiki/Zuf%C3%A4llige_Permutation#Direktes_Verfahren
        int ret[] = new int[n];
        Arrays.fill(ret, 0);  // filling array ret with zeros

        List<Integer> N = new ArrayList<Integer>();  // array with numbers 1 to n
        for(int i = 0; i < n; i++)
            N.add(i);

        for (int i = 0; i < n; i++) {
            int z = rand.nextInt(n - i);  // evenly distributed random number
            ret[i] = N.get(z);
            // critical step, as we cannot change the size of an array in Java, we need a list
            N.remove(z);
        }

        return ret;
    }

    private int[] randPermFisherYates(int n) {
        // based on https://de.wikipedia.org/wiki/Zuf%C3%A4llige_Permutation#Fisher-Yates-Verfahren
        int ret[] = new int[n];
        Arrays.setAll(ret, p -> p);  // filling the array with values 1 to 9

        for (int i = n-1; i > 0; i--) {  // loop over all entries, except the first one
            int z = rand.nextInt(i);  // evenly distributed random number
            int tmp = ret[i];  // swap number, as we work only with one array we need to remember the ret[i]
            ret[i] = ret[z];
            ret[z] = tmp;
        }

        return ret;
    }

    public void run() {
        setFont("Arial-bold-32");
        int n = 10;

        println("Direktes Verfahren:");
        int direct[] = randPermDirect(n);
        for(int i = 0; i < n; i++)
            print(direct[i] + " ");

        println("\n\nFisher-Yates:");
        int fisherYates[] = randPermFisherYates(n);
        for(int i = 0; i < n; i++)
            print(fisherYates[i] + " ");

        println("\n\nSorted:");
        Arrays.sort(fisherYates);
        for(int i = 0; i < n; i++)
            print(fisherYates[i] + " ");

    }
}
