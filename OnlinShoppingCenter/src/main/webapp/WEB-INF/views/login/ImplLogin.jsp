<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page session="false" %>
<html>
    <head>
        <title>Online Shopping Center</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="description" content="Expand, contract, animate forms with jQuery wihtout leaving the page" />
        <meta name="keywords" content="expand, form, css3, jquery, animate, width, height, adapt, unobtrusive javascript"/>
        <link href="<c:url value="/resources/css/login/loginStyle.css" />" rel="stylesheet">
		<script src="<c:url value="/resources/js/login/cufon-yui.js" />"></script>
		<script src="<c:url value="/resources/js/login/ChunkFive_400.font.js" />"></script>	
		<script type="text/javascript" src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" />"></script>
		<script src="<c:url value="/resources/js/login/login.js" />"></script>	
		<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon"/>
		<script type="text/javascript">
			Cufon.replace('h1',{ textShadow: '1px 1px #fff'});
			Cufon.replace('h2',{ textShadow: '1px 1px #fff'});
			Cufon.replace('h3',{ textShadow: '1px 1px #000'});
			Cufon.replace('.back');
		</script>
    </head>
    <body>
		<div class="wrapper">
			<h1>Online Shopping Center</h1>
			<br>
			<br>
			<h2>Delivery at your <span>doorstep</span></h2>
			<div class="content">
				<div id="form_wrapper" class="form_wrapper">
					<input type="hidden" name="actionType" id="actionType" value="${loginUser.actionType}"></input>
					<form:form class="register" method="POST" commandName="implLoginUserBean" action="register">
						<h3>Register</h3>
						<div class="column">
							<div>
								<label>Name: <form:errors path="username" cssStyle="color:#ff0000"></form:errors></label>
								<form:input path="username"/>
							</div>
							<div>
								<label>Email: <form:errors path="email" cssStyle="color:#ff0000"></form:errors></label>
								<form:input path="email" />
							</div>							
							<div>
								<label>Password: <form:errors path="password" cssStyle="color:#ff0000"></form:errors></label>
								<form:password path="password"/>
							</div>
							<div>
								<label>Confirm Password: <form:errors path="confirmPassword" cssStyle="color:#ff0000"></form:errors></label>
								<form:password path="confirmPassword"/>
							</div>
							<div>
								<label>Contact Number: <form:errors path="contactNumber" cssStyle="color:#ff0000"></form:errors></label>
								<form:input path="contactNumber"/>
							</div>
						</div>
						<div class="bottom">
							
							<form:hidden id="registerType" path="actionType"/>
							<input type ="submit" onclick="submitActionType('registerType');" name="submit" value="Register"/>
							<a href="#" rel="login" class="linkform">You have an account already? Log in here</a>
							<div class="clear"></div>
						</div>
					</form:form>
					<%-- <form:form class="login active" method="POST" commandName="implLoginUserBean" action="login"> --%>
						<form:form class="login active" method="POST" commandName="implLoginUserBean" action="login">
						
						<h3>Login</h3>
						<div>
							<label>Email: <form:errors path="email" cssStyle="color:#ff0000"></form:errors></label>
							<form:input path="email"/>
							
						</div>
						<div>
							<label>Password: <form:errors path="password" cssStyle="color:#ff0000"></form:errors></label>
							<form:password path="password"/>
							<a href="forgot_password.html" rel="forgot_password" class="forgot linkform">Forgot your password?</a>
						</div>
						<div class="bottom">
							<div class="remember"><input type="checkbox" name="remember-me"/><span>Keep me logged in</span></div>
							<form:hidden id="loginType" path="actionType"/>
							<input type="submit" onclick="submitActionType('loginType');" name="submit" value="Login"/>
							<a href="#" rel="register" class="linkform">You don't have an account yet? Register here</a>
							<div class="clear"></div>
						</div>
					</form:form>
					<form:form class="forgot_password" method="POST" commandName="implLoginUserBean" action="email">
						<h3>Forgot Password</h3>
						<div>
							<label>Email: <form:errors path="email" cssStyle="color:#ff0000"></form:errors></label>
							<form:input path="email"/>
						</div>
						<div class="bottom">
							<form:hidden id="emailType" path="actionType"/>
							<input type="submit" onclick="submitActionType('emailType');" name="submit" value="Send reminder"></input>
							<a href="index.html" rel="login" class="linkform">Suddenly remebered? Log in here</a>
							<a href="register.html" rel="register" class="linkform">You don't have an account? Register here</a>
							<div class="clear"></div>
						</div>
					</form:form>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		

		<!-- The JavaScript -->
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
		<script type="text/javascript">
			$(function() {
					//the form wrapper (includes all forms)
				var $form_wrapper	= $('#form_wrapper'),
					//the current form is the one with class active
					$currentForm	= $form_wrapper.children('form.active'),
					//the change form links
					$linkform		= $form_wrapper.find('.linkform');
						
				//get width and height of each form and store them for later						
				$form_wrapper.children('form').each(function(i){
					var $theForm	= $(this);
					//solve the inline display none problem when using fadeIn fadeOut
					if(!$theForm.hasClass('active'))
						$theForm.hide();
					$theForm.data({
						width	: $theForm.width(),
						height	: $theForm.height()
					});
				});
				
				//set width and height of wrapper (same of current form)
				setWrapperWidth();
				
				/*
				clicking a link (change form event) in the form
				makes the current form hide.
				The wrapper animates its width and height to the 
				width and height of the new current form.
				After the animation, the new form is shown
				*/
				$linkform.bind('click',function(e){
					var $link	= $(this);
					var target	= $link.attr('rel');
					$currentForm.fadeOut(400,function(){
						//remove class active from current form
						$currentForm.removeClass('active');
						//new current form
						$currentForm= $form_wrapper.children('form.'+target);
						//animate the wrapper
						$form_wrapper.stop()
									 .animate({
										width	: $currentForm.data('width') + 'px',
										height	: $currentForm.data('height') + 'px'
									 },500,function(){
										//new form gets class active
										$currentForm.addClass('active');
										//show the new form
										$currentForm.fadeIn(400);
									 });
					});
					e.preventDefault();
				});
				
				function setWrapperWidth(){
					$form_wrapper.css({
						width	: $currentForm.data('width') + 'px',
						height	: $currentForm.data('height') + 'px'
					});
				}
			});
			function submitActionType(actionType){
				document.getElementById(actionType).value = actionType;
			} 
       </script>
    </body>
    <div id="footer">
    	<p>© 2015 Online Shopping Center. All rights reserved  </p>
    </div>
</html>