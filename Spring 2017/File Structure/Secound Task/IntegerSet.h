//
// Created by Maxmya on 3/20/2017.
//

#ifndef SECOUND_TASK_INTEGERSET_H
#define SECOUND_TASK_INTEGERSET_H


class IntegerSet {

public:
    IntegerSet();

    IntegerSet(const IntegerSet&);

    IntegerSet(int [], int);

    IntegerSet unionOfSets(IntegerSet &);

    IntegerSet intersectionOfSets(IntegerSet &);

    ~IntegerSet();

    void insertElement(int);

    void deleteElement(int);

    void printSet();

    bool isEqualTo(IntegerSet &, IntegerSet &);

    bool *getElements() const;

    int getArrSize() const;

    void setElements(bool *elements);

private:
    bool *elements;
    int arrSize;
};


#endif //SECOUND_TASK_INTEGERSET_H
