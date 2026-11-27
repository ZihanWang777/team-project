package entity;

import java.util.*;

import static java.lang.Math.abs;

/*
one type of target entity: shape. Contains a unique parameter <edges> that records the coordinate
pairs of all edges
 */
public class StraightShapeEntity extends TargetEntity{
    private ArrayList<CoordinatePair> edges;
    private Style style;

    public StraightShapeEntity(String name, Boolean solid, String color, ArrayList<CoordinatePair> cps) {
        super(name, solid, color);
        if (isShapeLegal(cps)) {
            this.edges = cps;
        }
        else {
            throw new IllegalArgumentException("your StraightShape is invalid.");
        }
    }

    // the helper of the constructor carrying out whether a shape's coordinate pairs legal
    private boolean isShapeLegal(ArrayList<CoordinatePair> cps) {
        //As a straight shape, you can't have same points
        if (new HashSet<>(cps).size() != cps.size()) {
            throw new IllegalArgumentException("two of your points are the same");
        }
        //As a straight shape, you cant have less than 3 edge points.
        if (cps.size() < 3) {
            throw new IllegalArgumentException("you have less than three points");
        }
        //As a straight shape, you can't have 3 neighbor points on the same line.
        //this check 1-2-3, 2-3-4, 3-4-1, 4-1-2 all edges.
        int n = cps.size();
        for (int i = 0; i < n; i++) {
            if (shootALine(cps.get(i), cps.get((i + 1) % n), cps.get((i + 2) % n))) {
                throw new IllegalArgumentException("you have three points on a line");
            }
        }
        return true;
    }

    // helper method of isShapeLegal, return whether the line formed by Coordinate <a> and <b>
    // will reach Coordinate <c>
    private boolean shootALine(CoordinatePair a, CoordinatePair b, CoordinatePair c) {
        double xA = a.getXAxis();
        double yA = a.getYAxis();
        double xB = b.getXAxis();
        double yB = b.getYAxis();
        double xC = c.getXAxis();
        double yC = c.getYAxis();
        // form the line by solving y = ax+b via Coordinate Pair a and b
        if (xA != xB) {
            double slope = (yB - yA) / (xB - xA);
            double yAxisPoint = yB - (slope * xB);
            // put in c's x-axis value to see if the y value of the line match the actual c y-axis value
            return (abs(slope * xC + yAxisPoint - yC) < 0.000000001);
        }
        else {
            return xC == xA;
        }
    }

    public ArrayList<CoordinatePair> getEdges() {
        return edges;
    }
}
