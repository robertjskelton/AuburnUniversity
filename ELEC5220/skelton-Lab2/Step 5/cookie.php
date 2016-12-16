<?php
// Check to see if there's a username cookie set. 
if (isset($_COOKIE['username'])) {
// If cookie is set, display it. 
	echo "Welcome back $_COOKIE[username]! <br>";
}

else {
// Else, go to next page where you can login. 
	echo "Login required </br>
	<a href=\"multi_exercise.php\">multi_exercise.php</a>";
}
?>
