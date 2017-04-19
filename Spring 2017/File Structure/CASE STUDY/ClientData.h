/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ClientData.h
 * Author: A7mad
 *
 * Created on April 15, 2017, 6:58 PM
 */

#ifndef CLIENTDATA_H
#define CLIENTDATA_H

#include <string>

class ClientData {
public:
    // default ClientData constructor
    ClientData(int = 0 , std::string = "", std::string = "", double = 0.0,int=0);

    // accessor functions for accountNumber
    void setAccountNumber(int);
    int getAccountNumber() const;

    // accessor functions for lastName
    void setLastName(std::string);
    std::string getLastName() const;

    // accessor functions for firstName
    void setFirstName(std::string);
    std::string getFirstName() const;

    // accessor functions for balance
    void setBalance(double);
    double getBalance() const;

    //accessor functions for branchID
    void setBranchID(int);
    int getBranchID() const ;


private:
    int accountNumber;
    int branchID ;
    char lastName[15];
    char firstName[10];
    double balance;

};

#endif /* CLIENTDATA_H */

