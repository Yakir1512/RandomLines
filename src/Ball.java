 import biuoop.DrawSurface;
 import biuoop.GUI;

 import java.awt.*;
 public class Ball {
/// parameters
     private Point center;
     private int r;
     private Color color;
     private Velocity velocity;

     /// constractor
     public Ball(Point center, int r, Color color) {
         this.center = new Point(center.getX(), center.getY());
         this.r = r;
         this.color = color;
         velocity = new Velocity(0,0);
     }
     /// constractor
     public Ball(int x, int y, int r ,Color color) {
         center = new Point(x,y);
         this.r = r;
         this.color = color;
         velocity = new Velocity(0,0);
     }

     public Ball(int x, int y, int r ,Color color, Velocity velocity) {
         center = new Point(x,y);
         this.r = r;
         this.color = color;
         this.velocity = velocity;
     }

     // accessors
     public double getX() {return center.x;}

     public double getY() {return center.y;}

     public int getSize() {return r;}

     public Color getColor() {return color;}

     public void setVelocity(Velocity v){this.velocity = v;}

     public void setVelocity(double dx, double dy){this.velocity.dx=dx; this.velocity.dy = dy;}

     public Velocity getVelocity(){return velocity;}

     // draw the ball on the given DrawSurface
     public void drawOn(DrawSurface surface){
         surface.setColor(color);
         surface.fillCircle((int)center.getX(),(int)center.getY(),r);
     }

     public void moveOneStep() {
         if(this.center.getX() >= 400-this.getSize() ||
                 this.center.getX() <= 0+this.getSize()) {this.velocity.setDx(this.velocity.getDx() * (-1)); }

         if(this.center.getY() >= 400-this.getSize() ||
                 this.center.getY() <= 0+this.getSize()) {this.velocity.setDy(this.velocity.getDy() * (-1)); }

         this.center = this.getVelocity().applyToPoint(this.center);
     }

 }
