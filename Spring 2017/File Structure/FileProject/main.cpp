/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: A7mad
 *
 * Created on April 15, 2017, 6:57 PM
 */



#include <iostream>
#include <fstream>
#include <iomanip>
#include <cstdlib>
#include <string>
#include <sstream>
#include "ClientData.h" // ClientData class definition
#include "IndexRecord.h"
#include "SecondaryRecord.h"

int enterChoice();
void createTextFile(fstream&);
void updateRecord(fstream&);
void newRecord(fstream&);
void deleteRecord(fstream&);
void outputLine(ostream&, const ClientData &);
int getAccount(const char * const);
void BackupData();
void RestoreData();
void CreateIndexFiles(fstream&);
string NumberToString(int Number);
void CreateTextFilesforIndexFiles();
void outputLine2(ostream &, const IndexRecord &);
void outputLine3(ostream &, const SecondaryRecord &);

enum Choices {
    PRINT = 1, UPDATE, NEW, DELETE, BACKUP, RESTORE, CreateindexFiles, TextFilesforIndex, END
};




void checkFile() {

    string path = "//media//maxmya//Projects//Collage Projects//CollageProjects//Spring 2017//File Structure//FileProject//";
    fstream inOutCredit(path+"credit.dat", ios::in | ios::out | ios::binary);

    ClientData client;

    int counter = 1;

    if (!inOutCredit) {


        fstream inOutCredit1(path+"credit.dat", ios::out | ios::binary);

        while (counter <= 100) {

            client.setAccountNumber(counter);

            // move file-position pointer to correct record in file
            inOutCredit1.seekp((counter - 1) * sizeof ( ClientData));

            // insert record in file
            inOutCredit1.write(reinterpret_cast<const char *> (&client), sizeof ( ClientData));
            counter++;
        }
        cerr << "credit.dat file not found and new credit.dat with 100 blank records were created." << endl;

        //inOutCredit1.close();
    }
    //inOutCredit.close();
}

int main() {
    string path = "//media//maxmya//Projects//Collage Projects//CollageProjects//Spring 2017//File Structure//FileProject//";

    checkFile();
    // open file for reading and writing 

    fstream inOutCredit(path+"credit.dat", ios::in | ios::out | ios::binary);


    ClientData blankClient;

    for (int i = 0; i < 100; ++i) {

        inOutCredit.write(reinterpret_cast<const char *> (&blankClient),
                sizeof (ClientData));
    }

    if (!inOutCredit) {
        cerr << "File could not be created." << endl;
        exit(EXIT_FAILURE);
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
            case CreateindexFiles: // create CreateindexFiles
                CreateIndexFiles(inOutCredit);
                // CreateSecondary(inOutCredit);
                break;
            case TextFilesforIndex: // create TextFilesforIndex
                CreateTextFilesforIndexFiles();
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
            << "7 - Create index and secondary" << endl
            << "8 - Create text files for Index ,secondary" << endl
            << "9 - end program\n? ";

    int menuChoice;
    cin >> menuChoice; // input menu selection from user
    return menuChoice;

} // end function enterChoice


// create formatted text file for printing

void createTextFile(fstream & readFromFile) {
    // create text file
    string path = "//media//maxmya//Projects//Collage Projects//CollageProjects//Spring 2017//File Structure//FileProject//";

    ofstream outPrintFile(path+"print.txt", ios::out);

    // exit program if ofstream cannot create file
    if (!outPrintFile) {
        cerr << "File could not be created." << endl;
        exit(1);
    } // end if

    outPrintFile << left << setw(10) << "Account" << setw(16)
            << "Last Name" << setw(11) << "First Name" << right
            << setw(10) << "Balance" << setw(10) << "BranchID" << endl;

    // set file-position pointer to beginning of readFromFile
    readFromFile.seekg(0);

    // read first record from record file
    ClientData client;
    readFromFile.read(reinterpret_cast<char *> (&client),
            sizeof ( ClientData));
    // copy all records from record file into text file
    while (!readFromFile.eof()) {
        // write single record to text file
        if (client.getAccountNumber() != 0) // skip empty records
            outputLine(outPrintFile, client);

        // read next record from record file                     
        readFromFile.read(reinterpret_cast<char *> (&client),
                sizeof ( ClientData));
    } // end while

} // end function createTextFile

// update balance in record

void updateRecord(fstream & updateFile) {
    // obtain number of account to update
    int accountNumber = getAccount("Enter account to update");

    // move file-position pointer to correct record in file          
    updateFile.seekg((accountNumber - 1) * sizeof ( ClientData));

    // read first record from file
    ClientData client;
    updateFile.read(reinterpret_cast<char *> (&client),
            sizeof ( ClientData));

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
        updateFile.seekp((accountNumber - 1) * sizeof ( ClientData));

        // write updated record over old record in file               
        updateFile.write(reinterpret_cast<const char *> (&client),
                sizeof ( ClientData));
    }// end if
    else // display error if account does not exist
        cerr << "Account #" << accountNumber
            << " has no information." << endl;

} // end function updateRecord


