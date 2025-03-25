<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-4.dtd">

<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">

  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Add icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href="inquiryHub.css" rel="stylesheet">

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

        <div style="padding:5px; top-height:5px">
            <div style="float:left">
                <img src="/images/InquireX_Logo.jpg" alt = "logo" width = 15% height=auto >
            </div>
            <div style="float:left; padding:20px">
                    <a th:href="@{/index}">Home</a>
            </div>
        </div>

<form method="post" action="../../Update" style="max-width:500px;margin:auto">
  <h2>Update Data for Existing User </h2>
   
  <div class="input-container">
    <i class="fa fa-user icon"></i>
    <input class="input-field" type="text" placeholder="User Name" name="userName" th:value=${userEdit.userName}>
	<input type="hidden" name="id" th:value=${userEdit.id}></input>    
  </div>

  <div class="input-container">
    <i class="fa fa-envelope icon"></i>
    <input class="input-field" type="text" placeholder="Email" name="userEmail" th:value=${userEdit.userEmail}>
  </div>
  
  <div class="input-container">
    <i class="fa fa-key icon"></i>
    <input class="input-field" type="password" placeholder="Password" name="password" th:value=${userEdit.password}>
  </div>

  <div class="input-container">
    <i class="fa fa-mobile icon"></i>
    <input class="input-field" type="number" placeholder="Contact Number" name="userContactno" th:value=${userEdit.userContactno}>
  </div>

  <div class="input-container">
    <i class="fa fa-users icon"></i>
    <select class="input-field" type="text" name="userType" id="userType" th:value=${userEdit.userType}>
    	<option value="normal">Normal</option>
    	<option value="associative">Associative</option>
    </select>
  </div>
  			 
  
  <div class="input-container">
      <i class="fa fa-house icon"></i>
    <!--  
    	<input class="input-field" type="text" name="hubType" value="null" th:value=${userEdit.hubType}>
	-->
		    <select class="input-field" type="text" name="hubType" th:value=${userEdit.hubType}>
		    		<option value="null">None</option>
			    	<option th:each="ht : ${htList}" th:value="${ht.hubTypeName}" th:text="${ht.hubTypeName}"></option>
    		</select>
  </div>


	<div class="input-container">
	    <i class="fa fa-industry icon"></i>
	    <!-- 
    <input class="input-field" type="text" name="associateName" value="null" th:value=${userEdit.associateName}>
     -->
        <select class="input-field" type="text" name="associateName" th:value=${userEdit.associateName}>
        		    <option value="null">None</option>
			    	<option th:each="ac : ${acList}" th:value="${ac.associateName}" th:text="${ac.associateName}"></option>
    		</select>
    
  </div>
  <button type="submit" class="btn">Update</button>
  <button class="btn btn-primary" style="margin:10px" th:href="@{/Cancel}">Cancel</button>
  
</form>

<footer>
  <div style="background-color: lightgray; text-align:center;">
    @ 2025 Copyright:
    <a style="margin:10px; padding:10px; " href="@{/index}">Inquiry Hub Portal</a>
  </div>
</footer>


</body>
</html>
