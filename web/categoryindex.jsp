<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@include file = "navbar.jsp"%>
<style>
  .btn-new{
    background-color: #4AD991;
    color: white;
  }
  .btn-generate{
    background-color: #DAA2EB;
    color: white;
  }
  .btn-edit{
    background-color: #73C2FB;
    color: white;
  }
  .btn-delete{
    background-color: #FF6B7F;
    color: white;
  }
  </style>
 <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">Categories</h1>             
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Categories</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>

<!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-12">
          <div class="card">
            <div class="card-header">
              <h3 class="card-title">List of Categories</h3>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
              <div class = "row">
                <a href = "newcategory.jsp"style="padding-right: 5px; padding-bottom: 10px; padding-left: 5px;"><button type="button" class="btn btn-block btn-new" style="width:auto;height: auto;"><i class="fas fa-plus" style="padding-right: 5px;"></i>New Category</button></a>
              </div>
              <table id="expenses" class="table table-bordered table-hover">
                <thead>
                <tr>
                  <th>Name</th>
                  <th>Type</th>
                  <th>Description</th>
                  <th>Image</th>
                  <th>Action</th>
                </tr>
           		<tbody>
           		<c:forEach items="${categories}" var="elem">
           		<tr>
           		
    			<td><c:out value="${elem.name}" /></td>
    			<td><c:out value="${elem.module }"/></td>
    			<td><c:out value="${elem.description }"/></td>
   			<td><img src = "retrieveimage.action?module=category&fileName=<c:out value = '${elem.image }'/>"/></td>
  		
    			<td><div class="row" style="justify-content: center;"><a href = "retrievecategory.action?id=${elem.id }"><button type="button" class="btn btn-block btn-edit"><i class="fas fa-pen"></i> Edit</button></a>
    			<a href = "deletecategory.action?id=${elem.id }"onclick = 'return confirm("Confirm Deletion")' style="padding-left: 5px;"><button type="button" class="btn btn-block btn-delete">Delete</button></a></div>
    			</td>
    			</tr>
				</c:forEach>
           		</tbody>
              </table>
            </div>
            <!-- /.card-body -->
          </div>
          <!-- /.card -->
<script>
document.title = "Spendit - Categories";

</script>
<%@include file = "footer.jsp"%>