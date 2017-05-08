#include <string>
#include <cstring>

#include "IndexRecord.h"
using namespace std;


// default ClientData constructor
IndexRecord::IndexRecord( int account, int off)
{
   setAccount( account );
   setByteOffest( off );

} // end ClientData constructor


int IndexRecord::getAccount() const
{
   return account;
} // end function getAccountNumber

// set account-number value
void IndexRecord::setAccount( int accountNumberValue )
{
   account = accountNumberValue; // should validate
} // end function setAccountNumber



int IndexRecord::getByteOffest() const
{
   return offest;
} // end function getAccountNumber

// set account-number value
void IndexRecord::setByteOffest( int Offest )
{
   offest = Offest; // should validate
} // end function setAccountNumber
