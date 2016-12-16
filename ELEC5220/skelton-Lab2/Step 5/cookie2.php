<?php
// Check to see if user has been set
if(@isset($_POST['username'])) {
	// set username and password
	$username = $_POST['username'];
	$password = $_POST['password'];

	//connect to the mysql db called cd_store on localhost
	$dbcnx = mysql_connect("localhost", "bob","bob") or die("Could not connect to the database server.");
	mysql_select_db("cd_store",$dbcnx) or die("Can not select database");

	// mysql query to retrieve database information from table labtwo
	$query = "SELECT password FROM labtwo WHERE username=\"$username\"";
	
	// Remove slashes 
	$query = stripslashes($query);
	
	// Run query
	$result = mysql_query($query) or die(mysql_error());
	
	//Save row as an array
	$db_result = mysql_fetch_row($result);

	// see if password entered is in the database
	if($password == $db_result[0]) {
		//if so set a new cookie username for 1 hour
		setcookie("username", $username, time()+3600);
		//return to the test page
		echo "Login is successful, Please visit 
		<a href=\"cookie.php\">cookie.php</a>";
	}
	
	else {
		//otherwise the login was unsuccessful
		echo "Login was incorrect. Please try again <br>";
		//link to reload page
		echo "<a href= \"$_SERVER[PHP_SELF]\">login</a><br>";

		//Form for the user to enter their username and password
		echo "Username:<br>
		<form action=\"$_SERVER[PHP_SELF]\" method=\"post\">
			<input type=\"text\" name=\"username\"> <br>
			Password:<br>
			<input type=\"password\" name=\"password\"> <br>
			<input type=\"submit\" value=\"Submit\"></form>";
		}
	}
	else {
		// form to enter username and password, then submit it. 
		echo "Username:<br>
		<form action=\"$_SERVER[PHP_SELF]\" method=\"post\">
			<input type=\"text\" name=\"username\"> <br>
			Password:<br>
			<input type=\"password\" name=\"password\"> <br>
			<input type=\"submit\" value=\"Submit\"></form>";
		}
		?>