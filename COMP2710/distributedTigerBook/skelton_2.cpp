/** 
*
* Author: 		Robert Skelton
* Date 			10.28.13
* AU User Id: 	rjs0015
* Filename: 	skelton_2.cpp
* Email: 		robertjskelton@gmail.com
* Description:  This file is the entire Distributed TigerBook messaging system.
*
*/

#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <sstream>
using namespace std;

/* 
Initally declare functions  
*/

int quit();
int createUser();
int welcomeBanner(string userNameIn);
int timeStamp = 0;
int getTimeStamp();
int incTimeStamp();
int setTimeStamp();


/* 
Define Classes to be used
*/

/*
* Class:		User
* Input:		none
* Output:		none
* Description:	The User class holds many functions, strings, and vectors that each user will have access to.  
*/
class User {
public:
	User(string userNameIn); //
	User(); //
	int welcomeBanner(string userNameIn); //
	void addFriend(string userNameIn); // 
	string getName(); //
	bool isUser(string userNameIn); //
	vector<string> friendList; //
	string messageBuffer; // 
	int postMessage(); //
	int postTweet(); // 
	string fileName;
	int addFriend();
	int wall(); // 
	int menu(); //
	string getTweets();
	int home(); //
	string getPosts(string userIn);
	int addToAllUsers(string userIn);
	string getAllPosts();
	int addToAllPosts(string postsIn);
private:
	string name; //
};

/*
* Class:		System
* Input:		none
* Output:		none
* Description:	The System class holds all other functions not used in the User class. 
*/
class System {
public:
	System();
	string getAllUsers();
	bool isUser(string userNameIn);
};

/*
All Constuctors 
*/

/*
* Function:		User::User
* Input:		string userNameIn
* Output:		none
* Description:	This is the constructor for the User class. When a new User object is created, it will create a friendList vector and create a .txt file.
*/
User::User(string userNameIn) { // created a new User object
	name = userNameIn;
	User::addToAllUsers(name);
	ofstream outputStream;
	fileName = name + ".txt";
	outputStream.open(fileName.c_str());
}

/*
* Function:		User::User
* Input:		none
* Output:		none
* Description:	This is an empty constructor for the User class. Does pretty much nothing.
*/
User::User() { // empty constructor, just in case...
	name = "";
}

/*
* Function:		System::System
* Input:		none
* Output:		none
* Description:	This is an empty constructor for the System class.
*/
System::System() {

}

/* 
All functions defined 
*/

/*
* Function:		User::getAllPosts
* Input:		none
* Output:		string
* Description:	Reads in the allPostsByFriends.txt file.
*/
string User::getAllPosts() {
	ifstream inputStream;
	inputStream.open("allPostsByFriends.txt");
	string x = ""; 
	string next = "";

	// read file in and store in x
	while (inputStream >> x) 
		next = next + " " + x;
	return next;
}

/*
* Function:		User::addToAllPosts
* Input:		string postsIn
* Output:		int
* Description:	Appends a new string to the allPostsByFriends.txt file.
*/
int User::addToAllPosts(string postsIn) {
	string posts = getAllPosts();
	posts = "{[" + getName() + "]}" + postsIn + "\n" + posts;

	ofstream outputStream;
	string fileName = "allPostsByFriends.txt";
	outputStream.open(fileName.c_str());
	outputStream << posts << endl;
	return 0;
}


/*
* Function:		createUser
* Input:		none
* Output:		int
* Description:	Creates a User object for this program. Adds the user's name to allUsers vector and prints the Welcome Banner.
*/
int createUser() {
	string userName;
	cout << "\nPlease enter user name: ";
	getline(cin, userName);

	User::User user = User(userName);
	user.addToAllUsers(userName);
	cout << endl;
	welcomeBanner(userName);
	user.menu();
	return 0;
}

/*
* Function:		User::getName
* Input:		none
* Output:		string
* Description:	Returns the currentUser's name, which is a private string.
*/
string User::getName() {
	return name;
}

/*
* Function:		isUser
* Input:		string userNameIn
* Output:		bool
* Description:	Checks to see if userNameIn was ever created as a user. If so, userNameIn would have been stored in the allUser vector.
*				Returns true if the user exists, or false if the user does not exist.
*/
bool System::isUser(string userNameIn) {
	string users = System::getAllUsers();
	if (users.find(userNameIn) != string::npos) // if userNameIn is found in getAllUsers, return true
		return true;
	else 
		return false;
}

