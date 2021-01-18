<?php
    include "koneksi.php";

    $sql_get = "SELECT * FROM mystudentdata ";

    $readData = mysqli_query($connect_db,$sql_get);

    $result = array();
    while($row = mysqli_fetch_array($readData)){
        array_push($result,array(
            "idAlat"=> $row['idAlat'],
            "rssi" => $row['rssi'],
        ));
    }

    echo json_encode(array('result' => $result));

    mysqli_close($connect_db);
?>