package algoanalysis;

public class Gauss {

    public long sum(int n) {
        int ret = 0;
        // for (int i = 1; i <= n; i++)
        // we reformulate as while-loop to make the statements clearer
        int i = 1;
        while (i <= n) {
            ret += i;
            i++;
        }
        return ret;
        // => O(n): linear performance
    }

    public long sumGauss(int n) {
        int ret = n * n;
        ret += n;
        return ret / 2;
        // => O(1): constant performance
    }

    public static void main(String[] args) {
        Gauss gs = new Gauss();
        int n = 4;

        long sum = gs.sum(n);

        long sumGauss = gs.sumGauss(n);
    }
}
