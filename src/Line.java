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


    // Returns true if the lines intersect, false otherwise
//    public boolean isIntersecting(Line other) {
//        if (gradient == other.getGradient()) //אם הישרים מקבילים או חופפים
//            return false;
//       return (orienation(this.p1 , this.p2, other.p1) < 0) && (orienation(this.p1 , this.p2, other.p2) >0);
//        return
//    }

    //Returns a value that says where  the line is turning away from the corrent line we look at it.
    //if >0 the line is going right. <0 turning left. =0 on the same line.
//    public double orienation(Point p1 , Point p2 , Point p3){
//        double ans = (p2.getY()-p3.getY())*(p1.getX()-p2.getX()) - ((p2.getX()-p3.getX()) * (p1.getY() - p2.getY()) );
//        return ans;
//    }

    //Returns the exact intersect Point
    //and null if the Point is outside the range
    Point xPoint(Line l1 , Line l2){
        double xxP , yxP;
        //calulate x position
        xxP = ((l1.stat)-(l2.stat))/((l2.gradient)- (l1.gradient));        // mx + n = px + r
        //calculate y position
        yxP = (l1.gradient*xxP) + (l1.stat);            // y = mx+n

        // נוודא שהנקודה נמצאת בתוך שני הקטעים (ולא רק על המשך הקווים)
        if (!isBetween(xxP, l1.p1.getX(), l1.p2.getX()) || !isBetween(yxP, l1.p1.getY(), l1.p2.getY()) ||
                !isBetween(xxP, l2.p1.getX(), l2.p2.getX()) || !isBetween(yxP, l2.p1.getY(), l2.p2.getY())){
            return null;}
        Point xP = new Point(xxP,yxP);                  //returns intersection point
        return xP;
    }

    public boolean isIntersecting(Line other) {
        return xPoint(this , other) != null;
    }

    // Returns the intersection point if the lines intersect,
    // and null otherwise.
    public Point intersectionWith(Line other) {
        if (gradient == other.gradient){
            return null;
        }
//        double x1 = this.p1.getX(), y1 = this.p1.getY();
//        double x2 = this.p2.getX(), y2 = this.p2.getY();
//        double x3 = other.p1.getX(), y3 = other.p1.getY();
//        double x4 = other.p2.getX(), y4 = other.p2.getY();
//
//        double denom = (x1 - x2)*(y3 - y4) - (y1 - y2)*(x3 - x4);
//
//        // אם denom == 0 → הקווים מקבילים או חופפים
//        if (denom == 0) return null;
//
//
//        double px = ((x1*y2 - y1*x2)*(x3 - x4) - (x1 - x2)*(x3*y4 - y3*x4)) / denom;
//        double py = ((x1*y2 - y1*x2)*(y3 - y4) - (y1 - y2)*(x3*y4 - y3*x4)) / denom;
//
//        Point intersection = new Point(px, py);
//
//        // נוודא שהנקודה נמצאת בתוך שני הקטעים (ולא רק על המשך הקווים)
//        if (!isBetween(px, x1, x2) || !isBetween(py, y1, y2) ||
//                !isBetween(px, x3, x4) || !isBetween(py, y3, y4))
//            return null;

        return xPoint(this,other);
    }

    boolean isBetween(double val, double start, double end) {
        return val >= Math.min(start, end) && val <= Math.max(start, end);
    }



    // equals -- return true is the lines are equal, false otherwise
    public boolean equals(Line other) {
        return other.gradient==gradient && other.length==length && other.middle()==middle();
    }

}
