<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "beareader";

$conn = mysqli_connect($servername, $username, $password, $dbname);
if(!$conn){
	die("Connection failed: " .mysqli_connecet_error());
}
// $LoanId = $_GET["LoanId"];
$showData = "SELECT LoanId, datediff(curdate(), DueDate) as DateDiff
FROM bookloans
where DateIn is null" ;
$data = array();
$result = mysqli_query($conn, $showData);

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