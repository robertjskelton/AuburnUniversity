/** 
*
* Author: 		Robert Skelton
* Date 			10.7.13
* AU User Id: 	rjs0015
* Filename: 	skelton_hw1.cpp
* Email: 		robertjskelton@gmail.com
* Description:  This file is the entire TigerBook messaging system.
*
*/

#include <iostream>
#include <string>
#include <vector>
#include "User.h"

using namespace std;

/* Fuctions used throughtout the program */
void switchCase();
void createUser();
void addToWall(string wallPost);
void addTweet();
void addFriend();
void showHome();
void showWall();
bool switchUser();
bool isUser(string userNameIn);
int quit();

/* Things to use throughout the program*/
string messageBuffer = "";
string friendToAdd = ""; // userName to check if contained in friendToAdd
string userName = ""; 
vector<string> allUsers;
string currentuser;


/* the main driver for TigerBook that calls other methods */
/*
* Function:		main
* Input:		none
* Output:		int 0 or 1, depending on how the program runs
* Description:	Runs everything in the TigerBook Messaging System.
*/
int main() {
	
	cout << "=================================================================" << endl;
	cout << "|             The TigerBook Messaging System!                   |" << endl;
	cout << "=================================================================" << endl;
	switchCase();

}

/* create a new user */
/*
* Function:		createUser
* Input:		none
* Output:		void, no output
* Description:	Creates a new user object, add that user to allUsers, and prints a welcome banner.
*/
void createUser() {
	cout << "Please enter user name: ";
	cin >> userName;
	cout << "=================================================================" << endl;
	cout << "|             Welcome to TigerBook, " << userName << "!                     |" << endl;
	cout << "=================================================================" << endl;

	allUsers.push_back(userName); 
	currentuser = userName;
	switchCase();
}

/* add a known friend */
/*
* Function:		addFriend
* Input:		none
* Output:		void, no output
* Description:	Adds a friend to the current users friendList after checking if the friend to add is a valid user.
*/
void addFriend() {
	cout << "Enter friend's name: ";
	cin >> friendToAdd;
	if(isUser(friendToAdd)) {
		//user.addFriend(friendToAdd);
		cout << friendToAdd << " was added as a friend!" << endl;
	}
	else
		cout << "That user does not exist." << endl;
	
	switchCase();
}

/*
* Function:		addToWall
* Input:		none
* Output:		void, no output
* Description:	Adds a post to the messageBuffer.
*/
void addToWall() {
	string wallPost = "";
	string message = "";
	cout << "Enter message: ";
	do {
		cin.clear();	
		cin.ignore(1000, '\n');
		cin >> wallPost;
		if (wallPost != "!!")
			message += wallPost + "\n";

	} while (wallPost != "!!");
	messageBuffer = "{[" + currentuser + "]}" + message + messageBuffer;
	switchCase();
}

/*
* Function:		addTweet
* Input:		none
* Output:		void, no output
* Description:	Add a new tweet to the messageBuffer.
*/
void addTweet() {
	string tweet = "";
	string message = "";
	cout << "Enter tweet message: ";
	do {
		cin.clear();
		cin.ignore(1000, '\n');
		cin >> tweet;
		if (tweet != "!!")
			message += tweet + "\n";
	} while (tweet != "!!");
	messageBuffer = "{[" + currentuser + "::tweet]}" + message + messageBuffer;
	switchCase();
}

/*
* Function:		showWall
* Input:		none
* Output:		void, no output
* Description:	Outputs all posts by the currentuser.
*/
void showWall() {
	int pos1 = 0;
	int pos2 = 0;
	int pos3 = 0;
	pos1 = (int) messageBuffer.find(currentuser, pos1);
	pos2 = (int) messageBuffer.find("]}", pos1);
	int msgLen = (int) messageBuffer.find("{[", pos2) - pos2 - 2;
	pos3 = (int) messageBuffer.find("{[", pos2);
	if(pos3 == -1) {
		pos3 = messageBuffer.length();
		//cout << messageBuffer.substr(pos1 + 2, pos2 - 2) << ": " << messageBuffer.substr(pos2 + 2, pos3) << endl;
		//cout << "There is only one message to be printed." << endl;
	}
	cout << messageBuffer.substr(pos2 + 2, msgLen);
	//cout << messageBuffer.substr(pos1 + 2, pos2 - 2) << ": " << messageBuffer.substr(pos2 + 2, pos3) << endl;
	//cout << "There is two messages to be printed. " << endl;
	pos1 = pos3 - 1;
	pos2 = pos3 ;
	pos3 = 0;
	pos1 = messageBuffer.find("{[", pos1);
	pos2 = messageBuffer.find("]}", pos2);
	pos3 = messageBuffer.find("{[", pos2);
	//cout << messageBuffer.substr(pos1 + 2, pos2 - 2) << ": " << messageBuffer.substr(pos2 + 2, pos3) << endl;

	if(pos3 == -1) {
		pos3 = messageBuffer.length();
		//cout << "There are two messages to be printed." << endl;
		//cout << messageBuffer.substr(pos1 , pos2 - 2) << ": " << messageBuffer.substr(pos2 + 2, pos3) << endl;
		switchCase();
	}

	//cout << messageBuffer.substr(pos1 + 2, pos2 -2) << ": " << messageBuffer.substr(pos2 + 2, pos3) << endl;
	//print first two messages
	//cout << messageBuffer;
	string ans = "";
	cout << "More message? (yes/no):";
	cin >> ans;
	if(ans == "yes") {
	//print more messages
		switchCase();
	}
	else
		switchCase();
}

