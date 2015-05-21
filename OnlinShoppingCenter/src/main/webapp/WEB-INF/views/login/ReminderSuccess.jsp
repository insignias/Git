<%@ include file="/WEB-INF/views/common/CommonInclude.jsp" %>
<link href="<c:url value="/resources/css/common/GeneralStyle.css" />" rel="stylesheet">
<div class="wrapper">
			<h1>Online Shopping Center</h1>
			<br>
			<br>
			<h2>Delivery at your <span>doorstep</span></h2>
			<div class="content">
				
					<div id="form_wrapper" class="form_wrapper">
						<h3>Reminder Page:</h3>										
								<div class="row">
									<label>${forgot}</label>
								</div>
								<div class="row">
									<label>${emailMessage}</label>
								</div>
								
								<div class="bottom">
									<a class="relogin" title="Return to Login Page" href="http://localhost:8080/css/">Return to Login Page</a>
								</div>	
														
					</div>
				
			</div>
			<div class="clear"></div>
</div>