<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
  </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <strong>Copyright &copy; 2020 Kupunan ni Eugene</a>.</strong>
    All rights reserved.
    <div class="float-right d-none d-sm-inline-block">
      <b>Spendit</b> 
    </div>
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
<!-- jQuery -->
<link rel = "stylesheet" type = "text/css" href = "adminlte/plugins/datetimepicker/bootstrap-datetimepicker.css">
<script src="node_modules/admin-lte/plugins/moment/moment.min.js"></script>

<script src="node_modules/admin-lte/plugins/jquery/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>
<script src = "node_modules/admin-lte/plugins/datetimepicker/bootstrap-datetimepicker.min.js"></script>

<script type="text/javascript">
  jQuery('#date').datetimepicker();
</script>
<!-- for dropdown -->

<script src = "dropdownresources/jquery.dd.min.js"></script>
<!-- <script>

$('#imagechoices').ddslick({
	 onSelected: function(data){
		 if(data.selectedIndex > 0) {
             $('#image').val(data.selectedData.value);

            //  $('#editcflag').submit();
         }   
	    	
	        alert($('#image').attr('value'));
   
    }   
});

</script> -->
<script language="javascript" type="text/javascript"> 
    $('#imagechoices').ddslick({  
        onSelected: function(data){  
            if(data.selectedIndex > 0) {
                $('#image').attr('readonly', false);
                $('#image').val(data.selectedData.value);
                $('#image').attr('readonly', true);
				$('#image').hide();
               // $('#editcflag').submit();
            }   
        }    
    }); 
</script>
<!-- jQuery UI 1.11.4 -->
<script src="node_modules/admin-lte/plugins/jquery-ui/jquery-ui.min.js">
</script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="node_modules/admin-lte/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables -->
<script src="node_modules/admin-lte/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="node_modules/admin-lte/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="node_modules/admin-lte/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="node_modules/admin-lte/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<!-- ChartJS -->
<!--<script src="adminlte/plugins/chart.js/Chart.min.js"></script>-->
<!-- Sparkline -->
<!--<script src="adminlte/plugins/sparklines/sparkline.js"></script>-->
<!-- JQVMap -->
<script src="node_modules/admin-lte/plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="node_modules/admin-lte/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
<!-- jQuery Knob Chart -->
<script src="node_modules/admin-lte/plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->

<script src="node_modules/admin-lte/plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="node_modules/admin-lte/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>

<!-- Summernote -->
<!--<script src="adminlte/plugins/summernote/summernote-bs4.min.js"></script>-->
<!-- overlayScrollbars -->
<script src="node_modules/admin-lte/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="node_modules/admin-lte/dist/js/adminlte.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="node_modules/admin-lte/dist/js/pages/dashboard.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="node_modules/admin-lte/dist/js/demo.js"></script>
<!-- <script>
$(document).ready(function(){

    $.ajax({
      url: 'retrieveexpenses.action',
      type: 'get',
      contentType: "application/json; charset=utf-8",
      dataType: 'json',
      success:function(response){
    	$('#expenses').find('tbody').empty();
        var len = response.length;

        $.each(response, function(i, item) {
            $('<tr>').append(
                $('<td>').text(item.category),
                $('<td>').text(item.cost),
                $('<td>').text(item.comment),
                $('<td>').text(item.date),
                $('<td>Edit Delete')
            ).appendTo('#expenses');
           
        });
      }
    });
 
});
</script> -->
<script>
$("#password-form").submit(function(e){
	 $.ajax({
		 type: "POST",
		 url: "updatepassword.action",
		 data: $(this).serialize(),
		 success: function(data){
			// alert(JSON.stringify(data.msg));
			 if(data.msg === "incorrect"){
				// alert("Credentials updated!");
				// window.location.href = "accountsettings.jsp";
				 alert("The password you entered is incorrect. Please try again!");
				 window.location.href = "accountsettings.jsp";
			 }else{
				 
			 }
		 }
	 })
});
</script>
<script>
function preventNumbers(e) {
    var keyCode = (e.keyCode ? e.keyCode : e.which);
    if (keyCode > 47 && keyCode < 58) {
        e.preventDefault();
    }
}
</script>
<script>
$(document).ready(function() {
	$.ajax({
		 url : "retrievecategoryoptions.action",
         type:'GET',
         data: {
        	 module : '1'
         },
         dataType: 'json',
         success: function(response) {
             $.each(response,function(i, item)
             {
                 $("#categoriesforexpense").append('<option value=' + item.id + '>' + item.name + '</option>');
             });
          }
	});
	 });
