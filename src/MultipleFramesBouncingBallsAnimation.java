import biuoop.DrawSurface;
import biuoop.GUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultipleFramesBouncingBallsAnimation {
    public static void main(String[] args) {
        int b1 = Integer.parseInt(args[0]);
        int b2 = Integer.parseInt(args[1]);
        int b3 = Integer.parseInt(args[2]);
        int b4 = Integer.parseInt(args[3]);
        drawAnimation(b1 ,b2 ,b3 ,b4);
    }
    public static void drawAnimation(int x ,int y, int z ,int w){
        GUI gui = new GUI("MultipleFramesBouncingBallsAnimation", 800, 400);
        biuoop.Sleeper sleeper = new biuoop.Sleeper();

        // שתי קבוצות כדורים
        List<Ball> leftBalls = new ArrayList<>();
        List<Ball> rightBalls = new ArrayList<>();

        // יצירת כדורים
        leftBalls.add(randomball(30, 0,400));
        leftBalls.add(randomball(51,0, 400));

        rightBalls.add(randomball(46,400, 800));
        rightBalls.add(randomball(20,400 , 800));

        while (true) {
            DrawSurface d = gui.getDrawSurface();

            // Background
            d.setColor(Color.LIGHT_GRAY);
            d.fillRectangle(0, 0, 400, 400); // left side
            d.setColor(Color.ORANGE);
            d.fillRectangle(400, 0, 400, 400); // right side

            //Move malls on left side
            for (Ball b : leftBalls) {
                b.moveOneStep(0, 0, 400, 400); // borders left side
                b.drawOn(d);
            }

            // Move balls on right side
            for (Ball b : rightBalls) {
                b.moveOneStep(400, 0, 800, 400); // borders right side
                b.drawOn(d);
            }

            gui.show(d);
            sleeper.sleepFor(10);
        }

    }
    public static Ball randomball(int x, int start , int end) {
        if (x > 50) {
            Random r = new Random();
            return new Ball(r.nextInt(start + x, end - x), r.nextInt( x, 400 - x), x, Color.orange, new Velocity(r.nextInt(1, 4), r.nextInt(1, 4)));
        } else {
            Random r = new Random();
            return new Ball(r.nextInt(start + x, end - x), r.nextInt(x, 400 - x), x, Color.RED, new Velocity(r.nextInt(5, 10), r.nextInt(5, 10)));
        }
    }
}

