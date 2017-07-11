import java.util.Scanner;

class Cylinder extends Polyhedron {
    private double height;
    private double radius;

    /**
     * Default Constructor
     */
    Cylinder()
    {
        super("Cylinder");

        this.radius = 0;
        this.height = 0;
    }

    /**
     * Construct a cylinder with
     * specified height and radius
     */
    Cylinder(double r, double h)
    {
        super("Cylinder");

        this.radius = r;
        this.height = h;

        double d = this.getDiameter();
        this.boundingBox.setUpperRightVertex(d, d, height);
    }

    /**
     * Retrieve the radius
     */
    double getRadius()
    {
        return this.radius;
    }

    /**
     * Update the radius
     */
    void setRadius(double r)
    {
        this.radius = r;

        double d = getDiameter();
        this.boundingBox.setUpperRightVertex(d, d, height);
    }

    /**
     * Compute and return the diameter
     */
    double getDiameter()
    {
        return this.radius * 2;
    }

    public Polyhedron clone()
    {
        return new Cylinder(this.radius, this.height);
    }

    public void read(Scanner scanner)
    {
        this.height = scanner.nextDouble();
        this.radius = scanner.nextDouble();

        double d = this.getDiameter();
        this.boundingBox.setUpperRightVertex(d, d, height);
    }

    public void scale(double scalingFactor)
    {
        this.radius *= scalingFactor;
        this.height *= scalingFactor;

        this.boundingBox.scale(scalingFactor);
    }

    public String toString()
    {
        return super.toString()
             + "Radius: " + this.radius + " "
             + "Height: " + this.height;
    }
}
