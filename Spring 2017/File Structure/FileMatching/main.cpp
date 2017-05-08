#include <iostream>
#include <fstream>
#include <exception>

using namespace std;

void createAccount(ofstream &);

void createTransaction(ofstream &);

int enterChoice();


int main() {


    enum Entries {
        ACCOUNT = 1, TRANSACTION, END
    };


    string myPath = "//media//maxmya//Projects//Collage Projects//CollageProjects//Spring 2017//File Structure//FileMatchingAlter//";

    ofstream OldMaster(myPath + "oldmast.txt", ios::app);
    ofstream Transactions(myPath + "trans.txt", ios::app);

    if (!OldMaster.is_open() && !Transactions.is_open()) {
        cerr << "Cannot create the file ";
        exit(1);
    }

    int entry = 0;

    while ((entry = enterChoice()) != END) {

        switch (entry) {
            case ACCOUNT:
                createAccount(OldMaster);
                break;
            case TRANSACTION:
                createTransaction(Transactions);
                break;
            default:
                cerr << "Incorrect Choice" << endl;
        }

    }


}

int enterChoice() {
    cout << "\nEnter your choice" << endl
         << "1 - Create Account" << endl
         << "2 - Make A Transaction" << endl
         << "3 - Exit\n?";

    int menuChoice;

    cin >> menuChoice;

    return menuChoice;
}

void createAccount(ofstream &myAccountsFile) {
    cout << "Enter new Account (Account Number , FirstName , LastName , Balance)" << endl;
    int accountNumber = 0;
    string firstName;
    string secondName;
    double currentBalance = 0.0;
    try {
        cin >> accountNumber >> firstName >> secondName >> currentBalance;
    } catch (exception &e) {
        cerr << "Error : " << e.what() << endl;
    }
    myAccountsFile << accountNumber
                   << " " << firstName
                   << " " << secondName
                   << " " << currentBalance << endl;
}

void createTransaction(ofstream &myTransactionsFile) {
    cout << "Enter Transaction (Account Number , Dollar Amount)" << endl;
    int accountNumber = 0;
    double dollarAmmount = 0.0;
    try {
        cin >> accountNumber >> dollarAmmount;
    } catch (exception &e) {
        cerr << "Error : " << e.what() << endl;
    }
    cout << accountNumber << dollarAmmount;
    myTransactionsFile << accountNumber
                       << " " << dollarAmmount << endl;

}
