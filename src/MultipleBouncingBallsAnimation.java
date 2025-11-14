import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultipleBouncingBallsAnimation {
    public static void main(String[] args){
        int b1 = Integer.parseInt(args[0]);
        int b2 = Integer.parseInt(args[1]);
        int b3 = Integer.parseInt(args[2]);
        int b4 = Integer.parseInt(args[3]);
        drawAnimation(b1, b2 ,b3 ,b4);
    }


    static private void drawAnimation(int x, int y, int z, int w) {
        GUI gui = new GUI("title",400,400 );
        Sleeper sleeper = new Sleeper();
        List<Ball> balls = new ArrayList<>();
        Random r = new Random();

        //create random sized balls with random velocitys
        balls.add(randomball(x));
        balls.add(randomball(y));
        balls.add(randomball(z));
        balls.add(randomball(w));
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            for (Ball b : balls) {
                b.moveOneStep();
                b.drawOn(d);
            }
            gui.show(d);
            sleeper.sleepFor(10);  // wait for 10 milliseconds.
        }


    }
    public static Ball randomball(int x) {
        if (x > 50) {
            Random r = new Random();
            return new Ball(r.nextInt(x, 400 - x), r.nextInt(x, 400 - x), x, Color.RED, new Velocity(r.nextInt(1, 4), r.nextInt(1, 4)));
        } else {
            Random r = new Random();
            return new Ball(r.nextInt(x, 400 - x), r.nextInt(x, 400 - x), x, Color.RED, new Velocity(r.nextInt(5, 10), r.nextInt(5, 10)));
        }
    }
}
