package recursion;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.util.Random;

public class Recursion extends GraphicsProgram {

    private Random rand = new Random();
    private int count = 0;

    public void drawRect(int count) {
        if (count <= 0)   // base case
            return;

        System.out.println("drawRectangle is called");
        GRect rect = new GRect(40, 40);
        rect.setFillColor(Color.red);
        rect.setFilled(true);
        add(rect, rand.nextInt(600), rand.nextInt(400));

        drawRect(count - 1);   // recursive case
    }

    public void run() {
        drawRect(5);
    }
}
