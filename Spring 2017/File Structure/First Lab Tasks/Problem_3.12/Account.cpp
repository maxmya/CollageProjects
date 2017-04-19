//
// Created by Maxmya on 3/1/2017.
//

#include "Account.h"
#include <cstdio>

using namespace std;

Account::Account(int balance) {
    printf("Account is created successfully\n");
    setBalance(balance);
    getBalancePrinted();
    printf("-------------------------\n");

};

void Account::setBalance(int balance) {
    if (balance >= 0) {
        this->balance = balance;
    } else {
        printf("Invalid Initial Balance\n");

        this->balance = 0;
    }
}

void Account::credit(int creditAmount) {
    if (creditAmount > 0) {
        setBalance(getBalance() + creditAmount);
        printf("%d is successfully added to your credit\n", creditAmount);
        getBalancePrinted();
        printf("-------------------------\n");
    } else {
        printf("%d is a not valid credit\n", creditAmount);
        printf("-------------------------\n");

    }

}

void Account::debit(int debitAmount) {

    if ((this->balance - debitAmount) >= 0) {
        printf("%d is successfully withdraw\nbalance before transaction is %d\nbalance now is %d\n", debitAmount,
               getBalance(), getBalance() - debitAmount);
        setBalance(getBalance() - debitAmount);
        printf("-------------------------\n");

    } else {
        printf("%d is a not valid debit\n", debitAmount);
        getBalancePrinted();
        printf("-------------------------\n");

    }
}

int Account::getBalance() {

    return this->balance;

}

void Account::getBalancePrinted() {
    printf("your current balance is %d\n", getBalance());
}
