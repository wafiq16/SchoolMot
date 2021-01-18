<?php
    include "koneksi.php";
    // include "mainwindow.php";  
        
    $sql_device = "SELECT * FROM device";
    // $sql_android = "SELECT * FROM myStudentData";
    
    $result_device = mysqli_query($connect_db,$sql_device);
    // $result_android = mysqli_query($connect_db,$sql_android);
    // $myDate = date("Y-m-d");
    $result_all = array();
    $result_dev = array();
    if ($result_device-> num_rows >0) {
        while($row_dev = mysqli_fetch_array($result_device)){
                            array_push($result_all,array(
                                "id" => $row_dev['id'],
                                "nama"=> $row_dev['nama'],
                                "nrp"=> $row_dev['nrp'],
                                "idAlat"=> $row_dev['idAlat'],
                                "rssi"=> $row_dev['rssi'],
                                "waktu"=> $row_dev['waktu']
                            ));
        }
    }
    else 
    {
        echo "0 results";
    }

    echo json_encode(array('result_suspect' => $result_all));

    mysqli_close($connect_db);
?>