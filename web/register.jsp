<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
body {
    /*font-family: "Lato", sans-serif;*/
}

a.login {
  font-size: 16px;
  text-align: center;
  color: #73C2FB;
  padding-right: 10px;
}

a.login:hover {
  text-decoration: underline;
  color: #73C2FB;
}

.main-head{
    height: 150px;
    background: #FFF;
   
}

.sidenav {
    height: 1120px;
    width: 1080px;
    background-color: #50C878;
    overflow-x: hidden;
    padding-top: 20px;
}


.main {
    padding: 0px 10px;
  
}

@media screen and (max-height: 450px) {
    .sidenav {padding-top: 15px;}
}

@media screen and (max-width: 450px) {
    .login-form{
        margin-top: 10%;
    }

    .register-form{
        margin-top: 10%;
    }
}

@media screen and (min-width: 768px){
    .main{
        margin-left: 60%; 
    }

    .sidenav{
        width: 55%;
        position: fixed;
        z-index: 1;
        top: 0;
        left: 0;
    }

    .login-form{
        margin-top: 80%;
    }

    .register-form{
        margin-top: 20%;
    }
}


.login-main-text{
    margin-top: 20%;
    padding: 60px;
    color: #fff;
}

.login-main-text h2{
    font-weight: 300;
}

.btn-black{
    background-color: #73C2FB !important;
    color: #fff !important;
}
.btn-log{
  background-color: #73C2FB !important;
    color: #fff;
}
</style>
<%@include file = "header.jsp" %>
<body>
<script>
document.title = "Spendit - Registration";
function check() {
	  if (document.getElementById('password').value ==
	    document.getElementById('confirm').value) {
	    document.getElementById('message').style.color = 'green';
	    document.getElementById('message').innerHTML = 'Passwords Match!';
	  } else {
	    document.getElementById('message').style.color = 'red';
	    document.getElementById('message').innerHTML = 'not matching';
	  }
	}
	
	function checkEntry(e) {
	    var keyCode = (e.keyCode ? e.keyCode : e.which);
	    if (keyCode > 47 && keyCode < 58) {
	        e.preventDefault();
	    }
	}

</script>
	<div class="limiter">
    <div class="container-login100">
      <div class="wrap-login100">
        <form class="registration100-form validate-form" action = "signup.action" method = "post" id = "signup-form" enctype = "multipart/form-data" autocomplete = "off">
          <span class="login100-form-title p-b-43">
            SPENDIT
          </span>
          
          
          <div class="wrap-input100">
            <label>Firstname</label>
          <input id = "firstname" onkeydown="checkEntry(event);" onkeyup="checkEntry(event);" type="text" class="form-control" placeholder="First Name" name = "firstname" onPaste = "return false" required>
            <p id = "errormsg" class="error-msg"></p>
          </div>

          <div class="wrap-input100">
            <label>Last Name</label>
                  <input id = "lastname" onkeydown="checkEntry(event);" onkeyup="checkEntry(event);" type="text" class="form-control" placeholder="Last Name" name = "lastname" onPaste = "return false" required>
            <p id = "errormsg" class="error-msg"></p>
          </div>
          <div class="wrap-input100">
           <label>Username</label>
                      <%if (request.getParameter("error") != null && Integer.parseInt(request.getParameter("error")) == 1 ){%>
                     <p style= "color:red">Username already in our records!</p>
                     <% } %>
                     <input id = "username" type="text" class="form-control" placeholder="Username" name = "username" required>
          </div>

          <div class="wrap-input100">
            <label>Email</label>
                <input id = "email" type="email" class="form-control" placeholder="Email" name = "email" required>
            <p id = "errormsg" class="error-msg"></p>
          </div>
          
          
          <div class="wrap-input100 validate-input" data-validate="Password is required">
            <label>Password</label>
              <input id = "password" type="password" class="form-control" placeholder="Password" name = "password" required>
          </div>

          <div class="wrap-input100 validate-input" data-validate="Password is required">
              <label>Confirm Password</label>
              <input id = "confirm" autocomplete = "off" type="password" class="form-control" placeholder="Confirm Password" name = "confirm" onkeyup='check();' required>
              <span id = "message"></span>
          </div>

          <div class="wrap-input100 validate-input">
              <label>Image</label>
              <input type = "file" name = "file" class="control-image">
          </div>
      

          <div class="container-login100-form-btn">
            <button class="btn login100-form-btn">
              Sign Up
            </button>
          </div>
          
          <div class="text-center p-t-46 p-b-20">
            <span class="txt2">
                <a href = "login.jsp" class="login">Already have an account? Sign in</a>
               <p id = "errormsg"></p>
            </span>
          </div>
        </form>

        <div class="login100-more" style="background-image: url(resources/images/register-write.jpg);">
          <div class="login-main-text">
          <h3 class="login">Register Now!</h3>
            <p class="login" style="font-size:24px;">Ready for a Carefree Spendit-ing experiece</p>
          </div>
        </div>
      </div>
    </div>
  </div>
<!-- jQuery -->
<!-- <script src="adminlte/plugins/jquery/jquery.min.js">
 
  $("#signup-form").submit(function(e){
	  
	  
	 e.preventDefault();
	 $.ajax({
		 type: "POST",
		 url: "signup.action",
		 data: $(this).serialize(),
		 success: function(data){
			 if(data.msg == "success"){
				  window.location.href = "index.jsp";
			 }if(data.msg == "error"){
				 alert("NO!");
				 $("#errormsg").empty();
				 $("#errormsg").append("<p style='color:red'>Invalid Credentials.</p>");
			 }if(data.msg == "duplicate"){
				 $("#errormsg").empty();
				 $("#errormsg").append("<p style='color:red'>Account already exists!</p>");
			 }
		 }
	 	
	 })
 }); 
 </script> -->
 <!-- jQuery UI 1.11.4 -->
<!-- <script src="adminlte/plugins/jquery-ui/jquery-ui.min.js"></script>
 --> 
</body>
</html>