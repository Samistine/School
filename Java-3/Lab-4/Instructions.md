# CIST 2373 – Java III  -  Lab #4 – 40 Point
Spring Semester, 2017  
[Building Business Objects]


## Part I
Build a Customer Business Object.
This class will have 6 properties, CustId,  CustPassword, CustFirstName, CustLastName, CustAddress and CustEmail.
Build an empty args Constructor in the Customer class that initializes all properties to 0 or “”.
Also build a constructor that takes all 6 args and set the appropriate properties. Then build the following 3 methods:

	//to find a customer’s info in the DB
    selectDB(custID);
    
    // to insert a new Customer in the DB
	insertDB(custId, custPassword, custFirstName, custLastName, custAddress, custEmail)
    
    //this method will delete the Customer from the DB
    deleteDB();

so to check login execute the following code 

	Customer c1 = new Customer();   //creates empty object
	c1.selectDB(id);   				//does the DB lookup to find Customer
	String pwdb = c1.getPassword();
	
    if (pw.equals(pwdb)) { 			//this compares pw(from gui to the password from the database)
   		//login correct
	}
    else {
		//login incorrect
	}

## Part II
Now build an Account Business Object.
This class will have all of the database access code to lookup an Account in the database.
Build a selectDB(acctNo) method in the Account class that accepts an integer acctNo. This method will then go to the database and find all information about the Account requested. 
Then, in the next lab, when our Servlet wants to find an Account in the DB, all we have to do is 

		Account a1 = new Account();
		a1.selectDB(acctNo);
		abalance = a1.getBalance();