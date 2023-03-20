package introduction;

public class Euclidean {
    public int ggt(int a, int b)
    {
        if (a == 0)
            return b;
        while (b != 0)
        {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }

    public static void main(String[] args) {
        Euclidean euclidean = new Euclidean();
        int a = 10;
        int b = 15;
        System.out.println("ggt is: " + euclidean.ggt(a, b));
    }
}
