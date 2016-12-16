/** 
*
* Author: 		Robert Skelton
* Date 			11.22.13
* AU User Id: 	rjs0015
* Filename: 	skelton_4.cpp
* Email: 		robertjskelton@gmail.com
* Description:  This file is the entire Cash Register Application project.
*
*/

#include <iostream>
#include <string>
#include <vector>
#include <sstream>
using namespace std;
vector<string> allSales;
string saleString;

/*
* Function:  	mask
* Input:		string
* Output:		string
* Description:	Masks all but the last 4 digits of a credit card number. 
*/
string mask(string str) {
  for (int i = 0; i < str.length() - 4; ++i) {
    if (str[i] == '1' || str[i] == '2' || 
    	str[i] == '3' || str[i] == '4' || 
		str[i] == '5' || str[i] == '6' || 
    	str[i] == '7' || str[i] == '8' || 
    	str[i] == '9' || str[i] == '0')
      str[i] = '*';
  }
  return str;
}

/* Class Definitions */
/*
* Class:  		System
* Description:	Declares functions for the System Class.
*/
class System {
public:
	int quit();
	System();
	int menu();
};

/*
* Class:  		Sale
* Description:	Declares functions for the Sale Class.
*/
class Sale {
public:
	Sale();
	System::System system;
	double taxRate;
	double discount;
	vector<Sale> saleslist;
	string printAll();
	string IntToString(double number);
	string IntToString(int number);
};

/*
* Class:  		RegularSale
* Description:	Declares functions for the RegularSale Class.
*/
class RegularSale: public Sale {
public:
	RegularSale();
	//void RegularCash();
};

/*
* Class:  		ContractSale
* Description:	Declares functions for the ContractSale Class.
*/
class ContractSale: public Sale {
public:
	ContractSale();
};

/*
* Class:  		RegularSaleCash
* Description:	Declares functions for the RegularSaleCash Class.
*/
class RegularSaleCash: public RegularSale {
public:
	RegularSaleCash();
	void RegularCash();
};

/*
* Class:  		RegularSaleCredit
* Description:	Declares functions for the RegularSaleCredit Class.
*/
class RegularSaleCredit: public RegularSale {
public:
	RegularSaleCredit();
	void RegularCredit();
};

/*
* Class:  		RegularSaleCheck
* Description:	Declares functions for the RegularSaleCheck Class.
*/
class RegularSaleCheck: public RegularSale {
public:
	RegularSaleCheck();
	void RegularCheck();
};

/*
* Class:  		ContractSaleCash
* Description:	Declares functions for the ContractSaleCash Class.
*/
class ContractSaleCash: public ContractSale {
public:
	ContractSaleCash();
	void ContractCash();
};

/*
* Class:  		ContractSaleCredit
* Description:	Declares functions for the ContractSaleCredit Class.
*/
class ContractSaleCredit: public ContractSale {
public:
	ContractSaleCredit();
	void ContractCredit();
};

/*
* Class:  		ContractSaleCheck
* Description:	Declares functions for the ContractSaleCheck Class.
*/
class ContractSaleCheck: public ContractSale {
public:
	ContractSaleCheck();
	void ContractCheck();
};

/* Constructors */
/*
* Constructor:  System constuctor
* Input:		none
* Output:		none
* Description:	The constructor for System creates a new System object.
*/
System::System() {

}

/*
* Constructor:  Sale constuctor
* Input:		none
* Output:		none
* Description:	The constructor for Sale holds information across all objects referenced by Sale, such as taxRate and discount!
*/
Sale::Sale() {
	cout.setf(ios::fixed);
	cout.setf(ios::showpoint);
	cout.precision(2);
	System::System system;
	taxRate = 1.08;
}

/*
* Constructor:	RegularSale constuctor
* Input:		none
* Output:		none
* Description:	The constructor for RegularSale holds nothing, just creates an object.
*/
RegularSale::RegularSale() {

}

/*
* Constructor:  ContractSale constuctor
* Input:		none
* Output:		none
* Description:	The constructor for ContractSale holds the discount rate.
*/
ContractSale::ContractSale() {
	discount = .15; // 15 percent discount
}

/*
* Constructor:  RegularSaleCash constuctor
* Input:		none
* Output:		none
* Description:	The constructor for RegularSaleCash holds nothing, just creates an object.
*/
RegularSaleCash::RegularSaleCash() {

}

/*
* Constructor:	RegularSaleCredit constuctor
* Input:		none
* Output:		none
* Description:	The constructor for RegularSaleCredit holds nothing, just creates an object.
*/
RegularSaleCredit::RegularSaleCredit() {

}

