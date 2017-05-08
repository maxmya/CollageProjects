

#include <cstdlib>
#include <iostream>
#include <fstream>

using namespace std;

int main() {

    string myPath = "//media//maxmya//Projects//Collage Projects//CollageProjects//Spring 2017//File Structure//FileMatchingAlter//";

    ifstream inOldMaster(myPath + "oldmast.txt", ios::in);
    ifstream inTransaction(myPath + "trans.txt", ios::in);
    ofstream outNewMaster(myPath + "newmast.txt", ios::out);


    if (!outNewMaster && !inOldMaster && !inTransaction) {
        cerr << "files could not be opened" << endl;
        exit(1);
    }

    int transAccountNum = 0;
    int oldMastAccountNum = 0;
    double dollarAmount;
    double currentBalance;
    string firstName;
    string secondName;


    while (!inOldMaster.eof() && !inTransaction.eof()) {

            inOldMaster >> oldMastAccountNum >> firstName >> secondName >> currentBalance;

        if (transAccountNum < oldMastAccountNum)

            inTransaction >> transAccountNum >> dollarAmount;

        while ((oldMastAccountNum == transAccountNum) && !inTransaction.eof()) {

            currentBalance += dollarAmount;

            inTransaction >> transAccountNum >> dollarAmount;
        }

        if (((oldMastAccountNum > transAccountNum) && !inTransaction.eof()) || inOldMaster.eof()) {
            cerr << "Unmatched transaction record for account number: " << transAccountNum << endl;
        }


        if (!inOldMaster.eof())
            outNewMaster << oldMastAccountNum << " " << firstName << " " << secondName << " " << currentBalance << endl;
    }
    return 0;
}
