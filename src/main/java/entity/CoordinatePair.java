package entity;

import java.util.Objects;

/*
Foundation of the Entire project. This is the Coordinate Pair class store <xAxis> and <yAxis>
into one instance of CoordinatePair.

xAxis: value of x-axis of the pair.
yAxis: value of y-axis of the pair.
 */
public class CoordinatePair {
    private double xAxis;
    private double yAxis;

    public CoordinatePair(double x, double y) {
        this.xAxis = x;
        this.yAxis = y;
    }

    public double getXAxis() {
        return xAxis;
    }

    public double getYAxis() {
        return yAxis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CoordinatePair)) {
            return false;
        }
        CoordinatePair b = (CoordinatePair) o;
        return (this.xAxis == b.getXAxis() && this.yAxis == b.getYAxis());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.xAxis, this.yAxis);
    }


}
