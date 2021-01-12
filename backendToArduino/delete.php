<?php
    include"koneksi.php";

    // sql to delete a record
    $waktuku = date("Y-m-d H:i:s");

    $sql = mysqli_query($connect_db,"DELETE FROM device WHERE waktu <= '$waktuku'");
    
    if ($sql) {
        echo "Record deleted successfully";
    } 
    else {
        echo "Error deleting record: " . $conn->error;
    }
?> 