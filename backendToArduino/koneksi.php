<?php
    $username = "root";
    $password = "";
    $database = "rplku";
    $hostname = "127.0.0.1";

    $connect_db = mysqli_connect($hostname,$username,$password) or die("unable to connect") ;

    $find_db = mysqli_select_db($connect_db,$database);
?>