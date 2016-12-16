<?php
//index.php
//------------------------------------------------------------------------------------------
// This is the site's homepage. It displays a random selection of CDs to the user.
//------------------------------------------------------------------------------------------
//functions called:
// include_header(title) - include the page header and shopping cart
// include_browse_menu() - include the browse options
// include_footer() - close the page and include my footer text
// get_random_product_infos(length) - get a random list of products of size length
// Robert Skelton changed the length to 15 products on the main page. 
// display_item_list(products) - display formatted table output for the products
//------------------------------------------------------------------------------------------
require_once('./includes/counter.php');
require_once('./includes/mysql_connect.php');
require_once('./includes/mysql_functions.php');
require_once('./includes/functions.php');
print "Number of page visits: ";
print $stats;
include_header('Robertmart');
include_browse_menu();
print '<h2>Welcome to Robertmart</h2>';
//set the number of items to be fetched and displayed
$length = 15;
//get the random selection of products
$products = get_random_product_infos($length);
//display the list to the page
display_item_list($products);
include_footer();
?>