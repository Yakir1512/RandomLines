 public class Point {
     double x;
     double y;
    // constructor
    public Point(double x, double y) {
        this.x=x;
        this.y=y;
    }

     // distance -- return the distance of this point to the other point
     public double distance(Point other){
        if(other == null)
            return -1;
        double y=0 , x=0 , y2=0 , x2=0;
        y= this.y;
        x= this.x;
        y2 = other.y;
        x2 = other.x;
        return Math.sqrt((x-x2)*(x-x2) + (y-y2)*(y-y2));  //a^2 + b^2 = c^2
     }
     // equals -- return true is the points are equal, false otherwise
     public boolean equals(Point other) {
        if (other != null)
            return this.x== other.x &&this.y==other.y;
        return false;
     }

     // Return the x and y values of this point
     public double getX() {return this.x;
     }
     public double getY() {return this.y; }
}
