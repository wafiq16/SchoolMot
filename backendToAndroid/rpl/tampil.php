<?php
    include "koneksi.php";

    $sql_get = "SELECT * FROM myStudentData ";

    $readData = mysqli_query($connect_db,$sql_get);

    $result = array();
    while($row = mysqli_fetch_array($readData)){
        array_push($result,array(
            "no" => $row['no'],
            "nama"=> $row['nama'],
            "nrp"=> $row['nrp'],
            "idAlat"=> $row['idAlat']
        ));
    }

    echo json_encode(array('result' => $result));

    mysqli_close($connect_db);
?>