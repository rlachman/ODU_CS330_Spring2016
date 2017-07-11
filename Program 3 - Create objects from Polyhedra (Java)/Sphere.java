import java.util.Scanner;

/**
 * Sphere
 */
public class Sphere extends Polyhedron {
    private double radius;

    /**
     * Default Constructor
     */
    public Sphere()
    {
        super("Sphere");
        this.radius = 0;
    }

    /**
     * Construct a sphere from a provided radius
     */
    public Sphere(double r)
    {
        super("Sphere");
        this.radius = r;

        double d = this.getDiameter();
        this.boundingBox.setUpperRightVertex(d, d, d);
    }

    /**
     * Retrieve the radius
     */
    public double getRadius()
    {
        return this.radius;
    }

    /**
     * Update the radius
     */
    public void setRadius(double r)
    {
        this.radius = r;

        double d = getDiameter();
        boundingBox.setUpperRightVertex(d, d, d);
    }

    /**
     * Compute and return the diameter
     */
    public double getDiameter()
    {
        return 2 * this.radius;
    }

    public void read(Scanner scanner)
    {
        this.radius = scanner.nextDouble();

        double d = this.getDiameter();
        boundingBox.setUpperRightVertex(d, d, d);
    }

    public void scale(double scalingFactor)
    {
        this.radius *= scalingFactor;
        this.boundingBox.scale(scalingFactor);
    }

    public Polyhedron clone()
    {
        return new Sphere(this.radius);
    }

    public String toString()
    {
        return super.toString()
             + "Radius: " + this.radius
             + " "
             + "Diameter: " + this.getDiameter();
    }
}