/*
* Constructor:	RegularSaleCheck constuctor
* Input:		none
* Output:		none
* Description:	The constructor for RegularSaleCheck holds nothing, just creates an object.
*/
RegularSaleCheck::RegularSaleCheck() {

}

/*
* Constructor:	ContractSaleCash constuctor
* Input:		none
* Output:		none
* Description:	The constructor for RegularSaleCash does everything for a Cash Contract Sale. 
*/
ContractSaleCash::ContractSaleCash() {
	string item;
	double price;
	double total = 0;
	double cashGiven = 0;
	saleString = "";
	int cID = 0;
	cout << "\nEnter contractor ID number: ";
	cin >> cID;
	int itemNo = 1;
	do {
		cout << "\nEnter item: ";
		cin >> item;
		if (item == "*")
			goto label;
		cout << "\nEnter amount: $" ;
		cin >> price;
		total += price;
		saleString += "\n" + IntToString(itemNo) + ". " + item + " $" + IntToString(price);
		itemNo++;
	} while (item != "*");
	label:
	cout << "\nSubtotal: $" << total << endl;
	
	double discountPrice = total * discount;
	double subtotal = total - discountPrice;
	double tax = subtotal * (taxRate - 1);

	cout << "\nContractor Sale" << endl;
	cout << "\nContractor ID: " << cID << endl;
	cout << "\nDiscount: $" << discountPrice << endl;
	cout << "\nSubtotal: $" << subtotal << endl;
	cout << "\nTax: $" << tax << endl;
	total = subtotal + tax;
	cout << "\nTotal Amount: $" << total << endl;
	cout << "\nAmount recieved: $";
	cin >> cashGiven;

	if (total > cashGiven)
		cout << "That ain't gonna cut it, partner" << endl;
	else
		cout << "\nChange: $" << cashGiven - subtotal << endl;

	
	saleString = saleString + "\nContractor Sale\nContractor ID: " + IntToString(cID);
	saleString = saleString + "\nDiscount: $" + IntToString(discountPrice) + "\nSub-Total: $" + IntToString(total) + "\nTax: $" + IntToString(tax);
	saleString = saleString + "\nTotal amount: $" + IntToString(total) + "\nCASH\nAmount Recieved: $" + IntToString(cashGiven) + "\nChange: $" + IntToString(cashGiven - subtotal); 

	allSales.push_back(saleString);
	system.menu();
}

/*
* Function:		Sale::IntToString
* Input:		double number
* Output:		string
* Description:	Converts a double to a string for storing in a vector.
*/
string Sale::IntToString (double number) { 
	cout.setf(ios::fixed);
	cout.setf(ios::showpoint);
	cout.precision(2);
	ostringstream oss; 
	oss << number; 
	return oss.str(); 
} 

/*
* Function:		Sale::IntToString
* Input:		int number
* Output:		string
* Description:	Converts an int to a string for storing in a vector, overloaded function.
*/
string Sale::IntToString (int number) { 
	cout.setf(ios::fixed);
	cout.setf(ios::showpoint);
	cout.precision(2);
	ostringstream oss; 
	oss << number; 
	return oss.str(); 
} 

/*
* Function:		ContractSaleCredit::ContractSaleCredit
* Input:		none
* Output:		none
* Description:	Runs the Credit Card Contractor sale.
*/
ContractSaleCredit::ContractSaleCredit() {
	string item;
	double price;
	double total = 0;
	string custName;
	saleString = "";
	int cID = 0;
	int ccNo = 0;
	string ccExp;
	int itemNo = 1;
	cout << "\nEnter contractor ID number: ";
	cin >> cID;
	do {
		cout << "\nEnter item: ";
		cin >> item;
		if (item == "*")
			goto label;
		cout << "\nEnter amount: $" ;
		cin >> price;
		total += price;
		saleString += "\n" + IntToString(itemNo) + ". " + item + " $" + IntToString(price);
		itemNo++;
	} while (item != "*");
	label:
	cout << "\nSubtotal: $" << total << endl;
	
	double discountPrice = total * discount;
	double subtotal = total - discountPrice;
	double tax = subtotal * (taxRate - 1);
	cout << "\nContractor Sale" << endl;
	cout << "\nContractor ID: " << cID << endl;
	cout << "\nDiscount: $" << discountPrice << endl;
	cout << "\nSubtotal: $" << subtotal << endl;
	cout << "\nTax: $" << tax << endl;
	cout << "\nTotal Amount: $" << subtotal << endl;
	cout << "\nEnter name on the credit card: ";
	getline(cin, custName);
	getline(cin, custName);

	cout << "\nEnter credit card number: ";
	cin >> ccNo;
	cout << "\nEnter expiration date: ";	
	cin >> ccExp;

	saleString = saleString + "\nContractor Sale\nContractor ID: " + IntToString(cID);
	saleString = saleString + "\nDiscount: $" + IntToString(discountPrice) + "\nSub-Total: $" + IntToString(total) + "\nTax: $" + IntToString(tax);
	saleString = saleString + "\nTotal amount: $" + IntToString(total) + "\nCREDIT CARD " + custName + " " + mask(IntToString(ccNo)) + " " + ccExp;

	allSales.push_back(saleString);
	system.menu();
}

