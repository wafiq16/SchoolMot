<?php
    include"koneksi.php";

    // sql to delete a record
    $waktuku = date("d");

    $sql = mysqli_query($connect_db,"DELETE FROM myData WHERE waktu != '$waktuku'");
    
    if ($sql) {
        echo "Record deleted successfully";
    } 
    else {
        echo "Error deleting record: " . $conn->error;
    }
?> 