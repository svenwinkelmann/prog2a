package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Shuffle {

    Random rand = new Random();

    private int[] randPermDirect(int n) {
        // based on https://de.wikipedia.org/wiki/Zuf%C3%A4llige_Permutation#Direktes_Verfahren
        int ret[] = new int[n];
        Arrays.fill(ret, 0);

        List<Integer> N = new ArrayList<Integer>();
        for(int i = 0; i < n; i++)
            N.add(i);

        for (int i = 0; i < n; i++) {
            int z = rand.nextInt(n - i);
            ret[i] = N.get(z);
            // critical step, as we cannot change the size of an array in Java, we need a list
            N.remove(z);
        }

        return ret;
    }

    private int[] randPermFisherYates(int n) {
        // based on https://de.wikipedia.org/wiki/Zuf%C3%A4llige_Permutation#Fisher-Yates-Verfahren
        int ret[] = new int[n];
        Arrays.setAll(ret, p -> p);

        for (int i = n-1; i > 0; i--) {
            int z = rand.nextInt(i);
            int tmp = ret[i];
            ret[i] = ret[z];
            ret[z] = tmp;
        }

        return ret;
    }

    public static void main(String[] args) {
        Shuffle thisClass = new Shuffle();
        int n = 10;

        System.out.println("Direktes Verfahren:");
        int direct[] = thisClass.randPermDirect(n);
        for(int i = 0; i < n; i++)
            System.out.print(direct[i] + " ");

        System.out.println("\n\nFisher-Yates:");
        int fisherYates[] = thisClass.randPermFisherYates(n);
        for(int i = 0; i < n; i++)
            System.out.print(fisherYates[i] + " ");

        System.out.println("\n\nSorted:");
        Arrays.sort(fisherYates);
        for(int i = 0; i < n; i++)
            System.out.print(fisherYates[i] + " ");

    }
}
