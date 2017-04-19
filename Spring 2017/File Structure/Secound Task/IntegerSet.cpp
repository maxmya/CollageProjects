//
// Created by Maxmya on 3/20/2017.
//

#include "IntegerSet.h"
#include <iostream>

using namespace std;

IntegerSet::IntegerSet() {
    this->elements = new bool[100];
    for (int i = 0; i < 100; ++i) {
        elements[i] = false;
    }
    arrSize = 100;
}

IntegerSet::IntegerSet(const IntegerSet &ref) {

    elements = ref.elements;
    arrSize = ref.arrSize;
}

IntegerSet::IntegerSet(int arr[], int size) {

    this->elements = new bool[100];
    this->arrSize = 100;
    for (int j = 0; j < arrSize; ++j) {
        elements[j] = false;
    }

    for (int i = 0; i < size; ++i) {
        if (arr[i] <= arrSize) {
            elements[arr[i]] = true;
        } else {
            cerr << "element " << arr[i] << " is out of range";
        }
    }

}

IntegerSet IntegerSet::unionOfSets(IntegerSet &second) {

    bool *elementsOfFirst = this->getElements();
    bool *elementsOfSecond = second.getElements();

    int sizeOfFirst = this->getArrSize();
    int sizeOfSecond = second.getArrSize();


    int minArr = min(sizeOfFirst, sizeOfSecond);
    int maxArr = max(sizeOfFirst, sizeOfSecond);


    bool *result = new bool[maxArr];

    for (int i = 0; i < minArr; ++i) {
        result[i] = false;
        if (elementsOfFirst[i] || elementsOfSecond[i]) {
            result[i] = true;
        }

    }


    if (minArr != maxArr) {
        if (maxArr == sizeOfFirst) {
            for (int i = minArr; i < maxArr; ++i) {
                if (elementsOfFirst[i]) {
                    result[i] = true;
                }
            }
        } else {
            for (int i = minArr; i < maxArr; ++i) {
                if (elementsOfSecond[i]) {
                    result[i] = true;
                }
            }
        }
    }
    IntegerSet un;
    un.setElements(result);
    return un;
}

IntegerSet IntegerSet::intersectionOfSets(IntegerSet &second) {

    bool *elementsOfFirst = this->getElements();
    bool *elementsOfSecond = second.getElements();
    int sizeOfFirst = this->getArrSize();
    int sizeOfSecond = second.getArrSize();
    int minArr = min(sizeOfFirst, sizeOfSecond);
    int maxArr = max(sizeOfFirst, sizeOfSecond);
    bool *result = new bool[maxArr];
    for (int i = 0; i < minArr; ++i) {
        result[i] = false;
        if (elementsOfFirst[i] && elementsOfSecond[i]) {
            result[i] = true;
        }
    }

    IntegerSet un;
    un.setElements(result);
    return un;
}

void IntegerSet::insertElement(int element) {

    if (element <= arrSize) {

        this->elements[element] = true;

    } else {
        cerr << "this element is out of set bounds";
    }

}

void IntegerSet::deleteElement(int element) {
    if (element <= arrSize) {

        this->elements[element] = false;

    } else {
        cerr << "this element is out of set bounds";
    }
}

void IntegerSet::printSet() {

    cout << "{";
    for (int i = 0; i < arrSize; ++i) {

        if (elements[i] != 0) {
            cout << "  ";
            cout << i;
            cout << "  ";

        }
    }
    cout << "}" << endl;
}

bool IntegerSet::isEqualTo(IntegerSet &first, IntegerSet &second) {
    if (first.getArrSize() != second.getArrSize())
        return false;

    bool *elementsOfFirst = first.getElements();
    bool *elementsOfSecond = second.getElements();

    for (int i = 0; i < first.getArrSize(); ++i)
        if (elementsOfFirst[i] != elementsOfSecond[i])return false;


    return true;
}

bool *IntegerSet::getElements() const {
    return elements;
}

void IntegerSet::setElements(bool *elements) {
    this->elements = elements;
}

IntegerSet::~IntegerSet() {

    delete [] this->elements;

}

int IntegerSet::getArrSize() const {
    return arrSize;
}
