import java.lang.StringBuilder;

public class PolyhedronFactory {

    /**
     * Name Polyhedron Pair 2-tuple( name, model )
     */
    private static class PolyhedronPair {
        public String     name;  ///< Name of the Polyhedron to clone
        public Polyhedron model; ///< Model of the Polyhedron to clone

        /**
         * Default Constructor - Used as sentinel
         */
        public PolyhedronPair()
        {
            this.name  = new String();
            this.model = null;
        }

        /**
         * Non-Default Constructor
         *
         * @param name the name of a Polyhedron
         * @param Polyhedron a cloneable Polyhedron
         */
        public PolyhedronPair(String name, Polyhedron p)
        {
            this.name  = name;
            this.model = p;
        }

        /**
         * Print the PolyhedronPair
         */
        public String toString()
        {
            return "  " + this.name + "\n";
        }
    }

    /**
     * Listing of known Polyhedra
     */
    private static PolyhedronPair[] knownPolyhedra = new PolyhedronPair[] {
        new PolyhedronPair("sphere" ,    new Sphere()   ),
        new PolyhedronPair("cylinder" ,  new Cylinder() ),
        new PolyhedronPair("composite" , new Composite())
    };

    /**
     *  Create a Polyhedron
     *
     *  @param name the Polyhedron to be created
     *
     *  @return A Polyhedron with the specified name
     *      or null if no matching Polyhedron is found
     */
    public static Polyhedron createPolyhedron( String name )
    {
        for( PolyhedronPair pair : knownPolyhedra ){
            if( pair.name.equals(name) ){
                return pair.model.clone();
            }
        }

        return null;
    }

    /**
     *  Determine whether a given Polyhedron is known
     *
     *  @param name the Polyhedron for which to query
     */
    public static boolean isKnown( String name )
    {
        for( PolyhedronPair pair : knownPolyhedra ){
            if( pair.name.equals(name) ){
                return true;
            }
        }

        return false;
    }

    /**
     *  Print a list of known Polyhedrons
     */
    public static String listKnown()
    {
        StringBuilder bld = new StringBuilder();

        for( PolyhedronPair pair : knownPolyhedra ){
            bld.append(pair);
        }

        return bld.toString();
    }

    /**
     *  Determine the number of known Polyhedrons
     *
     *  @return the number of known Polyhedrons
     */
    public static int numberKnown()
    {
        return knownPolyhedra.length;
    }
}