/*
* Function:		ContractSaleCheck::ContractSaleCheck
* Input:		none
* Output:		none
* Description:	Runs the Check Contractor sale.
*/
ContractSaleCheck::ContractSaleCheck() {
	string item;
	double price;
	double total = 0;
	string custName;
	saleString = "";
	int cID = 0;
	int dlNo;
	cout << "\nEnter contractor ID number: ";
	cin >> cID;
	int itemNo = 1;
	do {
		cout << "\nEnter item: ";
		cin >> item;
		if (item == "*")
			goto label;
		cout << "\nEnter amount: $" ;
		cin >> price;
		total += price;
		saleString += "\n" + IntToString(itemNo) + ". " + item + " $" + IntToString(price);
		itemNo++;
	} while (item != "*");
	label:
	cout << "\nSubtotal: $" << total << endl;
	double discountPrice = total * discount;
	double subtotal = total - discountPrice;
	double tax = subtotal * (taxRate - 1);

	cout << "\nContractor Sale" << endl;
	cout << "\nContractor ID: " << cID << endl;
	cout << "\nDiscount: $" << discountPrice << endl;
	cout << "\nSubtotal: $" << subtotal << endl;
	cout << "\nTax: $" << tax << endl;
	cout << "\nTotal Amount: $" << subtotal << endl;
	cout << "\nEnter name on the check: ";
	getline(cin, custName);
	getline(cin, custName);
	cout << "\nEnter driver's license number: ";	
	cin >> dlNo;

	saleString = saleString + "\nContractor Sale\nContractor ID: " + IntToString(cID);
	saleString = saleString + "\nDiscount: $" + IntToString(discountPrice) + "\nSub-Total: $" + IntToString(total) + "\nTax: $" + IntToString(tax);
	saleString = saleString + "\nTotal amount: $" + IntToString(total) + "\nCHECK " + custName + " " + IntToString(dlNo);

	allSales.push_back(saleString);
	system.menu();
}


/* Functions */
/*
* Function:		System::quit
* Input:		none
* Output:		int
* Description:	Ends the program gracefully.
*/
int System::quit() {
	//cout << "\nHave a great day!" << endl;
	return 0;
}

/*
* Function:		RegularSaleCash::RegularCash
* Input:		none
* Output:		none
* Description:	Runs the Regular customer cash choice.
*/
void RegularSaleCash::RegularCash() {
	string item;
	double price;
	double total = 0;
	double cashGiven = 0;
	saleString = "";
	int itemNo = 1;
	do {
		cout << "\nEnter item: ";
		cin >> item;
		if (item == "*")
			goto label;
		cout << "\nEnter amount: $" ;
		cin >> price;
		total += price;
		saleString += "\n" + IntToString(itemNo) + ". " + item + " $" + IntToString(price);
		itemNo++;
	} while (item != "*");
	label:
	double tax = total * (taxRate - 1);
	cout << "\nRegular Sale" << endl;
	cout << "\nSubtotal: $" << total << endl;
	cout << "\nTax: $" << tax << endl;
	cout << "\nTotal Amount: $" << total * taxRate << endl;
	cout << "\nAmount recieved: $";
	cin >> cashGiven;
	if (total * taxRate > cashGiven)
		cout << "That ain't gonna cut it, partner" << endl;
	else
		cout << "\nChange: $" << cashGiven - total * taxRate << endl;

	saleString = saleString + "\nSub-Total: $" + IntToString(total) + "\nRegular Sale" + "\nTax: $" + IntToString(tax);
	saleString = saleString + "\nTotal amount: $" + IntToString(total + tax) + "\nCASH\nAmount Recieved: $" + IntToString(cashGiven) + "\nChange: $" + IntToString(cashGiven - total);

	allSales.push_back(saleString);
	system.menu();
}

