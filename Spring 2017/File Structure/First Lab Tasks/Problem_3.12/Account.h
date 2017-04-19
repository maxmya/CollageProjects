//
// Created by Maxmya on 3/1/2017.
//

#ifndef FIRST_LAB_TASKS_ACCOUNT_H
#define FIRST_LAB_TASKS_ACCOUNT_H


class Account {

public:
    Account(int);
    void credit(int);
    void debit(int);
    int getBalance();
    void setBalance(int);
    void getBalancePrinted();


private:
    int balance;

};


#endif //FIRST_LAB_TASKS_ACCOUNT_H
