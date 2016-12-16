<?php
//guess your favorite band based on a number
function my_own_function($j) {
    if ($j == 0) {
        echo "Johnny Cash";
    } elseif ($j== 1) {
        echo "Beethoven";
    } else {
        echo "Led Zeppelin";
    }
}
//added this function, takes i and converts it into a month name
function display_month_date($i) {
	if ($i == 0) {
        echo "DIVIDE BY ZERO HOW!>!>!>!";
    } elseif ($i == 1) {
        echo "January";
    } elseif ($i == 2) {
        echo "February";
    } elseif ($i == 3) {
        echo "March";
    }
    elseif ($i == 4) {
        echo "April";
    }
    elseif ($i == 5) {
        echo "May";
    }
    elseif ($i == 6) {
        echo "June";
    }
    elseif ($i == 7) {
        echo "July";
    }
    elseif ($i == 8) {
        echo "August";
    }
    elseif ($i == 9) {
        echo "September";
    }
    elseif ($i == 10) {
        echo "October";
    }
    elseif ($i == 11) {
        echo "November";
    } elseif ($i == 12) {
        echo "December";
    }
}
?>
