/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   IndexRecord.h
 * Author: A7mad
 *
 * Created on April 25, 2017, 2:38 PM
 */

#ifndef INDEXRECORD_H
#define INDEXRECORD_H

class IndexRecord {
public:
    IndexRecord(int = 0, int = 0);
    void setAccount(int);
    int getAccount() const;
    void setByteOffest(int);
    int getByteOffest() const;
private:
    int account;
    int offest;
};

#endif /* INDEXRECORD_H */

