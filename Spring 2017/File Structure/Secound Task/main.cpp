#include <iostream>
#include "IntegerSet.h"

int main() {

    IntegerSet a;
    a.insertElement(5);
    a.insertElement(7);

    a.printSet();

    IntegerSet b;
    b.insertElement(6);
    b.insertElement(5);
    b.insertElement(2);

    b.printSet();

    a.intersectionOfSets(b).printSet();

    a.unionOfSets(b).printSet();


    a.deleteElement(7);
    a.printSet();


    int ar[5];
    ar[0] = 1;
    ar[1] = 9;
    ar[2] = 35;
    ar[3] = 29;
    ar[4] = 300;

    IntegerSet s(ar, 5);
    s.printSet();


    IntegerSet d(s);
    d.printSet();

    return 0;
}