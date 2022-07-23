<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file = "header.jsp" %>
 <%  
     if (session.getAttribute("user") == null) {  
       // response.sendRedirect("login.jsp");
       request.getRequestDispatcher("login.jsp").forward(request, response);
     }
  %>
<style>
  p.contents {
  color:#FFFFFF;
}

p.error-msg {
   margin-top: 5px;
   margin-bottom: -20px;
}
i.icons{
  color:#FFFDD0;
}

aside.color{
  background-color: #4AD991;
}

a.contents{
   color:#FFFFFF;
}

img.avatar {
  /***vertical-align: middle;
  width: 50px;
  height: 50px;**/
  border-radius: 50%;
}

img.avatar-icon {
  /***vertical-align: middle;
  width: 50px;
  height: 50px;**/
  border-radius: 50%;
  width: 20px;
  height: 20px;
}
a.hover{
  background-color: #3BA960;
}
a.color{
  border-bottom: 1px solid #4b545c00;
    color: rgba(255,255,255,.8);
}
a.activities{
  color:black;
}
a.product-price{
  color:#FF6B7F;
  font-weight: bold;
}
i.icon{
  background-image: url(resources/images/coffee-category.png);
}
img.logo{
  width: 30%;
  height: auto;
}
span.logo-text{
   font-family: 'Bangers';
   font-size: 50px;
   font-weight: bold;
   color: white;
   text-shadow: 0px -3px 0px #000000, 4px -4px 0px #000000
}


</style>
<body class="hold-transition sidebar-mini layout-fixed">
<div class = "wrapper">
  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
     
    </ul>
    
	
    <!-- Right navbar links -->
<ul class="navbar-nav ml-auto">

      <li class="nav-item dropdown user-menu">
        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">
         <img src = "retrieveimage.action?module=profile&fileName=${sessionScope.user.image }" class="img-circle elevation-2 avatar-icon" alt="User Image"/>
          <span class="d-none d-md-inline">${sessionScope.user.firstName} ${sessionScope.user.lastName }</span>
        </a>
        <ul class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <!-- User image -->
          <li class="user-header bg-primary" style="background-color:#73C2FB!important; ">
            <img src = "retrieveimage.action?module=profile&fileName=${sessionScope.user.image }" class="img-circle elevation-2 avatar" alt="User Image"/>

            <p>
              ${sessionScope.user.firstName} ${sessionScope.user.lastName }
            </p>
          </li>
          <!-- Menu Footer-->
          <li class="user-footer">
              <form action = "signout.action" method = "post" style="padding-right: 90px;">
                 <button type="submit" class="btn btn-default float-right">Sign Out</button>         
              </form>
          </li>
        </ul>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->
  
  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-lime elevation-4 color">
    <!-- Brand Logo -->
    <a href="index.jsp" class="brand-link " style="border-bottom: 1px solid #FFFFFF;
    color: rgba(255,255,255,.8);">
      <img src="resources/images/logo.png" alt="SpendIt Logo" class="brand-image" style="max-height: 65px;
    width: auto;margin-left: -1px;">
      <span class="brand-text font-weight-light logo-text">SPENDIT</span>
      <!---<span class="brand-text font-weight-light" style="color:white;">AdminLTE 3</span> --->
    </a>

    <!-- Sidebar -->
    <div class="sidebar">

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
         
        
              <li class="nav-item">
                <a href="index.jsp" class="nav-link">
                  <i class="fas fa-chart-bar icons"></i>
                  <p class="contents">Dashboard</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="retrieveexpenses.action" class="nav-link">
                  <i class="fas fa-calculator icons"></i>
                  <p class="contents">Expenses</p>
                </a>
              </li>
              <li class = "nav-item">
              	<a href = "retrieveallincome.action" class = "nav-link">
              		<i class="fas fa-dollar-sign icons"></i>
              		<p class="contents">Income</p>
              	</a>
              </li>
              <li class="nav-item">
                <a href="retrievewishlist.action" class="nav-link">
					<i class="fas fa-clipboard-list icons"></i>                  
					<p class="contents">My Wishlist</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="categoryindex.action" class="nav-link">
                  <i class="fas fa-list icons"></i>
                  <p class="contents">Categories</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="accountsettings.jsp" class="nav-link">
                  <i class="fas fa-cog icons"></i>
                  <p class="contents">Account Settings</p>
                </a>
              </li>
            
              
            </ul>
         
          
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
