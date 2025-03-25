<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-4.dtd">

<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">

  <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Add icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

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
<div class="container">
<div class="d-flex">

        <div style="padding:5px; top-height:5px">
 <div style="color:Violet; padding:5px;"><center><h2>Welcome,  <span th:text="${userName}"></span></h2></center>
   
	        </div>
                
            <div style="float:left">
                <img src="/images/InquireX_Logo.jpg" alt = "logo" width = 15% height=auto >
            </div>
            <div style="float:right; padding:30px">
                    <a th:href="@{/index}">Logout</a>
            </div>
        </div>

	<div class="p-2 flex-grow-1"><center><h4 style="position:fixed; top: 70px; left:300px;">Inquiry Form for IT Training Institute</h4></center></div>
</div>
<div class="container">
<div class="d-flex">

	<form method="post" action="../../inquiryITWeb" style="max-width:500px;margin:auto">
		<div class="input-container">
			<input type="text" name="user" th:value="${userID}"></input>   
			<input type="hidden" name="inquiryHub" th:value="${acName}"></input>
			<tr th:each="ac2 : ${companyList2}">
			<p th:value=${ac2.associateName} th:text="${ac2.associateName}"></p>  
			</tr>
		</div>		
	 	
		<div class="input-container">
			<label for="course" class="input-field">Choose a course : </label>
			    <select id="course" name="inquiryFor" class="input-field">
			        <option value="Java">JAVA /J2EE Course</option>
			        <option value="PHP">PHP Course</option>
			        <option value="Python">Python Course</option>
			        <option value="Data Science">Data Science Course</option>
			        <option value="Digital Marketing">Digital Marketing Course</option>
			        <option value="Software Testing">Software Testing Course</option>
			        <option value="UI-UX Design">UI/UX Design Course</option>
			        <option value="Web Development">Web Development Course</option>
			    </select>
		</div>

		<button type="submit" class="btn">Submit</button>
	</form>
	</div>

</div>
		<button class="btn btn-primary" style="margin:10px; width:200px; left:50px;" th:href="@{/CancelInquiry/{id}(id=${userID})}">Cancel</button>

<footer>
  <div style="background-color: lightgray; text-align:center;">
    @ 2025 Copyright:
    <a style="margin:10px; padding:10px; " href="@{/index}">Inquiry Hub Portal</a>
  </div>
</footer>


</body>
</html>
