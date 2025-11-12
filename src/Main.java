import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.util.Random;
import java.awt.Color;



public static void main(String[] args) {
//    AbstractArtDrawing example = new AbstractArtDrawing();
//    example.drawRandomLines();
    Point p = new Point(200,200);
    Point p1 = new Point(100,200);
    drawAnimation(p,1,15);

}
static private void drawAnimation(Point start, double dx, double dy) {
    GUI gui = new GUI("title",400,400);
    Sleeper sleeper = new Sleeper();
    List<Ball> balls = new ArrayList<>();
    //Random r =new Random();
    balls.add(new Ball(50, 50, 15, Color.RED, new Velocity(2, 2)));
    balls.add(new Ball(200, 100, 25, Color.BLUE, new Velocity(-3, 1)));
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
