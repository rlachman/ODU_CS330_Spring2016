import java.util.Scanner;

/**
 * Coordinate in 3 dimensional Cartesian space
 */
public class Point {
    public double x, y, z;

    /**
     * Default Constructor
     */
    Point()
    {
        x = 0;
        y = 0;
        z = 0;
    }

    /**
     * Construct a Point from specified
     * x, y, and z values
     */
    Point(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Apply geometric scaling function
     */
    void scale(double scalingFactor)
    {
        x *= scalingFactor;
        y *= scalingFactor;
        z *= scalingFactor;
    }

    /**
     * Print a point
     */
    //void display(std::ostream& outs) const;
    public String toString()
    {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
