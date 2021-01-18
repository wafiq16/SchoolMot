<?php
    include "koneksi.php";
    // include "mainwindow.php";  
        
    $sql = "SELECT * FROM myStudentData";
    $result = $connect_db->query($sql);
    $myDate = date('Y-m-d H:i:s');
    
    

    $idAlat = @$_GET['idAlat'];
    $rssi = @$_GET['rssi'];

    if ($result->num_rows >0) {
    // output data of each row
        while($row = $result->fetch_assoc()) {
        
            if($row["idAlat"] == $idAlat){
                echo "idAlat: " . $row["idAlat"]. "<br>";
                echo "nama: " . $row["nama"]. "<br>";
                echo "nrp: " . $row["nrp"]. "<br>";
                $nama = $row["nama"];
                $nrp = $row["nrp"];
                $sql_simpan = mysqli_query($connect_db,"INSERT into device(nama,nrp,idAlat,rssi,waktu) VALUES ('$nama','$nrp','$idAlat','$rssi','$myDate')");

                if($sql_simpan){
                    echo "data berhasil disimpan<br>";
                    echo $idAlat.$rssi."<br>"; 
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
    // $sql_delete = mysqli_query($connect_db,"DELETE FROM device WHERE waktu < '$myDate'");
    // if($sql_delete){
    //     echo "\ndata berhasil dihapus\n"; 
    //     echo $myDate;
    // }
    // else{
    //     echo "\ndata gagal dihapus";
    // }   
    mysqli_close($connect_db);
?>