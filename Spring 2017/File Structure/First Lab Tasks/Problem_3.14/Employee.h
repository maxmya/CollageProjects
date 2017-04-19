//
// Created by Maxmya on 3/4/2017.
//

#ifndef FIRST_LAB_TASKS_EMPLOYEE_H
#define FIRST_LAB_TASKS_EMPLOYEE_H

#include <string.h>
#include <iostream>

using namespace std;

class Employee {

public:
    Employee(int,string , string);
    void setSlary(int);
    void setfName(string);
    void setlName(string);
    int getSalary();
    string getfName();
    string getlName();
    void getSalaryPrinted();
    void getYearlySalaryPrinted();
    int getYearlySalary();
    void setRise(int);
    void getFullNamePrinted();

private:
    int salary;
    string fName;
    string lName;

};


#endif //FIRST_LAB_TASKS_EMPLOYEE_H
