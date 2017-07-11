//CS 330
//Ryan Lachman
//Assignment 1

#include <utility>
#include <iostream>
#include "Schedule.h"

//using namespace std::rel_ops;
using namespace std;
/**
 *
 */

// Default Constructor
Schedule::Schedule()
{
    head = nullptr;
    tail = nullptr;
    totalCredits = 0;
}

// Copy Constructor
Schedule::Schedule(const Schedule& src):head(nullptr),tail(nullptr)
{
    Node* it = src.head;
    totalCredits = 0;

    while(it != nullptr)
    {
        this->add(it->data);
        it = it->next;
    }

    totalCredits = src.totalCredits;
}


// Destructor
Schedule::~Schedule()
{
    Node* it = this->head;

    while(it!= nullptr)
    {
        Node* prev = it;
        it = it->next;
        delete prev;

    }

    it = nullptr;

    this->head = nullptr;
    this->tail = nullptr;
}

// Add course method implemented.
bool Schedule::add(Course course)
{
    // Check if the linked list empty. If it is then add the course
    if( head == nullptr && tail == nullptr)
    {
        Node* newnode = new Node(course);
        this->head = newnode;
        this->tail = newnode;
        totalCredits = totalCredits + course.getCredits();

        // Set newnode to NULL to prevent memory leak;
        newnode = nullptr;
        return true;
    }

    else{
        Node* temp;
        temp = this->head;

        while(temp != nullptr)
        {
            // Check if the course number matches with that in the linked list. If yes, do not add the course
            if(temp->data.getNumber() == course.getNumber())
            {
                temp = nullptr;
                return false;
            }
            temp = temp->next;
        }
        temp = nullptr;
        int check;
        check = course.getCredits()+totalCredits;
        // Check if the added course does not exceed the total Credit Requirements
        if(check > 15 )
        {
            return false;
        }
        // Add the new course in case there is no conflict.
        else
        {
            temp = new Node(course);
            this->tail->next = temp;
            this->tail = this->tail->next;

            // Prevent any memory leaks
            temp = nullptr;
            totalCredits = totalCredits + course.getCredits();

            return true;
        }
    }
    return false;


}

// Display method implemented.
void Schedule::display(std::ostream& outs) const
{

    Node* temp;
    temp = head;
    // Display all the courses in the linked list.
    while(temp != nullptr)
    {
        outs << "  - " << temp->data << endl;
        temp = temp->next;
    }

    outs << " " << " (" << totalCredits << " Total Credits)" << endl;

}

Schedule& Schedule::operator = (const Schedule& rhs)
{
    if (this != &rhs)
    {

        // Deallocate the Linked List
        Node* it = this->head;

        while (it != nullptr)
        {
            Node* prev = it;
            it = it->next;
            delete prev;
        }

        it = nullptr;

        this->head = nullptr;
        this->tail = nullptr;
        // End Linked List Deallocation

        this->totalCredits = 0;

        // Reuse it
        it = rhs.head;

        while (it != nullptr)
        {
            this->add(it->data);
            it = it->next;
        }
    }

    return *this;
}





