<html>
<head>
	<title>Breed Lookup Search Results</title>
</head>
<body>
	<?php
	// Connect to the mySQL server and select our database
	$dbcnx = mysql_connect("localhost", "joe","joe") or die("Could not connect to the database server.");
	mysql_select_db("pet_store",$dbcnx) or die("Can not select database");
	$query = "SELECT species,breed,quantity,price,weight FROM animals WHERE breed=\"$_POST[breed_input]\" ";
	$query = stripslashes($query);
	$result = mysql_query($query) or die(mysql_error());
	$number_cols = mysql_num_fields($result);
	// Set up the initial table and header rows
	// This is the the database before it is updated. 
	echo "<table border=\"1\" cellspacing=\"0\" cellpadding=\"5\"><tr><td>Species</td><td>Breed</td><td>Quantity</td><td>Price</td><td>Weight</td></tr>";
	while ($row = mysql_fetch_row($result))
	{
		echo "<tr>";
		for ($i=0; $i<$number_cols; $i++)
		{
			echo "<td>$row[$i]</td>";
		}
		echo "</tr>";
	}
	// Change the weight of the dog you typed in. 
	$query = "UPDATE animals SET weight = \"$_POST[weight]\" WHERE breed=\"$_POST[breed_input]\";";

	//$query = "SELECT species,breed,quantity,price FROM animals WHERE breed=\"$_GET[breed_input]\" ";
	// We needed the slashes (\) to go with the PHP syntax, but
	// to actually complete the query we need to get rid of them.
	$query = stripslashes($query);
	// Actually run the query
	$result = mysql_query($query) or die(mysql_error());

	$query = "SELECT species,breed,quantity,price,weight FROM animals WHERE breed=\"$_POST[breed_input]\" ";
	$query = stripslashes($query);
	$result = mysql_query($query) or die(mysql_error());
	// Return how many fields we selected with our *
	$number_cols = mysql_num_fields($result);
	// Set up the initial table and header rows
	// This is the the database after it is updated. 
	echo "<table border=\"1\" cellspacing=\"0\" cellpadding=\"5\"><tr><td>Species</td><td>Breed</td><td>Quantity</td><td>Price</td><td>Weight</td></tr>";
	while ($row = mysql_fetch_row($result))
	{
		echo "<tr>";
		for ($i=0; $i<$number_cols; $i++)
		{
			echo "<td>$row[$i]</td>";
		}
		echo "</tr>";
	}
	?>
</body>
</html>