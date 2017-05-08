


#include <iostream>
#include <fstream>
#include <iomanip>
#include <cstdlib>
#include "ClientData.h" // ClientData class definition
#include "IndexRecord.h"
#include "SecondaryRecord.h"


int enterChoice();

void createTextFile(fstream &);

void updateRecord(fstream &);

void newRecord(fstream &);

void deleteRecord(fstream &);

void outputLine(ostream &, const ClientData &);

int getAccount(const char *const);

void BackupData();

void RestoreData();
void CreateIndexFiles(fstream&);
string NumberToString ( int Number );
void CreateTextFilesforIndexFiles( );
void outputLine2( ostream &, const IndexRecord & );
void CreateSecondary(fstream&);
void outputLine3( ostream &, const SecondaryRecord & );
//void insertsorted(int id, short offset);
//
//short CntID = 0;
//short offset;

enum Choices {
    PRINT = 1, UPDATE, NEW, DELETE, BACKUP, RESTORE, END
};

int main() {
    string path = "//media//maxmya//Projects//Collage Projects//CollageProjects//Spring 2017//File Structure//Project//";
    // open file for reading and writing
    fstream inOutCredit(path + "credit.dat", ios::in | ios::out | ios::trunc | ios::binary);

    ClientData blankClient;


    for (int i = 0; i < 100; ++i) {

        inOutCredit.write(reinterpret_cast<const char *> (&blankClient),
                          sizeof(ClientData));
    }

    if (!inOutCredit) {
        fstream inOutCredit(path + "credit.dat", ios::in | ios::out | ios::binary);

        ClientData blankClient;

        for (int i = 0; i < 100; ++i) {

            inOutCredit.write(reinterpret_cast<const char *> (&blankClient),
                              sizeof(ClientData));
        }
    }
    int choice; // store user choice

    // enable user to specify action
    while ((choice = enterChoice()) != END) {
        switch (choice) {
            case PRINT: // create text file from record file
                createTextFile(inOutCredit);
                break;
            case UPDATE: // update record
                updateRecord(inOutCredit);
                break;
            case NEW: // create record
                newRecord(inOutCredit);
                break;
            case DELETE: // delete existing record
                deleteRecord(inOutCredit);
                break;
            case BACKUP: // delete existing record
                BackupData();
                break;
            case RESTORE: // delete existing record
                RestoreData();
                break;
            default: // display error if user does not select valid choice
                cerr << "Incorrect choice" << endl;
                break;
        } // end switch

        inOutCredit.clear(); // reset end-of-file indicator
    } // end while

    return 0;

} // end main


// enable user to input menu choice

int enterChoice() {
    // display available options
    cout << "\nEnter your choice" << endl
         << "1 - store a formatted text file of accounts" << endl
         << "    called \"print.txt\" for printing" << endl
         << "2 - update an account" << endl
         << "3 - add a new account" << endl
         << "4 - delete an account" << endl
         << "5 - Backup" << endl
         << "6 - Restore" << endl
         << "7 - end program\n? ";

    int menuChoice;
    cin >> menuChoice; // input menu selection from user
    return menuChoice;

} // end function enterChoice


// create formatted text file for printing

void createTextFile(fstream &readFromFile) {
    string path = "//media//maxmya//Projects//Collage Projects//CollageProjects//Spring 2017//File Structure//Project//";

    // create text file                            
    ofstream outPrintFile(path + "print.txt", ios::out);

    outPrintFile << left << setw(10) << "Account" << setw(16)
                 << "Last Name" << setw(11) << "First Name" << right
                 << setw(10) << "Balance" << setw(10) << "BranchID" << endl;


    // exit program if ofstream cannot create file
    if (!outPrintFile) {
        cerr << "File could not be created." << endl;
        exit(1);
    } // end if



    // set file-position pointer to beginning of readFromFile
    readFromFile.seekg(0);

    // read first record from record file
    ClientData client;
    readFromFile.read(reinterpret_cast<char *> (&client),
                      sizeof(ClientData));
    // copy all records from record file into text file
    while (!readFromFile.eof()) {
        // write single record to text file
        if (client.getAccountNumber() != 0) // skip empty records
            outputLine(outPrintFile, client);

        // read next record from record file                     
        readFromFile.read(reinterpret_cast<char *> (&client),
                          sizeof(ClientData));
    } // end while

} // end function createTextFile