/* show all the posts and tweets on your home page */
/*
* Function:		showHome
* Input:		none
* Output:		void, no output
* Description:	Outputs all posts and tweets by the currentusers friends.
*/
void showHome() {
	int pos1 = 0;
	int pos2 = 0;
	int pos3 = 0;
	int pos4 = 0;
	pos1 = (int) messageBuffer.find("{[", pos1 + 1);
	pos2 = (int) messageBuffer.find("]}", pos2 + 1);
	pos3 = (int) messageBuffer.find_first_not_of("{[", pos3 + 1);
	pos4 = (int) messageBuffer.find_last_not_of("]}", pos4 + 1);
	int counter = 0; // use to know when to stop printing first two messages
	// print first two messages

	string ans = "";
	cout << "More message? (yes/no):";
	cin >> ans;
	if(ans == "yes")
	{
		//print more messages
		cout << "I'll print more messages, " << currentuser << endl;
		switchCase();
	}
	else
		switchCase();
	cout << messageBuffer;
}

/* switch to a different user */
/*
* Function:		switchUser
* Input:		none
* Output:		bool, a true or false
* Description:	Switches to a different user. Checks if user exists in allUsers, and if so, switches and returns true.
*/
bool switchUser() {
	string userNameIn;
	cout << "Enter user's name: ";
	cin >> userNameIn;

// removed if/else becuase it did not compile on linux. was testing on unix before? not sure why it gave vector error
	for(vector<string>::iterator it = allUsers.begin(); it != allUsers.end(); ++it) {
		if(*it == userNameIn) {
			cout << "=================================================================" << endl;
			cout << "|             Welcome back to TigerBook, " << userNameIn << "!                  |" << endl;
			cout << "=================================================================" << endl;
			currentuser = userNameIn;
			switchCase();

		}
		else {
			cout << userNameIn << " is not a user!" << endl;
			switchCase();
		}
	}
	return false;
	
}

/* ends the program gracefully */
/*
* Function:		quit
* Input:		none
* Output:		int, returns 0 always
* Description:	Prints an exit banner and exits gracefully.
*/
int quit() {
	cout << endl;
	cout << "=================================================================" << endl;
	cout << "|               Thank you for using TigerBook                   |" << endl;
	cout << "=================================================================" << endl;
	return 0;
}

/* provides the directories for TigerBook */
/*
* Function:		switchCase
* Input:		none
* Output:		void, no output
* Description:	Creates the main menu functions for TigerBook. Calls the correct function when needed.
*/
void switchCase()
{
	cout << "\n1) Create a new user" << endl;
	cout << "2) Post a message" << endl;
	cout << "3) Tweet a message" << endl;
	cout << "4) Display Wall Page" << endl;
	cout << "5) Display Home Page" << endl;
	cout << "6) Add a friend" << endl;
	cout << "7) Switch to a different user" << endl;
	cout << "8) Quit TigerBook" << endl;
	cout << "\nPlease choose an option: ";
	int ans = 0;
	cin >> ans;
	if ((ans > 0) && (ans < 9)) {
		switch (ans) {
			case 1:
				createUser();
				break;
			case 2:
				addToWall();
				break;
			case 3:
				addTweet();
				break;	
			case 4:
				showHome();
				break;
			case 5:
				showWall();
				break;
			case 6:
				addFriend();
				break;
			case 7:
				switchUser();
				break;
			case 8:
				quit();
				break;
			default:
				cout << "That is an invalid input. Try again." << endl;
		}
	}
	else {
		cout << "That is an invalid input. Try again." << endl;
		ans = 0;
		switchCase();
	}
}

/*
* Function:		isUser
* Input:		string userNameIn
* Output:		bool, returns a true or false
* Description:	Checks to see if userNameIn is a valid user contained in allUsers.
*/
bool isUser(string userNameIn) {
// removed if/else becuase it did not compile on linux. was testing on unix before? not sure why it gave vector error

	//if(find(allUsers.begin(), allUsers.end(), userNameIn) != allUsers.end())
	for(vector<string>::iterator it = allUsers.begin(); it != allUsers.end(); ++it) {
		if(*it == userNameIn)
			return true;
				else 
			return false;
		
	}
}
