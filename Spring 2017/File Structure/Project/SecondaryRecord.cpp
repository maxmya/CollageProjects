#include <string>
#include <cstring>

#include "SecondaryRecord.h"

using namespace std;

// default ClientData constructor

SecondaryRecord::SecondaryRecord(string a, string b) {
    setLastName(a);
    setAccountNumber(b);

} // end ClientData constructor

// get account-number value
string SecondaryRecord::getAccountNumber() const {
    return AccountNumber;
} // end function getAccountNumber

// set account-number value
void SecondaryRecord::setAccountNumber(string accountNumberValue) {
    // default value -1

    const char *lastNameValue = accountNumberValue.data();
    int length = accountNumberValue.size();
    length = (length < 1000 ? length : 1000);
    strncpy(AccountNumber, lastNameValue, length);
    AccountNumber[length] = '\0'; // append null character to lastName


    //  AccountNumber  = accountNumberValue; // should validate

} // end function setAccountNumber



string SecondaryRecord::getLastName() const {
    return lastName;
} // end function getLastName

// set last-name value
void SecondaryRecord::setLastName(string lastNameString) {
    // copy at most 15 characters from string to lastName
    const char *lastNameValue = lastNameString.data();
    int length = lastNameString.size();
    length = (length < 15 ? length : 14);
    strncpy(lastName, lastNameValue, length);
    lastName[length] = '\0'; // append null character to lastName
} // end function setLastName
