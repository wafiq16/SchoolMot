<?php
    include "koneksi.php";
    // include "mainwindow.php";
        $waktuku = date("Y-m-d H:i:s");
     
        $nama = @$_POST['nama'];
        $nrp = @$_POST['nrp'];
        $idAlat = @$_POST['idAlat'];

        $sql_simpan = mysqli_query($connect_db,"INSERT into myStudentData(nama,nrp,idAlat) VALUES ('$nama','$nrp','$idAlat')");

        if($sql_simpan){
            echo "data berhasil disimpan";
            //echo $nama + $isi + $waktu;
        }
        else{
            echo "\ndata gagal disimpan";
        }
        mysqli_close($connect_db);
        
    // $sql = "SELECT rssi FROM device";

    // if ($result->num_rows >0) {
    // // output data of each row
    //     while($row = $result->fetch_assoc()) {
    //         echo "idAlat: " . $row["idAlat"]. "<br>";
    //         echo $idAlat;
    //         if($row["idAlat"] == $idAlat){
            
    //             $sql_simpan = mysqli_query($connect_db,"INSERT into device(idAlat,rssi,waktu) VALUES ('$idAlat','$rssi','$myDate')");

    //             if($sql_simpan){
    //                 echo "data berhasil disimpan<br>";
    //                 echo $idAlat.$rssi; 
    //             }
    //             else{
    //                 echo "\ndata gagal disimpan\n";
    //             }
    //         }
    //     }
    // }   
    // else 
    // {
    //     echo "0 results";
    // }
    // mysqli_close($connect_db);
?>