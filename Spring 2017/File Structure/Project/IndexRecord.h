#ifndef IndexRecord_H
#define IndexRecord_H

#include <string>

using namespace std;
class IndexRecord
{
public:

   IndexRecord( int = 0, int =0 );

  // accessor functions for accountNumber
   void setAccount ( int );
   int getAccount() const;


   void setByteOffest ( int );
   int getByteOffest() const;

private:
   int account;
   int offest;


}; // end class IndexRecord

#endif
