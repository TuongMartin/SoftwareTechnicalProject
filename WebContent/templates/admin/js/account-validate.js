$(document).ready(function(){
	$('#accountform').validate({
		rules: {
			username: {
				required: true,
				minlength: 6,
				maxlength: 30
			},
			password: {
				required: true,
				minlength: 8,
				maxlength: 30
			},
			repassword: {
				required: true,
				minlength: 8,
				maxlength: 30
			}
		},
		messages: {
			username:{
				required: "Độ dài username 6-30",
				minlength: "Chiều dài tên đăng nhập phải từ 6 ký tự trở lên",
				maxlength: "Chiều dài tên đăng nhập phải nhỏ hơn 30 ký tự"
			},
			password: {
				required: "Độ dài username 8-30",
				minlength: "Chiều dài password phải từ 8 ký tự trở lên",
				maxlength: "Chiều dài password phải nhỏ hơn 30 ký tự"
			},
			repassword: {
				required: "Độ dài username 8-30",
				minlength: "Chiều dài password phải từ 8 ký tự trở lên",
				maxlength: "Chiều dài password phải nhỏ hơn 30 ký tự"
			}
			
		}
	});
	
	$('#accountform').submit(function() {
	    if($("#password").val()!=$("#repassword").val()){
	    	$("#checkpassword").text("Xác nhận mật khẩu sai");
	    	 return false;
	    }
	   
	});
	
	$('#changepassword').on('change', function() {
		if(this.checked){
			$('#password').removeAttr('disabled');
			$('#repassword').removeAttr('disabled');
		}else{
			$('#password').attr('disabled','disabled'); 
			$('#repassword').attr('disabled','disabled'); 
		}
	})
});