<html>
<head>
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="bootstrap-4.5.0-dist/css/bootstrap.css">
	<script type="text/javascript" src="bootstrap-4.5.0-dist/js/jquery.js"></script>
    <script type="text/javascript" src="bootstrap-4.5.0-dist/js/bootstrap.js"></script>
    <!-- <title align = "center" >Ini web Wafiq</title> -->
    <link rel="icon" href="wafiq_ikon.png">
</head>
    <body>
        <tbody>
            <?php
                include "koneksi.php";
                    $query = "SELECT * FROM mydata";

                    echo " <br></br> <center><h3><b>Semua Feedback</b></h3></center> <br> <br>";
                    if ($result = $connect_db->query($query)) {
                    ?>
                        <table class="table table-dark" width="200px">
                        <thead>
                            <tr>
                                <th scope="col">Nomor</th>
                                <th scope="col">Nama</th>
                                <th scope="col">Isi</th>
                                <th scope="col">Waktu</th>
                            </tr>
                        </thead>
                        <?php
                        while ($row = $result->fetch_assoc()) {
                        
                            $nomor = $row["no"];
                            $nama = $row["nama"];
                            $isi = $row["isi"];
                            $waktu = $row["waktu"];
                        ?>
                            <tbody>
                                <tr>
                                    <td><?php echo $nomor ?></td>
                                    <td><?php echo $nama ?></td>
                                    <td><?php echo $isi ?></td>
                                    <td><?php echo $waktu ?></td>
                                </tr>
                            </tbody>
                        <?php } ?>     
                    
                    </table>
                    <?php
                    /*freeresultset*/
                    $result->free();
                    }
                ?>
                    </form>
                    <br></br>
                    <form action = "mainwindow.php"  enctype="multipart/form-data" >
                        <button class = "btn btn-primary" type="kembali" style = "float:right;" name="kembali">Kembali</button</td>
                    </form>
        </tbody>
    </body>
</html>