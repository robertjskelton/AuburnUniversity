/*
* Functions used for client side processing with Javascript.
*/
var xmlHttp;
function updatecd1(str)
{
	var name="CD1";
	xmlHttp=GetXmlHttpObject();
	if (xmlHttp==null)
	{
		alert ("Your browser does not support AJAX!");
		return;
	}
	//Send the corresponding variables to PHP.
	var url="totalcal.php";
	url=url+"?q="+str;
	url=url+"&p="+name;
	url=url+"&sid="+Math.random();
	xmlHttp.onreadystatechange=stateChanged;
	xmlHttp.open("GET",url,true);
	xmlHttp.send(null);
}

function updatecd7(str)
{
	var name="CD7";
	xmlHttp=GetXmlHttpObject();
	if (xmlHttp==null)
	{
		alert ("Your browser does not support AJAX!");
		return;
	}
	//Send the corresponding variables to PHP.
	var url="totalcal.php";
	url=url+"?q="+str;
	url=url+"&p="+name;
	url=url+"&sid="+Math.random();
	xmlHttp.onreadystatechange=stateChanged;
	xmlHttp.open("GET",url,true);
	xmlHttp.send(null);
}

function updatemovie(str)
{
	var name="MovieA";
	xmlHttp=GetXmlHttpObject();
	if (xmlHttp==null)
	{
		alert ("Your browser does not support AJAX!");
		return;
	}
	//Send the corresponding variables to PHP.
	var url="totalcal.php";
	url=url+"?q="+str;
	url=url+"&p="+name;
	url=url+"&sid="+Math.random();
	xmlHttp.onreadystatechange=stateChanged;
	xmlHttp.open("GET",url,true);
	xmlHttp.send(null);
}

// On state change
function stateChanged()
{
	if (xmlHttp.readyState==4)
	{
		document.getElementById("total").innerHTML=xmlHttp.responseText;
		updateTable(xmlHttp.responseText);
	}
}
function GetXmlHttpObject()
{
	var xmlHttp=null;
	try
	{
		xmlHttp=new XMLHttpRequest();
	}
	catch (e)
	{
		try
		{
			xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch (e)
		{
			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	return xmlHttp;
}

// Is called whenever the total (sum) is calculated
// Updates the total cost for each item.
// Note: The actual sum is NOT affected by these changes, so any change to prices within this function
// would not change the total price.
function updateTable(total)
{
	var cd1Quantity = document.getElementById("cd1quantity").value;
	var cd7Quantity = document.getElementById("cd7quantity").value;
	var movieQuantity = document.getElementById("movieAquantity").value;
	
	document.getElementById("cd1Total").innerHTML=cd1Quantity*12.50;
	document.getElementById("cd7Total").innerHTML=cd7Quantity*12.95;
	document.getElementById("movieATotal").innerHTML=movieQuantity*19.95;
}