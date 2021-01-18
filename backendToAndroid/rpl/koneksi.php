<?php
    $username = "id14305605_wafiq16";
    $password = "@Kamaluddin123";
    $database = "id14305605_feedback_demo";
    $hostname = "localhost";

    $connect_db = mysqli_connect($hostname,$username,$password) or die("unable to connect") ;

    $find_db = mysqli_select_db($connect_db,$database);
?>