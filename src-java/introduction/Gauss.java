package introduction;

public class Gauss {

    public long sum(int n) {
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            ret += i;
        }
        return ret;
    }

    public long sumGauss(int n) {
        return (n * n + n) / 2;
    }

    public static void main(String[] args) {
        Gauss gs = new Gauss();
        int n = 5;

        long timeBefore = System.nanoTime();
        long sum = gs.sum(n);
        long duration = (System.nanoTime() - timeBefore)/1000;
        System.out.println("Sum without Gauß: " + sum + " (" + duration + "µs)");

        timeBefore = System.nanoTime();
        long sumGauss = gs.sumGauss(n);
        duration = (System.nanoTime() - timeBefore)/1000;
        System.out.println("Sum with Gauß: " + sumGauss + " (" + duration + "µs)");
    }
}
