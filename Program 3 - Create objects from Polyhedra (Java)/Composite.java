import java.util.Scanner;

public class Composite extends Polyhedron {
    /**
     * Collection of polyhedra of which
     * this composite polyhedron is composed
     */
    private Polyhedron[] polyhedra;

    /**
     * Default Constructor
     */
    Composite()
    {
        super("Composite");

        polyhedra = null;
    }

    /**
     * Copy Constructor
     */
    Composite(Composite src)
    {
        super("Composite");

        	int numPolyhedra = src.getPolyhedra().length; 
        	this.polyhedra = new Polyhedron[numPolyhedra];
        	for(int i=0;i<numPolyhedra;i++)
        	{
        		this.polyhedra[i] = src.getPolyhedra()[i].clone();
        		this.boundingBox.merge(src.getPolyhedra()[i].boundingBox);
        	}
    }

    /**
     * Read all component polyhedra
     *
     * @pre polyhedra == null
     *   && numPolyhedra == 0
     */
    public void read(Scanner scanner)
    {
        int numPolyhedra = scanner.nextInt();

        polyhedra = new Polyhedron[numPolyhedra];

        for (int i = 0; i < polyhedra.length; i++) {
            polyhedra[i] = Polyhedron.createAndRead(scanner);

            boundingBox.merge(polyhedra[i].getBoundingBox());
        }
    }

    public Polyhedron clone()
    {
        return new Composite(this);
    }

    public void scale(double scalingFactor)
    {
    		for(int i=0; i< polyhedra.length; i++)
    		{
    			polyhedra[i].scale(scalingFactor);
    		}
    		this.boundingBox.scale(scalingFactor);
    }

    /**
     * Scale all polyhedra
     */
    public String toString()
    {
        StringBuilder bld = new StringBuilder();

        bld.append(super.toString());


        // Start your toString code here
        bld.append("\n");
        for(int i=0;i<polyhedra.length;i++)
        {
        	bld.append(polyhedra[i].toString());
        	bld.append("\n");
        }

        //end your toString code here

        return bld.toString();
    }

	public Polyhedron[] getPolyhedra() {
		return polyhedra;
	}
}
