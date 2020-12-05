<?php
    include "koneksi.php";
    // include "mainwindow.php";

    $waktuku = date("Y-m-d H:i:s");
     
    $nama = @$_POST['nama'];
    $isi = @$_POST['isi'];
    $waktu = @$_POST['waktu'];

    $sql_simpan = mysqli_query($connect_db,"INSERT into mydata(nama,isi,waktu) VALUES ('$nama','$isi','$waktuku')");

    if($sql_simpan){
        // echo "data berhasil disimpan";
        // echo $nama + $isi + $waktu;
    }
    else{
        echo "\ndata gagal disimpan";
    }

?>