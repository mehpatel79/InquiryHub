<!DOCTYPE html SYSTEM "http://www.thymeleaf.org/dtd/xhtml1-strict-thymeleaf-4.dtd">

<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Search Display</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<!-- Add icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<div class="container">
<div class="d-flex">

        <div style="padding:5px; top-height:5px">
             <div style="color:Violet; padding:5px;">
             <center><h2>
             	<tr th:each="user : ${userList}">Welcome,  <span th:text="${user.userName}"></span></tr>
             </h2></center>
	        </div>
        
            <div style="float:left">
                <img src="/images/InquireX_Logo.jpg" alt = "logo" width = 15% height=auto >
            </div>
            <div style="float:right; padding:30px">
                    <a th:href="@{/index}">Logout</a>
            </div>
        </div>

	<div class="p-2 flex-grow-1"><center><h4 style="position:fixed; top: 70px; left:300px;">Search List for Inquiry</h4></center></div>
</div>
<table class="table center">

  <tbody class="table-group-divider table-hover table-striped">
	<div>
	
		<h5>IT Training Institute</h5>
			<div th:with="user = ${userList[0]}"> 
			<tr th:each="ac1 : ${companyList1}">
			<li style="margin-left:30px">
    		    <!--  <input type="hidden" th:text="${ac1.hubtype.id}" /> -->
				<a style="font-size:20px" th:href="@{/ITWeb/{id}/{acname}(id=${user.id},acname=${ac1.associateName})}" th:text="${ac1.associateName}"  ></a>
				 <input type="hidden" name="inquiryHub" id="inquiryHub" th:value=${ac1.associateName}></input>
			</li>
    	</tr>
    	</div>
    </div>
    
    <br> 
	<div>
		<h5>Car Dealer </h5>
			<tr th:each="ac2 : ${companyList2}">
    		<li style="margin-left:30px">
    		    <!--  <input type="hidden" th:text="${ac2.hubtype.id}" /> -->
				<a style="font-size:20px" th:href="@{/CarWeb}" th:text="${ac2.associateName}"  ></a>
			</li>
    	</tr>
    </div>
    
    <br> 
	<div>
		<h5>Bike Dealer </h5>
			<tr th:each="ac3 : ${companyList3}">
    		<li style="margin-left:30px">
    		    <!--  <input type="hidden" th:text="${ac3.hubtype.id}" /> -->
				<a style="font-size:20px" th:href="@{/BikeWeb}" th:text="${ac3.associateName}"  ></a>
			</li>
    	</tr>
    </div>
    
    <br> 
	<div>
		<h5>Car Service </h5>
			<tr th:each="ac4 : ${companyList4}">
    		<li style="margin-left:30px">
    		    <!--  <input type="hidden" th:text="${ac4.hubtype.id}" /> -->
				<a style="font-size:20px" th:href="@{/CarWeb}" th:text="${ac4.associateName}"  ></a>
			</li>
    	</tr>
    </div>
    <br> 
	<div>
		<h5>Bike Service </h5>
			<tr th:each="ac5 : ${companyList5}">
    		<li style="margin-left:30px">
    		    <!--  <input type="hidden" th:text="${ac5.hubtype.id}" /> -->
				<a style="font-size:20px" th:href="@{/BikeWeb}" th:text="${ac5.associateName}"  ></a>
			</li>
    	</tr>
    </div>
    <br> 
	<div>
		<h5>Electronics Goods Dealer </h5>
			<tr th:each="ac6 : ${companyList6}">
    		<li style="margin-left:30px">
    		    <!--  <input type="hidden" th:text="${ac6.hubtype.id}" /> -->
				<a style="font-size:20px" th:href="@{/ElectronicsWeb}" th:text="${ac6.associateName}"  ></a>
			</li>
    	</tr>
    </div>
    
    <div>
    	<p></p>
    	<p></p>
    	<p></p>
    	<p></p>
    	<p></p>
    </div>
    
    
    
    

<!-- 
    		<span th:if="${ht.id == ac.hubtypeid}">
			</span>
				<!-- 
		<tr th:each="ht1 : ${htList1}">
				<h4 th:text="${ht1.id}"></h4><h5 style="margin-left:30px" th:text="${ht1.hubTypeName}" />
		<td th:text="${web.id}"></td>
        <td th:text="${web.webname}"></td>
        <td th:text="${web.webdescription}"></td>
        <td><a class="btn btn-primary" th:href="@{/edit/{id}(id=${web.id})}">Edit</a></td>
        <td><a class="btn btn-danger" th:href="@{/delete/{id}(id=${web.id})}">Delete</a></td>
         -->
        
  </tbody>
</table>


<footer>
  <div style="background-color: lightgray; text-align:center;">
    @ 2025 Copyright:
    <a style="margin:10px; padding:10px; " href="@{/index}">Inquiry Hub Portal</a>
  </div>
</footer>

</div>
</body>
</html>
