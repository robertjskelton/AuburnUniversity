<?php
if (strpos($_SERVER['HTTP_USER_AGENT'], "MSIE 9"))
{ 
?>
<h3>You are using Internet Explorer 9</h3><center><b>strpos must feturned true</b></center>
<?php } 
else { 
?>
<h3>You are not using Internet Explorer</h3><center><b> 9strpos must have returned false</b></center>
<?php } ?>
