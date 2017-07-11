#include "Polyhedron.h"
#include "Composite.h"

/**
 *
 */
Composite::Composite()
    :Polyhedron("Composite"),
     numPolyhedra(0),
     polyhedra(nullptr)
{
}

Composite::Composite(const Composite& src)///Copy Constructor
    :Polyhedron("Composite"),
     numPolyhedra(0),
     polyhedra(nullptr)
{

    numPolyhedra = src.numPolyhedra;
    polyhedra = new Polyhedron*[numPolyhedra];

    for(int i=0;i< numPolyhedra;i++)
    {
        polyhedra[i] = src.polyhedra[i]->clone();  ///<------------- error once assignment is met
        boundingBox.merge(polyhedra[i]->getBoundingBox());
    }
}

Composite::~Composite()///Destructor
{
    delete polyhedra;
    //std::cout << "Destructor called!" << std::endl;
}




//------------------------HINT------------------------
/**
 *
 */
void Composite::scale(double scalingFactor)
{
    for (int i = 0; i < numPolyhedra; i++) {
        polyhedra[i]->scale(scalingFactor);
    }

    boundingBox.scale(scalingFactor);
}

/**
 *
 */
void Composite::read(std::istream& ins)
{
    ins >> numPolyhedra;///number of elements

    polyhedra = new Polyhedron*[numPolyhedra];
    for(int i=0;i< numPolyhedra; i++)
    {
        //polyhedra[i]->read(ins);///extracts from istream
        ins >> polyhedra[i];///pushes istream into array
        boundingBox.merge(polyhedra[i]->getBoundingBox());
    }

}

/**
 *
 */
void Composite::display(std::ostream& outs) const
{
    Polyhedron::display(outs);
    outs << numPolyhedra << " polyhedra";
    outs << "\n";

    for(int i=0;i< numPolyhedra;i++)
    {
        outs << "  ";
        polyhedra[i]->display(outs);
        outs << "\n";
    }
}