/*
* Function:		RegularSaleCredit::RegularSaleCredit
* Input:		none
* Output:		none
* Description:	Runs the Credit Card regular customer sale.
*/
void RegularSaleCredit::RegularCredit() {
	string item;
	double price;
	double total = 0;
	string custName;
	double cashGiven = 0;
	int ccNo = 0;
	string ccExp;
	saleString = "";
	int itemNo = 1;
	do {
		cout << "\nEnter item: ";
		cin >> item;
		if (item == "*")
			goto label;
		cout << "\nEnter amount: $" ;
		cin >> price;
		total += price;
		saleString += "\n" + IntToString(itemNo) + ". " + item + " $" + IntToString(price);
		itemNo++;
	} while (item != "*");
	label:
	double tax = total * (taxRate - 1);
	cout << "\nRegular Sale" << endl;
	cout << "\nSubtotal: $" << total << endl;
	cout << "\nTax: $" << tax << endl;
	cout << "\nTotal Amount: $" << total * taxRate << endl;
	cout << "\nEnter name on the credit card: ";
	getline(cin, custName);
	getline(cin, custName);
	cout << "\nEnter credit card number: ";
	cin >> ccNo;
	cout << "\nEnter expiration date: ";	
	cin >> ccExp;

	saleString = saleString + "\nSub-Total: $" + IntToString(total) + "\nRegular Sale" + "\nTax: $" + IntToString(tax);
	saleString = saleString + "\nTotal amount: $" + IntToString(total + tax) + "\nCREDIT CARD " + custName + " " + mask(IntToString(ccNo)) + " " + ccExp;

	allSales.push_back(saleString);
	system.menu();
}

/*
* Function:		RegularSaleCheck::RegularCheck
* Input:		none
* Output:		none
* Description:	Runs the check sale for a regular customer.
*/
void RegularSaleCheck::RegularCheck() {
	string item;
	double price;
	double total = 0;
	string custName;
	int dlNo;
	saleString = "";
	double cashGiven = 0;
	int itemNo = 1;
	do {
		cout << "\nEnter item: ";
		cin >> item;
		if (item == "*")
			goto label;
		cout << "\nEnter amount: $" ;
		cin >> price;
		total += price;
		saleString += "\n" + IntToString(itemNo) + ". " + item + " $" + IntToString(price);
		itemNo++;
	} while (item != "*");
	label:
	double tax = total * (taxRate - 1);
	cout << "\nRegular Sale" << endl;
	cout << "\nSubtotal: $" << total << endl;
	cout << "\nTax: $" << tax << endl;
	cout << "\nTotal Amount: $" << total * taxRate << endl;
	cout << "\nEnter name on the check: ";
	getline(cin, custName);
	getline(cin, custName);
	cout << "\nEnter driver's license number: ";	
	cin >> dlNo;

	saleString = saleString + "\nSub-Total: $" + IntToString(total) + "\nRegular Sale" + "\nTax: $" + IntToString(tax);
	saleString = saleString + "\nTotal amount: $" + IntToString(total + tax) + "\nCHECK " + custName + " " + IntToString(dlNo);

	allSales.push_back(saleString);
	system.menu();
}

/*
* Function:		ContractSaleCredit::ContractCredit
* Input:		none
* Output:		none
* Description:	Runs the Credit Card Contractor sale.
*/
void ContractSaleCredit::ContractCredit() {
	string item;
	double price;
	double total = 0;
	string custName;
	double cashGiven = 0;
	int ccNo = 0;
	saleString = "";
	string ccExp;
	int itemNo = 1;
	do {
		cout << "\nEnter item: ";
		cin >> item;
		if (item == "*")
			goto label;
		cout << "\nEnter amount: $" ;
		cin >> price;
		total += price;
		saleString += "\n" + IntToString(itemNo) + ". " + item + " $" + IntToString(price);
		itemNo++;
	} while (item != "*");
	label:
	double tax = total * (taxRate - 1);
	cout << "\nRegular Sale" << endl;
	cout << "\nSubtotal: $" << total << endl;
	cout << "\nTax: $" << tax << endl;
	cout << "\nTotal Amount: $" << total * taxRate << endl;
	cout << "\nEnter name on the credit card: ";
	getline(cin, custName);
	getline(cin, custName);
	cout << "\nEnter credit card number: ";
	cin >> ccNo;
	cout << "\nEnter expiration date: ";	
	cin >> ccExp;
	allSales.push_back(saleString);
	system.menu();
}

