<!-- PHP File used for editing the xml file and calculating the sum on the server side. -->
<?php
error_reporting(0);
$q=$_GET["q"];
$p=$_GET["p"];
$y=0;

$xmlDoc = new DOMDocument();
$xmlDoc->load("table.xml");

$x=$xmlDoc->getElementsByTagName("Item");
foreach($x as $item){
	if($item->getElementsByTagName('Name')->item(0)->nodeValue == $p){
		$numberOf = $item->getElementsByTagName('Amount')->item(0)->nodeValue = $q;
		$item->getElementsByTagName('Subtot')->item(0)->nodeValue = (($item->getElementsByTagName('Price')->item(0)->nodeValue)*($item->getElementsByTagName('Amount')->item(0)->nodeValue));
		$xmlDoc->save('table.xml');
	}

	$y= $y+($item->getElementsByTagName('Subtot')->item(0)->nodeValue);
}

echo("$" . (0.05*$y));
echo("<br />");
echo("$" . (1.05*$y));
?>