// create and insert record

void newRecord(fstream & insertInFile) {
    // obtain number of account to create
    int accountNumber = getAccount("Enter new account number");

    // move file-position pointer to correct record in file
    insertInFile.seekg((accountNumber - 1) * sizeof ( ClientData));

    // read record from file
    ClientData client;
    insertInFile.read(reinterpret_cast<char *> (&client),
            sizeof ( ClientData));

    // create record, if record does not previously exist
    if (client.getAccountNumber() == 0) {
        char lastName[ 15 ];
        char firstName[ 10 ];
        double balance;
        int branchID;

        // user enters last name, first name and balance
        cout << "Enter lastname, firstname, balance,branch id\n? ";
        cin >> setw(15) >> lastName;
        cin >> setw(10) >> firstName;
        cin >> setw(10) >> balance;
        cin>>branchID;

        // use values to populate account values
        client.setLastName(lastName);
        client.setFirstName(firstName);
        client.setBalance(balance);
        client.setAccountNumber(accountNumber);
        client.setBranchId(branchID);
        //offset=(short)sizeof(client);
        //insertsorted(client.getAccountNumber(), offset);

        // move file-position pointer to correct record in file            
        insertInFile.seekp((accountNumber - 1) * sizeof ( ClientData));

        // insert record in file                                        
        insertInFile.write(reinterpret_cast<const char *> (&client),
                sizeof ( ClientData));
    }// end if
    else // display error if account already exists
        cerr << "Account #" << accountNumber
            << " already contains information." << endl;

} // end function newRecord


// delete an existing record

