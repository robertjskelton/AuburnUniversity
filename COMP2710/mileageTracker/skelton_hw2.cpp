/** 
*
* Author: 		Robert Skelton
* Date 			11.4.13
* AU User Id: 	rjs0015
* Filename: 	skelton_hw2.cpp
* Email: 		robertjskelton@gmail.com
* Description:  This file is a MPG tracker system for a car. 
*
*/

using namespace std;
#include <iostream>
#include <string>


/* 
* Define Classes to be used
*/

class MileageTracker {
public:
	MileageTracker();
	int setMilesZero();
	int setMPG();
	int setFuelPrice();
	int addMiles();
	int getAll();
	double getMiles();
	double getMPG();
	double getFuelPrice();
	int setMiles(double milesIn);
private:
	double miles;
	double MPG;
	double fuelPrice;
};

class Menu {
public:
	Menu();
	MileageTracker::MileageTracker mileageTracker;
	int switchCase();
	int getSwitchCaseResponse();
	int quit();
private:
	int choice;
};

class System {
public:
	System();
	Menu::Menu menu;
	string getName();
	int setName();
private:
	string userName;
};

/*
* All Constuctors 
*/
MileageTracker::MileageTracker() {
	miles = 0;
	MPG = 0;
	fuelPrice = 0;
}

Menu::Menu() {
	MileageTracker::MileageTracker mileageTracker;
}

System::System() {
	Menu::Menu menu;
}

/*
* All Functions
*/
int MileageTracker::setMilesZero() {
	miles = 0.0;
	cout << "	The odometer is reset to 0" << endl;

/*	cout << "The MPG are: " << getMPG() << endl;
	cout << "The fuel price is: " << getFuelPrice() << endl;
	cout << "The total miles is: " << getMiles() << endl;*/

	cout << endl;
}

int MileageTracker::setMPG() {
	cout << "Enter the fuel efficiency in miles per gallon: ";
	cin >> MPG;

/*	cout << "The MPG are: " << getMPG() << endl;
	cout << "The fuel price is: " << getFuelPrice() << endl;
	cout << "The total miles is: " << getMiles() << endl;*/

	cout << endl;
}

int MileageTracker::setFuelPrice() {
	cout << "Enter the fuel price per gallon: ";
	cin >> fuelPrice;

/*	cout << "The MPG are: " << getMPG() << endl;
	cout << "The fuel price is: " << getFuelPrice() << endl;
	cout << "The total miles is: " << getMiles() << endl;*/

	cout << endl;
}

double MileageTracker::getMiles() {
	return miles;
}

double MileageTracker::getMPG() {
	return MPG;
}

double MileageTracker::getFuelPrice() {
	return fuelPrice;
}

int MileageTracker::addMiles() {
	cout << "Enter miles driven for a trip: ";
	double milesIn;
	double currentMiles = getMiles();
	cin >> milesIn;
	currentMiles += milesIn;
	setMiles(currentMiles);

/*	cout << "The MPG are: " << getMPG() << endl;
	cout << "The fuel price is: " << getFuelPrice() << endl;
	cout << "The total miles is: " << getMiles() << endl;*/

	cout << endl;
}

int MileageTracker::setMiles(double milesIn) {
	miles = milesIn;
}

int MileageTracker::getAll() {

	double gallons = getMiles() / getMPG();
	double cost = gallons * getFuelPrice();
	cout << "Total miles travelled: " << getMiles() << " miles" << endl;

	// used to only show first two digits after the decimal.
	cout.setf(ios::fixed);
	cout.setf(ios::showpoint);
	cout.precision(2);

	cout << "Number of gallons consumed: " << gallons << " gallons" << endl;
	cout << "Total cost of gasoline: $" << cost << endl;
	cout << endl;
}



int Menu::getSwitchCaseResponse() {
	return choice;
}

int Menu::quit() {
	cout << "	**** Good-bye **** " << endl;
	return 0;
}

string System::getName() {
	return userName;
}
int System::setName() {
	cout << "What is your name? ";
	cin >> userName;
}

int main() {
	System::System system;
	system.setName();
	cout << "*** Welcome to " << system.getName() << "'s Mileage Tracker *** " << endl;
	cout << endl;
	system.menu.switchCase();
	system.menu.mileageTracker.getMiles();
}

int Menu::switchCase() {
	int choice;
	cout << "1) Reset the odometer" << endl;
	cout << "2) Set the fuel efficiency in miles per gallon" << endl;
	cout << "3) Set the fuel price per gallon" << endl;
	cout << "4) Enter miles driven for a trip" << endl;
	cout << "5) Print the total miles, number of gallons, and cost of gasoline" << endl;
	cout << "6) Quit" << endl;
	cout << "Select an option: ";
	cin >> choice;

	// this is where the required loop is located.
	while (choice < 7 && choice > 0) {
	switch (choice) {
		case 1:
			mileageTracker.setMilesZero();
			switchCase();	
			break;
		case 2:
			mileageTracker.setMPG();
			switchCase();
			break;
		case 3:
			mileageTracker.setFuelPrice();
			switchCase();
			break;
		case 4:
			mileageTracker.addMiles();
			switchCase();
			break;
		case 5: 
			mileageTracker.getAll();
			switchCase();
			mileageTracker.getMiles();
			break;
		case 6:
			quit();
			break;
		default:
			cout << "That is not an option. Try again!\n" << endl;
			switchCase();
		}
	} 
}