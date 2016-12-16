<?php
error_reporting(0);
$q=$_GET["q"];
$xmlDoc = new DOMDocument();
$xmlDoc->load("PersonalInfo.xml");
$x=$xmlDoc->getElementsByTagName('Name');
for ($i=0; $i<=$x->length-1; $i++) {
//Process only element nodes
	if ($x->item($i)->nodeType==1) {
		if ($x->item($i)->childNodes->item(0)->nodeValue == $q) {
			$y=($x->item($i)->parentNode);
		}
	}
}
//Use the isset() function to check to see if there was a match
//to the specified name
if(isset($y)) {
	$person=($y->childNodes);
	for ($i=0;$i<$person->length;$i++) {
//Process only element nodes
		if ($person->item($i)->nodeType==1) {
			echo($person->item($i)->nodeName);
			echo(": ");
			echo($person->item($i)->childNodes->item(0)->nodeValue);
			echo("<br />");
		}
	}
}
//no person found, added for AJAX on your own 2. 
else {
	echo("Person not found. Try again.");
}
?>