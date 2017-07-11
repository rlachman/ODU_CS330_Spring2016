#ifndef CYLINDER_H_INCLUDED
#define CYLINDER_H_INCLUDED

#include "Polyhedron.h"

class Cylinder : public Polyhedron {
    private:
        double height;
        double radius;

    public:
        /**
         * Default Constructor
         */
        Cylinder();

        /**
         * Construct a cylinder with
         * specified height and radius
         */
        Cylinder(double r, double h);

        /**
         * Destructor
         */
        ~Cylinder();

         /**
         * Compute and return the diameter
         */
        double getDiameter() const;
        virtual Polyhedron* clone() const;
        virtual void read(std::istream& ins);
        virtual void display(std::ostream& outs) const;
        virtual void scale(double scalingFactor);


};

inline
double Cylinder::getDiameter() const
{
    return (2 * radius);
}

inline
Polyhedron* Cylinder::clone() const
{
    return new Cylinder(*this);
}

#endif
