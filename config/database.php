<?php
define('DB_HOST', 'localhost');
define('DB_USER', 'root');
define('DB_PASS', 'Password<3');
define('DB_NAME', 'database');

// Create connection
$conn = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);

// Check connection
if ($conn->connect_error) {
  die('Connection failed: ' . $conn->connect_error);
}

// echo 'Connected successfully';