</script>
<script>
$(document).ready(function() {
	$.ajax({
		 url : "retrievecategoryoptions.action",
         type:'GET',
         data: {
        	 module : '2'
         },
         dataType: 'json',
         success: function(response) {
             $.each(response,function(i, item)
             {
                 $("#categoriesforincome").append('<option value=' + item.id + '>' + item.name + '</option>');
             });
          }
	});
	$.ajax({
		 url : "retrievecategoryoptions.action",
        type:'GET',
        data: {
       	 module : '3'
        },
        dataType: 'json',
        success: function(response) {
            $.each(response,function(i, item)
            {
                $("#categoriesforwishes").append('<option value=' + item.id + '>' + item.name + '</option>');
            });
         }
	});
	 });
</script>
<script>
$(document).ready(function() {
	$.ajax({
		 url : "retrievemodules.action",
         type:'GET',
         dataType: 'json',
         success: function(response) {
             $.each(response,function(i, item)
             {
                 $("#modules").append('<option value=' + item.moduleID + '>' + item.name + '</option>');
             });
          }
	});
	 });
</script> 
<script>
$(document).ready(function() {
	$.ajax({
		 url : "expensetoday.action",
         type:'GET',
         dataType: 'json',
         success: function(data) {
          /*    $.each(response,function(data)
             {
            	

                 $("#expense-today").append('<h3>Php' +data.expense+'<h3>');
                 $("#expense-today").append('<p>Spent today</p>');
             }); */
             $("#expense-today").append('<h3 style="font-size: larger;">Php ' + data['expense'] + '</h3>');
             $("#expense-today").append('<p>Spent today</p>');

			
             /* for(var i = 0; i < jsonObj.length; i++)
             {
                 alert(jsonObj[i]['expense']);
             } */
           //  var obj = jQuery.parseJSON( data );

             //alert(obj.b);
          }
	});
	$.ajax({
		 url : "monthexpense.action",
        type:'GET',
        dataType: 'json',
        success: function(data) {
         /*    $.each(response,function(data)
            {
           	

                $("#expense-today").append('<h3>Php' +data.expense+'<h3>');
                $("#expense-today").append('<p>Spent today</p>');
            }); */
            $("#expense-month").append('<h3 style="font-size: larger;">Php ' + data['monthexpense'] + '</h3>');
            $("#expense-month").append('<p>Spent this month</p>');

			
            /* for(var i = 0; i < jsonObj.length; i++)
            {
                alert(jsonObj[i]['expense']);
            } */
          //  var obj = jQuery.parseJSON( data );

            //alert(obj.b);
         }
	});
	$.ajax({
		 url : "monthlyincome.action",
       type:'GET',
       dataType: 'json',
       success: function(data) {
  
           $("#monthly-income").append('<h3 style="font-size: larger;">Php ' + data['monthlyincome'] + '</h3>');
           $("#monthly-income").append('<p>Income this month</p>');

			
          
        }
	});
	
	$.ajax({
		 url : "gettopcategories.action",
      type:'GET',
      dataType: 'json',
      success: function(data) {
    	  $ulSub = $("#top-categories");
         $.each(data, function(i, item){
        	 $ulSub.append('<li class ="item"><div class="product-img"><img src ="retrieveimage.action?module=category&fileName=' +item.image+ '" class = "img-size50"></div><div class = "product-info"><a href = "#" class = "activities">' + item.name + '</a><a class = "product-price" href = "#"><span class = "float-right">Php ' + item.categoryexpense + '</span></a></div>');
        /* 	 $ulSub.append('<li class="item">');
        	 $ulSub.append('<div class = "product-img"');
        	 $ulSub.append('<img src = "retrieveimage.action?module=category&fileName="' + item.image + 'class = "img-size-50"');
        	 
        	 $ulSub.append() */
         });
		
			
         
       }
	});
	
			
        
	$.ajax({
		 url : "recentexpenses.action",
    type:'GET',
    dataType: 'json',
    success: function(data) {
  
       $.each(data, function(i, item){
  //    	 $ulSub.append('<li class ="item"><div class="product-img"><img src ="retrieveimage.action?module=category&fileName=' +item.image+ '" class = "img-size50"></div><div class = "product-info"><a href = "#" class = "activities">' + item.name + '</a><a class = "product-price" href = "#"><span class = "float-right">Php ' + item.categoryexpense + '</span></a></div>');
      /* 	 $ulSub.append('<li class="item">');
      	 $ulSub.append('<div class = "product-img"');
      	 $ulSub.append('<img src = "retrieveimage.action?module=category&fileName="' + item.image + 'class = "img-size-50"');
      	 
      	 $ulSub.append() */
      	 //<h3 class="timeline-header"><a href="#" class="activities">John Doe</a> had a <a href="#"class="activities">Starbucks Coffee</a> worth<a href="#" class="activities"> ₱180.00</a></h3>

      	 $('#transaction-history').append('<div><i class = "fas"><img src ="retrieveimage.action?module=category&fileName=' +item.image+ '" style="margin-left: -5px;"></i><div class = "timeline-item"><h3 class = "timeline-header"><a href = "#" class = "activities">' + item.firstname + ' ' + item.lastname + ' had a <a href= "#" class = "activities">' + item.comment + '</a> worth <a href = "#" class = "activities"> Php ' + item.cost + '</a></h3><div class = "timeline-body"><span title = "'+item.date+'"><i class = "fas fa-clock" style = "color: #999;"></i>'  + moment("'"+item.date+"'").endOf('minutes').fromNow() + '</span></div></div></div>');
      	
       });
		
			
       
     }
	});
	$.ajax({
		 url : "retrievetotalwish.action",
      type:'GET',
      dataType: 'json',
      success: function(data) {
 
          $("#wishlist-total").append('<h3 style="font-size: larger;">Php ' + data['wishtotal'] + '</h3>');
          $("#wishlist-total").append('<p>Wishlist</p>');

			
         
       }
	});
	$.ajax({
		url: "retrievewishpercent.action",
		type: 'GET',
		dataType: 'json',
		success: function(data){
			$ulSub = $("#wish-percentages");
	         $.each(data, function(i, item){
	        	 $ulSub.append('<li class="item"><div class="progress-group" style = "padding:left: 12px;padding-right: 12px;">' +item.comment+ '<span class = "float-right"><b>Php ' + item.partial+ '/'+item.amount+'</b></span><div class = "progress progress-sm"><div class = "progress-bar bg-primary" style = "width:'+item.percentages+'%;background-color: #73C2FB!important;"></div></div></div>');
	         });
		}
	});
	 });
</script> 
<script>
  $(function () {
    $('#expenses').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": true,
      "ordering": true,
      "info": true,
      "autoWidth": true,
      "responsive": true,
    });
   
  });
</script>

<script>
$("#signup-form input").prop("disabled", true);
$("#signup-form button").prop("disabled", true);
</script>

<script>
$(document).ready(function() {
$("#enable").click(function(){
$("#signup-form input").prop("disabled", false);
$("#signup-form button").prop("disabled", false);
});
});

</script>
<script>
  $(document).ready(function() {
$("#disable").click(function(){
$("#signup-form input").prop("disabled", true);
$("#signup-form button").prop("disabled", true);
});
});
</script>

<script>
$("#password-form input").prop("disabled", true);
$("#password-form button").prop("disabled", true);
</script>

<script>
$(document).ready(function() {
$("#enable-two").click(function(){
$("#password-form input").prop("disabled", false);
$("#password-form button").prop("disabled", false);
});
});

</script>

<script>
  $(document).ready(function() {
$("#disabletwo").click(function(){
$("#password-form input").prop("disabled", true);
$("#password-form button").prop("disabled", true);
});
});
</script>


</body>
</html>
