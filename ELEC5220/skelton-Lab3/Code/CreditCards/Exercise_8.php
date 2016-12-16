<?php
//disable notice
error_reporting(E_ALL ^ E_NOTICE);

echo "<html><head><title>Exercise 8: Number Checke</title></head><body>";
// get current date
$date = getdate();
// setup vars with info
$month = $date["mon"];
$year = $date["year"];
echo "Today's Date: $month/$year<br>";
echo "Expiration Date: $_POST[month]/$_POST[year]<br>";
echo "Credit Card Type: $_POST[type]<br>";
echo "Credit Card Number: $_POST[number]<br>";

if (check_for_exp($_POST["month"],$_POST["year"]) == 0)
	echo "<h3>Your Credit Card Has Expired!</h3><br>\n";
else
	echo "<h3>Your credit card expiration date is valid.";

if (check_card_number($_POST["number"],$_POST["type"]) == 0)
	echo "<h3>Your Credit Card Number Is Not Valid!</h3><br>\n";
else
	echo "<h3>Your credit card number is valid.";

echo "</body></html>";

// check to see if CC is expired
function check_for_exp($month,$year) {
	// get current date
	$date = getdate();
	// setup vars with info
	$current_month = $date["mon"];
	$current_year = $date["year"];

	// if year is old return 0
	if ($year < $current_year) return 0;

	// if year is current and month is bad return 0
	else if ($month < $current_month && $current_year == $year) return 0;

	return 1;
}

// check card number range and luhn
function check_card_number($number,$type) {
	// turn the number into a string
	$n = "$number";
	// c is the length, used multiple times below
	$c = strlen($n);
	// switch on type of CC
	switch ($type) {
		// check visa for starting 4
		case 'Visa':
		if ($number[0] == 4 && ($c==16 || $c == 13)) break;
		else return 0;
		break;
		// check mastercard for starting 51-55
		case 'MasterCard':
		if ($number[0] == 5 && $number[1] < 6 && $number[1] > 0 && $c == 16) break;
		else return 0;			
		break;
		// check discover for starting 6011
		case 'Discover':
		if ($number[0] == 6 && $number[1] == 0 && $number[2] == 1 && $number[3] == 1 && $c == 16) break;
		else return 0;
		break;
		// starts with 34 or 37, 15 digits
		case 'Amex':
		if ($number[0] == 3 && ($number[1] == 4 || $number[1] == 7) && ($c == 15)) break;
		else return 0;
		default:
		return 0;
	}

	// dummy
	$t = 1;
	// loop from the right to left
	for($i = ($c - 1); $i >= 0; $i--)
	{
		// mult. by 1 or 2
		$temp = $n[$i] * $t;
		// toggle between 1 and 2
		if($t == 1) $t = 2;
		else $t = 1;
		$value = "$value$temp";
	}
	// loop and sum up each idiv. digit
	$l = strlen($value);
	for($i = 0; $i < $l; $i++)
	{
		$checksum = $checksum + $value[$i];
	}
	// mod the checksum by 10
	$verified = $checksum % 10;
	// if not 0 return 0 
	if ($verified != 0) return 0;
	
	return 1;
}

?>
