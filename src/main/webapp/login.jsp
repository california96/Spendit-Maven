<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
body {
    /*font-family: "Lato", sans-serif;*/
    /*font-family*/
}



.main-head{
    height: 150px;
    background: #FFF;
   
}

.sidenav {
  background-image: url(resources/images/fruits.png);
   width: 50%;
   position: absolute;
   left: 0px;
   height: 100%;
}

p.login {
  font-weight: bold;
  font-size: 35px;
}

p.error-msg {
   margin-top: 5px;
   margin-bottom: -20px;
}

p.description {
  font-size: 16px;
  text-align: center;
  color: #646464;
}
p.forgotpass {
  font-size: 16px;
  text-align: center;
}

a.description {
  font-size: 16px;
  text-align: center;
  color: #73C2FB;
}

a.description:hover {
  text-decoration: underline;
  color: #73C2FB;
}

a.register {
  font-size: 16px;
  text-align: center;
  color: #73C2FB;
  padding-right: 10px;
}

a.register:hover {
  text-decoration: underline;
  color: #73C2FB;
}
h3.login {
  font-weight: bold;
  font-size: 35px;
}

h3.title {
  font-weight: bold;
  font-size: 35px;
  color: #73C2FB;
  text-align: center;
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
    display: flex;
    justify-content: center;
    align-items: center;
    width: 115px;
}
.btn-outline{
  background-color: #FFFF !important;
    color: #73C2FB!important;
    border-color: #73C2FB!important;
    display: flex;
    justify-content: center;
    align-items: center;
    width: 115px;
    /***margin-top: -97px;
    margin-left: 130px;**//
}
.buttonrow{
    display: flex;
    -ms-flex-wrap: wrap;
    flex-wrap: wrap;
    margin-right: -7.5px;
    margin-left: -7.5px;
    justify-content: center;
    padding-bottom: 10px;
    align-content: center;
}
</style>
<%@include file = "header.jsp" %>
<body>

<div class="limiter">
    <div class="container-login100">
      <div class="wrap-login100">
        <form class="login100-form validate-form" id = "login-form">
          <span class="login100-form-title p-b-43">
            SPENDIT
          </span>
          
          
          <div class="wrap-input100">
            <label>Username</label>
           <input id = "username" type="text" class="form-control" placeholder="User Name" name = "username" required>
            <p id = "errormsg" class="error-msg"></p>
          </div>
          
          
          <div class="wrap-input100 validate-input" data-validate="Password is required">
            <label>Password</label>
              <input id = "password" type="password" class="form-control" placeholder="Password" name = "password" required>
          </div>

          <div class="flex-sb-m w-full p-t-3 p-b-32">
            <div class="custom-container">
              <a href = "forgotpassword.jsp" class="forgotpass">Forgot password</a>
            </div>
          </div>
      

          <div class="container-login100-form-btn">
            <button class="btn login100-form-btn">
              Login
            </button>
          </div>
          
          <div class="text-center p-t-46 p-b-20">
            <span class="txt2">
               <a href = "register.jsp" class="register">Create an Account</a>
               <p id = "errormsg"></p>
            </span>
          </div>
        </form>

          <div class="login100-more" style="background-image: url(resources/images/fruits.png);">
          <div class="login-main-text">
          <h3 class="login">Curious on where you spend your money?</h3>
            <p class="login" style="font-size: 20px;">No worries! SpendIt will keep track of your spending habits.</p>
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
document.title = "Spendit - Login";
 $("#login-form").submit(function(e){
	 e.preventDefault();
	 

	 $.ajax({
		 type: "POST",
		 url: "login.action",
		 data: $(this).serialize(),
		 success: function(data){
			// alert(JSON.stringify(data.msg));
			 if(data.msg === "success"){
				  window.location.href = "index.jsp";
			 }else{
				 $("#errormsg").empty();
				 $("#errormsg").append("<p style='color:red'>Invalid Credentials.</p>");
			 }
		 }
	 })
 });
 </script>
</body>
</html>