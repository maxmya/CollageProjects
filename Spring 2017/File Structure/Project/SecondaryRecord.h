#ifndef SecondaryRecord_H
#define SecondaryRecord_H

#include <string>

using namespace std;

class SecondaryRecord {


public:

    SecondaryRecord(string = "", string = "");

    // accessor functions for accountNumber
    void setLastName(string);

    string getLastName() const;


    void setAccountNumber(string);

    string getAccountNumber() const;

private:
    char lastName[15];
    char AccountNumber[1000];
    //string AccountNumber;


}; // end class IndexRecord

#endif