/*
* Function:		addFriend
* Input:		none
* Output:		int
* Description:	If isUser is true, adds that user to the current user's friendsList. 
*/
int User::addFriend() {
	string checkUser = "";
	cout << "Please enter friend's name: ";
	cin >> checkUser;
	System::System tester = System();
	if (tester.isUser(checkUser)) { 
		friendList.push_back(checkUser); // if user exists, then add to friendList vector
		cout << "=================================================================" << endl;
		cout << "|                    Added " << checkUser << " to Friend's List                     |" << endl;
		cout << "=================================================================" << endl;
	}
	else
		cout << "That user does not exist." << endl;
	User::menu();
	return 0;
}

/*
* Function:		User::home
* Input:		none
* Output:		int
* Description:	Shows all posts by your friends and all tweets by everyone.
*/
int User::home() {
	cout << "=================================================================" << endl;
	cout << "|                    " << getName() << "'s Home Page                          |" << endl;
	cout << "=================================================================" << endl;

	// read in all posts
	string allPosts = getAllPosts();
	int tPos1 = 0;
	int tPos2 = 0;
	int tPos3 = 0;
	int namePos1 = 0;
	int namePos2 = 0;
	int namePos3 = 0;
	string name = getName();

	// print out first user name
	namePos1 = (int) allPosts.find_first_of("{[");
	namePos2 = (int) allPosts.find("]}", namePos1 + 1);
	namePos3 = (int) allPosts.find("{[", namePos2 + 1);
	cout << allPosts.substr(namePos1 + 2, namePos2 - namePos1 - 2);
	cout << ": " << endl;

	tPos1 = (int) allPosts.find_first_of(name);
	tPos2 = (int) allPosts.find("{<", tPos1 + 2);
	if(tPos2 < 0)
		tPos2 = allPosts.length();
	int length = name.length();
	
	int pos1 = 0;
	int pos2 = 0;
	int pos3 = 0;
	pos1 = (int) allPosts.find("{<", pos1);
	pos2 = (int) allPosts.find(">}", pos1);
	pos3 = (int) allPosts.find("{<", pos2);
	//cout << endl;

	if (pos3 > 0) { // if there is more than one message
		namePos2 = namePos3;
		namePos1 = (int) allPosts.find("{[", namePos3);
		namePos2 = (int) allPosts.find("]}", namePos1 + 1);
	/*	cout << allPosts.substr(namePos1 + 2, namePos2 - namePos1 - 2);
		cout << ": " << endl;*/
		cout << allPosts.substr(pos2 + 2, namePos3 - pos2 - 2);
	}
	else {	// only message
		namePos2 = namePos3;
		namePos1 = (int) allPosts.find("{[", namePos3);
		namePos2 = (int) allPosts.find("]}", namePos1 + 1);
		/*cout << allPosts.substr(namePos1 + 2, namePos2 - namePos1 - 2);
		cout << ": " << endl;*/
		cout << allPosts.substr(pos2 + 2);
	}
	cout << endl;

	// print second message correctly
	if (pos3 > 0) {
		pos2 = pos3;
		pos2 = (int) allPosts.find(">}", pos3);
		pos3 = (int) allPosts.find("{<", pos2);
		namePos1 = (int) allPosts.find("{[", pos2);


		if (pos3 > 0) {
			cout << allPosts.substr(pos2 + 2, namePos1 - pos2 - 2);
			string ans = "";
			cout << "\n\n\t\t\tMore message? (yes/no) ";
			cin >> ans;

			if (ans == "yes") {
				while (pos3 > 0) {
					namePos2 = namePos3;
					namePos1 = (int) allPosts.find("{[", namePos3);
					namePos2 = (int) allPosts.find("]}", namePos1 + 1);
					cout << allPosts.substr(namePos1 + 2, namePos2 - namePos1 - 2);
					cout << ": " << endl;

					pos2 = pos3;
					pos2 = (int) allPosts.find(">}", pos3);
					pos3 = (int) allPosts.find("{<", pos2);
					namePos1 = (int) allPosts.find("{[", pos2);
					if (pos3 > 0)
						cout << allPosts.substr(pos2 + 2, namePos1 - pos2 - 2);
					else
						cout << allPosts.substr(pos2 + 2);
				}
			}
		}
		// if only 2 messages
		else
			cout << allPosts.substr(pos2 + 2);
	}

	cout << endl;
	cout << "=================================================================" << endl;
	cout << "|                  End of " << getName() << "'s Home Page                    |" << endl;
	cout << "=================================================================" << endl;
	User::menu();
	return 0;
}


