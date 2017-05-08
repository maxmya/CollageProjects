/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   IndexRecord.cpp
 * Author: A7mad
 * 
 * Created on April 25, 2017, 2:38 PM
 */

#include "IndexRecord.h"
#include <string>
#include <cstring>
using namespace std;

IndexRecord::IndexRecord(int account, int off) {
    setAccount(account);
    setByteOffest(off);
}

int IndexRecord::getAccount() const {
    return account;
}

void IndexRecord::setAccount(int accountNumberValue) {
    account = accountNumberValue;
}

int IndexRecord::getByteOffest() const {
    return offest;
}

void IndexRecord::setByteOffest(int Offest) {
    offest = Offest;
}

