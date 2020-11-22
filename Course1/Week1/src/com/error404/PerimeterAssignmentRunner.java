package com.error404;
import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
//            System.out.println(currDist);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count = 0;
        for(Point pt : s.getPoints()){
            count++;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double perimeter = getPerimeter(s);
        int points = getNumPoints(s);
        return perimeter/points;
    }

    public double getLargestSide(Shape s) {
        Point prevPt = s.getLastPoint();
        double dis = 0.0;
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            dis = Math.max(dis, currDist);
        }
        return dis;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double Xmax = 0.0;
        for(Point pt : s.getPoints()){
            Xmax = Math.max(Xmax, pt.getX());
        }
        return Xmax;
    }

    public double getLargestPerimeterMultipleFiles() {
//        for (Point pt: s.ge)
        // Put code here
        return 0.0;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public double mysteryShape (Shape s) {
        double tmp = 0;
        for (Point p : s.getPoints()) {

            if (p.getX() > 0) {

                if (p.getY() < 0) {
                    tmp = tmp + 1;
                }
            }
        }
        return tmp / getNumPoints(s);
    }

    public void testPerimeter () {
        FileResource fr = new FileResource("data/example1.txt");
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println(mysteryShape(s));
//        System.out.println(getNumPoints(s));
//        System.out.println(getAverageLength(s));
//        System.out.println(getLargestSide(s));
//        System.out.println(getLargestX(s));
//        System.out.println("perimeter = " + length);
    }

    public void testPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
//            System.out.println(getNumPoints(s));
//            System.out.println(getAverageLength(s));
//            System.out.println(getLargestSide(s));
//            System.out.println(getLargestX(s));
            System.out.println(f);
            System.out.println("perimeter = " + length);

        }
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
//        pr.testPerimeterMultipleFiles();
    }
}