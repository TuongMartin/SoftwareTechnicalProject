$(document).ready(function() {
	
    $('a.login-window').click(function() {
    	
        var loginBox = $(this).attr('href');
        $(loginBox).fadeIn("slow");
        $('body').append('<div id="over"></div>');
        $('#over').fadeIn(300);
        
        return false;
    });
   


    $(document).on('click', "a.close, #over", function() { 
    	
        $('#over, .login').fadeOut(300 , function() {
            $('#over').remove();  
        }); 
        
        return false;
    });
	
});