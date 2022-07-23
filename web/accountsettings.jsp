<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@include file = "navbar.jsp"%>
<style>
    .btn-submit{
    background-color: #73C2FB;
    color: white;
    float: right;
  }
     .btn-edit{
    background-color: #DAA2EB;
    color: white;
    float: right;
  }

    .btn-cancel{
    color: #DAA2EB;
    border-color: #DAA2EB;
    float: right;
  }
  </style>
 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">Account Settings</h1>             
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
             <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
              <li class="breadcrumb-item active">Account Settings</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>

<!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="container-fluid">
          <div class="card">
            
            <!-- /.card-header -->
          </div>
          <div class = "card">
          	<div class = "card-header">
          		<h3 class="card-title">User Profile</h3>
               <button class="btn btn-edit" id="enable"><i class="fas fa-pen" style="padding-right: 5px;"></i>Edit</a></button>
          	</div>
          	<div class = "card-body">
          		
          		<form action = "updateaccount.action" method = "post" id = "signup-form" enctype = "multipart/form-data" autocomplete = "off"> <!-- Will need a servlet that edits everything but passwords. will do file processing -->
          		<img src = "retrieveimage.action?module=profile&fileName=${sessionScope.user.image }" style="width: 100px;height: 120px;"/>
          		
          		<div class = "form-group">
          			<label for = "file">Upload a New Profile Picture</label>
                  	<input type = "file" name = "file">
                  </div>
          			<div class = "form-group">
          			<label for = "firstname">First Name</label>
          			<input type = "text" name = "firstname" class = "form-control" value = "${sessionScope.user.firstName }">
          			</div>
          			<div class = "form-group">
          			<label for = "lastname">Last Name</label>
          			<input type = "text" name = "lastname" class = "form-control" value = "${sessionScope.user.lastName }">
          			</div>
          			<div class = "form-group">
          			<label for = "username">User Name</label>
          			<input type = "text" name = "username" class = "form-control" value = "${sessionScope.user.userName }">
          			</div>
          			<div class = "form-group">
          			<label for = "firstname">Email</label>
          			<input type = "email" name = "email" class = "form-control" value = "${sessionScope.user.email }">
          			</div>
          			
          			<div class="form-group">
                  <div class="row" style="float: right;">
                    <a style="padding-right: 10px;"><button type = "button" class="btn btn-cancel" id= "disable">Cancel</button></a>
                  	<button type="submit" class="btn btn-submit">Save</button>

                  </div>
                	</div>
          		</form>
          	</div>
          </div>
          
           
          <div class = "card">
          	<div class = "card-header">
          		<h3 class="card-title">Security Settings</h3>
              <button class="btn btn-edit" id="enable-two"><i class="fas fa-pen" style="padding-right: 5px;"></i>Edit</a></button>
          	</div>
          	<div class = "card-body">
          		
          		<form action = "updatepassword.action" method = "post" id="password-form" onsubmit="return validate()"> <!-- This should lead to Password Change Servlet  -->
          			<div class = "form-group">
          			<label for = "currentpass">Current Password</label>
          			
          			<input type = "password" name = "currentpass" class = "form-control" required>
          			</div>
          			<div class = "form-group">
          			<label for = "newpass">New Password</label>
          			<input type = "password" name = "newpass" class = "form-control" id = "newpass" required>
          			</div>
          			<div class = "form-group">
          			<label for = "confirmnew">Confirm New Password</label>
          			<input type = "password" name = "confirmnew" class = "form-control" id = "confirmnew" required>
          			</div>
          			<div class="form-group">
                  	<div class="row" style="float: right;">
                    <a style="padding-right: 10px;"><button type = "button" class="btn btn-cancel" id= "disabletwo">Cancel</button></a>
                    <button type="submit" class="btn btn-submit">Save</button>

                  </div>
                	</div>
                </form>
          	</div>
          			
          		
          	</div>
          </div>
<script type="text/javascript">
document.title = "Spendit - Account Settings";
    function validate() {
        var password = document.getElementById("newpass").value;
        var confirmPassword = document.getElementById("confirmnew").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }
    
</script> 
<%@include file = "footer.jsp"%>