/*
* Function:		User::wall
* Input:		none
* Output:		int
* Description:	Prints out all of the current user's messages and tweets.
*/
int User::wall() {
	cout << "=================================================================" << endl;
	cout << "|                    " << getName() << "'s Wall Page                          |" << endl;
	cout << "=================================================================" << endl;

	// read in tweets
	string allTweets = getTweets();
	int tPos1 = 0;
	int tPos2 = 0;
	int tPos3 = 0;
	string name = getName();
	tPos1 = (int) allTweets.find_first_of(name);
	tPos2 = (int) allTweets.find("{<", tPos1 + 2);
	if(tPos2 < 0)
		tPos2 = allTweets.length();
	int length = name.length();

	// show YOUR posts
	ifstream inputStream;
	string next = "";
	string allMsg = "";
	string fileName = User::getName() + ".txt";
	inputStream.open(fileName.c_str());
	string x;

	// read file in and store in x
	while (!inputStream.eof())
	{
		do {
			next = next + " " + x;
			inputStream >> x;
		} while (!inputStream.eof());
	}

	int pos1 = 0;
	int pos2 = 0;
	int pos3 = 0;
	pos1 = (int) next.find("{<", pos1);
	pos2 = (int) next.find(">}", pos1);
	pos3 = (int) next.find("{<", pos2);
	cout << endl;

	if (pos3 > 0) // if there is more than one message
		cout << next.substr(pos2 + 2, pos3 - pos2 - 2);
	else	// only message
		cout << next.substr(pos2 + 2);
	cout << endl;


	// print second message correctly
	if (pos3 > 0) {
		pos2 = pos3;
		pos2 = (int) next.find(">}", pos3);
		pos3 = (int) next.find("{<", pos2);

		if (pos3 > 0) {
			cout << next.substr(pos2 + 2, pos3 - pos2 - 2);
			string ans = "";
			cout << "\n\n\t\t\tMore message? (yes/no) ";
			cin >> ans;

			if (ans == "yes") {
				while (pos3 > 0) {
					pos2 = pos3;
					cout << endl;
					pos2 = (int) next.find(">}", pos3);
					pos3 = (int) next.find("{<", pos2);
					if (pos3 > 0)
						cout << next.substr(pos2 + 2, pos3 - pos2 - 2);
					else
						cout << next.substr(pos2 + 2);
				}
			}
		}
		// if only 2 messages
		else
			cout << next.substr(pos2 + 2);
}

	cout << endl;
	cout << "=================================================================" << endl;
	cout << "|                  End of " << getName() << "'s Wall Page                    |" << endl;
	cout << "=================================================================" << endl;
	User::menu();
	return 0;
}

/*
* Function:		User::postMessage
* Input:		none
* Output:		int
* Description:	Adds a new tweet to the current users message file in the correct format, and increments the time stamp. 
*				Prints a banner if successful.
*/
int User::postMessage() {
	string userName = User::getName();
	string fileName = userName + ".txt";
	string origPosts = User::getPosts(userName);

	int pos, pos1;
	int npos = -1;

	string wallPost = "";
	string message = "";
	cout << "Enter message: ";
	do {
		getline(cin , wallPost);
		pos = wallPost.find("{<");
		pos1 = wallPost.find(">}");
		if (pos != npos || pos1 != npos) // This is so you can't input fatal brackets as a message.
			cout << "Please don't use {< or >} in your message. Try again." << endl;
		else if (wallPost != "!!")
			message += wallPost + "\n";
	} while (wallPost != "!!"); 

	// you have to do all this just to print with the timestamp.
	stringstream ss;
	ss << getTimeStamp();
	string str = ss.str(); // so str is the timeStamp in string format
	message = string("{<") + string(str) + string(">}") + message;
	incTimeStamp(); // increment the timeStamp by 1
	messageBuffer = message + "\n" + messageBuffer;

	// print to file
	ofstream outputStream;
	outputStream.open(fileName.c_str());
	outputStream << messageBuffer << endl;
	addToAllPosts(message);

	cout << "=================================================================" << endl;
	cout << "|                         New message added                     |" << endl;
	cout << "=================================================================" << endl;
	User::menu();
	return 0;
}

