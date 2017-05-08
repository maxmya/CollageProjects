
#include "ClientData.h"
#include <string>
using namespace std;

// default ClientData constructor

ClientData::ClientData(int accountNumberValue,
        string lastNameValue, string firstNameValue, double balanceValue, int branchValue) {
    setAccountNumber(accountNumberValue);
    setLastName(lastNameValue);
    setFirstName(firstNameValue);
    setBalance(balanceValue);
    setBranchId(branchValue);
} // end ClientData constructor

void ClientData::setBranchId(int a) {
    branchID = a;
}

int ClientData::getBranchId() const {
    return branchID;
}

// getaccount-number value

int ClientData::getAccountNumber() const {
    return accountNumber;
} // end function getAccountNumber

// setaccount-number value

void ClientData::setAccountNumber(int accountNumberValue) {
    accountNumber = accountNumberValue; // should validate
} // end function setAccountNumber

// getlast-name value

string ClientData::getLastName() const {
    return lastName;
} // end function getLastName

// setlast-name value

void ClientData::setLastName(string lastNameString) {

    int length = sizeof (lastNameString);
    length = (length < 15 ? length : 14);
    lastNameString.copy(lastName, length);
    lastName[ length ] = '\0';
}

string ClientData::getFirstName() const {
    return firstName;
} // end function getFirstName

// setfirst-name value

void ClientData::setFirstName(string firstNameString) {
    // copy at most10characters from stringtofirstName
    int length = firstNameString.size();
    length = (length < 10 ? length : 9);
    firstNameString.copy(firstName, length);
    firstName[length ] = '\0'; // appendnullcharacter to firstName
} // end function setFirstName

//getbalance value

double ClientData::getBalance() const {
    return balance;
} // end function getBalance

// setbalance value

void ClientData::setBalance(double balanceValue) {
    balance = balanceValue;
} // end function setBalance