// update balance in record

void updateRecord(fstream &updateFile) {
    // obtain number of account to update
    int accountNumber = getAccount("Enter account to update");

    // move file-position pointer to correct record in file          
    updateFile.seekg((accountNumber - 1) * sizeof(ClientData));

    // read first record from file
    ClientData client;
    updateFile.read(reinterpret_cast<char *> (&client),
                    sizeof(ClientData));

    // update record
    if (client.getAccountNumber() != 0) {
        outputLine(cout, client); // display the record

        // request user to specify transaction
        cout << "\nEnter charge (+) or payment (-): ";
        double transaction; // charge or payment
        cin >> transaction;

        // update record balance
        double oldBalance = client.getBalance();
        client.setBalance(oldBalance + transaction);
        outputLine(cout, client); // display the record

        // move file-position pointer to correct record in file          
        updateFile.seekp((accountNumber - 1) * sizeof(ClientData));

        // write updated record over old record in file               
        updateFile.write(reinterpret_cast<const char *> (&client),
                         sizeof(ClientData));
    }// end if
    else // display error if account does not exist
        cerr << "Account #" << accountNumber
             << " has no information." << endl;

} // end function updateRecord


// create and insert record

void newRecord(fstream &insertInFile) {
    // obtain number of account to create
    int accountNumber = getAccount("Enter new account number");

    // move file-position pointer to correct record in file
    insertInFile.seekg((accountNumber - 1) * sizeof(ClientData));

    // read record from file
    ClientData client;
    insertInFile.read(reinterpret_cast<char *> (&client),
                      sizeof(ClientData));

    // create record, if record does not previously exist
    if (client.getAccountNumber() == 0) {
        char lastName[15];
        char firstName[10];
        double balance;
        int branchID;

        // user enters last name, first name and balance
        cout << "Enter lastname, firstname, balance,branch id\n? ";
        cin >> setw(15) >> lastName;
        cin >> setw(10) >> firstName;
        cin >> setw(10) >> balance;
        cin >> branchID;

        // use values to populate account values
        client.setLastName(lastName);
        client.setFirstName(firstName);
        client.setBalance(balance);
        client.setAccountNumber(accountNumber);
        client.setBranchId(branchID);
        //offset=(short)sizeof(client);
        //insertsorted(client.getAccountNumber(), offset);

        // move file-position pointer to correct record in file            
        insertInFile.seekp((accountNumber - 1) * sizeof(ClientData));

        // insert record in file                                        
        insertInFile.write(reinterpret_cast<const char *> (&client),
                           sizeof(ClientData));
    }// end if
    else // display error if account already exists
        cerr << "Account #" << accountNumber
             << " already contains information." << endl;
    offset = (short) sizeof(client);
} // end function newRecord


// delete an existing record

void deleteRecord(fstream &deleteFromFile) {
    // obtain number of account to delete
    int accountNumber = getAccount("Enter account to delete");

    // move file-position pointer to correct record in file             
    deleteFromFile.seekg((accountNumber - 1) * sizeof(ClientData));

    // read record from file
    ClientData client;
    deleteFromFile.read(reinterpret_cast<char *> (&client),
                        sizeof(ClientData));

    // delete record, if record exists in file
    if (client.getAccountNumber() != 0) {
        ClientData blankClient; // create blank record

        // move file-position pointer to correct record in file
        deleteFromFile.seekp((accountNumber - 1) *
                             sizeof(ClientData));

        // replace existing record with blank record        
        deleteFromFile.write(
                reinterpret_cast<const char *> (&blankClient),
                sizeof(ClientData));

        cout << "Account #" << accountNumber << " deleted.\n";
    }// end if
    else // display error if record does not exist
        cerr << "Account #" << accountNumber << " is empty.\n";
} // end deleteRecord


// display single record

void outputLine(ostream &output, const ClientData &record) {
    output << left << setw(10) << record.getAccountNumber()
           << setw(16) << record.getLastName()
           << setw(11) << record.getFirstName()
           << setw(10) << setprecision(2) << right << fixed
           << showpoint << record.getBalance() << setw(10) << record.getBranchId() << endl;
} // end function outputLine


