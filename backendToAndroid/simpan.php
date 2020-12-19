<?php
    include "koneksi.php";
    // include "mainwindow.php";
        $waktuku = date("Y-m-d H:i:s");
     
        $nama = @$_POST['nama'];
        $nrp = @$_POST['nrp'];
        $idAlat = @$_POST['idAlat'];

        $sql_simpan = mysqli_query($connect_db,"INSERT into mystudentdata(nama,nrp,idAlat) VALUES ('$nama','$nrp','$idAlat')");

        if($sql_simpan){
            echo "data berhasil disimpan";
            //echo $nama + $isi + $waktu;
        }
        else{
            echo "\ndata gagal disimpan";
        }
        mysqli_close($connect_db);
?>