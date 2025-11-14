// Velocity specifies the change in position on the `x` and the `y` axes.
public class Velocity {
    double dx;
    double dy;

    // constructor
    public Velocity(double dx, double dy){
        this.dx =dx;
        this.dy =dy;
    }

    //Change the direction of x
    public void invertX() { this.dx = -this.dx; }

    //Change the direction of y
    public void invertY() { this.dy = -this.dy; }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    // Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)
    public Point applyToPoint(Point p) {
        double newX = p.getX() + this.dx;
        double newY = p.getY() + this.dy;
        return new Point(newX, newY);
    }
}