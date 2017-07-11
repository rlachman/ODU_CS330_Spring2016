import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class CreatePolyhedra {
    /**
     * Main function
     *
     * @param argv[1] polyhedron input file
     * @param argv[2] scaling factor
     */
    public static void main(String[] argv)
    {
        int argc = argv.length;

        // Validate number of command line arguments
        if (argc < 2) {
            System.err.println("Usage: java -jar CreatePolyhedra.jar inputFile scalingFactor");
            System.exit(1);
        }

        // Validate Scaling Factor
        int scalingFactor = 1;

        try {
            scalingFactor = Integer.parseInt(argv[1]);
        }
        catch (Exception e) {
            System.err.println("Scaling Factor must be >= 1");
            System.exit(1);
        }

        if (scalingFactor < 1) {
            System.err.println("Scaling Factor must be >= 1");
            System.exit(1);
        }

        Scanner polyIn = null;

        try {
            polyIn = new Scanner(new FileReader(argv[0]));
        }
        catch (Exception e) {
            System.err.println("Could not open " + argv[0]);
            System.exit(2);
        }

        ArrayList<Polyhedron> polyhedra = new ArrayList<Polyhedron>();
        readPolyhedra(polyIn, polyhedra);

        System.out.println("Original Polyhedra");
        printDivider('-', 60);
        printPolyhedra(polyhedra);

        ArrayList<Polyhedron> scaledCopies = new ArrayList<Polyhedron>();
        duplicateAndScale(polyhedra, scaledCopies, scalingFactor);

        System.out.println();
        System.out.println();

        System.out.println("Scaled Polyhedra (Clones)");
        printDivider('-', 60);
        printPolyhedra(scaledCopies);
    }

    /**
     * Construct a list of polyhedra from
     * an input stream
     */
    static void readPolyhedra(Scanner inf, ArrayList<Polyhedron> polyhedra)
    {
        Polyhedron p =  Polyhedron.createAndRead(inf);

        while (p != null) {
            polyhedra.add(p);

            p = Polyhedron.createAndRead(inf);
        }
    }

    /**
     * Print a collection of polyhedra
     */
    static void printPolyhedra(ArrayList<Polyhedron> polyhedra)
    {
        for (Polyhedron p : polyhedra) {
            System.out.println(p);
        }
    }

    /**
     * Copy each polyhedron and apply
     * the scaling factor to each copy
     *
     * @param polyhedra orignal polyhedron collection
     * @param scaledCopies collection in whcih to store the scled copies
     * @param s scaling factor
     */
    static void duplicateAndScale(ArrayList<Polyhedron> polyhedra,
                                  ArrayList<Polyhedron> scaledCopies,
                                  double s)
    {
        for (Polyhedron original : polyhedra) {
            Polyhedron copy = original.clone();
            copy.scale(s);

            scaledCopies.add(copy);
        }
    }

    /**
     * Generate a divider
     */
    static void printDivider(char symbol, int length)
    {
        StringBuilder bld = new StringBuilder();

        for (int i = 0; i < length; i++) {
            bld.append(symbol);
        }

        System.out.println(bld.toString());
    }
}
