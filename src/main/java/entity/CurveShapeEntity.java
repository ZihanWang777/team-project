package entity;

// This implement circle and ellipse as TargetEntity.
public class CurveShapeEntity extends TargetEntity{
    private CoordinatePair origin;
    private double xRadius;
    private double yRadius;
    private double degree;

    public CurveShapeEntity(String name, boolean solid, String color,
                            CoordinatePair ori, double xRadius, double yRadius, double degree) {
        super(name, solid, color);
        this.origin = ori;
        if (xRadius > 0) {
            this.xRadius = xRadius;
        }
        else {
            throw new IllegalArgumentException("you have non-positive x-radius value.");
        }
        if (yRadius > 0) {
            this.yRadius = yRadius;
        }
        else {
            throw new IllegalArgumentException("you have non-positive y-radius value.");
        }
        if (0 <= degree && degree < 360) {
            this.degree = degree;
        }
        else {
            throw new IllegalArgumentException("invalid degree, 0<=degree<360");
        }
    }

    public CoordinatePair getOrigin() {
        return origin;
    }

    public double getXRadius() {
        return xRadius;
    }

    public double getYRadius() {
        return yRadius;
    }

    public double getDegree() {
        return degree;
    }
}
