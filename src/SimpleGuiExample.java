import biuoop.GUI;
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

public class SimpleGuiExample {

    public void drawRandomCircles() {
        Random rand = new Random(); // create a random-number generator
        // Create a window with the title "Random Circles Example"
        // which is 400 pixels wide and 300 pixels high.
        GUI gui = new GUI("Random Circles Example", 400, 300);
        DrawSurface d = gui.getDrawSurface();
        for (int i = 0; i < 10; ++i) {
            int x = rand.nextInt(400) + 1; // get integer in range 1-400
            int y = rand.nextInt(300) + 1; // get integer in range 1-300
            int r = 5*(rand.nextInt(4) + 1); // get integer in 5,10,15,20
            d.setColor(Color.RED);
            d.fillCircle(x,y,r);
        }
        gui.show(d);
    }

    public void drawRandomLines() {
        Random rand = new Random(); // create a random-number generator
        // Create a window with the title "Random Circles Example"
        // which is 400 pixels wide and 300 pixels high.
        GUI gui = new GUI("Random Lines Example", 400, 300);
        DrawSurface d = gui.getDrawSurface();
        DrawSurface s = gui.getDrawSurface();
        ArrayList<Line> lines = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            int x = rand.nextInt(400) + 1; // get integer in range 1-400
            int y = rand.nextInt(300) + 1; // get integer in range 1-300
            int x2 = rand.nextInt(400) + 1; // get integer in range 1-400
            int y2 = rand.nextInt(300) + 1; // get integer in range 1-300
            Line l =new Line(x , y ,x2 ,y2);
            lines.add(l);
            d.setColor(Color.BLACK);
            d.drawLine(x,y,x2,y2);
            d.setColor(Color.RED);
            d.fillCircle(x,y,3);
            d.setColor(Color.MAGENTA);
            d.fillCircle(x2,y2,5);

            /// החלק שמצייר את נקודות החיתוך
            for (Line line: lines){
                Point p =l.intersectionWith(line);
                if (p != null){
                d.setColor(Color.YELLOW);
                d.fillCircle((int)(p.getX()),(int)(p.getY()),3);}
            }
        }

//        for (int i = 0; i < 10; ++i) {
//            int x = rand.nextInt(400) + 1; // get integer in range 1-400
//            int y = rand.nextInt(300) + 1; // get integer in range 1-300
//            int r = 5*(rand.nextInt(4) + 1); // get integer in 5,10,15,20
//            d.setColor(Color.RED);
//            d.fillCircle(x,y,r);
//        }
        gui.show(d);
    }


}