/*
* Function:		User::getTweets
* Input:		none
* Output:		string
* Description:	Stores the entire string of tweets.txt into a string and returns that string. Used when writing to the tweets.txt file to maintain old tweets.
*/
string User::getTweets() {
	ifstream inputStream;
	inputStream.open("tweet.txt");
	string x = ""; // string to store timeStamp into
	string next = "";

	// read file in and store in x
	while (inputStream >> x) 
		next = next + " " + x;
	return next;
}

/*
* Function:		User::getPosts
* Input:		none
* Output:		string
* Description:	Stores the entire string of tweets.txt into a string and returns that string. Used when writing to the tweets.txt file to maintain old tweets.
*/
string User::getPosts(string userIn) {
	ifstream inputStream;
	string fileName = userIn + ".txt";
	inputStream.open(fileName.c_str());
	string x = ""; 
	string next = "";

	// read file in and store in x
	while (inputStream >> x) 
		next = next + " " + x;
	return next;
}

/*
* Function:		getAllUsers
* Input:		none
* Output:		string
* Description:	Returns the allUsers.txt file as a string. 
*/
string System::getAllUsers() {
	ifstream inputStream;
	inputStream.open("allUsers.txt");
	string x = ""; 
	string next = "";

	while (inputStream >> x) 
		next = next + " " + x;
	return next;
}

/*
* Function:		addToAllUsers
* Input:		string userIn
* Output:		int
* Description:	Adds a new user string to the allUsers.txt file.
*/
int User::addToAllUsers(string userIn) {
	System system = System();
	string old = system.getAllUsers();
	ofstream outputStream;
	outputStream.open("allUsers.txt");
	if (old.find(userIn) != -1) // make sure you don't add same user to allUsers.txt file
		cout << "That user is already contained in allUsers. It will not be added again." << endl;
	else
		old = old + " " + userIn;
	outputStream << old << endl;
	return 0;
}

/*
* Function:		User::postTweet
* Input:		none
* Output:		int
* Description:	Adds a new tweet to the tweet.txt file in the correct format, and increments the time stamp. Prints a banner if successful.
*/
int User::postTweet() {
	string tweet = "";
	string message = "";
	int pos, pos1, pos2, pos3, npos = -1;
	string allTweets = getTweets();
	cout << "Enter message: ";
	do {
		getline(cin , tweet);
		pos = tweet.find("{<");
		pos1 = tweet.find(">}");
		pos2 = tweet.find("]}");
		pos3 = tweet.find("{[");
		if (pos != npos || pos1 != npos || pos2 != npos || pos3 != npos) // make sure there is no illegal brackets in your program
			cout << "Please don't use {< or >} or {[ or ]}in your tweet. Try again." << endl;
		else if (tweet != "!!")
			message += tweet + "\n";
	} while (tweet != "!!");

	// you have to do all this just to print with the timestamp.
	stringstream ss;
	ss << getTimeStamp();
	string str = ss.str();
	string message1 = ""; // so you can write to userName.txt
	message1 = string("{<") + string(str) + string(">}") + message;
	message = string("{<") + string(str) + string(">}") + "{[" + User::getName() + "]}" + message;
	incTimeStamp(); // increment the timeStamp by 1

	// print to file
	ofstream outputStream;
	outputStream.open("tweet.txt");
	outputStream << message << allTweets << endl;
	outputStream.close();

	// write to userName.txt also
	string userName = User::getName();
	string fileName = userName + ".txt";
	ofstream outputStreamq;
	outputStreamq.open(fileName.c_str());
	string posts = getPosts(userName);
	posts = message1 + " " + posts;
	messageBuffer = message1 + "\n" + messageBuffer;
	outputStreamq << messageBuffer <<  endl;
	addToAllPosts(message1);

	cout << "=================================================================" << endl;
	cout << "|                       New message tweeted                     |" << endl;
	cout << "=================================================================" << endl;
	User::menu();
	return 0;
}

