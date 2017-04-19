//
// Created by Maxmya on 3/4/2017.
//

#include "Employee.h"

int main() {


    Employee firstEmployee(4000, "ali", "ahmed");
    firstEmployee.getSalaryPrinted();
    firstEmployee.getYearlySalaryPrinted();
    firstEmployee.setRise(10);
    firstEmployee.getYearlySalaryPrinted();
    firstEmployee.getFullNamePrinted();



    Employee secondEmployee(200, "atef", "zaki");
    secondEmployee.getYearlySalaryPrinted();
    secondEmployee.setRise(10);
    secondEmployee.getYearlySalaryPrinted();
    return 0;
};