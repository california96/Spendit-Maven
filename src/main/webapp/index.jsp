<%--
  Created by IntelliJ IDEA.
  User: bryan
  Date: 7/23/2022
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file = "navbar.jsp" %>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <div class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1 class="m-0 text-dark">Dashboard</h1>
        </div><!-- /.col -->
        <div class="col-sm-6">
          <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item active">Dashboard</li>
          </ol>
        </div><!-- /.col -->
      </div><!-- /.row -->
    </div><!-- /.container-fluid -->
  </div>
  <!-- /.content-header -->
  <section class="content">
    <div class="container-fluid">
      <div class="row">
        <div class="col-lg-3 col-6">
          <!-- small box -->
          <div class="small-box bg-info" style = "background-color: #73C2FB!important;">
            <div class="inner" id = "expense-today">
            </div>
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-3 col-6">
          <!-- small box -->
          <div class="small-box bg-dangers" style="background-color: #FF899A!important; color: white!important;">
            <div class="inner" id = "expense-month">
            </div>
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-3 col-6">
          <!-- small box -->
          <div class="small-box bg-success" style="background-color: #DAA2EB!important;">
            <div class="inner" id = "monthly-income">
            </div>
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-3 col-6">
          <!-- small box -->
          <div class="small-box bg-danger" style="background-color: #4AD991!important;">
            <div class="inner" id = "wishlist-total">
            </div>
          </div>
        </div>
        <!-- ./col -->
      </div>
      <!-- /.row -->
      <!-- Main row -->
      <div class="row">
        <!-- Left col -->
        <section class="col-lg-7 connectedSortable">

          <!-- TO DO List -->
          <div class="card">
            <div class="card-header">
              <h3 class="card-title">Transaction Activities</h3>
              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse">
                  <i class="fas fa-minus"></i>
                </button>
              </div>
            </div>
            <!-- /.card-header -->
            <div class="card-body">
              <div class="timeline" id = "transaction-history">
                <!-- /.timeline-label -->
                <!-- timeline item -->
                <!-- <div>
                  <i class="fas"><img src="resources/images/coffee-category.png"style="margin-left: -5px;"></i>
                  <div class="timeline-item">
                    <h3 class="timeline-header"><a href="#" class="activities">John Doe</a> had a <a href="#"class="activities">Starbucks Coffee</a> worth<a href="#" class="activities"> ₱180.00</a></h3>

                    <div class="timeline-body">
                      <span><i class="fas fa-clock" style="color: #999;"></i> 2 hrs ago</span>
                    </div>
                  </div>
                </div> -->

              </div>
            </div>
          </div>
          <!-- END timeline item -->
          <!-- timeline item -->
          <!-- /.timeline-label -->
          <!-- timeline item -->
          <!-- /.card -->

        </section>

        <!-- /.Left col -->
        <!-- right col (We are only adding the ID to make the widgets sortable)-->
        <section class="col-lg-5 connectedSortable">

          <div class="card">
            <div class="card-header">
              <h3 class="card-title">Top 5 Categories with biggest expense:</h3>

              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse">
                  <i class="fas fa-minus"></i>
                </button>
              </div>
            </div>
            <!-- /.card-header -->
            <div class="card-body p-0">
              <ul class="products-list product-list-in-card pl-2 pr-2" id = "top-categories">

              </ul>
            </div>
            <!-- /.card-footer -->
          </div>

          <!-- solid sales graph -->
          <div class="card">
            <div class="card-header">
              <h3 class="card-title">My Wishlist</h3>

              <div class="card-tools">
                <button type="button" class="btn btn-tool" data-card-widget="collapse">
                  <i class="fas fa-minus"></i>
                </button>
              </div>
            </div>
            <!-- /.card-header -->
            <div class="card-body p-0">
              <ul class="products-list product-list-in-card pl-2 pr-2" id = "wish-percentages">

              </ul>
            </div>
            <!-- /.card-footer -->
          </div>

      </div>
      <!-- /.card -->
  </section>
  <!-- right col -->
</div>
<script>
  document.title = "Spendit - Dashboard";
</script>
<%@include file = "footer.jsp" %>
