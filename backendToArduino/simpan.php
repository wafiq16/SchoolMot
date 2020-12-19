<?php
    include "koneksi.php";
    // include "mainwindow.php";  
        $waktuku = date("Y-m-d H:i:s");
        $tempq = @$_GET['tempq'];
        $myData = @$_GET['myData'];
        $hehe = @$_GET['hehe'];
        // $tempq = @$_POST['tempq'];
        // $myData = @$_POST['myData'];
        // $hehe = @$_POST['hehe'];
        $sql_simpan = mysqli_query($connect_db,"INSERT into device(nama,nrp,idAlat) VALUES ('$tempq','$myData','$hehe')");

        if($sql_simpan){
            echo "data berhasil disimpan\n";
            echo $tempq." ".$myData." ".$hehe; 
        }
        else{
            echo "\ndata gagal disimpan";
        }
        mysqli_close($connect_db);
?>