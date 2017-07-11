/**
 * Rectangular prism representing the boundaries
 * x, y, and z of a polyhedron
 */
public class BoundingBox {
    /**
     * Lower boundary. In this exercise, it is
     * fixed at (0,0,0)
     */
    private Point lowerLeftVertex;

    /**
     * Upper boundary
     */
    private Point upperRightVertex;

    /**
     * Default Constructor
     */
    public BoundingBox()
    {
        lowerLeftVertex  = new Point(0, 0, 0);
        upperRightVertex = new Point(0, 0, 0);
    }

    /**
     * Construct a bounding box from lower and upper
     * points that define it
     */
    public BoundingBox(Point lowerLeft, Point upperRight)
    {
        lowerLeftVertex  = lowerLeft;
        upperRightVertex = upperRight;
    }

    /**
     * Retrieve the upper boundary
     */
    public Point getUpperRightVertex()
    {
        return upperRightVertex;
    }

    /**
     * Set the upper boundary using a Point
     */
    public void setUpperRightVertex(Point u)
    {
        upperRightVertex = u;
    }

    /**
     * Set the upper boundary using the x, y, and z
     * components
     */
    public void setUpperRightVertex(double x, double y, double z)
    {
        upperRightVertex.x = x;
        upperRightVertex.y = y;
        upperRightVertex.z = z;
    }

    /**
     * Merge two bounding boxes, taking the
     * largest values for each of x, y, and z
     */
    public void merge(BoundingBox other)
    {
        upperRightVertex.x = Math.max(this.upperRightVertex.x,
                                      other.upperRightVertex.x);

        upperRightVertex.y = Math.max(this.upperRightVertex.y,
                                      other.upperRightVertex.y);

        upperRightVertex.z = Math.max(this.upperRightVertex.z,
                                      other.upperRightVertex.z);
    }

    /**
     * Apply a scaling factor
     */
    public void scale(double s)
    {
        upperRightVertex.scale(s);
    }
}