/*
* Function:		introBanner
* Input:		none
* Output:		int
* Description:	Prints a welcome banner when Tiger Book is started.
*/
int introBanner() {
	cout << "=================================================================" << endl;
	cout << "|                 Distributed Tiger Book System!                |" << endl;
	cout << "=================================================================" << endl;
	return 0;
}

/*
* Function:		getTimeStamp
* Input:		none
* Output:		int
* Description:	Returns the current value of timeStamp, since timeStamp is a private variable.
*/
int getTimeStamp() {
	ifstream inputStream;
	inputStream.open("timeStamp.txt");
	string x = ""; // string to store timeStamp into

	// read file in and store in x
	while (!inputStream.eof())
	{
		do {
			inputStream >> x;
		} while (!inputStream.eof());
	}

	int result; // number which will contain the result
	stringstream convert(x); // stringstream used for the conversion 
	if (!(convert >> result)) // give the value to result using the characters in the string
	    result = 0; // if that fails set Result to 0
	return result;
}

/*
* Function:		setTimeStamp
* Input:		int in
* Output:		int
* Description:	Sets the timeStamp to whatever the integer input is, used in conjunction with incTimeStamp.
*/
int setTimeStamp(int in) {
	ofstream outputStream;
	outputStream.open("timeStamp.txt");
	outputStream << in << endl;
	return 0;
}

/*
* Function:		incTimeStamp
* Input:		none
* Output:		int
* Description:	Reads the timeStamp and increments it by one.
*/
int incTimeStamp() {
	int increment = getTimeStamp();
	increment++;
	setTimeStamp(increment); 
	return increment;
}

/*
* Function:		quit
* Input:		none
* Output:		int
* Description:	Outputs a thank you banner, and ends the program cleanly.
*/
int quit() {
	cout << "=================================================================" << endl;
	cout << "|               Thank you for using TigerBook                   |" << endl;
	cout << "=================================================================" << endl;

return 0;
//exit;
}

/*
* Function:		welcomeBanner
* Input:		string userNameIn
* Output:		int
* Description:	Prints a banner welcoming the new user to the TigerBook app.
*/
int welcomeBanner(string userNameIn) {
	cout << endl;
	cout << "=================================================================" << endl;
	cout << "|      Welcome to Distributed Tiger Book System, " << userNameIn << "          |" << endl;
	cout << "=================================================================" << endl;
	return 0;
}

/*
* Function:		main
* Input:		none
* Output:		int
* Description:	This is the main driver program, and calls other Objects and functions. 
*/
int main() {
	string tweetFile =  "tweet.txt";
	// there must already be a file called timeStamp.txt or else the program will fail

	introBanner();
	string userName;

	do {
		cout << "\nPlease enter user name: ";
		getline(cin, userName);

	// checks for making sure illegal characters are not in the username
		if (userName.find("{[") < 100) 
			cout << "You cannot use the characters {[ in your userName. Please try again." << endl;
		if (userName.find("]}") < 100)
			cout << "You cannot use the characters ]} in your userName. Please try again." << endl;
		if (userName.find("{<") < 100)
			cout << "You cannot use the characters {< in your userName. Please try again." << endl;
		if (userName.find(">}") < 100)
			cout << "You cannot use the characters >} in your userName. Please try again." << endl;
	} while ((userName.find("{[") < 100) || (userName.find("]}") < 100) || (userName.find(">}") < 100) || (userName.find("{<") < 100));

User::User user = User(userName); 
welcomeBanner(userName);
cout << endl;
user.menu();
return 0;
}

/*
* Function:		User::menu
* Input:		none
* Output:		int
* Description:	This is a menu that is called recursively, which determines the overall flow of the program.
*/
int User::menu() {
	char option;
	cout << "Add Friend (f), Post (p), Tweet (t), Wall (w), Home (h), Quit (q)" << endl;
	cout << "Enter option: ";
	cin >> option;

	switch (option) {
		case 'q':
		case 'Q':
			quit();
			//exit;
			return 0;
			break;
		case 'f':
		case 'F':
			addFriend();
			break;
		case 'p':
		case 'P':
			postMessage();
			break;
		case 't':
		case 'T':
			postTweet();
			break;
		case 'w':
		case 'W': 
			wall();
			break;
		case 'h':
		case 'H':
			home();
			break;
		default:
			cout << "That is not an option. Try again!\n" << endl;
			menu();
	} 
	return 0;
}