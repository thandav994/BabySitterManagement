<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "beareader";

$conn = mysqli_connect($servername, $username, $password, $dbname);
if(!$conn){
	die("Connection failed: " .mysqli_connecet_error());
}

$BookId = $_GET["BookId"];
$BorrowerId = $_GET["BorrowerId"];
echo $BookId;
echo $BorrowerId;

$showData = "INSERT INTO bookloans (BookId, BorrowerId, DateOut, DueDate) VALUES ('$BookId', '$BorrowerId', CURDATE() , DATE_ADD(CURDATE(), INTERVAL 14 DAY) )";
$data = array();
$result = mysqli_query($conn, $showData);

// if(mysqli_num_rows($result) > 0){
// 	while($row = mysqli_fetch_assoc($result)){
// 		$data[] = $row;
// 	}
// } else {
// 	echo "0 results";
// };
echo $result;
print json_encode($data);
mysqli_close($conn);
?>