<?php include 'config/database.php' ?>

<?php
$name = $body = '';
$nameErr = $bodyErr = '';

if (isset($_POST['submit'])) {
  if (empty($_POST['name'])) {
    $nameErr = 'Name is required.';
  } else {
    $name = filter_input(
      INPUT_POST,
      'name',
      FILTER_SANITIZE_FULL_SPECIAL_CHARS
    );
  }

  if (empty($_POST['body'])) {
    $bodyErr = 'Body is required.';
  } else {
    $body = filter_input(
      INPUT_POST,
      'body',
      FILTER_SANITIZE_FULL_SPECIAL_CHARS
    );
  }

if (empty($nameErr) && empty($bodyErr)) {
  $sql = "INSERT INTO table1 (name, body) VALUES ('$name', '$body')";
  if (mysqli_query($conn, $sql)) {
    echo 'Connected.';
  } else {
    echo 'Error: ' . mysqli_error($conn);
  }
 }
}
?>

<h2>Comments</h2>
<?php echo isset($name) ? $name : ''; ?>
<p class = "lead text-center">Leave your comments</p>

<form class="" action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?> " method="post">
  <div class="mb-3">
    <label for="name">Name</label>
    <input type="text" class= "form-control <?php echo !$nameErr ?: 'is-invalid'; ?>"
    name="name" value="<?php echo $name; ?>">

  </div>
  <div class="mb-3">
    <label for="body">Comments</label>
    <textarea type="text" class= "form-control <?php echo !$bodyErr ?: 'is-invalid'; ?>"
    name="body"><?php echo $body; ?></textarea>

  </div>
  <div class="mb-3">
    <input type="submit" name="submit" value="Submit">

  </div>

</form>
