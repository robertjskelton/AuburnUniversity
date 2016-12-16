<?php
// Start the session and register the variables
session_start();
// print the 3 names entered on the previous page
echo "Hello ";
print($_SESSION['names'][0]);
echo "<br>Hello ";
print($_SESSION['names'][1]);
echo "<br>Hello ";
print($_SESSION['names'][2]);

// Print some information about the variable
// $_SESSION
echo "- - - - - - - - - - - - - - <br>";
echo "Sessions: <pre>";
print_r($_SESSION);
echo "</pre>";
echo "Your session ID: ";
print_r(session_id());
?>

