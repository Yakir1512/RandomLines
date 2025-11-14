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
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int dx = Integer.parseInt(args[2]);
        int dy = Integer.parseInt(args[3]);
        drawAnimation(x, y, dx, dy);
    }

    static void drawAnimation(int x, int y, int dx, int dy) {
        GUI gui = new GUI("title", 400, 400);
        Sleeper sleeper = new Sleeper();
        Random r = new Random();

        //create random sized balls with random velocitys
        Ball b = new Ball(r.nextInt(0, 400), r.nextInt(0,400), 30, Color.RED, new Velocity(dx, dy));
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            b.moveOneStep();
            b.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(10);  // wait for 10 milliseconds.
        }
    }
}
