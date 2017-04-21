#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main() {

    string accountNumber = "";
    string name = "";
    string accountNum = "";
    double dollarAmount = 0.0;
    double currentBalance = 0.0;
    string lineOne = " ";
    string linetwo = " ";

    ifstream inOldMaster("oldmast.txt", ios::in);
    ifstream inTransaction("trans.txt", ios::in);
    ofstream outNewMaster("newmast.txt", ios::out);

    inTransaction >> accountNum >> dollarAmount;
    inOldMaster >> accountNumber >> name >> currentBalance;

    while (getline(inTransaction, lineOne) && getline(inOldMaster, linetwo)) {

        if (accountNum < accountNumber && !inTransaction.eof()) {
            cout << accountNum << " < " << accountNumber << endl;
            inTransaction >> accountNum >> dollarAmount;
        } else if (accountNum > accountNumber && !inOldMaster.eof()) {
            cout << accountNum << " > " << accountNumber << endl;
            inOldMaster >> accountNumber >> name >> currentBalance;
        } else if (accountNum == accountNumber) {

            cout << accountNum << " = " << accountNumber << endl;
            outNewMaster << " " << accountNumber << " " << name << " " << (currentBalance + dollarAmount) << endl;
            inTransaction >> accountNum >> dollarAmount;
            inOldMaster >> accountNumber >> name >> currentBalance;

        }
    }


    return 0;
}
