#include "User.h"

/*
* Function:		User constructor with parameters
* Input:		string userNameIn
* Output:		none
* Description:	Creates a User object with the name set as userNameIn.
*/
User::User(string userNameIn) { // created a new User object
	name = userNameIn;
	friendList.push_back(userNameIn); // user will be first element in his friendList vector
	
}

/*
* Function:		User
* Input:		none
* Output:		none
* Description:	Empty user constructor, just in case...
*/
User::User() { // empty constructor, just in case...
	name = "";
}

/* All Functions */

/*
* Function:		addFriend
* Input:		string userNameIn
* Output:		void, no output
* Description:	Adds a friend to the current users friendList.
*/
void User::addFriend(string userNameIn) {

		friendList.push_back(userNameIn);
}

/*
* Function:		setName
* Input:		string userNameIn
* Output:		void, no output
* Description:	Set the current users name.
*/
void User::setName(string userNameIn) {
	name = userNameIn;	
}

/*
* Function:		getName
* Input:		none
* Output:		string name
* Description:	Returns the current users name.
*/
string User::getName() {
	return name;
}