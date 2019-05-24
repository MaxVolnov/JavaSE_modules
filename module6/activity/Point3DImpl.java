package sef.module6.activity;

import java.util.Objects;

/**
 * @author John Doe
 * <p>
 * This class represents a point in 3D space.  The coordinates are represented by
 * a set of values x, y an z that represents the coordinates along each plane
 */
public class Point3DImpl extends Point2DImpl implements Point3D {

    @SuppressWarnings("unused")
    private double z;

    /**
     * Creates a Point3D object with the default coordinate of 0,0,0
     */
    public Point3DImpl() {

    }

    /**
     * Creates a Point3D object at the specified coordinates
     *
     * @param x coordinate along the x axis
     * @param y coordinate along the y axis
     * @param z coordinate along the z axis
     */
    public Point3DImpl(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point3D#setZ(double)
     */
    public final void setZ(double z) {
        this.z = z;
    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point3D#getZ()
     */
    public final double getZ() {
        return z;
    }

    /* (non-Javadoc)
     * @see sef.module5.activity.Point3D#move(double, double, double)
     */
    public void move(double x2, double y2, double z2) {
        this.x = x2;
        this.y = y2;
        this.z = z2;
    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point3D#translate(double, double, double)
     */
    public void translate(double x2, double y2, double z2) {
        this.x += x2;
        this.y += y2;
        this.z += z2;
    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point3D#equals(double, double, double)
     */
    public boolean equals(double x2, double y2, double z2) {
        return this.x == x2 && this.y == y2 && this.z == z2;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Point3DImpl point3D = (Point3DImpl) o;
        return Double.compare(point3D.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), z);
    }

    /* (non-Javadoc)
     * @see sef.module5.activity.Point3D#getDistance(sef.module5.activity.Point3D)
     */
    public double getDistance(Point3D p) {
        return Math.sqrt(Math.pow(this.x - p.getX(), 2) + Math.pow(this.y - p.getY(), 2) + Math.pow(this.z - p.getZ(), 2));
    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point3D#getDistance(double, double, double)
     */
    public double getDistance(double x2, double y2, double z2) {
        return Math.sqrt(Math.pow(this.x - x2, 2) + Math.pow(this.y - y2, 2) + Math.pow(this.z - z2, 2));

    }


}
