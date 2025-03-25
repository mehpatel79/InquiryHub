<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-4.dtd">

<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">

  <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


<style>
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
             <div style="color:Violet; padding:5px;"><center><h2><tr th:each="admin : ${loginList}">Welcome,  <span th:text="${admin.userName}"></h2></center></span>
    	 </div>
        
            <div style="float:left">
                <img src="/images/InquireX_Logo.jpg" alt = "logo" width = 15% height=auto >
            </div>
            <div style="float:right; padding:30px">
                    <a class="btn btn-outline-primary" th:href="@{/index}">Logout</a>
            </div>
        </div>

<div style="display:inline-block" class="flex">
<section>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-5 justify-content-center me-auto mb-2 mb-lg-0">
              <li class="nav-item ps-5 ms-5">
                <a class="nav-link active" aria-current="page" th:href="@{adminHome/UserInfo}">User Information</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" th:href="@{/HubtypeInfo}">Hub Type</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" th:href="@{/ACInfo}">Associate Company</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" th:href="@{/InquiryInfo}">Inquiry Information</a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
</section>

<table class="table center" style="padding:30px; margin:30px;">
  <thead class="table-dark">
  	<tr>
	    <th scope="col">ID</th>
	    <th scope="col">Name</th>
	    <th scope="col">Email</th>
	    <th scope="col">Contact No.</th>
	    <th scope="col">User Type</th>
	    <th scope="col">Hub Type</th>
	    <th scope="col">Associate Name</th>
	    <th scope="col" colspan="2">Action</th>
		</tr>
  </thead>
  <tbody class="table-group-divider table-hover table-striped">
	
	<tr th:each="user : ${userList}">
		<span th:if="${user.userType != 'superadmin'}">
			<td th:text="${user.id}"></td>
    	    <td th:text="${user.userName}"></td>
        	<td th:text="${user.userEmail}"></td>
        	<td th:text="${user.userContactno}"></td>
        	<td th:text="${user.userType}"></td>
        	<td th:text="${user.hubType}"></td>
        	<td th:text="${user.associateName}"></td>
            <td><a class="btn btn-secondary" th:href="@{/user/edit/{id}(id=${user.id})}">Edit</a></td>
        	<td><a class="btn btn-danger" th:href="@{/user/delete/{id}(id=${user.id})}">Delete</a></td>
        </span>
        </tr>
  </tbody>
</table>


<footer>
  <div style="background-color: lightgray; text-align:center;">
    @ 2025 Copyright:
    <a style="margin:10px; padding:10px; " href="@{/index}">Inquiry Hub Portal</a>
  </div>
</footer>


</body>
</html>
