
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = "header.jsp" %>
<!------ Include the above in your HEAD tag ---------->
<style>
    .btn-submit{
    background-color: #73C2FB;
    color: white;
  }
  </style>
<body>
 <div id="success">
        <div class="success">
            <img src="resources/images/success.png"style="width: 250px; height: 250px;">
            <div class="success-404">

                <h1>Success</h2>
            </div>
            <h2>Password Request Success.</h2>
            <p>An email has been sent to the address you have provided. Please see your email for the instructions.</p>
             <a href = "login.jsp" class="login"><button class="btn block btn-submit">Go back to login.</button></a>
        </div>
    </div>

</body>
<script>
document.title = "Password Request Successful";
</script>
</html>