//
// Created by Maxmya on 3/4/2017.
//

#include <cstdio>
#include "Employee.h"


// constructor
Employee::Employee(int salary, string fName, string lName) {
    setSlary(salary);
    setfName(fName);
    setlName(lName);
    printf("Employee created successfully\n");
    printf("-------------------\n");
}
// setters
void Employee::setSlary(int salary) {
    if (salary >= 0) {
        this->salary = salary;
    } else {
        printf("%d is a not valid salary\n", salary);

    }
}

void Employee::setfName(string fName) {
    if (fName != "") {
        this->fName = fName;
    } else {
        printf("%s is not a valid name , name is set to <blank>\n", fName.c_str());
        this->fName = "blank";
    }
}


void Employee::setlName(string lName) {
    if (lName != "") {
        this->lName = lName;
    } else {
        printf("%s is not a valid name , name is set to <blank>\n", lName.c_str());
        this->lName = "blank";
    }
}


void Employee::setRise(int amount) {
    if (amount > 0 && amount <= 100) {
        printf("salary is raised successfully by %d\nold salary is %d\n", amount, getSalary());
        setSlary(getSalary() + ((getSalary() / 100) * amount));
        getSalaryPrinted();
        printf("-------------------\n");
    } else {
        printf("%d is not a valid rise\n", amount);
        printf("-------------------\n");

    }
}


// getters
string Employee::getfName() {
    return this->fName;
}

string Employee::getlName() {
    return this->lName;
}

int Employee::getSalary() {
    return this->salary;
}

int Employee::getYearlySalary() {
    return getSalary() * 12;
}




// printers

void Employee::getSalaryPrinted() {
    printf("employee's current salary is %d\n", getSalary());

}

void Employee::getYearlySalaryPrinted() {
    printf("employee's yearly salary is %d\n", getYearlySalary());
    printf("-------------------\n");

}

void Employee::getFullNamePrinted() {
    printf("First Name : %s Last Name : %s\n", getfName().c_str(), getlName().c_str());
    printf("-------------------\n");

}