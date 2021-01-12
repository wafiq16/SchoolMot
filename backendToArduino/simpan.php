<?php
    include "koneksi.php";
    // include "mainwindow.php";  
        
    $sql = "SELECT idAlat FROM mystudentdata";
    $result = $connect_db->query($sql);
    $myDate = date("Y-m-d");

    $tempq = @$_GET['tempq'];
    $myData = @$_GET['myData'];
    $hehe = @$_GET['hehe']; 
    // $tempq = @$_POST['tempq'];
    // $myData = @$_POST['myData'];
    // $hehe = @$_POST['hehe'];

    if ($result->num_rows >0) {
    // output data of each row
        while($row = $result->fetch_assoc()) {
            echo "idAlat: " . $row["idAlat"]. "<br>";
            if($row["idAlat"] == $hehe){
            
                $sql_simpan = mysqli_query($connect_db,"INSERT into device(nama,nrp,idAlat,waktu) VALUES ('$tempq','$myData','$hehe','$myDate')");

                if($sql_simpan){
                    echo "data berhasil disimpan<br>";
                    echo $tempq." ".$myData." ".$hehe; 
                }
                else{
                    echo "\ndata gagal disimpan\n";
                }
            }
        }
    }   
    else 
    {
        echo "0 results";
    }
    $sql_delete = mysqli_query($connect_db,"DELETE FROM device WHERE waktu < '$myDate'");
    if($sql_delete){
        echo "\ndata berhasil dihapus\n"; 
        echo $myDate;
    }
    else{
        echo "\ndata gagal dihapus";
    }   
    mysqli_close($connect_db);
?>