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

	<div class="limiter">
    <div class="container-login100">
      <div class="wrap-login100">
        <form class="login100-form validate-form" id = "forgot-form">
          <span class="login100-form-title p-b-43">
            SPENDIT
          </span>
          
          
          <div class="wrap-input100" data-validate = "Valid email is required: ex@abc.xyz" action = "processpassword.action" method = "post" id = "password-request">
            <label>Email</label>
            <input id = "email" type="email" class="form-control" placeholder="Email Address" name = "email" required>
            <p id = "errormsg"></p>
          </div>
      

          <div class="container-login100-form-btn-forgotpass">  
            <button type="submit" class="btn login100-form-btn">
                    Send Request
          </button>
          </div>
          <div class="text-center p-t-46 p-b-20">
            <span class="txt2">
               <a href = "login.jsp" class="login">Go back to login?</a>
               <p id = "errormsg"></p>
            </span>
          </div>
        </form>

        <div class="login100-more" style="background-image: url(resources/images/forgotpass.jpg);">
          <div class="login-main-text">
          <h3 class="login">Forgot Password</h3>
          </div>
        </div>
      </div>
    </div>
  </div>
<!-- jQuery -->
<script src="node_modules/admin-lte/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="node_modules/admin-lte/plugins/jquery-ui/jquery-ui.min.js"></script>
<script>
document.title = "Spendit - Forgot Password";
 $("#forgot-form").submit(function(e){
	 e.preventDefault();
	 

	 $.ajax({
		 type: "POST",
		 url: "processpassword.action",
		 data: $(this).serialize(),
		 success: function(data){
			$("#errormsg").empty();
			 if(data.msg === "success"){
			
				window.location.href = "success.jsp";
			 }else{
				 $("#errormsg").empty();
				 $("#errormsg").append("<p style='color:red'>This email is not in our records. Would you like to register?</p>");
			 }
		 }
	 })
 });
 </script>
</body>
</html>