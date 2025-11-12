import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import javax.sql.rowset.JdbcRowSet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BouncingBallAnimation {
    public static void main(String[] args){
        System.out.print("Enter Radius's between '15' - '40'");
        Scanner s = new Scanner(System.in);
        drawAnimation(s.nextInt() ,s.nextInt() ,s.nextInt() ,s.nextInt());
    }
    static private void drawAnimation(int x, int y, int z, int w) {
        GUI gui = new GUI("title",400,400);
        Sleeper sleeper = new Sleeper();
        List<Ball> balls = new ArrayList<>();
        Random r = new Random();

        //create random sized balls with random velocitys
        balls.add(new Ball(r.nextInt(0,400), 50, x, Color.RED, new Velocity(2, 2)));
        balls.add(new Ball(r.nextInt(0,400), 100, y, Color.BLUE, new Velocity(r.nextInt(0,10), 1)));
        balls.add(new Ball(r.nextInt(0,400), 100, z, Color.BLACK, new Velocity(r.nextInt(0,10), 1)));
        balls.add(new Ball(r.nextInt(0,400), 100, z, Color.BLACK, new Velocity(r.nextInt(0,10), 1)));
        while (true) {
            for (Ball b : balls) {
                b.moveOneStep();
                DrawSurface d = gui.getDrawSurface();
                b.drawOn(d);
                gui.show(d);
                sleeper.sleepFor(10);  // wait for 10 milliseconds.
            }

        }
    }
}
