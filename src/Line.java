import java.util.List;

public class Line {
     Point p1;
     Point p2;
     private double gradient;
     private double stat;
     private double length;
    //Pass@Pluga25

    // constructors
    public Line(Point start, Point end) {
        p1 = start;
        p2 = end;
        gradient();
        stat();
        length();
    }
    public Line(double x1, double y1, double x2, double y2) {
        p1 = new Point(x1,y1);
        p2 = new Point(x2,y2);
        gradient();
        stat();
        length();
    }

    // Set the length of the line
    public void length() {
        length = p1.distance(p2);
    }
     //Returns the length of the line
    double getLength(){
        return this.length;
    }

    // Returns the middle point of the line
    public Point middle() {

        Point mpoint = new Point(((p1.getX()) +(p2.getX()))/2 , ((p1.getY()) +(p2.getY()))/2);
        return mpoint;
    }

    // If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.
    public Point closestIntersectionToStartOfLine(Rectangle rect){
        // all intersections with the block
        List<Point> intersections = rect.intersectionPoints(this);

        //return null if there is no such points
        if (intersections.isEmpty())
        return null;

        //
        Point start = rect.getUpperLeft();
        Point retPoint = null;
        //set the first value  of this double to the minimum
        double minDis = Double.MIN_VALUE;
        //check which intersection point is closest
        for(Point p : intersections){
            double dist= start.distance(p);
            if (dist<minDis){
                minDis = dist;
                retPoint = p;
            }
        }
        return retPoint;
    }

    // Returns the start point of the line
    public Point start() {return p1;}

    // Returns the end point of the line
    public Point end() {return p2; }

    //set the Gradient betwin the points
    void gradient() {
        this.gradient = ((p1.getY())- (p2.getY()))/((p1.getX())- (p2.getX()));
    }

    //Returns the gradient
    public double getGradient(){return gradient;}

    //set the static num of the equesion
    void stat(){
        this.stat = (p1.getY())-(this.gradient*p1.getX());
    }



    //Returns the exact intersect Point
    //and null if the Point is outside the range
    public static Point xPoint(Line l1 , Line l2){
        double xxP , yxP;
        //calulate x position
        xxP = ((l1.stat)-(l2.stat))/((l2.gradient)- (l1.gradient));        // mx + n = px + r
        //calculate y position
        yxP = (l1.gradient*xxP) + (l1.stat);            // y = mx+n

        // נוודא שהנקודה נמצאת בתוך שני הקטעים (ולא רק על המשך הקווים)
        if (!isBetween(xxP, l1.p1.getX(), l1.p2.getX()) || !isBetween(yxP, l1.p1.getY(), l1.p2.getY()) ||
                !isBetween(xxP, l2.p1.getX(), l2.p2.getX()) || !isBetween(yxP, l2.p1.getY(), l2.p2.getY())){
            return null;}
        Point xP = new Point(xxP,yxP);                  //returns intersection point ,else null
        return xP;
    }

    //check if the returned point is null
    public boolean isIntersecting(Line other) {
        return xPoint(this , other) != null;
    }

    // Returns the intersection point if the lines intersect,
    // and null otherwise.
    public Point intersectionWith(Line other) {
        if (gradient == other.gradient){
            return null;
        }

        return xPoint(this,other);
    }

    static boolean isBetween(double val, double start, double end) {
        return val >= Math.min(start, end) && val <= Math.max(start, end);
    }



    // equals -- return true is the lines are equal, false otherwise
    public boolean equals(Line other) {
        return other.gradient==gradient && other.length==length && other.middle()==middle();
    }

}
