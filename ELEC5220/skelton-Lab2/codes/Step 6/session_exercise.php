<?php
// start the session
session_start();

// if a name has been passed
if (@isset($_GET[name1]))
{
	//Create array with all 3 names
	$names=array(@$_GET[name1],@$_GET[name2],@$_GET[name3]);
	//put that array into the session
	$_SESSION['names'] = $names;
	//Display all names
	echo "Welcome ";
	print($_SESSION['names'][0]);
	echo "<br>Welcome ";
	print($_SESSION['names'][1]);
	echo "<br>Welcome ";
	print($_SESSION['names'][2]);
}
else // Print out the input form to get 3 names as input
{
	echo "<form action=\"$_SERVER[PHP_SELF]\" method=\"GET\">
	Name 1:
	<input type=\"text\" name=\"name1\">
	<br>
	Name 2:
	<input type=\"text\" name=\"name2\">
	<br>
	Name 3:
	<input type=\"text\" name=\"name3\">
	<br>
	<input type=\"submit\" value=\"Submit\">
	</form>";
}

// Print some information about the variable 
// $_SESSION
echo "- - - - - - - - - - - - - - <br>";
echo "Sessions: <pre>";
print_r($_SESSION);
echo "</pre>";
echo "Your session ID: ";
print_r(session_id());
?>
