package containers.lists;

import acm.graphics.GRect;

public class HeapStack
{
    public static void foo()
    {
        int j = 5;
        GRect rectFoo = new GRect(j, 50);
    }

    public static void main (String[] args)
    {
        int v0 = 40;
        int v1 = v0 + 10;
        GRect rect1 = new GRect(v0, v1);
        foo();
        int i = 1;
    }
}
