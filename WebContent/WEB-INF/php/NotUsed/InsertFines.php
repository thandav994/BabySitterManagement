<?php
$servername = "localhost:3306";
$username = "root";
$password = "1234";
$dbname = "beareader";

$conn = mysqli_connect($servername, $username, $password, $dbname);
if(!$conn){
	die("Connection failed: " .mysqli_connecet_error());
}
$LoanId = $_GET["LoanId"];
$Fine = $_GET["Fine"];
$Paid = 0;
// $CheckQuery= "SELECT * FROM fines";
$showData = "INSERT INTO fines (LoanId, FineAmt, Paid) VALUES ('$LoanId','$Fine','$Paid')";
// $UpdateQuery = "UPDATE fines SET FineAmt = '$Fine' WHERE LoanId='$LoanId'";
$data = array();
$result = mysqli_query($conn, $showData);
// echo $result;
if(mysqli_num_rows($result) > 0){
	while($row = mysqli_fetch_assoc($result)){
		$data[] = $row;
	}
} else {
	echo "0 results";
};
print json_encode($data);
mysqli_close($conn);
?>