void deleteRecord(fstream & deleteFromFile) {
    // obtain number of account to delete
    int accountNumber = getAccount("Enter account to delete");

    // move file-position pointer to correct record in file             
    deleteFromFile.seekg((accountNumber - 1) * sizeof (ClientData));

    // read record from file
    ClientData client;
    deleteFromFile.read(reinterpret_cast<char *> (&client),
            sizeof ( ClientData));

    // delete record, if record exists in file
    if (client.getAccountNumber() != 0) {
        ClientData blankClient; // create blank record

        // move file-position pointer to correct record in file
        deleteFromFile.seekp((accountNumber - 1) *
                sizeof ( ClientData));

        // replace existing record with blank record        
        deleteFromFile.write(
                reinterpret_cast<const char *> (&blankClient),
                sizeof ( ClientData));

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

int getAccount(const char * const prompt) {
    int accountNumber;

    // obtain account-number value
    do {
        cout << prompt << " (1 - 100): ";
        cin >> accountNumber;
    } while (accountNumber < 1 || accountNumber > 100);

    return accountNumber;
} // end function getAccount

void BackupData() {
    string path = "//media//maxmya//Projects//Collage Projects//CollageProjects//Spring 2017//File Structure//FileProject//";

    std::ifstream srce(path+"credit.dat", std::ios::binary);
    std::ofstream dest(path+"backup.dat", std::ios::binary);
    dest << srce.rdbuf();
    cout << "success BackupData" << endl;
}

void RestoreData() {
    string path = "//media//maxmya//Projects//Collage Projects//CollageProjects//Spring 2017//File Structure//FileProject//";

    std::ifstream sr(path+"backup.dat", std::ios::binary);
    if (!sr) {
        cerr << "Backup file dosen't exist ,can't do restoration" << endl;
        return;
    }
    std::ofstream dest(path+"credit.dat", std::ios::binary);
    dest << sr.rdbuf();
    cout << "success RestoreData" << endl;
}

void CreateIndexFiles(fstream &fileData) {
    string path = "//media//maxmya//Projects//Collage Projects//CollageProjects//Spring 2017//File Structure//FileProject//";

    int accountNumber, offs, countt = 0, indexx = 1;
    string *Array = new string[101];
    ClientData client;
    IndexRecord index;
    SecondaryRecord Secondary;
    fstream indexPrimary(path+"primary_index.dat", ios::out | ios::binary|ios::trunc);
    fstream indexSecondary(path+"secondary_index.dat", ios::out | ios::binary|ios::trunc);

    fileData.read(reinterpret_cast<char *> (&client), sizeof ( ClientData));
    fileData.clear();
//    cout<<client.getLastName();
    while (!fileData.eof()) {


        accountNumber = client.getAccountNumber();

        Array[countt + 1] = client.getLastName();

        indexPrimary.seekg((accountNumber - 1) * sizeof ( IndexRecord));
        offs = countt * 48;

        index.setAccount(accountNumber);
        index.setByteOffest(offs);

        indexPrimary.seekp((accountNumber - 1) * sizeof ( IndexRecord));

        indexPrimary.write(reinterpret_cast<const char *> (&index), sizeof ( IndexRecord));

        fileData.read(reinterpret_cast<char *> (&client), sizeof ( ClientData));
        countt++;
    }

   fileData.clear();
    string accountN;
    int Size = 101;

    while (!fileData.eof()) {

        string temp = Array[indexx];
        for (int i = 1; i < Size; i++) {

            if (temp == Array[i]) {

                accountN += NumberToString(i) + ", ";

                Array[i] = "";
            }

        }

        Secondary.setLastName(temp);
        Secondary.setAccountNumber(accountN);
        //cout << Secondary.getAccountNumber()<<"\n"<<endl;
        indexSecondary.write(reinterpret_cast<const char *> (&Secondary), sizeof ( SecondaryRecord));

        fileData.read(reinterpret_cast<char *> (&client), sizeof ( ClientData));

        accountN = "";
        indexx++;
    }


}

string NumberToString(int Number) {
    ostringstream ss;
    ss << Number;
    return ss.str();
}

void CreateTextFilesforIndexFiles() {
    string path = "//media//maxmya//Projects//Collage Projects//CollageProjects//Spring 2017//File Structure//FileProject//";

    fstream readFromFile(path+"primary_index.dat", ios::in | ios::binary);

    fstream readFromFile2(path+"secondary_index.dat", ios::in | ios::binary);
    // create text file
    ofstream outPrintFile(path+"primary_index.txt", ios::out);
    // create text file
    ofstream secondaryText(path+"secondary_index.txt", ios::out);

    // exit program if ofstream cannot create file
    if (!outPrintFile || !readFromFile) {
        cerr << "File could not be created." << endl;
        //exit( 1 );
    } // end if

    outPrintFile << left << setw(10) << "Account" << setw(16) << "Byte-offset" << endl;

    secondaryText << left << setw(16) << "Last Name" << setw(16) << "Account Number" << endl;

    // set file-position pointer to beginning of readFromFile
    readFromFile.seekg(0);

    // read first record from record file
    IndexRecord client;

    SecondaryRecord Secondary;

    readFromFile.read(reinterpret_cast<char *> (&client), sizeof ( IndexRecord));

    readFromFile.clear();


    // copy all records from record file into text file
    while (!readFromFile.eof()) {
        // write single record to text file
        if (client.getAccount() != 0) // skip empty records
            outputLine2(outPrintFile, client);


        // read next record from record file
        readFromFile.read(reinterpret_cast<char *> (&client), sizeof ( IndexRecord));
    } // end while

    //readFromFile2.read( reinterpret_cast< char * >( &Secondary ),sizeof( SecondaryRecord ) );
   readFromFile2.clear();

    while (!readFromFile2.eof()) {

        if (Secondary.getLastName() != "") outputLine3(secondaryText, Secondary);
        //if ( Secondary.getLastName() != "" )
        // cout<<Secondary.getAccountNumber()<<endl;
        readFromFile2.read(reinterpret_cast<char *> (&Secondary), sizeof ( SecondaryRecord));

    }



} // end function createTextFile

void outputLine2(ostream &output, const IndexRecord &record) {
    output << left << setw(16) << record.getAccount()
            << setw(16) << record.getByteOffest() << endl;

} // end function outputLine2

void outputLine3(ostream &output, const SecondaryRecord &record) {
    output << left << setw(26) << record.getLastName()
            << setw(26) << record.getAccountNumber() << endl;

} // end function outputLine3