/*
* Function:		ContractSaleCheck::ContractSaleCheck
* Input:		none
* Output:		none
* Description:	Runs the Checks for Contractor sale.
*/
void ContractSaleCheck::ContractCheck() {
	string item;
	double price;
	double total = 0;
	string custName;
	int dlNo;
	saleString = "";
	double cashGiven = 0;
	int itemNo = 1;
	do {
		cout << "\nEnter item: ";
		cin >> item;
		if (item == "*")
			goto label;
		cout << "\nEnter amount: $" ;
		cin >> price;
		total += price;
		saleString += "\n" + IntToString(itemNo) + ". " + item + " $" + IntToString(price);
		itemNo++;
	} while (item != "*");
	label:
	double tax = total * (taxRate - 1);
	cout << "\nRegular Sale" << endl;
	cout << "\nSubtotal: $" << total << endl;
	cout << "\nTax: $" << tax << endl;
	cout << "\nTotal Amount: $" << total * taxRate << endl;
	cout << "\nEnter name on the check: ";
	getline(cin, custName);
	getline(cin, custName);
	cout << "\nEnter driver's license number: ";	
	cin >> dlNo;
	allSales.push_back(saleString);
	system.menu();
}

/*
* Function:		ContractSaleCash::ContractSaleCash
* Input:		none
* Output:		none
* Description:	Runs the Cash based Contractor sale.
*/
void ContractSaleCash::ContractCash() {
	string item;
	double price;
	double total = 0;
	double cashGiven = 0;
	saleString = "";
	int itemNo = 1;
	do {
		cout << "\nEnter item: ";
		cin >> item;
		if (item == "*")
			goto label;
		cout << "\nEnter amount: $" ;
		cin >> price;
		total += price;
		saleString += "\n" + IntToString(itemNo) + ". " + item + " $" + IntToString(price);
		itemNo++;
	} while (item != "*");
	label:
	double tax = total * (taxRate - 1);
	cout << "\nRegular Sale" << endl;
	cout << "\nSubtotal: $" << total << endl;
	cout << "\nTax: $" << tax << endl;
	cout << "\nTotal Amount: $" << total * taxRate << endl;
	cout << "\nAmount recieved: $";
	cin >> cashGiven;
	if (total * taxRate > cashGiven)
		cout << "That ain't gonna cut it, partner" << endl;
	else
		cout << "\nChange: $" << cashGiven - total * taxRate << endl;
	allSales.push_back(saleString);
	system.menu();
}

/*
* Function:		Sale::printAll
* Input:		none
* Output:		string
* Description:	Returns the sales in a string output from the vector.
*/
string Sale::printAll() {
	int saleNo = 1;
	for(vector<string>::const_iterator i = allSales.begin(); i != allSales.end(); ++i) {
		cout << "\nSale #" << saleNo << ": ";
		cout << *i << " " << endl;
		saleNo++;
	}
	system.menu();
	return "No";
}

/*
* Function:		System::menu
* Input:		none
* Output:		int
* Description:	Calls all the other Sale objects, this is the selection menu for the cash register.
*/
int System::menu() {
	int choice;
	cout << endl;
	cout << "	===============================================" << endl;
	cout << "	|           Welcome to Buy More!              |" << endl;
	cout << "	===============================================" << endl;
	cout << "\nSelect an option: (1) Regular Cash, (2) Regular Check, (3) Regular" << endl;
	cout << "Credit Card, (4) Contract Cash, (5) Contract Check, (6) Contract Credit" << endl;
	cout << "Card, (7) Print all sales, (8) Log off: ";
	cin >> choice;
	switch (choice) {
		case 1: {
			RegularSaleCash::RegularSaleCash sale;
			sale.RegularCash();
		}
		break;
		case 2: {
			RegularSaleCheck::RegularSaleCheck sale;
			sale.RegularCheck();
		}
		break;
		case 3: {
			RegularSaleCredit::RegularSaleCredit sale;
			sale.RegularCredit();
		}
		break;
		case 4: {
			ContractSaleCash::ContractSaleCash sale;
			sale.ContractCash();
		} 
		break;
		case 5: {
			ContractSaleCheck::ContractSaleCheck sale;
			sale.ContractCheck();
			return 0;
		}
		break;
		case 6: {
			ContractSaleCredit::ContractSaleCredit sale;
			sale.ContractCredit();
			return 0;
		}
		break;
		case 7: {
			Sale::Sale sale;
			sale.printAll();
			return 0;
		}
		break;
		case 8:
		cout << endl;
		cout << "	===============================================" << endl;
		cout << "	|        Thanks for using Buy More!           |" << endl;
		cout << "	===============================================" << endl;
		cout << endl;
		return 0;
		quit();
		break;
		default:
		cout << "That is not an option. Try again!\n" << endl;
		break;
	} 
	return 0;
}

/*
* Function:  	main
* Input:		none
* Output:		int
* Description:	Calls other functions. This is the main function!
*/
int main() {
	System::System system;
	system.menu();
}