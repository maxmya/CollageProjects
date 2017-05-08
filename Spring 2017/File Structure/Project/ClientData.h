

#ifndef CLIENTDATA_H
#define CLIENTDATA_H
#include <string>

using namespace std;

class ClientData {
public:
    // defaultClientData constructor
    ClientData(int = 0, string = "", string = "", double = 0.0, int = 0);

    // accessor functions foraccountNumber
    void setAccountNumber(int);

    int getAccountNumber() const;
    // accessor functions forlastName
    void setLastName(string);
    string getLastName() const;

    // accessor functions forfirstName
    void setFirstName(string);
    string getFirstName() const;

    // accessor functions forbalance
    void setBalance(double);
    double getBalance() const;

    void setBranchId(int);
    int getBranchId()const;


private:
    int accountNumber;
    char lastName[ 15 ];
    char firstName[ 10 ];
    double balance;
    int branchID;
}; // endclass ClientData



#endif /* CLIENTDATA_H */