// obtain account-number value from user

int getAccount(const char *const prompt) {
    int accountNumber;

    // obtain account-number value
    do {
        cout << prompt << " (1 - 100): ";
        cin >> accountNumber;
    } while (accountNumber < 1 || accountNumber > 100);

    return accountNumber;
} // end function getAccount

void BackupData() {
    string path = "//media//maxmya//Projects//Collage Projects//CollageProjects//Spring 2017//File Structure//Project//";
    std::ifstream srce(path + "credit.dat", std::ios::binary);
    std::ofstream dest(path + "backup.dat", std::ios::binary);
    dest << srce.rdbuf();
}

void RestoreData() {
    string path = "//media//maxmya//Projects//Collage Projects//CollageProjects//Spring 2017//File Structure//Project//";
    std::ifstream sr(path + "backup.dat", std::ios::binary);
    if (!sr) {
        cerr << "Backup file dosen't exist ,can't do restoration" << endl;
        return;
    }

    std::ofstream dest(path + "credit.dat", std::ios::binary);
    dest << sr.rdbuf();

}

void insertsorted(int id, short offset) /// insert sorted in the primary index
{
    string path = "//media//maxmya//Projects//Collage Projects//CollageProjects//Spring 2017//File Structure//Project//";
    fstream prim(path + "primary_index.dat", ios::out | ios::in);
    int tmp = 0;
    short of = 0;
    bool hi = false;
    if (CntID == 0) {
        //        cout << x << " " << offset <<endl ;
        prim.write((char *) &id, sizeof(int));
        prim.write((char *) &offset, sizeof(short));
        CntID++;
        return;
    }
    prim.read((char *) &tmp, sizeof(tmp));
    while (prim.good()) {
        if (tmp > id) {
            hi = true;
            prim.seekg(-4, ios::cur);
            of = prim.tellg();
            break;
        }

        prim.seekg(2, ios::cur);
        prim.read((char *) &tmp, sizeof(tmp));

    }
    prim.close();
    prim.open(path + "primary_index.txt", ios::out | ios::in);

    if (!hi) { ///in the last position

        prim.seekg(CntID * 6, ios::beg);
        prim.write((char *) &id, sizeof(int));
        prim.write((char *) &offset, sizeof(short));
        CntID++;
    } else {
        prim.seekg((CntID - 1) * 6, ios::beg);
        int numend;
        short ofend;
        prim.read((char *) &numend, sizeof(numend));
        prim.read((char *) &ofend, sizeof(ofend));

        prim.seekg(of, ios::beg);


        while (prim.good()) {
            int tmpnum;
            short tmpof;
            int tmpnum1;
            short tmpof1;
            prim.read((char *) &tmpnum, sizeof(tmpnum));
            prim.read((char *) &tmpof, sizeof(tmpof));
            prim.read((char *) &tmpnum1, sizeof(tmpnum1));
            prim.read((char *) &tmpof1, sizeof(tmpof1));
            prim.seekg(-6, ios::cur);
            prim.write((char *) &tmpnum, sizeof(tmpnum));
            prim.write((char *) &tmpof, sizeof(tmpof));

        }
        prim.close();
        prim.open("primary_index.txt", ios::out | ios::in);
        prim.seekg(0, ios::end);

        prim.write((char *) &numend, sizeof(numend));
        prim.write((char *) &ofend, sizeof(ofend));
        prim.seekg(of, ios::beg);
        prim.write((char *) &id, sizeof(id));
        prim.write((char *) &offset, sizeof(of));
        CntID++;

    }
    prim.close();
    prim.open("primary_index.txt", ios::out | ios::in | ios::binary);
    int tt;
    short rr;
    prim.read((char *) &tt, sizeof(tt));
    prim.read((char *) &rr, sizeof(rr));
    while (prim.good()) {

        cout << "ID In primary = " << tt << " Off = " << rr << endl;
        prim.read((char *) &tt, sizeof(tt));
        prim.read((char *) &rr, sizeof(rr));

    }

    prim.close();
}
