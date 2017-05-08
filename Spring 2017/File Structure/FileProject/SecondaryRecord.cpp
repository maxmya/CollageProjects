/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   SecondaryRecord.cpp
 * Author: A7mad
 * 
 * Created on April 25, 2017, 2:44 PM
 */

#include <string>
#include <cstring>
#include "SecondaryRecord.h"
using namespace std;

SecondaryRecord::SecondaryRecord(string a, string b) {
    setLastName(a);
    setAccountNumber(b);

}

string SecondaryRecord::getAccountNumber() const {
    return AccountNumber;
}

void SecondaryRecord::setAccountNumber(string accountNumberValue) {
    // default value -1

    const char *lastNameValue = accountNumberValue.data();
    int length = accountNumberValue.size();
    length = (length < 1000 ? length : 1000);
    strncpy(AccountNumber, lastNameValue, length);
    AccountNumber[ length ] = '\0'; // append null character to lastName

}

string SecondaryRecord::getLastName() const {
    return lastName;
}

void SecondaryRecord::setLastName(string lastNameString) {
    // copy at most 15 characters from string to lastName
    const char *lastNameValue = lastNameString.data();
    int length = lastNameString.size();
    length = (length < 15 ? length : 14);
    strncpy(lastName, lastNameValue, length);
    lastName[ length ] = '\0'; // append null character to lastName
} // end function setLastName
