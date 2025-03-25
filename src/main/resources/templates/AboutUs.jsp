<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-4.dtd">

<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">

  <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Add icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="inquiryHub.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	
<style>
 body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

.input-container {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  width: 100%;
  margin-bottom: 15px;
}

.icon {
  padding: 10px;
  background: dodgerblue;
  color: white;
  min-width: 50px;
  text-align: center;
}

.input-field {
  width: 100%;
  padding: 10px;
  outline: none;
}

.input-field:focus {
  border: 2px solid dodgerblue;
}

/* Set a style for the submit button */
.btn {
  background-color: dodgerblue;
  color: white;
  padding: 15px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.btn:hover {
  opacity: 1;
}

footer {
    position: fixed;
    height: 30px;
    bottom: 0;
    width: 100%;
}
</style>
</head>
<body>
    	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

        <div style="padding:5px; top-height:5px">
            <div style="float:left">
                <img src="/images/InquireX_Logo.jpg" alt = "logo" width = 15% height=auto >
            </div>
            <div style="float:left; padding:20px">
                    <a th:href="@{/index}">Home</a>
            </div>
        </div>

		<div style="position:fixed; top:220px; left:50px; text-align:center; font-size:30px;">
          <p>
            At Inquiry Hub, we understand that efficient communication is the backbone of any successful business. That's why we've designed a cutting-edge inquiry system that streamlines the way you interact with your clients and customers. Our platform is here to help you manage inquiries, automate responses, and keep your communication organized—all in one place.
          </p>
        </div>
    

<footer>
  <div style="background-color: lightgray; text-align:center;">
    @ 2025 Copyright:
    <a style="margin:10px; padding:10px; " href="@{/index}">Inquiry Hub Portal</a>
  </div>
</footer>


</body>
</html>
