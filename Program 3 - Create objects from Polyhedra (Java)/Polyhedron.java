import java.util.Scanner;

/**
 * Abstract Polyhedron Base Class
 */
public abstract class Polyhedron implements Cloneable{
    /**
     * A string representing the name of this polyhedron
     */
    private   String      type;

    /**
     * Box (rectangular prism) that contains this element
     */
    protected BoundingBox boundingBox;

    /**
     * Default Constructor
     */
    public Polyhedron()
    {
        this.type        = "Polyhedron";
        this.boundingBox = new BoundingBox();
    }

    /**
     * Constructor which allows
     * a name to be set
     *
     * @param t c-string representing the polyhedron name
     */
    public Polyhedron(String t)
    {
        this.type        = t;
        this.boundingBox = new BoundingBox();
    }

    /**
     * Get the polyhedron name
     */
    public String getType()
    {
        return this.type;
    }

    /**
     * set the polyhedron name
     */
    public void setType(String t)
    {
        this.type = t;
    }

    /**
     * Retrieve the bounding box
     */
    public BoundingBox getBoundingBox()
    {
        return this.boundingBox;
    }

    /**
     * Retrieve and reconstruct the polyhedron
     * from an input stream
     */
    public abstract void read(Scanner s);

    /**
     * Apply a geometric scaling operation
     */
    public abstract void scale(double scalingFactor);

    /**
     * Clone a Polyhedron and minimize casting
     */
    public abstract Polyhedron clone();

    /**
     * Print the polyhedron
     */
    public String toString()
    {
        return "[" + type + "] "
            + boundingBox.getUpperRightVertex()
            + "->";
    }

    /**
     * Create and return a new Polyhedron. This
     * is an object that is one of the three subtypes,
     * Sphere, Cylinder, or Composite
     */
    public static Polyhedron createAndRead(Scanner s)
    {
        Polyhedron ply            = null;
        String     polyhedronType = null;

        if (s.hasNext()) {
            polyhedronType = s.next();

            ply = PolyhedronFactory.createPolyhedron(polyhedronType);

            if (ply != null) {
                ply.read(s);
            }
            else {
                s.nextLine();
                s.nextLine();
            }
        }

        return ply;
    }
}
