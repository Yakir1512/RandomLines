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

     public void setVelocity(double dx, double dy){this.velocity.setDx(dx); this.velocity.setDy(dy);}

     public Velocity getVelocity(){return velocity;}

     // draw the ball on the given DrawSurface
     public void drawOn(DrawSurface surface){
         surface.setColor(color);
         surface.fillCircle((int)center.getX(),(int)center.getY(),r);
     }

     public void moveOneStep() {
         if(this.center.getX() >= 400-this.getSize() ||
                 this.center.getX() <= 0+this.getSize()) {this.velocity.invertX(); }

         if(this.center.getY() >= 400-this.getSize() ||
                 this.center.getY() <= 0+this.getSize()) {this.velocity.invertY(); }

         this.center = this.getVelocity().applyToPoint(this.center);
     }

     public void moveOneStep(int minX, int minY, int maxX, int maxY) {
         this.center.x += velocity.dx;
         this.center.y += velocity.dy;

         // Walls
         if (this.center.x - r < minX || this.center.x + r > maxX) velocity.dx = -velocity.dx;
         if (this.center.y - r < minY || this.center.y + r > maxY) velocity.dy = -velocity.dy;
     }

 }
