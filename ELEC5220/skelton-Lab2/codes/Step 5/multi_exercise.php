<?php
// Simply set 3 cookies for A,B,C
setcookie("cookie[UserA]", "A",time() +3600);
setcookie("cookie[UserB]", "B",time() +3600);
setcookie("cookie[UserC]", "C",time() +3600);

// after the page reloads, print them out
if (isset($_COOKIE['cookie'])) {
	foreach ($_COOKIE['cookie'] as $name => $value) {
		$name = htmlspecialchars($name);
		$value = htmlspecialchars($value);
		echo "$name : $value <br />\n";
	}
}
?>
