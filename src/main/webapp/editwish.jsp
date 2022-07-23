<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<%@include file = "navbar.jsp"%>
<style>
    .btn-submit{
    background-color: #73C2FB;
    color: white;
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
            <h1 class="m-0 text-dark">Add a Wish</h1>             
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
              <li class="breadcrumb-item active">New Wish</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
<!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row">
          <!-- left column -->
          <div class="col-md-12">
            <!-- general form elements -->
            <div class="card">
              <div class="card-header">
                <h3 class="card-title">Wish Form</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form action="updatewish.action" method = "post" autocomplete = "off">
               <input type = "hidden" name = "wishID" value = "${wish.id }">
                <div class="card-body">
                  <div class="form-group col-sm-3">
                    <label for="category">Select Category</label>
                      <select class="form-control" id = "categoriesforwishes-edit" name = "categoryID" required>
  						<option selected disabled>Select a Category</option>
  						<c:forEach items="${wishcategories}" var="elem">
  						<option value = "${elem.id }" ${wish.categoryID == elem.id ? 'selected' : '' }>${elem.name }</option>
  						</c:forEach>
                        </select>
                  </div>
                  <div class="form-group col-sm-3">
                    <label for="category">Income Source</label>
                      <select class="form-control" id = "categoriesforincome-edit" name = "incomeSourceID" required>
  						<option selected disabled>Select source of income</option>
  						<c:forEach items="${incomesources}" var="sources">
  						<option value = "${sources.id }" ${wish.incomeSourceID == sources.id ? 'selected' : '' }>${sources.name }</option>
  						</c:forEach>
                        </select>
                  </div>
                  <div class="form-group col-sm-3">
                    <label for="cost">Amount</label>
                    <input type="number" step = ".01" class="form-control" id="amount" name = "amount" value = "${wish.amount }"required>
                  </div>
                  
                 <div class="form-group col-sm-3">
                  <label>Date:</label>
                  <div class="input-group">
                    <div class="input-group date" id="datetimepicker1" data-target-input="nearest">
                    <fmt:parseDate value="${wish.date}" pattern="yyyy-MM-dd HH:mm:ss" var="myDate"/>
                    <fmt:formatDate value="${myDate}" var="parsedDate" pattern="MM/dd/yyyy hh:mm a"/>
                  
                    <input type="text" class="form-control datetimepicker-input" id="date" name = "date" value = "${parsedDate}">
                    <div class="input-group-append" data-target="#datetimepicker1" data-toggle="datetimepicker">
                        <div class="input-group-text"><i class="fa fa-calendar"></i></div>
                    </div>
                </div>
            </div>
                  <!-- /.input group -->
                </div>
                <div class="form-group col-sm-3">
                    <label for="category">Status</label>
                      <select class="form-control" id = "categoriesforincome-edit" name = "statusID" required>
  						<option selected disabled>Select status</option>
  						<c:forEach items="${status}" var="status">
  						<option value = "${status.id }" ${wish.statusID == status.id ? 'selected' : '' }>${status.name }</option>
  						</c:forEach>
                      </select>
                  </div>
                 <div class="form-group">
                    <label>Comment</label>
                     <textarea name = "comment" id = "description" class="form-control" rows="3" placeholder="Enter ..." required>${wish.comment }</textarea>
                 </div>
                </div>
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="submit" class="btn btn-submit">Submit</button>
                </div>
              </form>
            </div>
            <!-- /.card -->

</div>
</div>
<script>
document.title = "Spendit - Wish Edit";

</script>
<%@include file = "footer.jsp"%>