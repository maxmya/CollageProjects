/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   SecondaryRecord.h
 * Author: A7mad
 *
 * Created on April 25, 2017, 2:44 PM
 */

#ifndef SECONDARYRECORD_H
#define SECONDARYRECORD_H
#include <string>
using namespace std;

class SecondaryRecord {
public:
    SecondaryRecord(string = "", string = "");

    void setLastName(string);
    string getLastName() const;


    void setAccountNumber(string);
    string getAccountNumber() const;

private:
    char lastName[ 15 ];
    char AccountNumber[ 1000 ];
};

#endif /* SECONDARYRECORD_H */

