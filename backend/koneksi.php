<?php
    $username = "root";
    $password = "";
    $database = "feedback_demo";
    $hostname = "192.168.43.231";

    $connect_db = mysqli_connect($hostname,$username,$password) or die("unable to connect") ;

    $find_db = mysqli_select_db($connect_db,$database);
?>