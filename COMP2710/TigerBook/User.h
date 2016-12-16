#ifndef USER_H
#define USER_H
#include <iostream>
#include <vector>
#include <string>
using namespace std;

/*
* Function:		User
* Input:		none
* Output:		none
* Description:	All public and private methods and strings used by a User object.
*/
class User {
	public:
		User(string userNameIn); 
		User(); 
		void addFriend(string userNameIn);
		string getName(); 
		void setName(string userNameIn);
		bool isUser(string userNameIn); 
		vector<string> friendList;

	private:
		string name;
};

#endif